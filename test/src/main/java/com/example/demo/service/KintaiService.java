package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.Kintai;

public interface KintaiService {
		
    List<Kintai> findKintaiByUserIdAndDate(Integer userId, Date date);
	
}
