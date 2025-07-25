package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewUser;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MUserRepositoryImpl implements MUserRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public void add(NewUser newUser) {

		String sql = " INSERT INTO m_user " +
				" (USER_ID, MAIL, PASS, BUSHO_ID, FAMILY_NAME, FIRST_NAME) " +
				" VALUES (?, ?, SHA2(?, 256), ?, ?, ?) ";

		jdbcTemplate.update(sql,
				newUser.getUserId(),
				newUser.getMailAddress(),
				newUser.getPassword(),
				newUser.getBusyoId(),
				newUser.getFamilyName(),
				newUser.getFirstName());


	}

	
        
}
