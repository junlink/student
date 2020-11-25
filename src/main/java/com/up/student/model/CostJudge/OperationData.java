package com.up.student.model.CostJudge;

import java.util.ArrayList;

/**
 * Created by juu79 on 2020/3/13 0013.
 */
public class OperationData {
    private String name ;
    private String airTime ;
    private String landingInterval ;
    private String airOil ;
    private String landOil ;
    private String A_GDeviationDate ;
    private String TO_LandingFee ;
    private String ManMachineRatio ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public String getLandingInterval() {
        return landingInterval;
    }

    public void setLandingInterval(String landingInterval) {
        this.landingInterval = landingInterval;
    }

    public String getAirOil() {
        return airOil;
    }

    public void setAirOil(String airOil) {
        this.airOil = airOil;
    }

    public String getLandOil() {
        return landOil;
    }

    public void setLandOil(String landOil) {
        this.landOil = landOil;
    }

    public String getA_GDeviationDate() {
        return A_GDeviationDate;
    }

    public void setA_GDeviationDate(String a_GDeviationDate) {
        A_GDeviationDate = a_GDeviationDate;
    }

    public String getTO_LandingFee() {
        return TO_LandingFee;
    }

    public void setTO_LandingFee(String TO_LandingFee) {
        this.TO_LandingFee = TO_LandingFee;
    }

    public String getManMachineRatio() {
        return ManMachineRatio;
    }

    public void setManMachineRatio(String manMachineRatio) {
        ManMachineRatio = manMachineRatio;
    }

    public static void transferList(ArrayList arrayList, OperationData operationData){
        arrayList.add(operationData.airTime);
        arrayList.add(operationData.landingInterval);
        arrayList.add(operationData.airOil);
        arrayList.add(operationData.landOil);
        arrayList.add(operationData.A_GDeviationDate);
        arrayList.add(operationData.TO_LandingFee);
        arrayList.add(operationData.ManMachineRatio);
    }
}
