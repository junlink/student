package com.up.student.model.CostJudge;

import java.util.ArrayList;

/**
 * Created by juu79 on 2020/3/13 0013.
 */
public class FinanceData {
    private String name ;
    private String PreTaxJetPrice ;
    private String JetFuelPrice ;
    private String Tariff ;
    private String VAT ;
    private String ExchangeRate;
    private String LoanRatio ;
    private String AnnualRate ;
    private String AnnualRepayments ;
    private String LoanLife ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreTaxJetPrice() {
        return PreTaxJetPrice;
    }

    public void setPreTaxJetPrice(String preTaxJetPrice) {
        PreTaxJetPrice = preTaxJetPrice;
    }

    public String getJetFuelPrice() {
        return JetFuelPrice;
    }

    public void setJetFuelPrice(String jetFuelPrice) {
        JetFuelPrice = jetFuelPrice;
    }

    public String getTariff() {
        return Tariff;
    }

    public void setTariff(String tariff) {
        Tariff = tariff;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getExchangeRate() {
        return ExchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        ExchangeRate = exchangeRate;
    }

    public String getLoanRatio() {
        return LoanRatio;
    }

    public void setLoanRatio(String loanRatio) {
        LoanRatio = loanRatio;
    }

    public String getAnnualRate() {
        return AnnualRate;
    }

    public void setAnnualRate(String annualRate) {
        AnnualRate = annualRate;
    }

    public String getAnnualRepayments() {
        return AnnualRepayments;
    }

    public void setAnnualRepayments(String annualRepayments) {
        AnnualRepayments = annualRepayments;
    }

    public String getLoanLife() {
        return LoanLife;
    }

    public void setLoanLife(String loanLife) {
        LoanLife = loanLife;
    }

    public static void transferList(ArrayList arrayList, FinanceData data){
        arrayList.add(data.PreTaxJetPrice);
        arrayList.add(data.JetFuelPrice);
        arrayList.add(data.Tariff);
        arrayList.add(data.VAT);
        arrayList.add(data.ExchangeRate);
        arrayList.add(data.LoanRatio);
        arrayList.add(data.AnnualRate);
        arrayList.add(data.AnnualRepayments);
        arrayList.add(data.LoanLife);
    }
}
