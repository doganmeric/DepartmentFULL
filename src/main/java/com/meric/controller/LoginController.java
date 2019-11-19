package com.meric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	@GetMapping("/showCustomLoginPage")
	public String showCustomLoginPage() {
		return "login";
	}
	@GetMapping("/erisim-engellendi")
	public String accessDenied() {
		return "erisim";
	}

}
