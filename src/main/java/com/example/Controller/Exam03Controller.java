package com.example.Controller;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/calc-result")
	public String calcResult(Integer item1,Integer item2,Integer item3) {
		Integer totalPlace = item1+item2+item3;
		Integer totalPlaceOnTax = (int) (totalPlace*1.1);
		
		application.setAttribute("totalPlace", totalPlace);
		application.setAttribute("totalPlaceOnTax", totalPlaceOnTax);
		
		return "exam03-result";
	}
}
