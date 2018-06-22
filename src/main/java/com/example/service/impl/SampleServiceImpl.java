package com.example.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.SampleMapper;
import com.example.service.SampleService;
import com.example.vo.TicksVo;

@Service
@MapperScan("com.example.mapper")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;

	@Override
	@Transactional(readOnly = true)
	public List<TicksVo> getTicks() {
		return sampleMapper.getTicks();
	}

}
