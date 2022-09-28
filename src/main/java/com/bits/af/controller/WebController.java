package com.bits.af.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("home")
	public String home() {

		return "index.html";
	}

	@RequestMapping("login")
	public String login() {

		return "login.html";
	}

	@RequestMapping("signup")
	public String signup() {

		return "signup.html";
	}

	@RequestMapping("register")
	public String register() {

		return "post.html";
	}
	
	@RequestMapping("list")
	public String listProperties() {

		return "list.html";
	}

}