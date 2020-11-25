package com.up.student.dao;

import com.up.student.base.BaseDAO;
import com.up.student.model.CostJudge.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class CostDataDAO extends BaseDAO {
    private static CostDataDAO sd = null;

    public static synchronized CostDataDAO getInstance() {
        if (sd == null) {
            sd = new CostDataDAO();
        }
        return sd;
    }
    // add

    public boolean addAirportData(AirportData data) {
        boolean result = false;
        if (data == null) {
            return result;
        }
        try {
            // check
            if (queryBySno(data.getName()) == 1) {
                return result;
            }
            // insert
            String sql = "insert into CostData(name,amount,depreciationPeriod,salvageRate,airplaneSeat,engineNumber) " +
                    "values(?, ?, ?, ?, ?, ?)";
            String[] param = {data.getName(),data.getAmount(),data.getDepreciationPeriod(),data.getSalvageRate(),data.getAirplaneSeat(),data.getEngineNumber()};

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
    public boolean addOperationData(OperationData data) {
        boolean result = false;
        //需要的时候在这里掺入名字的参数即可
        String name="D40";
        if (data == null) {
            return result;
        }
        try {
            // check
            if (queryBySno(data.getName()) != 1) {
                return result;
            }
            // insert
            String sql = "update CostData set airTime =? ,landingInterval= ?,airOil =? , landOil = ? , A_GDeviationDate=? ,TO_LandingFee=?,ManMachineRatio=? where name =?" ;
            String[] param = {data.getAirTime(),data.getLandingInterval(),data.getAirOil(),data.getLandOil(),data.getA_GDeviationDate()
                    ,data.getTO_LandingFee(),data.getManMachineRatio(),name};
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
    public boolean addFinanceData(FinanceData data) {
        String name="D40";
        boolean result = false;
        if (data == null) {
            return result;
        }
        try {
            // check
            if (queryBySno(data.getName()) != 1) {
                return result;
            }
            // insert
            String sql = "update  CostData set PreTaxJetPrice=?, JetFuelPrice=?, Tariff=?,VAT=?, ExchangeRate=?,LoanRatio=?, AnnualRate=?, AnnualRepayments=? " +
                    ",LoanLife=? where name =?";
            String[] param = {data.getPreTaxJetPrice(),data.getJetFuelPrice(),data.getTariff(),data.getVAT(),data.getExchangeRate()
                    ,data.getLoanRatio(),data.getAnnualRate(),data.getAnnualRepayments(),data.getLoanLife(),name };
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
    public boolean addInsuranceData(InsuranceData data) {
        String name="D40";
        boolean result = false;
        if (data == null) {
            return result;
        }
        try {
            // check
            if (queryBySno(data.getName()) != 1) {
                return result;
            }
            // insert
            String sql = "update  CostData set Jet_insurance=?, PerSeat_insurance=?,seat_insurance_rate=?,ThirdParty_insurance=?,ThirdParty_insurance_rate=? where name =?";
            String[] param = {data.getJet_insurance(),data.getPerSeat_insurance(),data.getSeat_insurance_rate(),data.getThirdParty_insurance(),data.getThirdParty_insurance_rate(),name };
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
    public boolean addRepairData(RepairData data) {
        String name="D40";
        boolean result = false;
        if (data == null) {
            return result;
        }
        try {
            // check
            if (queryBySno(data.getName()) != 1) {
                return result;
            }
            // insert

            String sql = "update CostData set engineChangeFee=?, engineChangeInterval=?,jetBigRepairMaterialFee=?, jetBigRepairInterval=?, jetBigRepairWorkingHour=?" +
                    ",jetBigRepairWorkingHourFee=?,jetSmallRepairMaterialFee=?,jetSmallRepairWorkingHour=? , jetSmallRepairInterval=?" +
                    ",jetSmallRepairWorkingHourFee=? where name =?";
            String[] param = {data.getEngineChangeFee(),data.getEngineChangeInterval(),data.getJetBigRepairMaterialFee(),data.getJetBigRepairInterval()
                    ,data.getJetBigRepairWorkingHour(),data.getJetBigRepairWorkingHourFee(),data.getJetSmallRepairMaterialFee(),data.getJetSmallRepairWorkingHour()
            ,data.getJetSmallRepairInterval(),data.getJetSmallRepairWorkingHourFee(),name };

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
    public boolean addTeacherData(TeacherData data) {
        String name="D40";
        boolean result = false;
        if (data == null) {
            return result;
        }
        try {
            // check
            if (queryBySno(data.getName()) != 1) {
                return result;
            }
            // insert
            String sql = "update CostData set teacherSalary=? where name=?";
            String[] param = {data.getTeacherSalary(),name };

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
    // query by sno
    private int queryBySno(String name) throws SQLException {
        int result = 0;
        if ("".equals(name) || name == null) {
            return result;
        }
        String checkSql = "select * from CostData where name=?";
        String[] checkParam = { name };
        rs = db.executeQuery(checkSql, checkParam);
        if (rs.next()) {
            result = 1;
        }
        return result;
    }
    private void buildList(ResultSet rs, List<AirportData> list_airport,  List<OperationData> list_Operation ,List<FinanceData> list_finance ,
                           List<InsuranceData> list_insurance , List<RepairData> list_repair , List<TeacherData> list_teacher) throws SQLException {
        AirportData airportData = new AirportData();
        OperationData operationData =new OperationData();
        FinanceData financeData =new FinanceData();
        InsuranceData insuranceData =new InsuranceData();
        RepairData repairData =new RepairData();
        TeacherData teacherData =new TeacherData();

        airportData.setName(rs.getString("name"));
        airportData.setAmount(rs.getString("amount"));
        airportData.setDepreciationPeriod(rs.getString("depreciationPeriod"));
        airportData.setSalvageRate(rs.getString("salvageRate"));
        airportData.setAirplaneSeat(rs.getString("airplaneSeat"));
        airportData.setEngineNumber(rs.getString("engineNumber"));

        operationData.setAirTime(rs.getString("airTime"));
        operationData.setLandingInterval(rs.getString("landingInterval"));
        operationData.setAirOil(rs.getString("airOil"));
        operationData.setLandOil(rs.getString("landOil"));
        operationData.setA_GDeviationDate(rs.getString("A_GDeviationDate"));
        operationData.setTO_LandingFee(rs.getString("TO_LandingFee"));
        operationData.setManMachineRatio(rs.getString("ManMachineRatio"));

        financeData.setPreTaxJetPrice(rs.getString("PreTaxJetPrice"));
        financeData.setJetFuelPrice(rs.getString("JetFuelPrice"));
        financeData.setTariff(rs.getString("Tariff"));
        financeData.setVAT(rs.getString("VAT"));
        financeData.setExchangeRate(rs.getString("ExchangeRate"));
        financeData.setLoanRatio(rs.getString("LoanRatio"));
        financeData.setAnnualRate(rs.getString("AnnualRate"));
        financeData.setAnnualRepayments(rs.getString("AnnualRepayments"));
        financeData.setLoanLife(rs.getString("LoanLife"));

        insuranceData.setJet_insurance(rs.getString("Jet_insurance"));
        insuranceData.setPerSeat_insurance(rs.getString("PerSeat_insurance"));
        insuranceData.setSeat_insurance_rate(rs.getString("Seat_insurance_rate"));
        insuranceData.setThirdParty_insurance(rs.getString("ThirdParty_insurance"));
        insuranceData.setThirdParty_insurance_rate(rs.getString("ThirdParty_insurance_rate"));

        repairData.setEngineChangeFee(rs.getString("engineChangeFee"));
        repairData.setEngineChangeInterval(rs.getString("engineChangeInterval"));
        repairData.setJetBigRepairMaterialFee(rs.getString("jetBigRepairMaterialFee"));
        repairData.setJetBigRepairInterval(rs.getString("jetBigRepairInterval"));
        repairData.setJetBigRepairWorkingHour(rs.getString("jetBigRepairWorkingHour"));
        repairData.setJetBigRepairWorkingHourFee(rs.getString("jetBigRepairWorkingHourFee"));
        repairData.setJetSmallRepairMaterialFee(rs.getString("jetSmallRepairMaterialFee"));
        repairData.setJetSmallRepairWorkingHour(rs.getString("jetSmallRepairWorkingHour"));
        repairData.setJetSmallRepairInterval(rs.getString("jetSmallRepairInterval"));
        repairData.setJetSmallRepairWorkingHourFee(rs.getString("jetSmallRepairWorkingHourFee"));

        teacherData.setTeacherSalary(rs.getString("teacherSalary"));

        list_airport.add(airportData);
        list_Operation.add(operationData);
        list_finance.add(financeData);
        list_insurance.add(insuranceData);
        list_repair.add(repairData);
        list_teacher.add(teacherData);
    }
    public  boolean queryData(List<AirportData> list_airport,  List<OperationData> list_Operation ,List<FinanceData> list_finance ,
                                List<InsuranceData> list_insurance , List<RepairData> list_repair , List<TeacherData> list_teacher){

        String sql = "select * from CostData";
        rs = db.executeQuery(sql);
        try{
            if (rs.next()) {
                buildList(rs, list_airport,list_Operation,list_finance,list_insurance,list_repair,list_teacher );
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            destroy();
        }
        return false;
    }
}
