package com.example.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
	public List<Timestamp> getTicks();
}
