/*
 * Created by JFormDesigner on Thu Dec 12 18:50:00 CST 2019
 */

package com.up.student.view.costMoudle;

import javax.swing.border.*;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.*;
import com.up.student.model.Fixed_Cost;
import com.up.student.view.ROI_Analysis.ROIView;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class CostView extends JFrame {
    public static String[]initAirplaneData =new String[5];
    public static String[]initOperationData =new String[7];
    public static String[]initFinanceData =new String[9];
    public static String[]initInsuranceData =new String[5];
    public static String[]initRepairData =new String[10];
    public static String[]initTeacherData =new String[1];
    public static ArrayList<JLabel> Lable_airportData=new ArrayList<>();
    public static ArrayList<JLabel> Lable_operationData=new ArrayList<>();
    public static ArrayList<JLabel> Lable_financeData=new ArrayList<>();
    public static ArrayList<JLabel> Lable_insuranceData=new ArrayList<>();
    public static ArrayList<JLabel> Lable_repairData=new ArrayList<>();
    public static ArrayList<JLabel> Lable_teacherData=new ArrayList<>();

    public static ArrayList<AirportData> airportData =new ArrayList<>();
    public static ArrayList<OperationData> operationData =new ArrayList<>();
    public static ArrayList<FinanceData> financeData =new ArrayList<>();
    public static ArrayList<InsuranceData> insuranceData =new ArrayList<>();
    public static ArrayList<RepairData> repairData =new ArrayList<>();
    public static ArrayList<TeacherData> teacherData =new ArrayList<>();

    public static ArrayList airportList =new ArrayList<>();
    public static ArrayList operationList =new ArrayList<>();
    public static ArrayList financeList =new ArrayList<>();
    public static ArrayList insuranceList =new ArrayList<>();
    public static ArrayList repairList =new ArrayList<>();
    public static ArrayList teacherList =new ArrayList<>();

    private boolean isData;

    public CostView() {
        init();
        initComponents();
    }
    private void init(){
        this.setTitle("教练机机队直接成本计算");
        this.setBackground(Color.black);
    }


    private void Bt_airplane_dataActionPerformed(ActionEvent e) {
        GetAirplaneDataView ga=new GetAirplaneDataView();
        ga.setVisible(true);
    }

    private void Bt_operation_dataActionPerformed(ActionEvent e) {
        // TODO add your code here
        GetOperationDataView go= new GetOperationDataView();
        go.setVisible(true);

    }

    private void Bt_finance_dataActionPerformed(ActionEvent e) {
        // TODO add your code here
        GetFinanceDataView ga=new GetFinanceDataView();
        ga.setVisible(true);
    }

    private void Bt_insurance_dataActionPerformed(ActionEvent e) {
        // TODO add your code here
        GetInsuranceDataView ga=new GetInsuranceDataView();
        ga.setVisible(true);
    }

    private void Bt_repair_dataActionPerformed(ActionEvent e) {
        // TODO add your code here
        GetRepairDataView ga=new GetRepairDataView();
        ga.setVisible(true);
    }

    private void Bt_teacher_dataActionPerformed(ActionEvent e) {
        // TODO add your code here
        GetTeacherDataView ga=new GetTeacherDataView();
        ga.setVisible(true);
    }

    private void Bt_getInitDataActionPerformed(ActionEvent e) {
        // TODO add your code here
        getInitData();
    }
    void getInitData(){
        Fixed_Cost Inityc = new Fixed_Cost();
        initAirplaneData = new String[]{"1", "10", "6%", "4", "1"};
        initOperationData= new String[]{"1000", "0.35", "18", "6.5", "0.18","18.07228916","1.5"};
        initFinanceData = new String[]{"355512.41", "0.454819277", "5%", "17%", "6.64","100%","6.5%","2","10"};
        initInsuranceData= new String[]{"0.6%", "120482", "0.15%", "451807.2289", "0.7%"};
        initRepairData = new String[]{"47121.08434", "2100", "2500", "10000", "210","80","16219.2756","504","1800","80"};
        initTeacherData= new String[]{"75301.20482"};//假定50万人民币/汇率
    }

    private void Bt_backMainActionPerformed(ActionEvent e) {
        // TODO add your code here
        InitLableList();
    }

    private void Bt_variable_costActionPerformed(ActionEvent e) {
        AnalyzeVariableCost analyzeVariableCost=new AnalyzeVariableCost();
        analyzeVariableCost.setVisible(true);
    }

    private void Bt_dataShowActionPerformed(ActionEvent e) {
        // TODO add your code here
        AnalyzeChart analyzeChart= new AnalyzeChart("成本分析饼图");
        analyzeChart.pack();
        analyzeChart.setVisible(true);
    }

    private void Bt_fixed_costActionPerformed(ActionEvent e) {
        // TODO add your code here
        AnalyzeFixedCost fixedCost=new AnalyzeFixedCost();
        fixedCost.setVisible(true);
    }

    private void Bt_ROIActionPerformed(ActionEvent e) {
        ROIView roiView = new ROIView();
        roiView.setVisible(true);
    }

    protected void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        Bt_airplane_data = new JButton();
        Bt_operation_data = new JButton();
        Bt_finance_data = new JButton();
        Bt_insurance_data = new JButton();
        Bt_repair_data = new JButton();
        Bt_teacher_data = new JButton();
        panel4 = new JPanel();
        Bt_getInitData = new JButton();
        Bt_backMain = new JButton();
        Bt_variable_cost = new JButton();
        Bt_fixed_cost = new JButton();
        Bt_dataShow = new JButton();
        Bt_ROI = new JButton();
        panel1 = new JPanel();
        panelAirplane = new JPanel();
        label6 = new JLabel();
        LB_airplane1 = new JLabel();
        label2 = new JLabel();
        LB_airplane2 = new JLabel();
        label4 = new JLabel();
        LB_airplane3 = new JLabel();
        label5 = new JLabel();
        LB_airplane4 = new JLabel();
        label9 = new JLabel();
        LB_airplane5 = new JLabel();
        panelOperation = new JPanel();
        label7 = new JLabel();
        LB_operation1 = new JLabel();
        label3 = new JLabel();
        LB_operation2 = new JLabel();
        label8 = new JLabel();
        LB_operation3 = new JLabel();
        label10 = new JLabel();
        LB_operation4 = new JLabel();
        label11 = new JLabel();
        LB_operation5 = new JLabel();
        label12 = new JLabel();
        LB_operation6 = new JLabel();
        label13 = new JLabel();
        LB_operation7 = new JLabel();
        panelFinance = new JPanel();
        label14 = new JLabel();
        LB_finance1 = new JLabel();
        label15 = new JLabel();
        LB_finance2 = new JLabel();
        label16 = new JLabel();
        LB_finance3 = new JLabel();
        label17 = new JLabel();
        LB_finance4 = new JLabel();
        label18 = new JLabel();
        LB_finance5 = new JLabel();
        label19 = new JLabel();
        LB_finance6 = new JLabel();
        label20 = new JLabel();
        LB_finance7 = new JLabel();
        label26 = new JLabel();
        LB_finance8 = new JLabel();
        label27 = new JLabel();
        LB_finance9 = new JLabel();
        panelInsurance = new JPanel();
        label21 = new JLabel();
        LB_insurance1 = new JLabel();
        label22 = new JLabel();
        LB_insurance2 = new JLabel();
        label23 = new JLabel();
        LB_insurance3 = new JLabel();
        label24 = new JLabel();
        LB_insurance4 = new JLabel();
        label25 = new JLabel();
        LB_insurance5 = new JLabel();
        panelRepair = new JPanel();
        label28 = new JLabel();
        LB_repair1 = new JLabel();
        label29 = new JLabel();
        LB_repair2 = new JLabel();
        label30 = new JLabel();
        LB_repair3 = new JLabel();
        label31 = new JLabel();
        LB_repair4 = new JLabel();
        label32 = new JLabel();
        LB_repair5 = new JLabel();
        label33 = new JLabel();
        LB_repair6 = new JLabel();
        label34 = new JLabel();
        LB_repair7 = new JLabel();
        label35 = new JLabel();
        LB_repair8 = new JLabel();
        label36 = new JLabel();
        LB_repair9 = new JLabel();
        label37 = new JLabel();
        LB_repair10 = new JLabel();
        panelTeacher = new JPanel();
        label38 = new JLabel();
        LB_teacher1 = new JLabel();

        //======== this ========
        setBackground(Color.black);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel3 ========
        {
            panel3.setLayout(new GridLayout(2, 3, 0, 15));

            //---- Bt_airplane_data ----
            Bt_airplane_data.setText("\u98de\u673a\u6570\u636e");
            Bt_airplane_data.addActionListener(e -> Bt_airplane_dataActionPerformed(e));
            panel3.add(Bt_airplane_data);

            //---- Bt_operation_data ----
            Bt_operation_data.setText("\u8fd0\u8425\u6570\u636e");
            Bt_operation_data.addActionListener(e -> Bt_operation_dataActionPerformed(e));
            panel3.add(Bt_operation_data);

            //---- Bt_finance_data ----
            Bt_finance_data.setText("\u4ef7\u683c\u4e0e\u8d22\u52a1\u6570\u636e");
            Bt_finance_data.addActionListener(e -> Bt_finance_dataActionPerformed(e));
            panel3.add(Bt_finance_data);

            //---- Bt_insurance_data ----
            Bt_insurance_data.setText("\u4fdd\u9669\u6570\u636e");
            Bt_insurance_data.addActionListener(e -> Bt_insurance_dataActionPerformed(e));
            panel3.add(Bt_insurance_data);

            //---- Bt_repair_data ----
            Bt_repair_data.setText("\u7ef4\u4fee\u6570\u636e");
            Bt_repair_data.addActionListener(e -> Bt_repair_dataActionPerformed(e));
            panel3.add(Bt_repair_data);

            //---- Bt_teacher_data ----
            Bt_teacher_data.setText("\u6559\u5458\u6570\u636e");
            Bt_teacher_data.addActionListener(e -> Bt_teacher_dataActionPerformed(e));
            panel3.add(Bt_teacher_data);
        }
        contentPane.add(panel3, BorderLayout.NORTH);

        //======== panel4 ========
        {
            panel4.setLayout(new GridLayout(1, 4));

            //---- Bt_getInitData ----
            Bt_getInitData.setText("\u8fd0\u8425\u73af\u5883\u6a21\u62df");
            Bt_getInitData.addActionListener(e -> Bt_getInitDataActionPerformed(e));
            panel4.add(Bt_getInitData);

            //---- Bt_backMain ----
            Bt_backMain.setText("\u5237\u65b0");
            Bt_backMain.addActionListener(e -> Bt_backMainActionPerformed(e));
            panel4.add(Bt_backMain);

            //---- Bt_variable_cost ----
            Bt_variable_cost.setText("\u5c0f\u65f6\u53d8\u52a8\u6210\u672c");
            Bt_variable_cost.addActionListener(e -> Bt_variable_costActionPerformed(e));
            panel4.add(Bt_variable_cost);

            //---- Bt_fixed_cost ----
            Bt_fixed_cost.setText("\u5c0f\u65f6\u56fa\u5b9a\u6210\u672c");
            Bt_fixed_cost.addActionListener(e -> Bt_fixed_costActionPerformed(e));
            panel4.add(Bt_fixed_cost);

            //---- Bt_dataShow ----
            Bt_dataShow.setText("\u6570\u636e\u6c47\u603b");
            Bt_dataShow.addActionListener(e -> Bt_dataShowActionPerformed(e));
            panel4.add(Bt_dataShow);

            //---- Bt_ROI ----
            Bt_ROI.setText("\u6295\u8d44\u56de\u62a5\u5206\u6790");
            Bt_ROI.addActionListener(e -> Bt_ROIActionPerformed(e));
            panel4.add(Bt_ROI);
        }
        contentPane.add(panel4, BorderLayout.SOUTH);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(3, 2));

            //======== panelAirplane ========
            {
                panelAirplane.setBorder(new TitledBorder("\u98de\u673a\u6570\u636e"));
                panelAirplane.setLayout(new GridLayout(5, 2));

                //---- label6 ----
                label6.setText("\u98de\u673a\u6570\u91cf/\u67b6");
                panelAirplane.add(label6);
                panelAirplane.add(LB_airplane1);

                //---- label2 ----
                label2.setText("\u6298\u65e7\u5e74\u9650/\u5e74");
                panelAirplane.add(label2);
                panelAirplane.add(LB_airplane2);

                //---- label4 ----
                label4.setText("\u6b8b\u503c\u7387");
                panelAirplane.add(label4);
                panelAirplane.add(LB_airplane3);

                //---- label5 ----
                label5.setText("\u98de\u673a\u5ea7\u4f4d\u6570/\u4e2a");
                panelAirplane.add(label5);
                panelAirplane.add(LB_airplane4);

                //---- label9 ----
                label9.setText("\u53d1\u52a8\u673a\u6570\u91cf/\u4e2a");
                panelAirplane.add(label9);
                panelAirplane.add(LB_airplane5);
            }
            panel1.add(panelAirplane);

            //======== panelOperation ========
            {
                panelOperation.setBorder(new TitledBorder("\u8fd0\u8425\u6570\u636e"));
                panelOperation.setLayout(new GridLayout(7, 2));

                //---- label7 ----
                label7.setText("\u5e74\u5747\u7a7a\u4e2d\u98de\u884c\u65f6\u95f4/\u5c0f\u65f6");
                panelOperation.add(label7);
                panelOperation.add(LB_operation1);

                //---- label3 ----
                label3.setText("\u98de\u673a\u5e73\u5747\u8d77\u843d\u95f4\u9694");
                panelOperation.add(label3);
                panelOperation.add(LB_operation2);

                //---- label8 ----
                label8.setText("\u7a7a\u4e2d\u5c0f\u65f6\u6cb9\u8017/\u5347");
                panelOperation.add(label8);
                panelOperation.add(LB_operation3);

                //---- label10 ----
                label10.setText("\u5730\u9762\u5c0f\u65f6\u6cb9\u8017/\u5347");
                panelOperation.add(label10);
                panelOperation.add(LB_operation4);

                //---- label11 ----
                label11.setText("\u7a7a\u5730\u504f\u5dee\u7387");
                panelOperation.add(label11);
                panelOperation.add(LB_operation5);

                //---- label12 ----
                label12.setText("\u8d77\u964d\u8d39/\uff08\u7f8e\u5143/\u5927\u8d77\u843d\uff09");
                panelOperation.add(label12);
                panelOperation.add(LB_operation6);

                //---- label13 ----
                label13.setText("\u4eba\u673a\u6bd4");
                panelOperation.add(label13);
                panelOperation.add(LB_operation7);
            }
            panel1.add(panelOperation);

            //======== panelFinance ========
            {
                panelFinance.setBorder(new TitledBorder("\u4ef7\u683c\u4e0e\u8d22\u52a1\u6570\u636e"));
                panelFinance.setLayout(new GridLayout(9, 2, 10, 0));

                //---- label14 ----
                label14.setText("\u7a0e\u524d\u98de\u673a\u4ef7\u683c(\u542b\u53d1\u52a8\u673a)/\u7f8e\u5143");
                panelFinance.add(label14);

                //---- LB_finance1 ----
                LB_finance1.setHorizontalAlignment(SwingConstants.LEFT);
                LB_finance1.setAlignmentX(1.0F);
                panelFinance.add(LB_finance1);

                //---- label15 ----
                label15.setText("\u822a\u6cb9\u4ef7\u683c/\u5143/\u5347");
                panelFinance.add(label15);
                panelFinance.add(LB_finance2);

                //---- label16 ----
                label16.setText("\u5173\u7a0e");
                panelFinance.add(label16);
                panelFinance.add(LB_finance3);

                //---- label17 ----
                label17.setText("\u589e\u503c\u7a0e");
                panelFinance.add(label17);
                panelFinance.add(LB_finance4);

                //---- label18 ----
                label18.setText("\u6c47\u7387");
                panelFinance.add(label18);
                panelFinance.add(LB_finance5);

                //---- label19 ----
                label19.setText("\u8d37\u6b3e\u6bd4\u4f8b");
                panelFinance.add(label19);
                panelFinance.add(LB_finance6);

                //---- label20 ----
                label20.setText("\u5e74\u5229\u7387");
                panelFinance.add(label20);
                panelFinance.add(LB_finance7);

                //---- label26 ----
                label26.setText("\u5e74\u8fd8\u6b3e\u6b21\u6570");
                panelFinance.add(label26);
                panelFinance.add(LB_finance8);

                //---- label27 ----
                label27.setText("\u8d37\u6b3e\u5e74\u6570");
                panelFinance.add(label27);
                panelFinance.add(LB_finance9);
            }
            panel1.add(panelFinance);

            //======== panelInsurance ========
            {
                panelInsurance.setBorder(new TitledBorder("\u4fdd\u9669\u6570\u636e"));
                panelInsurance.setLayout(new GridLayout(5, 2));

                //---- label21 ----
                label21.setText("\u98de\u673a\u4fdd\u9669\u8d39\u7387");
                panelInsurance.add(label21);
                panelInsurance.add(LB_insurance1);

                //---- label22 ----
                label22.setText("\u6bcf\u5ea7\u4fdd\u989d");
                panelInsurance.add(label22);
                panelInsurance.add(LB_insurance2);

                //---- label23 ----
                label23.setText("\u5ea7\u4f4d\u9669\u8d39\u7387");
                panelInsurance.add(label23);
                panelInsurance.add(LB_insurance3);

                //---- label24 ----
                label24.setText("\u7b2c\u4e09\u8005\u9669\u4fdd\u989d");
                panelInsurance.add(label24);
                panelInsurance.add(LB_insurance4);

                //---- label25 ----
                label25.setText("\u7b2c\u4e09\u8005\u9669\u4fdd\u8d39\u7387");
                panelInsurance.add(label25);
                panelInsurance.add(LB_insurance5);
            }
            panel1.add(panelInsurance);

            //======== panelRepair ========
            {
                panelRepair.setBorder(new TitledBorder("\u7ef4\u4fee\u6570\u636e"));
                panelRepair.setLayout(new GridLayout(10, 2));

                //---- label28 ----
                label28.setText("DA 40D\u6362\u53d1\u8d39\u7528/\u7f8e\u5143");
                panelRepair.add(label28);
                panelRepair.add(LB_repair1);

                //---- label29 ----
                label29.setText("\u6362\u53d1\u65f6\u95f4\u95f4\u9694/\u5c0f\u65f6");
                panelRepair.add(label29);
                panelRepair.add(LB_repair2);

                //---- label30 ----
                label30.setText("\u673a\u8eab\u5927\u4fee\u7406\u822a\u6750\u8d39/\u7f8e\u5143");
                panelRepair.add(label30);
                panelRepair.add(LB_repair3);

                //---- label31 ----
                label31.setText("\u673a\u8eab\u5927\u4fee\u7406\u65f6\u95f4\u95f4\u9694/\u5c0f\u65f6");
                panelRepair.add(label31);
                panelRepair.add(LB_repair4);

                //---- label32 ----
                label32.setText("\u673a\u8eab\u5927\u4fee\u7406\u5de5\u65f6/\u5c0f\u65f6");
                panelRepair.add(label32);
                panelRepair.add(LB_repair5);

                //---- label33 ----
                label33.setText("\u673a\u8eab\u5927\u4fee\u7406\u5c0f\u65f6\u5de5\u65f6\u8d39/\u7f8e\u5143");
                panelRepair.add(label33);
                panelRepair.add(LB_repair6);

                //---- label34 ----
                label34.setText("\u98de\u673a\u5c0f\u4fee\u7406\u822a\u6750\u8d39/\u7f8e\u5143");
                panelRepair.add(label34);
                panelRepair.add(LB_repair7);

                //---- label35 ----
                label35.setText("\u98de\u673a\u5c0f\u4fee\u7406\u5de5\u65f6\u6570/\u5c0f\u65f6");
                panelRepair.add(label35);
                panelRepair.add(LB_repair8);

                //---- label36 ----
                label36.setText("\u98de\u673a\u5c0f\u4fee\u7406\u65f6\u95f4\u95f4\u9694/\u5c0f\u65f6");
                panelRepair.add(label36);
                panelRepair.add(LB_repair9);

                //---- label37 ----
                label37.setText("\u98de\u673a\u5c0f\u4fee\u7406\u5c0f\u65f6\u5de5\u65f6\u8d39/\u7f8e\u5143");
                panelRepair.add(label37);
                panelRepair.add(LB_repair10);
            }
            panel1.add(panelRepair);

            //======== panelTeacher ========
            {
                panelTeacher.setBorder(new TitledBorder("\u6559\u5458\u6570\u636e"));
                panelTeacher.setLayout(new GridLayout(1, 1));

                //---- label38 ----
                label38.setText("\u6559\u5458\u5de5\u8d44");
                panelTeacher.add(label38);
                panelTeacher.add(LB_teacher1);
            }
            panel1.add(panelTeacher);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
