package com.hs.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertData(BoardDto dto) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		session.save(dto);
		trans.commit();
	}
}
