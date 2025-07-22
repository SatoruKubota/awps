package com.example.demo.service;

import java.sql.Date;

import com.example.demo.entity.Kintai;

public interface KintaiService {
		
    Kintai findKintaiByUserIdAndDate(Integer userId, Date date);
	
}
