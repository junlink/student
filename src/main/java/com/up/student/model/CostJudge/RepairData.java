package com.up.student.model.CostJudge;

import java.util.ArrayList;

/**
 * Created by juu79 on 2020/3/13 0013.
 */
public class RepairData {
    private String name ;
    private String engineChangeFee ;
    private String engineChangeInterval ;
    private String jetBigRepairMaterialFee ;
    private String jetBigRepairInterval ;
    private String jetBigRepairWorkingHour ;
    private String jetBigRepairWorkingHourFee ;
    private String jetSmallRepairMaterialFee ;
    private String jetSmallRepairWorkingHour ;
    private String jetSmallRepairInterval ;
    private String jetSmallRepairWorkingHourFee ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineChangeFee() {
        return engineChangeFee;
    }

    public void setEngineChangeFee(String engineChangeFee) {
        this.engineChangeFee = engineChangeFee;
    }

    public String getEngineChangeInterval() {
        return engineChangeInterval;
    }

    public void setEngineChangeInterval(String engineChangeInterval) {
        this.engineChangeInterval = engineChangeInterval;
    }

    public String getJetBigRepairMaterialFee() {
        return jetBigRepairMaterialFee;
    }

    public void setJetBigRepairMaterialFee(String jetBigRepairMaterialFee) {
        this.jetBigRepairMaterialFee = jetBigRepairMaterialFee;
    }

    public String getJetBigRepairInterval() {
        return jetBigRepairInterval;
    }

    public void setJetBigRepairInterval(String jetBigRepairInterval) {
        this.jetBigRepairInterval = jetBigRepairInterval;
    }

    public String getJetBigRepairWorkingHour() {
        return jetBigRepairWorkingHour;
    }

    public void setJetBigRepairWorkingHour(String jetBigRepairWorkingHour) {
        this.jetBigRepairWorkingHour = jetBigRepairWorkingHour;
    }

    public String getJetBigRepairWorkingHourFee() {
        return jetBigRepairWorkingHourFee;
    }

    public void setJetBigRepairWorkingHourFee(String jetBigRepairWorkingHourFee) {
        this.jetBigRepairWorkingHourFee = jetBigRepairWorkingHourFee;
    }

    public String getJetSmallRepairMaterialFee() {
        return jetSmallRepairMaterialFee;
    }

    public void setJetSmallRepairMaterialFee(String jetSmallRepairMaterialFee) {
        this.jetSmallRepairMaterialFee = jetSmallRepairMaterialFee;
    }

    public String getJetSmallRepairWorkingHour() {
        return jetSmallRepairWorkingHour;
    }

    public void setJetSmallRepairWorkingHour(String jetSmallRepairWorkingHour) {
        this.jetSmallRepairWorkingHour = jetSmallRepairWorkingHour;
    }

    public String getJetSmallRepairInterval() {
        return jetSmallRepairInterval;
    }

    public void setJetSmallRepairInterval(String jetSmallRepairInterval) {
        this.jetSmallRepairInterval = jetSmallRepairInterval;
    }

    public String getJetSmallRepairWorkingHourFee() {
        return jetSmallRepairWorkingHourFee;
    }

    public void setJetSmallRepairWorkingHourFee(String jetSmallRepairWorkingHourFee) {
        this.jetSmallRepairWorkingHourFee = jetSmallRepairWorkingHourFee;
    }
    public static void transferList(ArrayList arrayList, RepairData data){
        arrayList.add(data.engineChangeFee);
        arrayList.add(data.engineChangeInterval);
        arrayList.add(data.jetBigRepairMaterialFee);
        arrayList.add(data.jetBigRepairInterval);
        arrayList.add(data.jetBigRepairWorkingHour);
        arrayList.add(data.jetBigRepairWorkingHourFee);
        arrayList.add(data.jetSmallRepairMaterialFee);
        arrayList.add(data.jetSmallRepairWorkingHour);
        arrayList.add(data.jetSmallRepairInterval);
        arrayList.add(data.jetSmallRepairWorkingHourFee);
    }
}
