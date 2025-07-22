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

    private Integer userId;

    private Date date;

    private String workMode;

    private Time start;
    
    private Time finish;

    private Integer breakTime;

}
