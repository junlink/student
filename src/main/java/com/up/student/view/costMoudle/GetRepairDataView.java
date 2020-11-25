package com.up.student.view.costMoudle;

import java.awt.event.*;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.RepairData;

import java.awt.*;
import javax.swing.*;
import java.util.jar.JarFile;
import javax.swing.border.*;

/**
 * Created by juu79 on 2020/3/7 0007.
 */
public class GetRepairDataView extends JFrame {

    public GetRepairDataView() {
        initComponents();
        init();

    }
    private void init() {
        this.setTitle("维修数据");
        this.setBackground(Color.black);
    }

    private void Bt_RepairData_determineActionPerformed(ActionEvent e) {
        // TODO add your code here

        repairData.setEngineChangeFee(TF_engineChangeFee.getText());
        repairData.setEngineChangeInterval(TF_engineChangeInterval.getText());
        repairData.setJetBigRepairMaterialFee(TF_jetBigRepairMaterialFee.getText());
        repairData.setJetBigRepairInterval(TF_jetBigRepairInterval.getText());
        repairData.setJetBigRepairWorkingHour(TF_jetBigRepairWorkingHour.getText());
        repairData.setJetBigRepairWorkingHourFee(TF_jetBigRepairWorkingHourFee.getText());
        repairData.setJetSmallRepairMaterialFee(TF_jetSmallRepairMaterialFee.getText());
        repairData.setJetSmallRepairWorkingHour(TF_jetSmallRepairWorkingHour.getText());
        repairData.setJetSmallRepairInterval(TF_jetSmallRepairInterval.getText());
        repairData.setJetSmallRepairWorkingHourFee(TF_jetSmallRepairWorkingHourFee.getText());
        boolean isSuccess = ((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).addRepairData(repairData);
        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "已将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
            setEmpty();
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "为将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
        }
    }
    private void setEmpty() {
        TF_engineChangeFee.setText("");
        TF_engineChangeInterval.setText("");
        TF_jetBigRepairMaterialFee.setText("");
        TF_jetBigRepairInterval.setText("");
        TF_jetBigRepairWorkingHour.setText("");
        TF_jetBigRepairWorkingHourFee.setText("");
        TF_jetSmallRepairMaterialFee.setText("");
        TF_jetSmallRepairWorkingHour.setText("");
        TF_jetSmallRepairInterval.setText("");
        TF_jetSmallRepairWorkingHourFee.setText("");
    }
    private void Bt_RepairData_BackMainActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        TF_engineChangeFee = new JTextField();
        label2 = new JLabel();
        TF_engineChangeInterval = new JTextField();
        label3 = new JLabel();
        TF_jetBigRepairMaterialFee = new JTextField();
        label4 = new JLabel();
        TF_jetBigRepairInterval = new JTextField();
        label5 = new JLabel();
        TF_jetBigRepairWorkingHour = new JTextField();
        label6 = new JLabel();
        TF_jetBigRepairWorkingHourFee = new JTextField();
        label7 = new JLabel();
        TF_jetSmallRepairMaterialFee = new JTextField();
        label9 = new JLabel();
        TF_jetSmallRepairWorkingHour = new JTextField();
        label8 = new JLabel();
        TF_jetSmallRepairInterval = new JTextField();
        label10 = new JLabel();
        TF_jetSmallRepairWorkingHourFee = new JTextField();
        panel2 = new JPanel();
        Bt_RepairData_determine = new JButton();
        Bt_RepairData_BackMain = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u7ef4\u4fee\u8d39\u7528"));
            panel1.setMinimumSize(new Dimension(480, 330));
            panel1.setPreferredSize(new Dimension(480, 330));
            panel1.setLayout(new GridLayout(10, 2));

            //---- label1 ----
            label1.setText("\u6362\u53d1\u8d39\u7528/\u7f8e\u5143");
            panel1.add(label1);
            panel1.add(TF_engineChangeFee);

            //---- label2 ----
            label2.setText("\u6362\u53d1\u65f6\u95f4\u95f4\u9694/\u5c0f\u65f6");
            panel1.add(label2);
            panel1.add(TF_engineChangeInterval);

            //---- label3 ----
            label3.setText("\u673a\u8eab\u5927\u4fee\u7406\u822a\u6750\u8d39/\u7f8e\u5143");
            panel1.add(label3);
            panel1.add(TF_jetBigRepairMaterialFee);

