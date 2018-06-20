package com.example;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMapper {
	
	@Select("SELECT tick FROM ticks")
	List<Timestamp> getTicks();
}
