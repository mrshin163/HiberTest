package com.rest.board.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.board.domain.Board;

@Repository
public class BoardDAOHibernate implements BoardDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List selectAll(){
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		Session session=sessionFactory.getCurrentSession();
		List list=session.createSQLQuery("select * from board").list();
		return list;
	} 
	public Board select(int board_id){
		return null;
	}
	

	public void insert(Board board){
		System.out.println("save !!");
		
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		
		Session session=sessionFactory.getCurrentSession();
		session.save(board);
		tx.commit();
		
	}
	
	public void update(Board board){
		
	}
	
	public void delete(int board_id){
		
	}
	
	
}