            //---- label4 ----
            label4.setText("\u673a\u8eab\u5927\u4fee\u7406\u65f6\u95f4\u95f4\u9694/\u5c0f\u65f6");
            panel1.add(label4);
            panel1.add(TF_jetBigRepairInterval);

            //---- label5 ----
            label5.setText("\u673a\u8eab\u5927\u4fee\u7406\u5de5\u65f6/\u5c0f\u65f6");
            panel1.add(label5);
            panel1.add(TF_jetBigRepairWorkingHour);

            //---- label6 ----
            label6.setText("\u673a\u8eab\u5927\u4fee\u7406\u5c0f\u65f6\u5de5\u65f6\u8d39/\u7f8e\u5143");
            panel1.add(label6);
            panel1.add(TF_jetBigRepairWorkingHourFee);

            //---- label7 ----
            label7.setText("\u98de\u673a\u5c0f\u4fee\u7406\u822a\u6750\u8d39/\u7f8e\u5143");
            panel1.add(label7);
            panel1.add(TF_jetSmallRepairMaterialFee);

            //---- label9 ----
            label9.setText("\u98de\u673a\u5c0f\u4fee\u7406\u65f6\u95f4\u95f4\u9694/\u5c0f\u65f6");
            panel1.add(label9);
            panel1.add(TF_jetSmallRepairWorkingHour);

            //---- label8 ----
            label8.setText("\u98de\u673a\u5c0f\u4fee\u7406\u5de5\u65f6\u6570/\u5c0f\u65f6");
            panel1.add(label8);
            panel1.add(TF_jetSmallRepairInterval);

            //---- label10 ----
            label10.setText("\u98de\u673a\u5c0f\u4fee\u7406\u5c0f\u65f6\u5de5\u65f6\u8d39/\u7f8e\u5143");
            panel1.add(label10);
            panel1.add(TF_jetSmallRepairWorkingHourFee);
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(1, 2));

            //---- Bt_RepairData_determine ----
            Bt_RepairData_determine.setText("\u786e\u5b9a");
            Bt_RepairData_determine.addActionListener(e -> Bt_RepairData_determineActionPerformed(e));
            panel2.add(Bt_RepairData_determine);

            //---- Bt_RepairData_BackMain ----
            Bt_RepairData_BackMain.setText("\u8fd4\u56de");
            Bt_RepairData_BackMain.addActionListener(e -> Bt_RepairData_BackMainActionPerformed(e));
            panel2.add(Bt_RepairData_BackMain);
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
    private JTextField TF_engineChangeFee;
    private JLabel label2;
    private JTextField TF_engineChangeInterval;
    private JLabel label3;
    private JTextField TF_jetBigRepairMaterialFee;
    private JLabel label4;
    private JTextField TF_jetBigRepairInterval;
    private JLabel label5;
    private JTextField TF_jetBigRepairWorkingHour;
    private JLabel label6;
    private JTextField TF_jetBigRepairWorkingHourFee;
    private JLabel label7;
    private JTextField TF_jetSmallRepairMaterialFee;
    private JLabel label9;
    private JTextField TF_jetSmallRepairWorkingHour;
    private JLabel label8;
    private JTextField TF_jetSmallRepairInterval;
    private JLabel label10;
    private JTextField TF_jetSmallRepairWorkingHourFee;
    private JPanel panel2;
    private JButton Bt_RepairData_determine;
    private JButton Bt_RepairData_BackMain;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private RepairData repairData=new RepairData();
    private void getinitData(){
        repairData.setName("D40");
        if(CostView.initRepairData!=null){
            String[] Datatemp=CostView.initRepairData;
            TF_engineChangeFee.setText(Datatemp[0]);
            TF_engineChangeInterval.setText(Datatemp[1]);
            TF_jetBigRepairMaterialFee.setText(Datatemp[2]);
            TF_jetBigRepairInterval.setText(Datatemp[3]);
            TF_jetBigRepairWorkingHour.setText(Datatemp[4]);
            TF_jetBigRepairWorkingHourFee.setText(Datatemp[5]);
            TF_jetSmallRepairMaterialFee.setText(Datatemp[6]);
            TF_jetSmallRepairWorkingHour.setText(Datatemp[7]);
            TF_jetSmallRepairInterval.setText(Datatemp[8]);
            TF_jetSmallRepairWorkingHourFee.setText(Datatemp[9]);
        }
    }
}
