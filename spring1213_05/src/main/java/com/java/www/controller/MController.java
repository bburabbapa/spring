package com.java.www.controller;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MController {

	@GetMapping("member/memberInsert")
	public String memberInsert(Model model) {
		return "member/memberInsert";
	}
	
	@GetMapping("member/login")
	public String login(Model model) {
		return "member/login";
	}
	
	@PostMapping("member/doLogin") //리퀘스트파람을 통해 하나씩 가져오기
	public String doLogin(@RequestParam String id,@RequestParam String pw,
	@RequestParam(defaultValue = "1") int bno, Model model) { //게시글번호 미입력시 1번으로 출력하게끔 1로셋팅
		System.out.println("id: "+id);
		System.out.println("pw: "+pw); //String / int 형변환없이 가져옴
		System.out.println("bno: "+bno);
		return "/index";
	}

	@PostMapping("member/doMemberInsert")//기존 방식인 리퀘스트 겟파라미터
	public String doMemberInsert(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String [] hobbys = request.getParameterValues("hobby");
		System.out.printf("%s,%s,%s,%s,%s,%s",id,pw,name,phone,gender,Arrays.toString(hobbys));
		return "/member/memberView";
	}

	@GetMapping("member/memberUpdate")
	public String memberUpdate(Model model) {

		// id를 전달
		// String id = "aaa";
		// request.setAttribute("id", id);
		// 현재날짜와 시간을 Timestamp파일에 저장
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto = new MemberDto("bbb", "1111", "유관순", "010-1111-1111", "male", "game,golf", mdate);
		// model.addAttribute("id",id);
		model.addAttribute("mdto", mdto);
		System.out.println("MemberDto id : " + mdto.getId());
		return "member/memberUpdate";

		// ModelAndView
		// ModelAndView mv = new ModelAndView();
		// id를 전달
		// String id = "",pw="",name="",phone="",gender="",hobby="";
		// request.setAttribute("id", id);
		// 현재날짜와 시간을 Timestamp파일에 저장
		// Timestamp mdate = new Timestamp(System.currentTimeMillis());
		// MemberDto mdto
		// = new MemberDto("bbb", "1111", "유관순", "010-1111-1111", "male", "game,golf",
		// mdate);

		// model.addAttribute("id",id);
		// model.addAttribute("pw",pw);
		// model.addAttribute("name",name);
		// model.addAttribute("phone",phone);
		// model.addAttribute("gender",gender);
		// model.addAttribute("hobby",hobby);
		// model.addAttribute("mdto",mdto);
		// mv.addObject("mdto", mdto);
		// mv.setViewName("member/memberInsert");
		// System.out.println("MemberDto id : "+mdto.getId());
		// return mv;
	}
}
