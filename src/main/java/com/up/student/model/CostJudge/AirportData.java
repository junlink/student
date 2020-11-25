package com.up.student.model.CostJudge;

import java.util.ArrayList;

/**
 * Created by juu79 on 2020/3/13 0013.
 */
public class AirportData {
    private String name ;
    private String amount ;
    private String depreciationPeriod ;
    private String salvageRate ;
    private String airplaneSeat ;
    private String engineNumber ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDepreciationPeriod() {
        return depreciationPeriod;
    }

    public void setDepreciationPeriod(String depreciationPeriod) {
        this.depreciationPeriod = depreciationPeriod;
    }

    public String getSalvageRate() {
        return salvageRate;
    }

    public void setSalvageRate(String salvageRate) {
        this.salvageRate = salvageRate;
    }

    public String getAirplaneSeat() {
        return airplaneSeat;
    }

    public void setAirplaneSeat(String airplaneSeat) {
        this.airplaneSeat = airplaneSeat;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public static void transferList(ArrayList arrayList, AirportData data){
        arrayList.add(data.amount);
        arrayList.add(data.depreciationPeriod);
        arrayList.add(data.salvageRate);
        arrayList.add(data.airplaneSeat);
        arrayList.add(data.engineNumber);

    }
}
