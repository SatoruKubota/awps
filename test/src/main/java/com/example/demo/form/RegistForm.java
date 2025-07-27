package com.example.demo.form;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class RegistForm {
	
	private Integer userId;
	private LocalDate date;
	private String workMode;
	private LocalTime start;
	private LocalTime finish;
	private Integer breakTime;

}
