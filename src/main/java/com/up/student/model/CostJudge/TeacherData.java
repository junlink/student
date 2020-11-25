package com.up.student.model.CostJudge;

import java.util.ArrayList;

/**
 * Created by juu79 on 2020/3/13 0013.
 */
public class TeacherData {
    private String name ;
    private String teacherSalary ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(String teacherSalary) {
        this.teacherSalary = teacherSalary;
    }
    public static void transferList(ArrayList arrayList, TeacherData data){
        arrayList.add(data.teacherSalary);

    }
}
