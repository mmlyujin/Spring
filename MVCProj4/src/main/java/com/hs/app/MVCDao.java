package com.hs.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MVCDao {

	@Autowired
	private JdbcTemplate jdbcTmp;
	
	//@Value("insert into member1 values (null,?,?,?)")
	//private String insert;// @Value 는 변수에 값을 넣는 애노테이션
	private String insert="insert into member1 values (null,?,?,?)";
	
	@Value("delete from member1 where idx=?")
	private String delete;	
	
	
	@Value("select * from member1")
	private String selectAll;
	
	@Value("select * from member1 where idx=?")
	private String selectOne;
	
	@Value("update member1 set id=?, pw=?, name=? where idx=?")
	private String update;
	
	@Value("select count(idx) from member1 where id=?")
	private String selectId;
	
	public int insertData(MVCDto dto) {
		return jdbcTmp.update(insert, dto.getId(),dto.getPw(),dto.getName());
	}
	
	public int deleteData(int idx) {
		return jdbcTmp.update(delete, idx);
	}
	
	public List<MVCDto> selectDataAll(){
		return jdbcTmp.query(selectAll, new MVCMapper());// sql, RowMapper
	}
	
	
	public MVCDto selectDataOne(int idx) {
		return jdbcTmp.queryForObject(selectOne, new MVCMapper(), idx);
	}
	
	public int update(MVCDto dto) {
		return jdbcTmp.update(update, dto.getId(),dto.getPw(),dto.getName(),dto.getIdx());
	}
	
	//select를 하기 위해서 jdbcTmp의 경우 rowMapper 클래스가 필요하다
	// 말그대로 row랑 dto를 1:1 맵핑 시키는 클래스 이다.
	class MVCMapper implements RowMapper<MVCDto>{

		@Override
		public MVCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			/*
			MVCDto dto = new MVCDto();
			dto.setIdx(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setPw(rs.getString(3));
			dto.setName(rs.getString(4));
			return dto;
			*/
			
			return new MVCDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
		
	}
	
	public String checkId(String id) {
	      String res = "사용할 수 있는 아이디";
	      if(jdbcTmp.queryForInt(selectId, id)>0) {
	         res="사용할 수 없는 아이디";
	      }
	      
	      return res;
	      
	   }
	
	
}// class 끝










