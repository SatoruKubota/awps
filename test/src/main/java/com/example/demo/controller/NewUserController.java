package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.NewUserForm;

@Controller
public class NewUserController {
	
	@GetMapping("/admin-menu-sample")
	public String adminSample(){
		return "admin-menu-sample";
	}
	
	@GetMapping("/new-user-regist")
	public String newUserRequest(
			@ModelAttribute NewUserForm form) {
		return "new-user-regist";
	}
	
	@PostMapping("/new-user-confirm")
	public String newUserConfirm(
			@ModelAttribute NewUserForm form, Model model) {
		return "new-user-confirm";
	}
	
	@GetMapping("/new-user-complete")
	public String newUserComplete() {
		return "new-user-complete";
	}

}
