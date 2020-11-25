
package com.up.student;
import javax.swing.*;

/**
 * 模块说明： 常量
 */
public class AppConstants {
    // jdbc
    public static final String JDBC_URL = "jdbc:sqlite:test.db";
    public static final String JDBC_USERNAME = "test";
    public static final String JDBC_PASSWORD = "test";
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";

    // student field
    public static final String STUDENT_NAME = "名字";
    public static final String STUDENT_SNO = "评价专家代码";
    public static final String STUDENT_SEX = "性别";
    public static final String STUDENT_DEPARTMETN = "年级";
    public static final String STUDENT_HOMETOWN = "家乡";
    public static final String STUDENT_EMAIL = "邮箱";
    public static final String STUDENT_TEL = "电话";
    public static final String STUDENT_MARK = "年级";

    // login view
    public static final String LOGIN_TITLE = "登录界面";
    public static final String LOGIN_USERNAME = "用户名";
    public static final String LOGIN_PASSWORD = "密码";
    public static final String LOGIN = "登录";
    public static final String RESET = "重置";

    // main view
    public static final String MAINVIEW_TITLE = "通用教练机机队运营经济性分析软件";
    public static final String MAINVIEW_PAGENUM_JLABEL_DI = "第 ";
    public static final String MAINVIEW_PAGENUM_JLABEL_YE = "/99 页";
    public static final String MAINVIEW_FIND_JLABEL = "查询结果";
    public static final String MAINVIEW_FIRST = "首页";
    public static final String MAINVIEW_LAST = "末页";
    public static final String MAINVIEW_PRE = "上一页";
    public static final String MAINVIEW_NEXT = "下一页";
    public static final String MAINVIEW_JudgeStandard = "评价标准";
    public static final String PARAM_FIND_CONDITION = "";
    public static final String PARAM_FIND = "查找";
    public static final String PARAM_ADD = "添加";
    public static final String PARAM_DELETE = "删除";
    public static final String PARAM_UPDATE = "更新";
    public static final String PARAM_JUDGE = "评价";
    public static final String PARAM_reason = "评价因素";
    public static final String PARAM_rank = "评价等级";
    public static final String PARAM_possible = "最可能的分数";
    public static final String PARAM_TieJingDu = "贴进度详情";

    // add view
    public static final String ADDVIEW_TITLE = "添加通用教练机评价信息";
    public static final String ADDVIEW_ADDBUTTON = "添加";
    public static final String EXITBUTTON = "退出";
    public static final String Judege_Standard = "评价等级指标";
    // Add 一级评价指标
    public static final String ADDVIEW_TITLEB1 = "专家打分";
    public static final String ADDVIEW_TITLEB2 = "添加教师2评价因素";
    public static final String ADDVIEW_TITLEB3 = "添加教师3评价因素";
    public static final String ADDVIEW_TITLEB4 = "添加教师4评价因素";
    public static final String ADDVIEW_TITLEB5 = "添加教师5评价因素";
    public static final String ADDVIEW_TITLEB6 = "添加教师6评价因素";
    public static final String ADDVIEW_TITLEB7 = "添加专家评价因素";

    // delete view
    public static final String DELETEVIEW_TITLE = "删除教练机信息";
    public static final String DELETEVIEW_DELETEBUTTON = "删除";

    // update view
    public static final String UPDATEVIEW_TITLE = "更新教练机信息";
    public static final String UPDATEVIEW_UPDATEBUTTON = "更新";
    //import view
    public static final String IMPORTVIEW_TITLE = "导入EXCEL";
    //judge view
    public static final String JUDGEVIEW_TITLE = "教练机综合评价";
    public static final String JUDGEVIEW_SHANG= "计算权重";
    public static final String JUDGEVIEW_LIXIANGJIE= "确定正负理想解";
    public static final String JUDGEVIEW_JULI= "计算与理想解的距离";
    public static final String JUDGEVIEW_TIEJINDU = "计算贴进度";
    public static final String ZHIDING="置顶";
    public static final String COSTBUTTON="直接成本计算";

    // Add 二级评价指标
    public static final String AddC1 = "发动机功率";
    public static final String AddC2 = "最大起飞重量";
    public static final String AddC3 = "最大着陆重量";
    public static final String AddC4 = "最大商载";
    public static final String AddC5 = "最大爬升率";
    public static final String AddC6 = "起飞滑跑距离";
    public static final String AddC7 = "降落滑跑距离";
    public static final String AddC8 = "失速速度";
    public static final String AddC9 = "翼展";
    public static final String AddC10 = "翼型";
    public static final String AddC11 = "有无起落架弹簧";
    public static final String AddC12 = "最大航程";
    public static final String AddC13 = "小时变动成本";
    public static final String AddC14 = "维护成本";
    public static final String AddC15 = "航材供应规模化";
    public static final String AddC16 = "额外安全措施";
    public static final String AddC17 = "NTSB事故统计";
    public static final String AddC18 = "AOPA评价";
    public static final String AddC19 = "航材保障模式";
    public static final String AddC20 = "保障时间";
    public static final String AddC21 = "购置净价";
    public static final String AddC22 = "时寿件成本";
    public static final String AddC23 = "融资模式";
    public static final String AddC24 = "碳排放";
    public static final String AddC25 = "噪音";
    public static final String AddC26 = "在产机型数";
    public static final String AddC27 = "年产量";
    public static final String AddC28 = "市场评价";
    public static final String AddC29 = "机型改进能力";
    public static final String AddC30 = "教练机综合配套能力";
    public static final String AddC31 = "对飞行培训产业贡献";
    public static final String AddC32 = "总衍生机型数";
    public static final String AddC33 = "取证机型数";
    public static JTextField  c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26, c27, c28, c29, c30, c31, c32, c33;
    String AddView[]=new String[33];
    public static String AddViewString[]={"发动机功率","最大起飞重量","最大着陆重量","最大商载","最大爬升率","起飞滑跑距离","降落滑跑距离","失速速度",
            "翼展","翼型","有无起落架弹簧","最大航程","小时变动成本","维护成本","航材供应规模化", "额外安全措施",
            "NTSB事故统计","AOPA评价", "航材保障模式","保障时间", "购置净价", "时寿件成本", "融资模式","碳排放","噪音","在产机型数", "年产量",
            "市场评价","机型改进能力","教练机综合配套能力","对飞行培训产业贡献","总衍生机型数","取证机型数"
    };
//    public static String ruzu (int i){
//
//    }
    public static String Second(int i) {
        String text="AddC"+i;
        return text;
    }
    public static String SecondTextfield(int i) {
        String text="C"+i;
        return text;
    }

    public static String getLable(int i){
        return AddViewString[i-1];

    }

}
