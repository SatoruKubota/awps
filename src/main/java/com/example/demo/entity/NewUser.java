package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {

	private Integer userId;
	private String familyName;
	private String firstName;
	private String mailAddress;
	private String password;
	private Integer busyoId;

}
