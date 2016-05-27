package com.javaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"","news"})
public class NewsController {

	@RequestMapping(value={"","view"})
	public String view(Model modelZ) {
		return "news/view";
	}
	
	@RequestMapping("add")
	public String add() {
		return "news/add";
	}
	
	@ResponseBody
	@RequestMapping("saveAdd")
	public String saveAdd(HttpServletRequest request,HttpServletResponse response) {
		String title = request.getParameter("title");
		String keywords = request.getParameter("keywords");
		
		
		return "{flag:ok}";
	}
	
	@RequestMapping("modify")
	public String modify() {
		return "news/modify";
	}
	
	@RequestMapping("delete")
	public String delete() {
		return "news/delete";
	}
}
