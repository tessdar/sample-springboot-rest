package com.example;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleDao {

	private static String namespace = "com.example.dao";
	
	@Autowired
	private DBConfig dbConfig;
	
	public List<Timestamp> getTicks() throws Exception {
		return this.dbConfig.sqlSessionTemplate().selectList(namespace + ".selectTicks");
	}
	
}
