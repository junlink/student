package com.up.student.view.costMoudle;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by juu79 on 2020/4/9 0009.
 */
public class AnalyzeFixedCost extends JFrame {
    public static double []cost = new double[9];
    public static String t_FixedCost;

    public AnalyzeFixedCost() {
        initComponents();
        init();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        TF_depreciation_Cost = new JTextField();
        label2 = new JLabel();
        TF_Interest_Cost = new JTextField();
        label3 = new JLabel();
        TF_Interest_Principal = new JTextField();
        label4 = new JLabel();
        TF_Insurance_Cost = new JTextField();
        label5 = new JLabel();
        TF_JetInsurance = new JTextField();
        label6 = new JLabel();
        TF_SeatInsurance = new JTextField();
        label7 = new JLabel();
        TF_ThirdPartyInsurance = new JTextField();
        label8 = new JLabel();
        TF_EngineLargeRepair = new JTextField();
        label9 = new JLabel();
        TF_JetLargeRepair = new JTextField();
        label10 = new JLabel();
        TF_FixedCost = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(10, 2));

        //---- label1 ----
        label1.setText("Depreciation/USD/H");
        contentPane.add(label1);
        contentPane.add(TF_depreciation_Cost);

        //---- label2 ----
        label2.setText("Interest /USD/H");
        contentPane.add(label2);
        contentPane.add(TF_Interest_Cost);

        //---- label3 ----
        label3.setText("Principal and Interest/USD");
        contentPane.add(label3);
        contentPane.add(TF_Interest_Principal);

        //---- label4 ----
        label4.setText("Insurance/USD");
        contentPane.add(label4);
        contentPane.add(TF_Insurance_Cost);

        //---- label5 ----
        label5.setText("Aircraft Insurance/USD");
        contentPane.add(label5);
        contentPane.add(TF_JetInsurance);

        //---- label6 ----
        label6.setText("Seat Insurance/USD");
        contentPane.add(label6);
        contentPane.add(TF_SeatInsurance);

        //---- label7 ----
        label7.setText("Third party Insurance/USD");
        contentPane.add(label7);
        contentPane.add(TF_ThirdPartyInsurance);

        //---- label8 ----
        label8.setText("Engine replace/USD");
        contentPane.add(label8);
        contentPane.add(TF_EngineLargeRepair);

        //---- label9 ----
        label9.setText("Major repairs/USD");
        contentPane.add(label9);
        contentPane.add(TF_JetLargeRepair);

