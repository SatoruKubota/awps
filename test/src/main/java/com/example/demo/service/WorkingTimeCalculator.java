package com.example.demo.service;

import java.time.Duration;
import java.time.LocalTime;

public class WorkingTimeCalculator {

	public static int calculateWorkingMinutes(LocalTime start, LocalTime finish, int breakTimeMinutes) {
		Duration duration = Duration.between(start, finish);
		int totalMinutes = (int) duration.toMinutes() - breakTimeMinutes;
		return Math.max(totalMinutes, 0); // 負の値を防ぐ

	}
}
