package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.NewUser;
import com.example.demo.form.NewUserForm;
import com.example.demo.service.MUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NewUserController {
	
	private final MUserService service;
	
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
		
		NewUser NU = new NewUser();
		NU.setUserId(form.getUserId());
		NU.setFamilyName(form.getFamilyName());
		NU.setFirstName(form.getFirstName());
		NU.setMailAddress(form.getMailAddress());
		NU.setBusyoId(form.getBusyoId());
		NU.setPassword(form.getPassword());
		service.regist(NU);
		
				
		return "new-user-confirm";
	}
	
	@GetMapping("/new-user-complete")
	public String newUserComplete() {
		return "new-user-complete";
	}

}
