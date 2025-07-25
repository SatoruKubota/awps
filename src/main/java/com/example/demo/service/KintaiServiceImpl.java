package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Kintai;
import com.example.demo.repository.KintaiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KintaiServiceImpl implements KintaiService {
	
	private final KintaiRepository repository;

	@Override
	public List<Kintai> findKintaiByUserIdAndDate(Integer userId, Date date) {
		// TODO 自動生成されたメソッド・スタブ
		
		List<Kintai> searchResult = repository.selectByUserIdAndDate(userId, date);
		
		return searchResult;
	}

}
