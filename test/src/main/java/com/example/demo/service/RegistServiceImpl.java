package com.example.demo.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Kintai;
import com.example.demo.form.RegistForm;
import com.example.demo.repository.KintaiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

	private final KintaiRepository repository;

	@Override
	public void regist(RegistForm registForm) {

		Kintai kintai = new Kintai();

		kintai.setUserId(registForm.getUserId());
		kintai.setDate(registForm.getDate());

		// フラグ決定処理
		String workMode = registForm.getWorkMode();

		switch (workMode) {
	    case "出勤":
	        kintai.setAttendFlag(true);
	        kintai.setTfAttendFlag(false);
	        kintai.setSubHolidayFlag(false);
			kintai.setPvFlag(false);
	        break;

	    case "振出":
	        kintai.setAttendFlag(false);
	        kintai.setTfAttendFlag(true);
	        kintai.setSubHolidayFlag(false);
			kintai.setPvFlag(false);
	        break;

	    case "振休":
	        kintai.setAttendFlag(false);
	        kintai.setTfAttendFlag(false);
	        kintai.setSubHolidayFlag(true);
			kintai.setPvFlag(false);
	        break;

	    case "年休":
	        kintai.setAttendFlag(false);
	        kintai.setTfAttendFlag(false);
	        kintai.setSubHolidayFlag(false);
			kintai.setPvFlag(true);
	        break;

	    case "欠勤":
	        kintai.setAttendFlag(false);
	        kintai.setTfAttendFlag(false);
	        kintai.setSubHolidayFlag(false);
			kintai.setPvFlag(false);
	        break;
	}

		kintai.setWdFlag(true); // 稼働日フラグ→よくわからん

		// 労働時間計算処理
		LocalTime start = registForm.getStart();
		LocalTime finish = registForm.getFinish();
		int breakTimeMinutes = registForm.getBreakTime(); // 休憩時間（分）
		int workingMinutes = WorkingTimeCalculator.calculateWorkingMinutes(start, finish, breakTimeMinutes);
		kintai.setWorkingTime(workingMinutes);

		// 残業時間計算
		Integer ot;
		if (workingMinutes > 420) {
			ot = workingMinutes-420;
		}else {
			ot = 0;
		}
		kintai.setOt(ot);

		kintai.setPvGet(20);
		kintai.setSubHolidayGet(0);

		kintai.setStart(registForm.getStart());
		kintai.setFinish(registForm.getFinish());
		kintai.setBreakTime(registForm.getBreakTime());


		repository.add(kintai);

	}

}