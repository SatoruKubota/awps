package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.RegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {
	
	private final RegistService service;	
	
	@GetMapping("/regist-kintai")
	public String registKintai(
			@ModelAttribute RegistForm form) {
		return "regist-kintai";
	}
	
	@PostMapping("/regist-confirm")
	public String registConfirm(
			@ModelAttribute RegistForm form, Model model) {
		
		RegistForm RF = new RegistForm();
		RF.setUserId(form.getUserId());
		RF.setDate(form.getDate());
		RF.setWorkMode(form.getWorkMode());
		RF.setStart(form.getStart());
		RF.setFinish(form.getFinish());
		RF.setBreakTime(form.getBreakTime());
		service.regist(RF);
		
		return "regist-confirm";
	}
	
	@GetMapping("/regist-complete")
	public String registComplete() {
		return "regist-complete";
	}

}
