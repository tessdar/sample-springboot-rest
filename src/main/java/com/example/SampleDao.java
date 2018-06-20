package com.example;

import java.sql.Timestamp;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SampleDao {

	private static String namespace = "com.example.dao";
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSessionTemplate sqlSession;
	
	public List<Timestamp> getTicks() throws Exception {
		return sqlSession.selectList(namespace + ".selectTicks");
	}
	
}
