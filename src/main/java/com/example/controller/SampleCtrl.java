package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SampleService;
import com.example.vo.TicksVo;

@RestController
@RequestMapping({"/api"})
public class SampleCtrl {

	@Autowired
	private SampleService sampleService;

	@GetMapping(path = {"/"})
	public String index() {
		return "index";
	}

	@GetMapping(path = {"/db"})
	@ResponseBody
	public ResponseEntity<List<TicksVo>> db() throws Exception {
		List<TicksVo> timestamps = sampleService.getTicks();

		return new ResponseEntity<List<TicksVo>>(timestamps, HttpStatus.OK);
	}

}
