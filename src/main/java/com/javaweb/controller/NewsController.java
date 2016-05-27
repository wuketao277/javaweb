package com.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"","news"})
public class NewsController {

	@RequestMapping(value={"","view"})
	public String view(Model model) {
		return "news/view";
	}
	
	@RequestMapping("add")
	public String add() {
		return "news/add";
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
