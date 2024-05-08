package com.example.ecsfgex.controller;

import java.util.TreeMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@Controller
@ConfigurationProperties(prefix = "ecsfgex")
public class IndexController {

	@Setter
	@Getter
	private String contents = "ecsfgex default text on IndexController!!";

	@RequestMapping("/")
	String index(Model model) {
		model.addAttribute("contents", contents);
		model.addAttribute("envMap", new TreeMap<String,String>(System.getenv()));
		return "index";
	}

}
