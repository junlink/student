package com.up.student.view.costMoudle;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.AirportData;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;



public class GetAirplaneDataView extends JFrame {
    public GetAirplaneDataView() {
        initComponents();
        init();
    }

    private void init() {
        this.setTitle("飞机数据");
        this.setBackground(Color.black);
    }

    private void Bt_ApData_DetermineActionPerformed(ActionEvent e) {
        // 在这里写存入数据的操作
        if (IsEmpty()) {
            JOptionPane.showMessageDialog(null, "请确认所有的数据是否填入，再点击确定", "警告", JOptionPane.PLAIN_MESSAGE);
        } else {
            airportData.setAmount(JT_amount.getText());
            airportData.setDepreciationPeriod(JT_depreciationPeriod.getText());
            airportData.setSalvageRate(JT_salvageRate.getText());
            airportData.setAirplaneSeat(JT_airplaneSeat.getText());
            airportData.setEngineNumber(JT_engineNumber.getText());
            boolean isSuccess = ((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).addAirportData(airportData);
            if (isSuccess) {

                JOptionPane.showMessageDialog(null, "打分成功，已将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
                setEmpty();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "已将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

    private boolean IsEmpty() {
        if (JT_amount.getText() == "" && JT_depreciationPeriod.getText() == "" && JT_salvageRate.getText() == "" && JT_airplaneSeat.getText() == "" && JT_engineNumber.getText() == "") {

            return true;
        } else {
            return false;
        }
    }

    private void setEmpty() {
        CostView.initAirplaneData = null;
        airportData.setAmount("");
        airportData.setDepreciationPeriod("");
        airportData.setSalvageRate("");
        airportData.setAirplaneSeat("");
        airportData.setEngineNumber("");
    }

    private void Bt_backActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        Label_amount = new JLabel();
        JT_amount = new JTextField();
        Label_depreciationPeriod = new JLabel();
        JT_depreciationPeriod = new JTextField();
        Label_salvageRate = new JLabel();
        JT_salvageRate = new JTextField();
        Label_airplaneSeat = new JLabel();
        JT_airplaneSeat = new JTextField();
        Label_engineNumber = new JLabel();
        JT_engineNumber = new JTextField();
        panel2 = new JPanel();
        Bt_ApData_Determine = new JButton();
        Bt_back = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(480, 330));
            panel1.setPreferredSize(new Dimension(480, 330));
            panel1.setBorder(new TitledBorder("\u98de\u673a\u6570\u636e"));
            panel1.setToolTipText("\u98de\u673a\u6570\u636e");
            panel1.setLayout(new GridLayout(5, 2));

            //---- Label_amount ----
            Label_amount.setText("\u98de\u673a\u6570\u91cf/\u67b6");
            panel1.add(Label_amount);
            panel1.add(JT_amount);

            //---- Label_depreciationPeriod ----
            Label_depreciationPeriod.setText("\u6298\u65e7\u5e74\u9650/\u5e74");
            panel1.add(Label_depreciationPeriod);
            panel1.add(JT_depreciationPeriod);

            //---- Label_salvageRate ----
            Label_salvageRate.setText("\u6b8b\u503c\u7387");
            panel1.add(Label_salvageRate);
            panel1.add(JT_salvageRate);

            //---- Label_airplaneSeat ----
            Label_airplaneSeat.setText("\u98de\u673a\u5ea7\u4f4d\u6570/\u4e2a");
            panel1.add(Label_airplaneSeat);
            panel1.add(JT_airplaneSeat);

            //---- Label_engineNumber ----
            Label_engineNumber.setText("\u53d1\u52a8\u673a\u6570\u91cf/\u4e2a");
            panel1.add(Label_engineNumber);
            panel1.add(JT_engineNumber);
        }
        contentPane.add(panel1, BorderLayout.CENTER);

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
        contentPane.add(panel2, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        getinitData();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel Label_amount;
    private JTextField JT_amount;
    private JLabel Label_depreciationPeriod;
    private JTextField JT_depreciationPeriod;
    private JLabel Label_salvageRate;
    private JTextField JT_salvageRate;
    private JLabel Label_airplaneSeat;
    private JTextField JT_airplaneSeat;
    private JLabel Label_engineNumber;
    private JTextField JT_engineNumber;
    private JPanel panel2;
    private JButton Bt_ApData_Determine;
    private JButton Bt_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private AirportData airportData = new AirportData();

    private void getinitData() {
        airportData.setName("D40");// 这里预设一个传入的参数 或者预设一个他类的一个参数 表示为同一个机型的成本分析
        if (CostView.initAirplaneData != null) {
            String[] Datatemp = CostView.initAirplaneData;
            JT_amount.setText(Datatemp[0]);
            JT_depreciationPeriod.setText(Datatemp[1]);
            JT_salvageRate.setText(Datatemp[2]);
            JT_airplaneSeat.setText(Datatemp[3]);
            JT_engineNumber.setText(Datatemp[4]);
        }
    }
}
