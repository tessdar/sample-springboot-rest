package com.example.controller;

import java.sql.Timestamp;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.SampleMapper;

@RestController
@MapperScan("com.example.mapper")
public class SampleCtrl {

	@Autowired
	private SampleMapper sampleMapper;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "db", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Timestamp>> db() throws Exception {
		List<Timestamp> timestamps = sampleMapper.getTicks();

		return new ResponseEntity<List<Timestamp>>(timestamps, HttpStatus.OK);
	}

}