        //---- label10 ----
        label10.setText("FixCost/USD/H");
        contentPane.add(label10);
        contentPane.add(TF_FixedCost);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField TF_depreciation_Cost;
    private JLabel label2;
    private JTextField TF_Interest_Cost;
    private JLabel label3;
    private JTextField TF_Interest_Principal;
    private JLabel label4;
    private JTextField TF_Insurance_Cost;
    private JLabel label5;
    private JTextField TF_JetInsurance;
    private JLabel label6;
    private JTextField TF_SeatInsurance;
    private JLabel label7;
    private JTextField TF_ThirdPartyInsurance;
    private JLabel label8;
    private JTextField TF_EngineLargeRepair;
    private JLabel label9;
    private JTextField TF_JetLargeRepair;
    private JLabel label10;
    private JTextField TF_FixedCost;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    void init() {
        this.setTitle("Hourly FixCost");
        setBounds(390, 200, 400, 400);
        if (CostView.airportList != null && CostView.operationList != null && CostView.financeList != null
                && CostView.insuranceList != null && CostView.repairList != null && CostView.teacherList != null) {

            ArrayList airportList = CostView.airportList;
            ArrayList operationList = CostView.operationList;
            ArrayList financeList = CostView.financeList;
            ArrayList insuranceList = CostView.insuranceList;
            ArrayList repairList = CostView.repairList;
            ArrayList teacherList = CostView.teacherList;
            String t_depreciation_Cost;
            String t_Interest_Cost;
            String t_Interest_Principal;
            String t_Insurance_Cost;
            String t_JetInsurance;
            String t_SeatInsurance;
            String t_ThirdPartyInsurance;
            String t_EngineLargeRepair;
            String t_JetLargeRepair;



            // 折旧/美元/小时
            t_depreciation_Cost = String.valueOf(
                    Double.parseDouble(airportList.get(0).toString()) * Double.parseDouble(financeList.get(0).toString())
                            * (1 - Double.parseDouble(airportList.get(2).toString().replace("%",""))*0.01)
                            * (1 + Double.parseDouble(financeList.get(2).toString().replace("%",""))*0.01)
                            * (1 + Double.parseDouble(financeList.get(3).toString().replace("%",""))*0.01)
                            / Double.parseDouble(airportList.get(1).toString()) / Double.parseDouble(operationList.get(0).toString())
            );
            TF_depreciation_Cost.setText(t_depreciation_Cost);
            // 每期利息/美元/小时
            t_Interest_Principal = String.valueOf(
                    Double.parseDouble(airportList.get(0).toString()) * Double.parseDouble(financeList.get(0).toString())
                            * (1 + Double.parseDouble(financeList.get(2).toString().replace("%",""))*0.01)
                            * (1 + Double.parseDouble(financeList.get(3).toString().replace("%",""))*0.01)
                            * Double.parseDouble(financeList.get(5).toString().replace("%",""))*0.01
                            *(Double.parseDouble(financeList.get(6).toString().replace("%",""))*0.01
                            /Double.parseDouble(financeList.get(7).toString()))
                            *( Math.pow(1 + Double.parseDouble(financeList.get(6).toString().replace("%",""))*0.01  /Double.parseDouble(financeList.get(7).toString()),
                            Double.parseDouble(financeList.get(7).toString()) * Double.parseDouble(financeList.get(8).toString())) )
                            /( Math.pow(1 + Double.parseDouble(financeList.get(6).toString().replace("%",""))*0.01   /Double.parseDouble(financeList.get(7).toString()),
                            Double.parseDouble(financeList.get(7).toString()) * Double.parseDouble(financeList.get(8).toString())) -1 )
            );
            TF_Interest_Principal.setText(t_Interest_Principal);
            // 利息/美元/小时
            t_Interest_Cost = String.valueOf(
                    (Double.parseDouble(financeList.get(7).toString()) * Double.parseDouble(financeList.get(8).toString())
                            * (Double.parseDouble(t_Interest_Principal))
                            - Double.parseDouble(airportList.get(0).toString()) * Double.parseDouble(financeList.get(0).toString())
                            * (1 + Double.parseDouble(financeList.get(2).toString().replace("%",""))*0.01)
                            * (1 + Double.parseDouble(financeList.get(3).toString().replace("%",""))*0.01)
                            * Double.parseDouble(financeList.get(5).toString().replace("%",""))*0.01      )
                            / Double.parseDouble(financeList.get(8).toString()) / Double.parseDouble(operationList.get(0).toString())
            );
            TF_Interest_Cost.setText(t_Interest_Cost);
            //  飞机保险/美元
            t_JetInsurance= String.valueOf(
                    Double.parseDouble(airportList.get(0).toString()) * Double.parseDouble(financeList.get(0).toString())
                            * (1 + Double.parseDouble(financeList.get(2).toString().replace("%",""))*0.01)
                            * (1 + Double.parseDouble(financeList.get(3).toString().replace("%",""))*0.01)
                            * Double.parseDouble(insuranceList.get(0).toString().replace("%",""))*0.01
            );
            TF_JetInsurance.setText(t_JetInsurance);
            // 座位保险/美元
            t_SeatInsurance= String.valueOf(
                    Double.parseDouble(airportList.get(3).toString())
                            * Double.parseDouble(insuranceList.get(1).toString())
                            * Double.parseDouble(insuranceList.get(2).toString().replace("%",""))*0.01
            );
            TF_SeatInsurance.setText(t_SeatInsurance);
            // 第三者险/美元
            t_ThirdPartyInsurance= String.valueOf(
                   Double.parseDouble(insuranceList.get(3).toString())
                            * Double.parseDouble(insuranceList.get(4).toString().replace("%",""))*0.01
            );
            TF_ThirdPartyInsurance.setText(t_ThirdPartyInsurance);
            //保险费/空中时间/美元/小时
            t_Insurance_Cost= String.valueOf(
                    (Double.parseDouble(t_JetInsurance)
                            + Double.parseDouble(t_SeatInsurance)
                            + Double.parseDouble(t_ThirdPartyInsurance))
                            / Double.parseDouble(operationList.get(0).toString())
            );
            TF_Insurance_Cost.setText(t_Insurance_Cost);
            //发动机大修（换发）费用/美元
            t_EngineLargeRepair= String.valueOf(
                    Double.parseDouble(repairList.get(0).toString())
                            / Double.parseDouble(repairList.get(1).toString())
            );
            TF_EngineLargeRepair.setText(t_EngineLargeRepair);
            //机身大修理费用/美元/每小时
            t_JetLargeRepair= String.valueOf(
                    Double.parseDouble(repairList.get(2).toString())
                            / Double.parseDouble(repairList.get(3).toString())
                            + (  Double.parseDouble(repairList.get(4).toString())
                                * Double.parseDouble(repairList.get(5).toString())   ) /10000
            );
            TF_JetLargeRepair.setText(t_JetLargeRepair);
            // 总固定成本
            t_FixedCost =String.valueOf( Double.parseDouble(t_depreciation_Cost)
                    +Double.parseDouble(t_Interest_Cost)
                    +Double.parseDouble(t_Insurance_Cost)
                    +Double.parseDouble(t_EngineLargeRepair)
                    +Double.parseDouble(t_JetLargeRepair) );
            TF_FixedCost.setText(t_FixedCost);

            cost[0]=  Double.parseDouble(t_depreciation_Cost);
            cost[1]=  Double.parseDouble(t_Interest_Cost);
            cost[2]=  Double.parseDouble(t_Insurance_Cost);
            cost[3]=  Double.parseDouble(t_EngineLargeRepair);
            cost[4]=  Double.parseDouble(t_JetLargeRepair);
        }

    }
}