//        InitLableList();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JButton Bt_airplane_data;
    private JButton Bt_operation_data;
    private JButton Bt_finance_data;
    private JButton Bt_insurance_data;
    private JButton Bt_repair_data;
    private JButton Bt_teacher_data;
    private JPanel panel4;
    private JButton Bt_getInitData;
    private JButton Bt_backMain;
    private JButton Bt_variable_cost;
    private JButton Bt_fixed_cost;
    private JButton Bt_dataShow;
    private JButton Bt_ROI;
    private JPanel panel1;
    private JPanel panelAirplane;
    private JLabel label6;
    private JLabel LB_airplane1;
    private JLabel label2;
    private JLabel LB_airplane2;
    private JLabel label4;
    private JLabel LB_airplane3;
    private JLabel label5;
    private JLabel LB_airplane4;
    private JLabel label9;
    private JLabel LB_airplane5;
    private JPanel panelOperation;
    private JLabel label7;
    private JLabel LB_operation1;
    private JLabel label3;
    private JLabel LB_operation2;
    private JLabel label8;
    private JLabel LB_operation3;
    private JLabel label10;
    private JLabel LB_operation4;
    private JLabel label11;
    private JLabel LB_operation5;
    private JLabel label12;
    private JLabel LB_operation6;
    private JLabel label13;
    private JLabel LB_operation7;
    private JPanel panelFinance;
    private JLabel label14;
    private JLabel LB_finance1;
    private JLabel label15;
    private JLabel LB_finance2;
    private JLabel label16;
    private JLabel LB_finance3;
    private JLabel label17;
    private JLabel LB_finance4;
    private JLabel label18;
    private JLabel LB_finance5;
    private JLabel label19;
    private JLabel LB_finance6;
    private JLabel label20;
    private JLabel LB_finance7;
    private JLabel label26;
    private JLabel LB_finance8;
    private JLabel label27;
    private JLabel LB_finance9;
    private JPanel panelInsurance;
    private JLabel label21;
    private JLabel LB_insurance1;
    private JLabel label22;
    private JLabel LB_insurance2;
    private JLabel label23;
    private JLabel LB_insurance3;
    private JLabel label24;
    private JLabel LB_insurance4;
    private JLabel label25;
    private JLabel LB_insurance5;
    private JPanel panelRepair;
    private JLabel label28;
    private JLabel LB_repair1;
    private JLabel label29;
    private JLabel LB_repair2;
    private JLabel label30;
    private JLabel LB_repair3;
    private JLabel label31;
    private JLabel LB_repair4;
    private JLabel label32;
    private JLabel LB_repair5;
    private JLabel label33;
    private JLabel LB_repair6;
    private JLabel label34;
    private JLabel LB_repair7;
    private JLabel label35;
    private JLabel LB_repair8;
    private JLabel label36;
    private JLabel LB_repair9;
    private JLabel label37;
    private JLabel LB_repair10;
    private JPanel panelTeacher;
    private JLabel label38;
    private JLabel LB_teacher1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void InitLableList(){
        Lable_airportData.add(LB_airplane1);
        Lable_airportData.add(LB_airplane2);
        Lable_airportData.add(LB_airplane3);
        Lable_airportData.add(LB_airplane4);
        Lable_airportData.add(LB_airplane5);

        Lable_operationData.add(LB_operation1);
        Lable_operationData.add(LB_operation2);
        Lable_operationData.add(LB_operation3);
        Lable_operationData.add(LB_operation4);
        Lable_operationData.add(LB_operation5);
        Lable_operationData.add(LB_operation6);
        Lable_operationData.add(LB_operation7);

        Lable_financeData.add(LB_finance1);
        Lable_financeData.add(LB_finance2);
        Lable_financeData.add(LB_finance3);
        Lable_financeData.add(LB_finance4);
        Lable_financeData.add(LB_finance5);
        Lable_financeData.add(LB_finance6);
        Lable_financeData.add(LB_finance7);
        Lable_financeData.add(LB_finance8);
        Lable_financeData.add(LB_finance9);

        Lable_insuranceData.add(LB_insurance1);
        Lable_insuranceData.add(LB_insurance2);
        Lable_insuranceData.add(LB_insurance3);
        Lable_insuranceData.add(LB_insurance4);
        Lable_insuranceData.add(LB_insurance5);

        Lable_repairData.add(LB_repair1);
        Lable_repairData.add(LB_repair2);
        Lable_repairData.add(LB_repair3);
        Lable_repairData.add(LB_repair4);
        Lable_repairData.add(LB_repair5);
        Lable_repairData.add(LB_repair6);
        Lable_repairData.add(LB_repair7);
        Lable_repairData.add(LB_repair8);
        Lable_repairData.add(LB_repair9);
        Lable_repairData.add(LB_repair10);

        Lable_teacherData.add(LB_teacher1);
        reInit();
    }
    private void reInit(){
        isData=((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).queryData(airportData,operationData,financeData,
                insuranceData,repairData,teacherData);
        if(isData){
            transferdata();
        }
        else{
            setLableEmpty(Lable_airportData);
            setLableEmpty(Lable_operationData);
            setLableEmpty(Lable_financeData);
            setLableEmpty(Lable_insuranceData);
            setLableEmpty(Lable_repairData);
            setLableEmpty(Lable_teacherData);
        }
    }
    private void setLableEmpty(ArrayList<JLabel> list){
        for(int i=0 ;i<list.size();i++){
            list.get(i).setText("");
        }
    }
    private void transferdata(){
        AirportData.transferList(airportList,airportData.get(0));
        setLableData(airportList,Lable_airportData);

        OperationData.transferList(operationList,operationData.get(0));
        setLableData(operationList,Lable_operationData);

        FinanceData.transferList(financeList,financeData.get(0));
        setLableData(financeList,Lable_financeData);

        InsuranceData.transferList(insuranceList,insuranceData.get(0));
        setLableData(insuranceList,Lable_insuranceData);

        RepairData.transferList(repairList,repairData.get(0));
        setLableData(repairList,Lable_repairData);

        TeacherData.transferList(teacherList,teacherData.get(0));
        setLableData(teacherList,Lable_teacherData);
    }
    private void setLableData(ArrayList listData ,ArrayList<JLabel> listLable){
        if(listData.size()==listLable.size()){
//            String[]data=new String[]
            for(int i=0;i<listData.size();i++){
                listLable.get(i).setText(listData.get(i).toString());
            }
        }
    }
    private void setLableData1(ArrayList listData ,ArrayList<JLabel> listLable){
        if(listData.size()==listLable.size()){
//            String[]data=new String[]
            for(int i=1;i<listData.size();i++){
                listLable.get(i).setText(listData.get(i).toString());
            }
        }
    }
}
