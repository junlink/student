package com.up.student.model.CostJudge;

import java.util.ArrayList;

/**
 * Created by juu79 on 2020/3/13 0013.
 */
public class InsuranceData {
    private String name ;
    private String Jet_insurance ;
    private String PerSeat_insurance ;
    private String Seat_insurance_rate;
    private String ThirdParty_insurance ;
    private String ThirdParty_insurance_rate ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJet_insurance() {
        return Jet_insurance;
    }

    public void setJet_insurance(String jet_insurance) {
        Jet_insurance = jet_insurance;
    }

    public String getPerSeat_insurance() {
        return PerSeat_insurance;
    }

    public void setPerSeat_insurance(String perSeat_insurance) {
        PerSeat_insurance = perSeat_insurance;
    }

    public String getSeat_insurance_rate() {
        return Seat_insurance_rate;
    }

    public void setSeat_insurance_rate(String seat_insurance_rate) {
        this.Seat_insurance_rate = seat_insurance_rate;
    }

    public String getThirdParty_insurance() {
        return ThirdParty_insurance;
    }

    public void setThirdParty_insurance(String thirdParty_insurance) {
        ThirdParty_insurance = thirdParty_insurance;
    }

    public String getThirdParty_insurance_rate() {
        return ThirdParty_insurance_rate;
    }

    public void setThirdParty_insurance_rate(String thirdParty_insurance_rate) {
        ThirdParty_insurance_rate = thirdParty_insurance_rate;
    }
    public static void transferList(ArrayList arrayList, InsuranceData data){
        arrayList.add(data.Jet_insurance);
        arrayList.add(data.PerSeat_insurance);
        arrayList.add(data.Seat_insurance_rate);
        arrayList.add(data.ThirdParty_insurance);
        arrayList.add(data.ThirdParty_insurance_rate);


    }
}
