
package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.Kintai;

public interface KintaiRepository {
	
	List<Kintai> selectByUserIdAndDate(Integer userId, Date date);
	
	void add(Kintai kintai);

}