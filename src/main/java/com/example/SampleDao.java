package com.example;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class SampleDao {

	private final SqlSession sqlSession;
	
	public SampleDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Timestamp> selectTicks() {
		return this.sqlSession.selectList("selectTicks");
	}
	
}
