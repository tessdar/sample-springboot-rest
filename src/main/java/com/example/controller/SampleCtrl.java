package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SampleService;
import com.example.vo.TicksVo;

@RestController
public class SampleCtrl {

	@Autowired
	private SampleService sampleService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "db", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TicksVo>> db() throws Exception {
		List<TicksVo> timestamps = sampleService.getTicks();

		return new ResponseEntity<List<TicksVo>>(timestamps, HttpStatus.OK);
	}

}
