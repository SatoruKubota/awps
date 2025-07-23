package com.example.demo.form;

import lombok.Data;

@Data
public class NewUserForm {
	
	private Integer userId;
	private String familyName;
	private String firstName;
	private String mailAddress;
	private String password;
	private Integer busyoId;

}
