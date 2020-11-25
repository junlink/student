package com.up.student.view.costMoudle;

import java.awt.event.*;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.OperationData;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;



public class GetOperationDataView extends JFrame{
    public GetOperationDataView() {
        initComponents();
        init();

    }
    private void init() {
        this.setTitle("运营数据");
        this.setBackground(Color.black);
    }

    private void Bt_OdData_DetermineActionPerformed(ActionEvent e) {
        operationData.setAirTime(TF_airTime.getText());
        operationData.setLandingInterval(TF_landingInterval.getText());
        operationData.setAirOil(TF_airOil.getText());
        operationData.setLandOil(TF_landOil.getText());
        operationData.setA_GDeviationDate(TF_A_GDeviationDate.getText());
        operationData.setTO_LandingFee(TF_TO_LandingFee.getText());
        operationData.setManMachineRatio(TF_ManMachineRatio.getText());
        boolean isSuccess = ((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).addOperationData(operationData);
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
        operationData.setAirTime("");
        operationData.setLandingInterval("");
        operationData.setAirOil("");
        operationData.setLandOil("");
        operationData.setA_GDeviationDate("");
        operationData.setTO_LandingFee("");
        operationData.setManMachineRatio("");
    }
    private void Bt_OdBackMainActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        TF_airTime = new JTextField();
        label2 = new JLabel();
        TF_landingInterval = new JTextField();
        label3 = new JLabel();
        TF_airOil = new JTextField();
        label4 = new JLabel();
        TF_landOil = new JTextField();
        label5 = new JLabel();
        TF_A_GDeviationDate = new JTextField();
        label6 = new JLabel();
        TF_TO_LandingFee = new JTextField();
        label7 = new JLabel();
        TF_ManMachineRatio = new JTextField();
        panel2 = new JPanel();
        Bt_OdData_Determine = new JButton();
        Bt_OdBackMain = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u8fd0\u8425\u6570\u636e"));
            panel1.setPreferredSize(new Dimension(480, 330));
            panel1.setMinimumSize(new Dimension(480, 330));
            panel1.setLayout(new GridLayout(7, 2));

            //---- label1 ----
            label1.setText("\u5e74\u5747\u7a7a\u4e2d\u98de\u884c\u65f6\u95f4/\u5c0f\u65f6");
            panel1.add(label1);
            panel1.add(TF_airTime);

            //---- label2 ----
            label2.setText("\u98de\u673a\u5e73\u5747\u8d77\u843d\u95f4\u9694");
            panel1.add(label2);
            panel1.add(TF_landingInterval);

            //---- label3 ----
            label3.setText("\u7a7a\u4e2d\u5c0f\u65f6\u6cb9\u8017/\u5347");
            panel1.add(label3);
            panel1.add(TF_airOil);

            //---- label4 ----
            label4.setText("\u5730\u9762\u5c0f\u65f6\u6cb9\u8017/\u5347");
            panel1.add(label4);
            panel1.add(TF_landOil);

            //---- label5 ----
            label5.setText("\u7a7a\u5730\u504f\u5dee\u7387");
            panel1.add(label5);
            panel1.add(TF_A_GDeviationDate);

            //---- label6 ----
            label6.setText("\u8d77\u964d\u8d39");
            panel1.add(label6);
            panel1.add(TF_TO_LandingFee);

            //---- label7 ----
            label7.setText("\u4eba\u673a\u6bd4");
            panel1.add(label7);
            panel1.add(TF_ManMachineRatio);
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(1, 2));

            //---- Bt_OdData_Determine ----
            Bt_OdData_Determine.setText("\u786e\u5b9a");
            Bt_OdData_Determine.addActionListener(e -> Bt_OdData_DetermineActionPerformed(e));
            panel2.add(Bt_OdData_Determine);

            //---- Bt_OdBackMain ----
            Bt_OdBackMain.setText("\u8fd4\u56de");
            Bt_OdBackMain.addActionListener(e -> Bt_OdBackMainActionPerformed(e));
            panel2.add(Bt_OdBackMain);
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
    private JTextField TF_airTime;
    private JLabel label2;
    private JTextField TF_landingInterval;
    private JLabel label3;
    private JTextField TF_airOil;
    private JLabel label4;
    private JTextField TF_landOil;
    private JLabel label5;
    private JTextField TF_A_GDeviationDate;
    private JLabel label6;
    private JTextField TF_TO_LandingFee;
    private JLabel label7;
    private JTextField TF_ManMachineRatio;
    private JPanel panel2;
    private JButton Bt_OdData_Determine;
    private JButton Bt_OdBackMain;
    private OperationData operationData=new OperationData();
    private void getinitData() {
        operationData.setName("D40");
        if (CostView.initFinanceData != null) {
            String[] Datatemp = CostView.initOperationData;
            TF_airTime.setText(Datatemp[0]);
            TF_landingInterval.setText(Datatemp[1]);
            TF_airOil.setText(Datatemp[2]);
            TF_landOil.setText(Datatemp[3]);
            TF_A_GDeviationDate.setText(Datatemp[4]);
            TF_TO_LandingFee.setText(Datatemp[5]);
            TF_ManMachineRatio.setText(Datatemp[6]);
        }
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
