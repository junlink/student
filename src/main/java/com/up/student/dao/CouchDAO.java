/**
 * 项目名：student
 * 修改历史：
 * 作者： MZ
 * 创建时间： 2016年1月6日-上午10:00:07
 */
package com.up.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.up.student.base.BaseDAO;
import com.up.student.model.CouchJudge;


public class CouchDAO extends BaseDAO {
	private final int fieldNum = 36;
	private final int showNum = 36;
	private static CouchDAO sd = null;

	public static synchronized CouchDAO getInstance() {
		if (sd == null) {
			sd = new CouchDAO();
		}
		return sd;
	}

	// update
	public boolean update(CouchJudge stu, String num_c, String value) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		try {
			// check
			if (queryBySno(stu.getTeacher_Code()) == 0) {
				return result;
			}
			// update
			String sql = "update student set "+num_c+"=? where name=? and teacher_code=?";
			String[] param = { value, stu.getName(), stu.getTeacher_Code() };
			int rowCount = db.executeUpdate(sql, param);
			if (rowCount == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}

	// delete
	public boolean delete(CouchJudge stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		String sql = "delete from student where name=? and teacher_code=?";
		String[] param = { stu.getName(), stu.getTeacher_Code() };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}

	// add
	public boolean add(CouchJudge stu) {
		boolean result = false;
		if (stu == null) {
			return result;
		}
		try {
			// check
			if (queryBySno(stu.getTeacher_Code()) == 1) {
				return result;
			}
			// insert

			String sql = "insert into student(id,teacher_code,name,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33) " +
					"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			String[] param = { stu.getId(),stu.getTeacher_Code(),stu.getName(),  stu.getAddC1(), stu.getAddC2(), stu.getAddC3(), stu.getAddC4(), stu.getAddC5(),
					stu.getAddC6(),stu.getAddC7(),stu.getAddC8(),stu.getAddC9(),stu.getAddC10(),stu.getAddC11(),stu.getAddC12(),stu.getAddC13(),
					stu.getAddC14(),stu.getAddC15(),stu.getAddC16(),stu.getAddC17(),stu.getAddC18(),stu.getAddC19(),stu.getAddC20(),stu.getAddC21(),
					stu.getAddC22(),stu.getAddC23(),stu.getAddC24(),stu.getAddC25(),stu.getAddC26(),stu.getAddC27(),stu.getAddC28(),stu.getAddC29(),
					stu.getAddC30(),stu.getAddC31(),stu.getAddC32(),stu.getAddC33()};

			if (db.executeUpdate(sql, param) == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}

	// query by name
	public String[][] queryByName(String name) {
		String[][] result = null;
		if (name.length() < 0) {
			return result;
		}
		List<CouchJudge> stus = new ArrayList<CouchJudge>();
		int i = 0;
		String sql = "select * from student where name like ?";
		String[] param = { "%" + name + "%" };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				  buildList(rs, stus, i);
				i++;
			}
			if (stus.size() > 0) {
				result = new String[stus.size()][fieldNum];
				for (int j = 0; j < stus.size(); j++) {
					buildResult(result, stus, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}

	// query
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<CouchJudge> stus = new ArrayList<CouchJudge>();
		int i = 0;
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from student limit ?,?";
		Integer[] param = { beginNum, showNum };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				buildList(rs, stus, i);
				i++;
			}
			if (stus.size() > 0) {
				result = new String[stus.size()][showNum];
				for (int j = 0; j < stus.size(); j++) {
					buildResult(result, stus, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}

	// 将rs记录添加到list中
	private void buildList(ResultSet rs, List<CouchJudge> list, int i) throws SQLException {
		CouchJudge stu = new CouchJudge();
		stu.setId(i + 1);
		stu.setName(rs.getString("name"));
		stu.setTeacher_Code(rs.getString("teacher_code"));
		stu.setAddC1(rs.getString("C1"));
		stu.setAddC2(rs.getString("C2"));
		stu.setAddC3(rs.getString("C3"));
		stu.setAddC4(rs.getString("C4"));
		stu.setAddC5(rs.getString("C5"));
		stu.setAddC6(rs.getString("C6"));
		stu.setAddC7(rs.getString("C7"));
		stu.setAddC8(rs.getString("C8"));
		stu.setAddC9(rs.getString("C9"));
		stu.setAddC10(rs.getString("C10"));
		stu.setAddC11(rs.getString("C11"));
		stu.setAddC12(rs.getString("C12"));
		stu.setAddC13(rs.getString("C13"));
		stu.setAddC14(rs.getString("C14"));
		stu.setAddC15(rs.getString("C15"));
		stu.setAddC16(rs.getString("C16"));
		stu.setAddC17(rs.getString("C17"));
		stu.setAddC18(rs.getString("C18"));
		stu.setAddC19(rs.getString("C19"));
		stu.setAddC20(rs.getString("C20"));
		stu.setAddC21(rs.getString("C21"));
		stu.setAddC22(rs.getString("C22"));
		stu.setAddC23(rs.getString("C23"));
		stu.setAddC24(rs.getString("C24"));
		stu.setAddC25(rs.getString("C25"));
		stu.setAddC26(rs.getString("C26"));
		stu.setAddC27(rs.getString("C27"));
		stu.setAddC28(rs.getString("C28"));
		stu.setAddC29(rs.getString("C29"));
		stu.setAddC30(rs.getString("C30"));
		stu.setAddC31(rs.getString("C31"));
		stu.setAddC32(rs.getString("C32"));
		stu.setAddC33(rs.getString("C33"));
		list.add(stu);
	}

	// 将list中记录添加到二维数组中
	private void buildResult(String[][] result, List<CouchJudge> stus, int j) {
		CouchJudge stu = stus.get(j);
		result[j][0] = String.valueOf(stu.getId());
		result[j][1] = stu.getName();
		result[j][2] = stu.getTeacher_Code();
		result[j][3] = stu.getAddC1();
		result[j][4] = stu.getAddC2();
		result[j][5] = stu.getAddC3();
		result[j][6] = stu.getAddC4();
		result[j][7] = stu.getAddC5();
		result[j][8] = stu.getAddC6();
		result[j][9] = stu.getAddC7();
		result[j][10] = stu.getAddC8();
		result[j][11] = stu.getAddC9();
		result[j][12] = stu.getAddC10();
		result[j][13] = stu.getAddC11();
		result[j][14] = stu.getAddC12();
		result[j][15] = stu.getAddC13();
		result[j][16] = stu.getAddC14();
		result[j][17] = stu.getAddC15();
		result[j][18] = stu.getAddC16();
		result[j][19] = stu.getAddC17();
		result[j][20] = stu.getAddC18();
		result[j][21] = stu.getAddC19();
		result[j][22] = stu.getAddC20();
		result[j][23] = stu.getAddC21();
		result[j][24] = stu.getAddC22();
		result[j][25] = stu.getAddC23();
		result[j][26] = stu.getAddC24();
		result[j][27] = stu.getAddC25();
		result[j][28] = stu.getAddC26();
		result[j][29] = stu.getAddC27();
		result[j][30] = stu.getAddC28();
		result[j][31] = stu.getAddC29();
		result[j][32] = stu.getAddC30();
		result[j][33] = stu.getAddC31();
		result[j][34] = stu.getAddC32();
		result[j][35] = stu.getAddC33();
	}

	// query by sno
	private int queryBySno(String teacher_code) throws SQLException {
		int result = 0;
		if ("".equals(teacher_code) || teacher_code == null) {
			return result;
		}
		String checkSql = "select * from student where teacher_code=?";
		String[] checkParam = { teacher_code };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
	}

}
