package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kintai {

	private Integer userId;
    private LocalDate date;
    private Boolean attendFlag; 
    private Boolean tfAttendFlag;
    private Boolean subHolidayFlag; 
    private Boolean wdFlag;
    private LocalTime start;
    private LocalTime finish;
    private Integer breakTime;
    private Integer workingTime;
    private Integer ot;
    private Boolean pvFlag;
    private Integer pvGet;
    private Integer subHolidayGet;
    private String workMode;


}