package com.yj.app;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MDao {
	
	@Autowired
	private SqlSession sqlSession; // <=jdbcTemplate jdbcTmp
	 
	public List<MDto> selectAll(){
			return sqlSession.selectList("com.yj.selectAll");
	}
		
}
