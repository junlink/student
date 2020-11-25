package com.up.student.model;

/**
 * Created by juu79 on 2020/3/6 0006.
 */
public class Fixed_Cost {
    private String name ;
    private String depreciation_Cost ;
    private String interest_Cost ;
    private String insurance_Cost ;
    private String largeRepair ;
    private String tax_Cost ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepreciation_Cost() {
        return depreciation_Cost;
    }

    public void setDepreciation_Cost(String depreciation_Cost) {
        this.depreciation_Cost = depreciation_Cost;
    }

    public String getInterest_Cost() {
        return interest_Cost;
    }

    public void setInterest_Cost(String interest_Cost) {
        this.interest_Cost = interest_Cost;
    }

    public String getInsurance_Cost() {
        return insurance_Cost;
    }

    public void setInsurance_Cost(String insurance_Cost) {
        this.insurance_Cost = insurance_Cost;
    }

    public String getLargeRepair() {
        return largeRepair;
    }

    public void setLargeRepair(String largeRepair) {
        this.largeRepair = largeRepair;
    }

    public String getTax_Cost() {
        return tax_Cost;
    }

    public void setTax_Cost(String tax_Cost) {
        this.tax_Cost = tax_Cost;
    }
}
