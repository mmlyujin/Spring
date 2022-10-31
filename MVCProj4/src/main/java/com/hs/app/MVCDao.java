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
	//private String insert;// @Value �� ������ ���� �ִ� �ֳ����̼�
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
	
	//select�� �ϱ� ���ؼ� jdbcTmp�� ��� rowMapper Ŭ������ �ʿ��ϴ�
	// ���״�� row�� dto�� 1:1 ���� ��Ű�� Ŭ���� �̴�.
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
	      String res = "����� �� �ִ� ���̵�";
	      if(jdbcTmp.queryForInt(selectId, id)>0) {
	         res="����� �� ���� ���̵�";
	      }
	      
	      return res;
	      
	   }
	
	
}// class ��










