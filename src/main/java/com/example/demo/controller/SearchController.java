package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Kintai;
import com.example.demo.form.SearchForm;
import com.example.demo.service.KintaiService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

	private final KintaiService service;

	/*--- 最初のリクエスト -------------------------*/
	@GetMapping("/user-menu-sample")
	public String adminSample() {
		return "user-menu-sample";
	}

	@GetMapping("/search-request")
	public String searchRequest(
			@ModelAttribute SearchForm form) {
		return "user-search";
	}

	@PostMapping("/search-result")
	public String searchResult(
			@ModelAttribute SearchForm form, Model model) {

		List<Kintai> searchResult = service.findKintaiByUserIdAndDate(form.getUserId(), form.getDate());

		model.addAttribute("searchResult", searchResult);

		return "user-search";
	}
}