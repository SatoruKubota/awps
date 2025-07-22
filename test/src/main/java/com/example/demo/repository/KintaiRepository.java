package com.example.demo.repository;

import java.sql.Date;

import com.example.demo.entity.Kintai;

public interface KintaiRepository {
	
	Kintai selectByUserIdAndDate(Integer userId, Date date);

}
