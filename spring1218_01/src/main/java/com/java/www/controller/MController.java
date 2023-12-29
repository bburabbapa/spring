package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	//IOC컨테이너에 있는 객체 가져오기
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model, HttpServletRequest request) {
		int result = 0;
		System.out.println("id: "+mdto.getId());
		System.out.println("pw: "+mdto.getPw());
		MemberDto memberDto = mService.loginSelect(mdto);//mdto의 id pw를 태워 보냄
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
			System.out.println("id: "+memberDto.getId());			
			result = 1;
		}else {
			System.out.println("id: null");			
		}
		//result=1:로그인성공 result=0:로그인실패
		model.addAttribute("result", result);	
		//데이터를 jsp로 보냄
		//model.addAttribute("id", mdto.getId());	
		//model.addAttribute("pw", mdto.getPw());
		return "member/doLogin";
	}
}
