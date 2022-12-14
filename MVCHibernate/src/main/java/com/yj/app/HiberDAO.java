package com.yj.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//dao에는 repository 필요
@Repository
public class HiberDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void insertData(HiberDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

	
		session.save(dto);
		trans.commit();
	}
	
	public void deleteData(HiberDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		
		session.delete(dto);
	
		trans.commit();
	}
	
	public void updateData(HiberDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		session.update(dto);
	
		trans.commit();
	}
	
	public List<HiberDTO> selectAll(){//select이기 때문에 return 필수!
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		List<HiberDTO> list = session.createCriteria(HiberDTO.class).list();
		trans.commit(); //의미없음.
		
		
		return list;
	}
	
	
	public HiberDTO selectOne(HiberDTO dto) {//int로 받아도 상관없음
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		HiberDTO d = (HiberDTO)session.get(HiberDTO.class, dto.getIdx());
		trans.commit();
		return dto;

	}
	//==============hbdummy end=============
	
	
	
	public List<BoardDTO> selectAllBoard(){//select이기 때문에 return 필수!
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		List<BoardDTO> blist = session.createCriteria(BoardDTO.class).list();
		trans.commit(); //의미없음.
		
		return blist;
	}
	
	
	public BoardDTO selectOneBoard(BoardDTO bdto) {//int로 받아도 상관없음
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		BoardDTO bd = (BoardDTO)session.get(BoardDTO.class, bdto.getIdx());
		trans.commit();
		return bdto;

	}
	
	public void insertBoard(BoardDTO bdto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

	
		session.save(bdto);
		trans.commit();
	}
	
	public void deleteBoard(BoardDTO bdto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		
		session.delete(bdto);
	
		trans.commit();
	}
	
	public void updateBoard(BoardDTO bdto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		session.update(bdto);
	
		trans.commit();
	}
	
	
	
}
