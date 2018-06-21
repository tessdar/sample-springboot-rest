package com.example;

import java.sql.SQLException;

import javax.sql.DataSource;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Bean(name = "dataSource")
	public DataSource dataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}

//	@Bean(name = "sqlSessionFactory")
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/sql/*.xml"));
//
//		return sqlSessionFactoryBean.getObject();
//	}
//
//	@Bean(name = "sqlSession")
//	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory());
//	}

}
