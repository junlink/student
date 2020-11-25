
package com.up.student.model;
import java.util.ArrayList;
public class CouchJudge {
    private int id;
    private String sno;// 学号
    private String name;
    private String sex;
    private String department;// 院系
    private String homeTown;// 籍贯
    private String mark;// 学分
    private String email;
    private String tel;// 联系方式
    private String B1; //技术性能 B1
    private String B2; //运行经济性能 B2
    private String B3; //安全可靠性 B3
    private String B4; //可维护性B4
    private String B5; //财务因素 B5
    private String B6; //环境因素 B6
    private String B7; //厂家综合评价 B7
    private String Teacher_Code;
    private String AddC1;
    private String AddC2;
    private String AddC3;
    private String AddC4;
    private String AddC5;
    private String AddC6;
    private String AddC7;
    private String AddC8;
    private String AddC9;
    private String AddC10;
    private String AddC11;
    private String AddC12;
    private String AddC13;
    private String AddC14;
    private String AddC15;
    private String AddC16;
    private String AddC17;
    private String AddC18;
    private String AddC19;
    private String AddC20;
    private String AddC21;
    private String AddC22;
    private String AddC23;
    private String AddC24;
    private String AddC25;
    private String AddC26;
    private String AddC27;
    private String AddC28;
    private String AddC29;
    private String AddC30;
    private String AddC31;
    private String AddC32;
    private String AddC33;
    public ArrayList AddviewAll1;
    public String addviewall[] = new String[34];
    public String getId() {
        String id = String.valueOf(this.id);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_Code() {
        return Teacher_Code;
    }

    public void setTeacher_Code(String Teacher_Code) {
        this.Teacher_Code = Teacher_Code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setName(int  name) {
        this.name=String.valueOf(name);
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getHomeTown() {
        return homeTown;
    }
    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    // B1-B7 的get函数
    public String getB1() {
        return B1;
    }

    public String getB2() {
        return B2;
    }

    public String getB3() {
        return B3;
    }

    public String getB4() {
        return B4;
    }

    public String getB5() {
        return B5;
    }

    public String getB6() {
        return B6;
    }

    public String getB7() {
        return B7;
    }

    // B1-B7 的Set函数

    public void setB1(String b1) {
        B1 = b1;
    }

    public void setB2(String b2) {
        B2 = b2;
    }

    public void setB3(String b3) {
        B3 = b3;
    }

    public void setB4(String b4) {
        B4 = b4;
    }

    public void setB5(String b5) {
        B5 = b5;
    }

    public void setB6(String b6) {
        B6 = b6;
    }

    public void setB7(String b7) {
        B7 = b7;
    }

    public String getAddC1() {
//        initAddViewAll();
//        AddC1=AddviewAll1.get(0).toString();
        return AddC1;
    }

    public String getAddC2() {
//        AddviewAll.add(AddC2);
        return AddC2;
    }

    public String getAddC3() {
        return AddC3;
    }

    public String getAddC4() {
        return AddC4;
    }

    public String getAddC5() {
        return AddC5;
    }

    public String getAddC6() {
        return AddC6;
    }

    public String getAddC7() {
        return AddC7;
    }

    public String getAddC8() {
        return AddC8;
    }

    public String getAddC9() {
        return AddC9;
    }

    public String getAddC10() {
        return AddC10;
    }

    public String getAddC11() {
        return AddC11;
    }

    public String getAddC12() {
        return AddC12;
    }

    public String getAddC13() {
        return AddC13;
    }

    public String getAddC14() {
        return AddC14;
    }

    public String getAddC15() {
        return AddC15;
    }

    public String getAddC16() {
        return AddC16;
    }

    public String getAddC17() {
        return AddC17;
    }

    public String getAddC18() {
        return AddC18;
    }

    public String getAddC19() {
        return AddC19;
    }

    public String getAddC20() {
        return AddC20;
    }

    public String getAddC21() {
        return AddC21;
    }

    public String getAddC22() {
        return AddC22;
    }

    public String getAddC23() {
        return AddC23;
    }

    public String getAddC24() {
        return AddC24;
    }

    public String getAddC25() {
        return AddC25;
    }

    public String getAddC26() {
        return AddC26;
    }

    public String getAddC27() {
        return AddC27;
    }

    public String getAddC28() {
        return AddC28;
    }

    public String getAddC29() {
        return AddC29;
    }

    public String getAddC30() {
        return AddC30;
    }

    public String getAddC31() {
        return AddC31;
    }

    public String getAddC32() {
        return AddC32;
    }

    public String getAddC33() {
        return AddC33;
    }


    public void setAddC1(String addC1) {
        AddC1 = addC1;
    }

    public void setAddC2(String addC2) {
        AddC2 = addC2;
    }

    public void setAddC3(String addC3) {
        AddC3 = addC3;
    }

    public void setAddC4(String addC4) {
        AddC4 = addC4;
    }

    public void setAddC5(String addC5) {
        AddC5 = addC5;
    }

    public void setAddC6(String addC6) {
        AddC6 = addC6;
    }

    public void setAddC7(String addC7) {
        AddC7 = addC7;
    }

    public void setAddC8(String addC8) {
        AddC8 = addC8;
    }

    public void setAddC9(String addC9) {
        AddC9 = addC9;
    }

    public void setAddC10(String addC10) {
        AddC10 = addC10;
    }

    public void setAddC11(String addC11) {
        AddC11 = addC11;
    }

    public void setAddC12(String addC12) {
        AddC12 = addC12;
    }

    public void setAddC13(String addC13) {
        AddC13 = addC13;
    }

    public void setAddC14(String addC14) {
        AddC14 = addC14;
    }

    public void setAddC15(String addC15) {
        AddC15 = addC15;
    }

    public void setAddC16(String addC16) {
        AddC16 = addC16;
    }

    public void setAddC17(String addC17) {
        AddC17 = addC17;
    }

    public void setAddC18(String addC18) {
        AddC18 = addC18;
    }

    public void setAddC19(String addC19) {
        AddC19 = addC19;
    }

    public void setAddC20(String addC20) {
        AddC20 = addC20;
    }

    public void setAddC21(String addC21) {
        AddC21 = addC21;
    }

    public void setAddC22(String addC22) {
        AddC22 = addC22;
    }

    public void setAddC23(String addC23) {
        AddC23 = addC23;
    }

    public void setAddC24(String addC24) {
        AddC24 = addC24;
    }

    public void setAddC25(String addC25) {
        AddC25 = addC25;
    }

    public void setAddC26(String addC26) {
        AddC26 = addC26;
    }

    public void setAddC27(String addC27) {
        AddC27 = addC27;
    }

    public void setAddC28(String addC28) {
        AddC28 = addC28;
    }

    public void setAddC29(String addC29) {
        AddC29 = addC29;
    }

    public void setAddC30(String addC30) {
        AddC30 = addC30;
    }

    public void setAddC31(String addC31) {
        AddC31 = addC31;
    }

    public void setAddC32(String addC32) {
        AddC32 = addC32;
    }

    public void setAddC33(String addC33) {
        AddC33 = addC33;
    }


}
