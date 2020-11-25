package com.up.student.view.ROI_Analysis;

import com.up.student.view.costMoudle.AnalyzeBarChart;
import com.up.student.view.costMoudle.AnalyzeFixedCost;
import com.up.student.view.costMoudle.AnalyzeVariableCost;
import com.up.student.view.costMoudle.CostView;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.*;


public class ROIView extends JFrame {
    public static ArrayList<String> Data_ROI = new ArrayList<>();
    public static int year;
    public static String[] PresentValue;
    public static double SUM = 0;

    public static String[]initROIData =new String[]{
            "0","850000","265","0.25","17551600","0","0.1","0.06","10","195612754","500","0.1","0.63"
    };


    public ROIView() {
        initComponents();
        init();
    }


    private void init() {
        this.setTitle("教练机机队投资回报分析");
        this.setBackground(Color.black);
    }

    private void Bt_ApData_DetermineActionPerformed(ActionEvent e) {
        if (IsEmpty()) {
            JOptionPane.showMessageDialog(null, "请确认所有的飞机数据是否填入，再点击确定", "警告", JOptionPane.PLAIN_MESSAGE);
        } else {
            GetJT_Data();
            compute();
            JFrame frame = new JFrame("投资回报分析每年净现值柱状图");
            frame.add(new AnalyzeBarChart().getChartPanel());
            frame.setBounds(50, 50, 800, 600);
            frame.setVisible(true);
            if (SUM > 0) {
                JOptionPane.showMessageDialog(null, "计算得出最后的NPV为：" + SUM, "机队在规划服役期内的净现值", JOptionPane.PLAIN_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "计算得出最后的NPV为负：" + SUM, "机队在规划服役期内的净现值", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private void Bt_backActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private boolean IsEmpty() {
        if (JT_num.getText() == "" && JT_tuition.getText() == "" && JT_flying_hours.getText() == "" && JT_operation_tax.getText() == "" && JT_amount_depreciation.getText() == "" &&
                JT_loan_interest.getText() == "" && JT_annual_grwth_rate_of_revenue_cost.getText() == "" && JT_discount_rate.getText() == "" && JT_operation_life.getText() == "" && JT_initial_investment.getText() == "") {
            return true;
        } else {
            return false;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel3 = new JPanel();
        Label_amount = new JLabel();
        JT_num = new JTextField();
        Label_tuition = new JLabel();
        JT_tuition = new JTextField();
        Label_flying_hours = new JLabel();
        JT_flying_hours = new JTextField();
        Label_operation_tax = new JLabel();
        JT_operation_tax = new JTextField();
        Label_amount_depreciation = new JLabel();
        JT_amount_depreciation = new JTextField();
        Label_loan_interest = new JLabel();
        JT_loan_interest = new JTextField();
        Label_annual_grwth_rate_of_revenue_cost = new JLabel();
        JT_annual_grwth_rate_of_revenue_cost = new JTextField();
        Label__discount_rate = new JLabel();
        JT_discount_rate = new JTextField();
        Label_operation_life = new JLabel();
        JT_operation_life = new JTextField();
        Label_initial_investment = new JLabel();
        JT_initial_investment = new JTextField();
        Label_no_Stu = new JLabel();
        JT_no_Stu = new JTextField();
        Label_no_Stu_Gro = new JLabel();
        JT_no_Stu_Gro = new JTextField();
        Label_trainingPlane_Rate = new JLabel();
        JT_trainingPlane_Rate = new JTextField();
        panel2 = new JPanel();
        Bt_ApData_Determine = new JButton();
        Bt_back = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //======== panel3 ========
            {
                panel3.setMinimumSize(new Dimension(480, 400));
                panel3.setPreferredSize(new Dimension(480, 400));
                panel3.setBorder(new TitledBorder("\u6295\u8d44\u56de\u62a5\u5206\u6790"));
                panel3.setToolTipText("\u98de\u673a\u6570\u636e");
                panel3.setLayout(new GridLayout(7, 4));

                //---- Label_amount ----
                Label_amount.setText("\u7b2c\u4e00\u5e74\u6bd5\u4e1a\u4eba\u6570");
                panel3.add(Label_amount);
                panel3.add(JT_num);

                //---- Label_tuition ----
                Label_tuition.setText("\u5b66\u5458\u5b66\u8d39/\u4eba");
                panel3.add(Label_tuition);
                panel3.add(JT_tuition);

                //---- Label_flying_hours ----
                Label_flying_hours.setText("\u6559\u7ec3\u673a\u5e74\u98de\u884c\u5c0f\u65f6");
                panel3.add(Label_flying_hours);
                panel3.add(JT_flying_hours);

                //---- Label_operation_tax ----
                Label_operation_tax.setText("\u6240\u5f97\u7a0e\u7387");
                panel3.add(Label_operation_tax);
                panel3.add(JT_operation_tax);

                //---- Label_amount_depreciation ----
                Label_amount_depreciation.setText("\u7b2c\u4e00\u5e74\u6298\u65e7\u989d");
                panel3.add(Label_amount_depreciation);
                panel3.add(JT_amount_depreciation);

                //---- Label_loan_interest ----
                Label_loan_interest.setText("\u7b2c\u4e00\u5e74\u8d37\u6b3e\u5229\u606f");
                panel3.add(Label_loan_interest);
                panel3.add(JT_loan_interest);

                //---- Label_annual_grwth_rate_of_revenue_cost ----
                Label_annual_grwth_rate_of_revenue_cost.setText("\u6536\u5165\u6210\u672c\u5e74\u589e\u957f\u7387");
                panel3.add(Label_annual_grwth_rate_of_revenue_cost);
                panel3.add(JT_annual_grwth_rate_of_revenue_cost);

                //---- Label__discount_rate ----
                Label__discount_rate.setText("\u6298\u73b0\u7387");
                panel3.add(Label__discount_rate);
                panel3.add(JT_discount_rate);

                //---- Label_operation_life ----
                Label_operation_life.setText("\u8fd0\u8425\u5e74\u9650");
                panel3.add(Label_operation_life);
                panel3.add(JT_operation_life);

                //---- Label_initial_investment ----
                Label_initial_investment.setText("\u521d\u59cb\u6295\u8d44\u989d");
                panel3.add(Label_initial_investment);
                panel3.add(JT_initial_investment);

                //---- Label_no_Stu ----
                Label_no_Stu.setText("\u65b0\u5b66\u5458\u4eba\u6570");
                panel3.add(Label_no_Stu);
                panel3.add(JT_no_Stu);

                //---- Label_no_Stu_Gro ----
                Label_no_Stu_Gro.setText("\u5b66\u5458\u4eba\u6570\u589e\u957f\u7387");
                panel3.add(Label_no_Stu_Gro);
                panel3.add(JT_no_Stu_Gro);

                //---- Label_trainingPlane_Rate ----
                Label_trainingPlane_Rate.setText("\u521d\u6559\u673a/\u603b\u6559\u7ec3\u673a\u6570");
                panel3.add(Label_trainingPlane_Rate);
                panel3.add(JT_trainingPlane_Rate);
            }
            panel1.add(panel3, BorderLayout.CENTER);

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout(1, 2));

                //---- Bt_ApData_Determine ----
                Bt_ApData_Determine.setText("\u786e\u5b9a");
                Bt_ApData_Determine.addActionListener(e -> Bt_ApData_DetermineActionPerformed(e));
                panel2.add(Bt_ApData_Determine);

                //---- Bt_back ----
                Bt_back.setText("\u8fd4\u56de");
                Bt_back.addActionListener(e -> Bt_backActionPerformed(e));
                panel2.add(Bt_back);
            }
            panel1.add(panel2, BorderLayout.SOUTH);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        getinitData(initROIData);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel3;
    private JLabel Label_amount;
    private JTextField JT_num;
    private JLabel Label_tuition;
    private JTextField JT_tuition;
    private JLabel Label_flying_hours;
    private JTextField JT_flying_hours;
    private JLabel Label_operation_tax;
    private JTextField JT_operation_tax;
    private JLabel Label_amount_depreciation;
    private JTextField JT_amount_depreciation;
    private JLabel Label_loan_interest;
    private JTextField JT_loan_interest;
    private JLabel Label_annual_grwth_rate_of_revenue_cost;
    private JTextField JT_annual_grwth_rate_of_revenue_cost;
    private JLabel Label__discount_rate;
    private JTextField JT_discount_rate;
    private JLabel Label_operation_life;
    private JTextField JT_operation_life;
    private JLabel Label_initial_investment;
    private JTextField JT_initial_investment;
    private JLabel Label_no_Stu;
    private JTextField JT_no_Stu;
    private JLabel Label_no_Stu_Gro;
    private JTextField JT_no_Stu_Gro;
    private JLabel Label_trainingPlane_Rate;
    private JTextField JT_trainingPlane_Rate;
    private JPanel panel2;
    private JButton Bt_ApData_Determine;
    private JButton Bt_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    void GetJT_Data() {
        Data_ROI.add(JT_num.getText().toString());
        Data_ROI.add(JT_tuition.getText().toString());
        Data_ROI.add(JT_flying_hours.getText().toString());
        Data_ROI.add(JT_operation_tax.getText().toString());
        Data_ROI.add(JT_amount_depreciation.getText().toString());
        Data_ROI.add(JT_loan_interest.getText().toString());
        Data_ROI.add(JT_annual_grwth_rate_of_revenue_cost.getText().toString());
        Data_ROI.add(JT_discount_rate.getText().toString());
        Data_ROI.add(JT_operation_life.getText().toString());
        Data_ROI.add(JT_initial_investment.getText().toString());
        Data_ROI.add(JT_no_Stu.getText().toString());
        Data_ROI.add(JT_no_Stu_Gro.getText().toString());
        Data_ROI.add(JT_trainingPlane_Rate.getText().toString());
    }

    void compute() {
//        String Revenue = String.valueOf(Double.parseDouble(Data_ROI.get(0)) * Double.parseDouble(Data_ROI.get(1)));
        double No_stu_graduate = 0;
        year = Integer.valueOf(Data_ROI.get(8));
        double initial_investment = Double.parseDouble(Data_ROI.get(9));
        double growth_rate = Double.parseDouble(Data_ROI.get(6));
        double []new_stu=new double[year];
        double []graduate_stu=new double[year];
        double []Revenue=new double[year];
        double []Cost=new double[year];
        double []Profit=new double[year];
        String cost = String.valueOf((Double.parseDouble(AnalyzeFixedCost.t_FixedCost) + Double.parseDouble(AnalyzeVariableCost.t_Variable_cost))
                * Double.parseDouble(Data_ROI.get(2))*Double.parseDouble(Data_ROI.get(12)));
        for(int i=0;i<year;i++){
            if(i==0){
                new_stu[i]=Double.parseDouble(Data_ROI.get(10));
                Cost[i]=Double.parseDouble(cost);
            }
            else{
                new_stu[i]=new_stu[i-1]*Double.parseDouble(Data_ROI.get(11));
                Cost[i]=Cost[i-1]*Double.parseDouble(Data_ROI.get(11));
            }
        }
        for (int j=0;j<year;j++){
            if(j>=2){
                graduate_stu[j]=new_stu[j-2];
                Revenue[j]=graduate_stu[j] * Double.parseDouble(Data_ROI.get(1));
            }
           else{
                Revenue[j]=0;
            }
        }
        for(int i=0;i<year;i++){
            Profit[i]=Revenue[i]-Cost[i]*(1 - Double.parseDouble(Data_ROI.get(3)));
        }
//        String Revenue =String.valueOf(No_stu_graduate * Double.parseDouble(Data_ROI.get(1)));
//        String profit = String.valueOf((Double.parseDouble(Revenue) - Double.parseDouble(Cost)) * (1 - Double.parseDouble(Data_ROI.get(3))));

        String D_int = String.valueOf(Double.parseDouble(Data_ROI.get(4)) + Double.parseDouble(Data_ROI.get(5)));//第一年折旧额和贷款利息和
        String[] Cash_Flow = new String[year];//现金流
        String[] Depreciation_Figure = new String[year];//这项系数
        PresentValue = new String[year];//净现值
        for (int i = 0; i < year; i++) {
            if (i == 0) Cash_Flow[i] = String.valueOf(Profit[i] + Double.parseDouble(D_int));
            else if (i == year - 1)
                Cash_Flow[i] = String.valueOf( Profit[i] * Math.pow(1 + growth_rate, year-2) + Double.parseDouble(D_int)
                        + (Double.parseDouble(Data_ROI.get(9)) - Double.parseDouble(Data_ROI.get(4)) * year));
            else
                Cash_Flow[i] = String.valueOf( Profit[i] * Math.pow(1 + growth_rate, i+1) + Double.parseDouble(D_int));
        }
        for (int i = 0; i < year; i++) {
            Depreciation_Figure[i] = String.valueOf(1 / Math.pow(1 + Double.parseDouble(Data_ROI.get(7)), i+1));
        }
        for (int i = 0; i < year; i++) {
            if (i == 0)
                PresentValue[i] = String.valueOf(Double.parseDouble(Cash_Flow[i]) * Double.parseDouble(Depreciation_Figure[i]) - initial_investment);
            else PresentValue[i] = String.valueOf(Double.parseDouble(PresentValue[i - 1]) +
                    Double.parseDouble(Cash_Flow[i]) * Double.parseDouble(Depreciation_Figure[i]));
        }

        for (int i = 0; i < PresentValue.length; i++) {
            SUM += Double.parseDouble(PresentValue[i]);
        }

    }
        private void getinitData(String[] initROIData) {

            JT_num.setText(String.valueOf(initROIData[0]));
            JT_tuition.setText(String.valueOf(initROIData[1]));
            JT_flying_hours.setText(String.valueOf(initROIData[2]));
            JT_operation_tax.setText(String.valueOf(initROIData[3]));
            JT_amount_depreciation.setText(String.valueOf(initROIData[4]));
            JT_loan_interest.setText(String.valueOf(initROIData[5]));
            JT_annual_grwth_rate_of_revenue_cost.setText(String.valueOf(initROIData[6]));
            JT_discount_rate.setText(String.valueOf(initROIData[7]));
            JT_operation_life.setText(String.valueOf(initROIData[8]));
            JT_initial_investment.setText(String.valueOf(initROIData[9]));
            JT_no_Stu.setText(String.valueOf(initROIData[10]));
            JT_no_Stu_Gro.setText(String.valueOf(initROIData[11]));
            JT_trainingPlane_Rate.setText(String.valueOf(initROIData[12]));

        }
}
