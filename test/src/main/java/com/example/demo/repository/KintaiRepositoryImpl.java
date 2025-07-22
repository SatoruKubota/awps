package com.example.demo.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Kintai;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class KintaiRepositoryImpl implements KintaiRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<Kintai> selectByUserIdAndDate(Integer userId, Date date) {
		// TODO 自動生成されたメソッド・スタブ
		
		String sql = 
				"  SELECT                 " + 
				"    review_id,           " + 
				"    restaurant_id,       " + 
				"    user_id,             " + 
				"    visit_date,          " + 
				"    rating,              " + 
				"    comment              " + 
				"  FROM                   " + 
				"    t_review             " + 
				"  WHERE                  " + 
				"    restaurant_id = ?    " + 
				"  ORDER BY               " + 
				"    visit_date DESC,     " + 
				"    review_id ASC        ";
		
		// SQLで検索（プレースホルダ：引数で受け取ったrestaurantId）
		List<Map<String, Object>> list 
						= jdbcTemplate.queryForList(sql, userId);
		
		return null;
	}

}
