package com.up.student.view.costMoudle;

import java.awt.event.*;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.InsuranceData;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class GetInsuranceDataView extends JFrame {
    public GetInsuranceDataView() {
        initComponents();
        init();

    }
    private void init() {
        this.setTitle("保险数据");
        this.setBackground(Color.black);
    }

    private void Bt_InsuranceData_determineActionPerformed(ActionEvent e) {
        // TODO add your code here
        insuranceData.setJet_insurance(TF_Jet_insurance.getText());
        insuranceData.setPerSeat_insurance(TF_PerSeat_insurance.getText());
        insuranceData.setSeat_insurance_rate(TF_Seat_insurance_rate.getText());
        insuranceData.setThirdParty_insurance(TF_ThirdParty_insurance.getText());
        insuranceData.setThirdParty_insurance_rate(TF_ThirdParty_insurance_rate.getText());

        boolean isSuccess = ((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).addInsuranceData(insuranceData);
        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "已将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
            setEmpty();
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "未将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void setEmpty() {
        TF_Jet_insurance.setText("");
        TF_PerSeat_insurance.setText("");
        TF_Seat_insurance_rate.setText("");
        TF_ThirdParty_insurance.setText("");
        TF_ThirdParty_insurance_rate.setText("");
    }
    private void Bt_InsuranceData_BackMainActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        TF_Jet_insurance = new JTextField();
        label2 = new JLabel();
        TF_PerSeat_insurance = new JTextField();
        label3 = new JLabel();
        TF_Seat_insurance_rate = new JTextField();
        label4 = new JLabel();
        TF_ThirdParty_insurance = new JTextField();
        label5 = new JLabel();
        TF_ThirdParty_insurance_rate = new JTextField();
        panel2 = new JPanel();
        Bt_InsuranceData_determine = new JButton();
        Bt_InsuranceData_BackMain = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(480, 330));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u4fdd\u9669\u6570\u636e"));
            panel1.setMinimumSize(new Dimension(480, 330));
            panel1.setPreferredSize(new Dimension(480, 330));
            panel1.setLayout(new GridLayout(5, 2));

            //---- label1 ----
            label1.setText("\u98de\u673a\u4fdd\u9669\u8d39\u7387");
            panel1.add(label1);
            panel1.add(TF_Jet_insurance);

            //---- label2 ----
            label2.setText("\u6bcf\u5ea7\u4fdd\u989d");
            panel1.add(label2);
            panel1.add(TF_PerSeat_insurance);

            //---- label3 ----
            label3.setText("\u5ea7\u4f4d\u9669\u8d39\u7387");
            panel1.add(label3);
            panel1.add(TF_Seat_insurance_rate);

            //---- label4 ----
            label4.setText("\u7b2c\u4e09\u8005\u9669\u4fdd\u989d");
            panel1.add(label4);
            panel1.add(TF_ThirdParty_insurance);

            //---- label5 ----
            label5.setText("\u7b2c\u4e09\u8005\u9669\u4fdd\u8d39\u7387");
            panel1.add(label5);
            panel1.add(TF_ThirdParty_insurance_rate);
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(1, 2));

            //---- Bt_InsuranceData_determine ----
            Bt_InsuranceData_determine.setText("\u786e\u5b9a");
            Bt_InsuranceData_determine.addActionListener(e -> Bt_InsuranceData_determineActionPerformed(e));
            panel2.add(Bt_InsuranceData_determine);

            //---- Bt_InsuranceData_BackMain ----
            Bt_InsuranceData_BackMain.setText("\u8fd4\u56de");
            Bt_InsuranceData_BackMain.addActionListener(e -> Bt_InsuranceData_BackMainActionPerformed(e));
            panel2.add(Bt_InsuranceData_BackMain);
        }
        contentPane.add(panel2, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        getinitData();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField TF_Jet_insurance;
    private JLabel label2;
    private JTextField TF_PerSeat_insurance;
    private JLabel label3;
    private JTextField TF_Seat_insurance_rate;
    private JLabel label4;
    private JTextField TF_ThirdParty_insurance;
    private JLabel label5;
    private JTextField TF_ThirdParty_insurance_rate;
    private JPanel panel2;
    private JButton Bt_InsuranceData_determine;
    private JButton Bt_InsuranceData_BackMain;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private  InsuranceData insuranceData=new InsuranceData();
    private void getinitData(){
        insuranceData.setName("D40");
        if(CostView.initInsuranceData!=null){
            String[] Datatemp=CostView.initInsuranceData;
            TF_Jet_insurance.setText(Datatemp[0]);
            TF_PerSeat_insurance.setText(Datatemp[1]);
            TF_Seat_insurance_rate.setText(Datatemp[2]);
            TF_ThirdParty_insurance.setText(Datatemp[3]);
            TF_ThirdParty_insurance_rate.setText(Datatemp[4]);

        }
    }
}
