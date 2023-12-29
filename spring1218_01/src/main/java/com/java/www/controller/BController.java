package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	
	//게시글 전체 가져오기
	@RequestMapping("bList")
	public String bList(Model model) {
		//service연결
		ArrayList<BoardDto> list = bService.bList();
		//model에 데이터 담기
		model.addAttribute("list", list);
		
		return "board/bList";
	}
	//게시글 한 개 가져오기
	@RequestMapping("bView")
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model) {
		//service연결
		BoardDto boardDto = bService.selectOne(bno);
		model.addAttribute("bdto", boardDto);
		return "board/bView";
	}
	@RequestMapping("bInsert")
	public String bInsert() {
		return "board/bInsert";	
	}
	
	
	
	
	
	
	
	
}
