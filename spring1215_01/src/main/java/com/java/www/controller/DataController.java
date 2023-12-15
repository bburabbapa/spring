package com.java.www.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;

@Controller
public class DataController {
	
	@ResponseBody
	@RequestMapping("boardBno/{bno}/{bhit}")
	public String boardBno(@PathVariable(required = false) String bno,@PathVariable(required = false) String bhit) {
		
		String txt = "boardBno 글번호 : "+bno;
		txt += ", 조회수 bhit  : "+bhit;
		
		return txt;  //aaa.jsp
	}
	
	@RequestMapping("mInsert")
	public String mInsert() {
		return "mInsert";  //aaa.jsp
	}
	
	@ResponseBody
	@RequestMapping("idCheck")
	public Map<String, Object> idCheck(String id) {
		//db검색 select * from member where id=?
		Map<String, Object> map = new HashMap<>();
		ArrayList<MemberDto> list = new ArrayList<>();
		// 임의의 조건으로 ID 체크 예시
		if(id.equals("aaa")) {
			map.put("result", "fail");    //불가능
		}else {
			map.put("result", "success"); //사용가능
		}
		// 임의의 데이터를 리스트에 추가
		list.add(new MemberDto("ccc","1111","이순신","010","female",
				"game,golf",new Timestamp(System.currentTimeMillis())));
		list.add(new MemberDto("ddd","1111","강감찬","010","female",
				"game,golf",new Timestamp(System.currentTimeMillis())));
		 // Map에 다양한 정보 추가
		map.put("name", "홍길동");
		map.put("phone", "010-1111-1111");
		map.put("bno", 1);
		map.put("list", list);
		map.put("mdto", new MemberDto("bbb","1111","유관순","010","female",
				"game,golf",new Timestamp(System.currentTimeMillis())));
		
		 // Json 형식으로 자동 변환되어 응답으로 전송됨 (Map, list는 Spring이 자동으로 JSON으로 변환)
		return map;
	}
	
	
	@RequestMapping("aaa")
	public String aaa() {
		return "aaa";  //aaa.jsp
	}
	
	@ResponseBody //데이터로 리턴
	@RequestMapping("bbb")
	public String bbb() {
		String txt = "{'id':'aaa','pw':'1111','name':'홍길동'}";
		return txt;  //aaa.jsp
	}

}
