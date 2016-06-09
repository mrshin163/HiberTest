package com.rest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.board.domain.Board;
import com.rest.board.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	

	public List selectAll() {
		return boardDAO.selectAll();
	}

	@Override
	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}


	public void insert(Board board) {
		boardDAO.insert(board);		
		System.out.println("서비스에서 inserrt 호출");
	}

	@Override
	public void update(Board board) {
		boardDAO.update(board);		
	}

	@Override
	public void delete(int board_id) {
		boardDAO.delete(board_id);
	}
	
}
