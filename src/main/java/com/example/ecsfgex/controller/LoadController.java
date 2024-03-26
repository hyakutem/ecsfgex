package com.example.ecsfgex.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecsfgex.dto.DspCompanyDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoadController {

	@GetMapping("/load/cpu")
	public String cpu() {
		long startTime = System.currentTimeMillis();

		// some logic to consume more cpu
		double x = 1d;
		for (int i = 0; i < 1000000; i++) {
			x += Math.sqrt(x);
		}

		long endTime = System.currentTimeMillis();
		log.info("処理時間: " + (endTime - startTime) + "[ms]");
		return "Complete";
	}

	@RequestMapping(value = "/load/fu0101/{count}", method = RequestMethod.GET)
	public String fu0101(@PathVariable String count) {
		int countProcessLoop = Integer.parseInt(count);
		long startTime = System.currentTimeMillis();

		// Logic Fu0101Action
		Random rand = new Random();
		List<DspCompanyDto> displayCompanyList = new ArrayList<DspCompanyDto>();
		for (int i = 0; i < 10000; i++) {
				DspCompanyDto companyDto = new DspCompanyDto();
				companyDto.setId(Integer.valueOf(i));
				companyDto.setName("HOGE " + (i + 1) + ":" + rand.nextInt(100));
				companyDto.setAreaName("TOKYO " + ":" + rand.nextInt(100));
				companyDto.setCompanyCategory("IT " + ":" + rand.nextInt(100));
				displayCompanyList.add(companyDto);
		}

		// Repeat unnecessary sort processing
		for (int i = 0; i < countProcessLoop; i++) {

				Integer radomSort = rand.nextInt(4);

				switch (radomSort) {
				case 0:
						// descending order by Id Company
						Collections.sort(displayCompanyList);
						break;
				case 1:
						// ascending order by Company Name
						Collections.sort(displayCompanyList, DspCompanyDto.NameComparator);
						break;
				case 2:
						// ascending order by Area Name
						Collections.sort(displayCompanyList, DspCompanyDto.AreaNameComparator);
						break;
				case 3:
						// descending order by category Company
						Collections.sort(displayCompanyList, DspCompanyDto.CompanyCategoryComparator);
						break;
				}
		}

		long endTime = System.currentTimeMillis();
		log.info("処理時間: " + (endTime - startTime) + "[ms]");
		return "Complete fu0101 in " + (endTime - startTime) + "[ms]";
	}

}
