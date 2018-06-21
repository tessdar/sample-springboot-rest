package com.example.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper {
	
	@Select("SELECT tick FROM ticks")
	public List<Timestamp> getTicks();
}
