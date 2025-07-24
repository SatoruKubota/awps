package com.example.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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

		String tableName = "kintaitable_" + userId;

		String sql = " SELECT                              " +
				"   DATE,                             " +
				"   ATTEND_FLAG,                      " +
				"   TF_ATTEND_FLAG,                   " +
				"   SUB_HOLIDAY_FLAG,                 " +
				"   WD_FLAG,                          " +
				"   START,                            " +
				"   FINISH,                           " +
				"   WORKING_TIME,                     " +
				"   BREAK_TIME,                       " +
				"   OT,                               " +
				"   PV_FLAG,                          " +
				"   PV_GET,                           " +
				"   SUB_HOLIDAY_GET                   " +
				" FROM                                " +
				" " + tableName + "                 " +
				" WHERE                               " +
				"   DATE = ?                          ";

		// SQLで検索（プレースホルダ：date）

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, date);

		// 値の取得⇒結果の格納
		List<Kintai> result = new ArrayList<Kintai>(); // 結果の初期化
		for (Map<String, Object> one : list) { // データベースの値を取得
			Kintai kintai = new Kintai();
			kintai.setDate(((Date) one.get("DATE")));
			kintai.setWdFlag((Boolean) one.get("WD_FLAG"));					// 稼働日フラグ
			kintai.setAttendFlag((Boolean) one.get("ATTEND_FLAG")); 		// 出勤フラグ
			kintai.setTfAttendFlag((Boolean) one.get("TF_ATTEND_FLAG")); 	// 振出フラグ
			kintai.setSubHolidayFlag((Boolean) one.get("SUB_HOLIDAY_FLAG"));// 振休フラグ
			kintai.setPvFlag((Boolean) one.get("PV_FLAG")); 				// 年休フラグ	
			kintai.setStart((Time) one.get("START"));						// 出勤時刻
			kintai.setFinish((Time) one.get("FINISH"));						// 退勤時刻
			kintai.setWorkingTime((Integer) one.get("WORKING_TIME"));		// 勤務時間
			kintai.setBreakTime((Integer) one.get("BREAK_TIME"));			// 休憩時間
			kintai.setOt((Integer) one.get("OT"));							// 残業時間
			kintai.setPvGet((Integer) one.get("PV_GET"));					// 有給取得可能回数
			kintai.setSubHolidayGet((Integer) one.get("SUB_HOLIDAY_GET"));	// 振休取得可能回数
			
			// 勤務形態を決定
			Boolean attendFlag = kintai.getAttendFlag();
			Boolean tfAttendFlag = kintai.getTfAttendFlag();
			Boolean subHolidayFlag = kintai.getSubHolidayFlag();
			Boolean pvFlag = kintai.getPvFlag();
			
			String workMode;
			
			if (attendFlag && !tfAttendFlag && !subHolidayFlag && !pvFlag) {
				workMode = "出勤";
				kintai.setWorkMode(workMode);
			}else if(!attendFlag && tfAttendFlag && !subHolidayFlag && !pvFlag) {
				workMode = "振出";
				kintai.setWorkMode(workMode);
			}else if(!attendFlag && !tfAttendFlag && subHolidayFlag && !pvFlag) {
				workMode = "振休";
				kintai.setWorkMode(workMode);
			}else if(!attendFlag && !tfAttendFlag && !subHolidayFlag && pvFlag) {
				workMode = "振出";
				kintai.setWorkMode(workMode);
			}else {
				workMode = "不正な勤務形態";
				kintai.setWorkMode(workMode);
			}
			
			
			result.add(kintai);
		}
		return result;

	}

}
