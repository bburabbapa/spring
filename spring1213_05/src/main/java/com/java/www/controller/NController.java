package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("notice")
public class NController {
	
	@RequestMapping("noticeList")
	public String noticeList() {
		return "notice/noticeList";
	}
	
	@RequestMapping("noticeInsert")
	public String noticeInsert() {
		return "notice/noticeInsert";
	}
	
	@RequestMapping("doNoticeInsert")
	public String doNoticeInsert(HttpServletRequest request,Model model) {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bfile = request.getParameter("bfile"); //파일이름만보내기때문에 enctype 필요없음 (파일업로드시에필요함)
		System.out.println("btitle: "+btitle);
		System.out.println("bcontent: "+bcontent);
		System.out.println("bfile: "+bfile);
		Timestamp bdate = new Timestamp(System.currentTimeMillis());
		//빌더형태는 순서 상관없음!!!
		BoardDto bdto = BoardDto.builder() .btitle(btitle).bcontent(bcontent).bdate(bdate).bfile(bfile).build();
		model.addAttribute("bdto", bdto);
		//model.addAttribute("btitle", btitle);
		//model.addAttribute("bcontent", bcontent);
		//model.addAttribute("bdate", bdate);
		//model.addAttribute("bfile", bfile);
		
		return "notice/noticeView";
	}
	
	
	@RequestMapping("noticeView") //GetMapping,PostMapping 둘다 가능
	public String noticeView() {
		return "notice/noticeView";
	}
	
//	@RequestMapping("doNoticeView") //GetMapping,PostMapping 둘다 가능
//	public String doNoticeView(HttpServletRequest request,Model model) {
//		Timestamp bdate = new Timestamp(System.currentTimeMillis());
//		BoardDto bdto = new BoardDto(0, null, null, bdate, null, 0, 0, 0, 0, null);
//		model.addAttribute("bdto", bdto);
//		return "notice/noticeView";
//	}

}
