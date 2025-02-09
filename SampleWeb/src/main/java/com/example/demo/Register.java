package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Register {
	@RequestMapping("/")//URLがlocalhost:8080の時に実行
	public String start() {
		return "input.html";

	}

	@RequestMapping("/register")//URLがlocalhost:8080/registerの時に実行
	public ModelAndView register(@ModelAttribute RegisterBean rb,ModelAndView m) {
		m.addObject("rb", rb);
		m.setViewName("register.html");
		return m;
	}

}
