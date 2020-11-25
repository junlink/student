package com.up.student.view.costMoudle;

import com.up.student.model.CostJudge.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class AnalyzeVariableCost extends JFrame {
    public static String t_Variable_cost;
    public AnalyzeVariableCost() {
        initComponents();
        init();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Label_amount = new JLabel();
        JT_Teacher_Salary = new JTextField();
        Label_depreciationPeriod = new JLabel();
        JT_Fuel_Cost = new JTextField();
        Label_salvageRate = new JLabel();
        JT_AviationSupport_Cost = new JTextField();
        Label_airplaneSeat = new JLabel();
        JT_Small_Repair = new JTextField();
        Label_engineNumber = new JLabel();
        JT_VaribleCost = new JTextField();

        //======== this ========
        setMinimumSize(new Dimension(54, 33));
        setMaximizedBounds(new Rectangle(50, 50, 100, 90));
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(5, 2));

        //---- Label_amount ----
        Label_amount.setText("Faculty salary/USD/H");
        contentPane.add(Label_amount);
        contentPane.add(JT_Teacher_Salary);

        //---- Label_depreciationPeriod ----
        Label_depreciationPeriod.setText("Fuel cost/USD/H");
        contentPane.add(Label_depreciationPeriod);
        contentPane.add(JT_Fuel_Cost);

        //---- Label_salvageRate ----
        Label_salvageRate.setText("flight support fee/USD");
        contentPane.add(Label_salvageRate);
        contentPane.add(JT_AviationSupport_Cost);

        //---- Label_airplaneSeat ----
        Label_airplaneSeat.setText("Small maintenance cost/USD");
        contentPane.add(Label_airplaneSeat);
        contentPane.add(JT_Small_Repair);

        //---- Label_engineNumber ----
        Label_engineNumber.setText("VariableCost/USD/H");
        contentPane.add(Label_engineNumber);

        //---- JT_VaribleCost ----
        JT_VaribleCost.setMinimumSize(new Dimension(54, 33));
        JT_VaribleCost.setPreferredSize(new Dimension(54, 33));
        JT_VaribleCost.setAlignmentX(2.5F);
        JT_VaribleCost.setAlignmentY(2.5F);
        contentPane.add(JT_VaribleCost);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel Label_amount;
    private JTextField JT_Teacher_Salary;
    private JLabel Label_depreciationPeriod;
    private JTextField JT_Fuel_Cost;
    private JLabel Label_salvageRate;
    private JTextField JT_AviationSupport_Cost;
    private JLabel Label_airplaneSeat;
    private JTextField JT_Small_Repair;
    private JLabel Label_engineNumber;
    private JTextField JT_VaribleCost;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    void init() {
        this.setTitle("Hourly VariableCost");
        setBounds(190, 200, 400, 300);
        if (CostView.airportList != null && CostView.operationList != null && CostView.financeList != null
                && CostView.insuranceList != null && CostView.repairList != null && CostView.teacherList != null) {

            ArrayList airportList =CostView.airportList;
            ArrayList operationList = CostView.operationList;
            ArrayList financeList =  CostView.financeList;
            ArrayList insuranceList =  CostView.insuranceList;
            ArrayList repairList = CostView.repairList;
            ArrayList teacherList =  CostView.teacherList;
            String t_salary;
            String t_fuel_cost;
            String t_aviationsupport_cost;
            String t_small_repair;


            t_salary = String.valueOf(Double.parseDouble(teacherList.get(0).toString()) * Double.parseDouble(operationList.get(6).toString())
                                        / Double.parseDouble(operationList.get(0).toString()));
            JT_Teacher_Salary.setText(t_salary);

            t_fuel_cost = String.valueOf(
                    Double.parseDouble(financeList.get(1).toString())
                            *( Double.parseDouble(operationList.get(2).toString())+ Double.parseDouble(operationList.get(3).toString())* Double.parseDouble(operationList.get(4).toString()))
            );
            JT_Fuel_Cost.setText(t_fuel_cost);
            t_aviationsupport_cost = String.valueOf( (1 + Double.parseDouble(operationList.get(4).toString() ) )
                                                        * Double.parseDouble(operationList.get(5).toString())
                                                        /Double.parseDouble(operationList.get(1).toString())
                                                        / 5);
            JT_AviationSupport_Cost.setText(t_aviationsupport_cost);
            t_small_repair= String.valueOf( (Double.parseDouble(repairList.get(6).toString() )+ Double.parseDouble(repairList.get(7).toString() )*80 ) /Double.parseDouble(repairList.get(8).toString() ) );
            JT_Small_Repair.setText(t_small_repair);
            t_Variable_cost=String.valueOf( Double.parseDouble(t_salary)
                    +Double.parseDouble(t_fuel_cost)
                    +Double.parseDouble(t_aviationsupport_cost)
                    +Double.parseDouble(t_small_repair) );
            JT_VaribleCost.setText(t_Variable_cost);
            AnalyzeFixedCost.cost[5]=  Double.parseDouble(t_salary);
            AnalyzeFixedCost.cost[6]=  Double.parseDouble(t_fuel_cost);
            AnalyzeFixedCost.cost[7]=  Double.parseDouble(t_aviationsupport_cost);
            AnalyzeFixedCost.cost[8]=  Double.parseDouble(t_small_repair);
        }
    }
}
