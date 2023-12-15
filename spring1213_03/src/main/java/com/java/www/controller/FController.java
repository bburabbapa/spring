package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //jsp페이지오픈
public class FController {
	@GetMapping
	public String index() {
		return "index";
	}
	
	
	
	

}
