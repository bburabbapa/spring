package com.java.www.controller;

import java.lang.reflect.Member;
import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("member")
public class MemberController {

	@RequestMapping("mInsert")
    public String mInsert() {
    	return "member/memberInsert"; //memberInsert.jsp
    }
	@RequestMapping("doMInsert")
	public String doMInsert(MemberDto mdto, Model model) {
		//데이터 받는 방법
		//1.HttpServletRequest, 2.@RequestParam, 3.변수  4.객체
		model.addAttribute("mdto",mdto);
		System.out.println("controller hobby : "+mdto.getHobby());
		return "member/memberView"; //memberView.jsp
	}
	@RequestMapping("mUpdate")
	public String mUpdate(MemberDto mdto, Model model) {
		model.addAttribute("mdto",mdto);
		return "member/memberUpdate";//memberUpdate.jsp
	}
	
	@RequestMapping("mView")
	public String mView(MemberDto mdto, Model model) {
		model.addAttribute("mdto",mdto);
		return "member/memberView"; //memberView.jsp
	}
	
	@RequestMapping("login")
    public String login() {
    	return "member/login";
    }
	
	@PostMapping("doLogin")
	public String doLogin(MemberDto memberDto
			,BoardDto boardDto, Model model
			) {
		System.out.println("controller id : "+memberDto.getId());
		System.out.println("controller pw : "+memberDto.getPw());
		System.out.println("controller bno : "+boardDto.getBno());
		
		String id = memberDto.getId();
		String pw = memberDto.getPw();
		int bno = boardDto.getBno();
		
		
		//기본생성자
		MemberDto mdto = new MemberDto();
		mdto.setId(id);
		System.out.println("mdto.getId : "+mdto.getId());
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		//전체생성자
		MemberDto mdto2 = new MemberDto(id, pw, "홍길동", "010-1111-1111",
				"male", "game,golf", mdate); 
		//부분생성자
		MemberDto mdto3 = MemberDto.builder().id(id).pw(pw)
				.name("유관순").gender("female").build();
		
		System.out.println("controller mdto3.name : "+mdto3.getName());
		
		model.addAttribute("id",id); //request
		model.addAttribute("pw",pw);
		model.addAttribute("bno",bno);
		model.addAttribute("mdto",memberDto);
		
		return "member/doLogin";
	}
}
