package com.example.demo.service;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewUser;
import com.example.demo.repository.MUserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MUserServiceImpl implements MUserService {
	
	private final MUserRepository repository;

	@Override
	public void regist(NewUser newUser) {
		// TODO 自動生成されたメソッド・スタブ
		
		repository.add(newUser);

	}

}
