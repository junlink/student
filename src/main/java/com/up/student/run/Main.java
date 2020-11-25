/**
 * 项目名：student
 * 修改历史：
 * 作者： MZ
 * 创建时间： 2016年1月6日-上午9:43:05
 */
package com.up.student.run;

import com.up.student.util.DBUtil;
import com.up.student.view.LoginView;

import javax.swing.*;
import java.awt.*;

/**
 * 模块说明：主函数
 * 
 */
public class Main {
	public static void initDB() {
		DBUtil dbUtil = DBUtil.getDBUtil();

		//检查数据库是否初始化
		if (dbUtil.exeute("select 1 from  admin")) {
			return;
		}

		//初始化数据库
		//admin表
		dbUtil.exeute("create table if not exists admin(id int primary key," +
				"name varchar(32)," +
				"username varchar(32)," +
				"password varchar(32))");
		dbUtil.exeute("insert into admin(id, name, username, password) values(1, 'admin', 'admin', 'admin')");
		dbUtil.exeute("insert into admin(id, name, username, password) values(2, 'user', '1', '1')");
		//student
		dbUtil.exeute("create table if not exists student(" +
				"id int primary key," +
				"teacher_code varchar(16)," +
				"name varchar(32)," +
				"c1 varchar(32)," +
				"c2 varchar(32)," +
				"c3 varchar(32)," +
				"c4 varchar(32)," +
				"c5 varchar(32)," +
				"c6 varchar(32)," +
				"c7 varchar(32)," +
				"c8 varchar(32)," +
				"c9 varchar(32)," +
				"c10 varchar(32)," +
				"c11 varchar(32)," +
				"c12 varchar(32)," +
				"c13 varchar(32)," +
				"c14 varchar(32)," +
				"c15 varchar(32)," +
				"c16 varchar(32)," +
				"c17 varchar(32)," +
				"c18 varchar(32)," +
				"c19 varchar(32)," +
				"c20 varchar(32)," +
				"c21 varchar(32)," +
				"c22 varchar(32)," +
				"c23 varchar(32)," +
				"c24 varchar(32)," +
				"c25 varchar(32)," +
				"c26 varchar(32)," +
				"c27 varchar(32)," +
				"c28 varchar(32)," +
				"c29 varchar(32)," +
				"c30 varchar(32)," +
				"c31 varchar(32)," +
				"c32 varchar(32)," +
				"c33 varchar(32))");

		dbUtil.exeute("create table if not exists CostData(" +
				"name varchar(32) primary key," +
				"amount varchar(32)," +
				"depreciationPeriod varchar(32)," +
				"salvageRate varchar(32)," +
				"airplaneSeat varchar(32)," +
				"engineNumber varchar(32)," +
				"airTime varchar(32)," +
				"landingInterval varchar(32)," +
				"airOil varchar(32)," +
				"landOil varchar(32)," +
				"A_GDeviationDate varchar(32)," +
				"TO_LandingFee varchar(32)," +
				"ManMachineRatio varchar(32)," +
				"PreTaxJetPrice varchar(32)," +
				"JetFuelPrice varchar(32)," +
				"Tariff varchar(32)," +
				"VAT varchar(32)," +
				"ExchangeRate varchar(32)," +
				"LoanRatio varchar(32)," +
				"AnnualRate varchar(32)," +
				"AnnualRepayments varchar(32)," +
				"LoanLife varchar(32)," +
				"Jet_insurance varchar(32)," +
				"PerSeat_insurance varchar(32)," +
				"Seat_insurance_rate varchar(32)," +
				"ThirdParty_insurance varchar(32)," +
				"ThirdParty_insurance_rate varchar(32)," +
				"engineChangeFee varchar(32)," +
				"engineChangeInterval varchar(32)," +
				"jetBigRepairMaterialFee varchar(32)," +
				"jetBigRepairInterval varchar(32)," +
				"jetBigRepairWorkingHour varchar(32)," +
				"jetBigRepairWorkingHourFee varchar(32)," +
				"jetSmallRepairMaterialFee varchar(32),"+
				"jetSmallRepairWorkingHour varchar(32),"+
				"jetSmallRepairInterval varchar(32),"+
				"jetSmallRepairWorkingHourFee varchar(32),"+
				"teacherSalary varchar(32) )");
	}

	public static void main(String[] args) {
		initDB();
		new LoginView();
		DBUtil.getDBUtil().close();
	}

}
