package com.example.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.SampleMapper;
import com.example.service.SampleService;

@Service
@MapperScan("com.example.mapper")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;

	public List<Timestamp> getTicks() {
		return sampleMapper.getTicks();
	}

}
