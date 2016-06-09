package com.rest.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rest.board.domain.Board;
import com.rest.board.service.BoardService;

@Controller
@RequestMapping("/rest")
public class BoardController{
	@Autowired
	private BoardService boardService;

	
	//디바이스로 접근시 
	@RequestMapping(value="/board", method=RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<Board> selectAll(){
		System.out.println("selectAll 호출");
		List list=boardService.selectAll();
		System.out.println("list is "+list);
		return list;
	}
	
	//browser
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String getList(Model model){
		model.addAttribute("list",selectAll());
		return "board/list";
	}
	
	//디바이스 접근
	@RequestMapping(value="/board", method=RequestMethod.POST, produces={"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void regist(@RequestBody Board board){
		boardService.insert(board);
	}
	
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public String insert(Board board){
		regist(board);
		return "redirect:/rest/board";
	}
	
}











