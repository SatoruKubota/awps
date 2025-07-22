package com.example.demo.controller;

import java.sql.Time;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Kintai;
import com.example.demo.form.SearchForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
//	private final KintaiService service;

	/*--- 最初のリクエスト -------------------------*/
	@GetMapping("/menu-sample")
	public String sample(){
		return "menu-sample";
	}
	
	@GetMapping("/search-request")
	public String searchRequest(
			@ModelAttribute SearchForm form) {
		return "user-search";
	}
	
//	@PostMapping("/search-result")
//	public String searchResult(
//			@ModelAttribute SearchForm form, Model model) {
//		return "search-result";
//	}
	
	@PostMapping("/search-result")
	public String searchResult(
			@ModelAttribute SearchForm form, Model model) {
				
//		Kintai searchResult = service.findKintaiByUserIdAndDate(form.getUserId(), form.getDate());
		Kintai searchResult = new Kintai();
		searchResult.setStart(Time.valueOf("09:00:00"));
		searchResult.setFinish(Time.valueOf("17:00:00"));
		searchResult.setBreakTime(60);

		model.addAttribute("searchResult", searchResult);
		
		return "user-search";
	}
}
