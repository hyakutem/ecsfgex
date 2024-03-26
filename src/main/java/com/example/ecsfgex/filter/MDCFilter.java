package com.example.ecsfgex.filter;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MDC(Mapped Diagnostic Context)を利用してX-Request-IDをアプリログへ出力可能にする
 */
@Component
public class MDCFilter extends OncePerRequestFilter {

	/**
	 * 世の中標準的に利用されているリクエストを一意に識別する為の識別子
	 * nginx ingress controller通過時に、当該Headerがなければランダム文字列が
	 * 生成されてTomcat側へHttp Headerとして渡ってくる想定
	 */
	private static final String X_REQUEST_ID_HEADER = "X-Request-ID";

	@SuppressWarnings("null")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		putMDC(request, response);
		try {
			filterChain.doFilter(request, response);
		} finally {
			clearMDC();
		}
	}

	protected void putMDC(HttpServletRequest request, HttpServletResponse response) {
		String requestId = request.getHeader(X_REQUEST_ID_HEADER);
		if (Objects.isNull(requestId)) {
			// もしHeaderが渡ってきていない場合は、自ら生成する
			requestId = UUID.randomUUID().toString().replace("-", "");
		}
		MDC.put(X_REQUEST_ID_HEADER, requestId);
	}

	protected void clearMDC() {
		MDC.remove(X_REQUEST_ID_HEADER);
	}

}
