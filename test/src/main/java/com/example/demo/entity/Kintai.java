package com.example.demo.entity;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kintai {

    private Date date;
    private Boolean attendFlag; 
    private Boolean tfAttendFlag;
    private Boolean subHolidayFlag; 
    private Boolean wdFlag;
    private Time start;
    private Time finish;
    private Integer breakTime;
    private Integer workingTime;
    private Integer ot;
    private Boolean pvFlag;
    private Integer pvGet;
    private Integer subHolidayGet;
    private String workMode;

}
