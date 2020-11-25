package com.up.student.view.costMoudle;

import java.awt.event.*;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.FinanceData;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class GetFinanceDataView extends JFrame {
    public GetFinanceDataView() {
        initComponents();
        init();

    }
    private void init() {
        this.setTitle("价格和财务数据");
        this.setBackground(Color.black);
    }

    private void Bt_FinanceData_DetermineActionPerformed(ActionEvent e) {
        // TODO add your code here
        financeData.setPreTaxJetPrice(TF_PreTaxJetPrice.getText());
        financeData.setJetFuelPrice(TF_JetFuelPrice.getText());
        financeData.setTariff(TF_Tariff.getText());
        financeData.setVAT(TF_VAT.getText());
        financeData.setExchangeRate(TF_ExchangeRate.getText());
        financeData.setLoanRatio(TF_LoanRatio.getText());
        financeData.setAnnualRate(TF_AnnualRate.getText());
        financeData.setAnnualRepayments(TF_AnnualRepayments.getText());
        financeData.setLoanLife(TF_LoanLife.getText());
        boolean isSuccess = ((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).addFinanceData(financeData);
//        FinanceData.transferList(financeData,);
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
        TF_PreTaxJetPrice.setText("");
        TF_JetFuelPrice.setText("");
        TF_Tariff.setText("");
        TF_VAT.setText("");
        TF_ExchangeRate.setText("");
        TF_LoanRatio.setText("");
        TF_AnnualRate.setText("");
        TF_AnnualRepayments.setText("");
        TF_LoanLife.setText("");
    }
    private void Bt_FinanceDataBackMainActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        TF_PreTaxJetPrice = new JTextField();
        label2 = new JLabel();
        TF_JetFuelPrice = new JTextField();
        label3 = new JLabel();
        TF_Tariff = new JTextField();
        label4 = new JLabel();
        TF_VAT = new JTextField();
        label5 = new JLabel();
        TF_ExchangeRate = new JTextField();
        label6 = new JLabel();
        TF_LoanRatio = new JTextField();
        label7 = new JLabel();
        TF_AnnualRate = new JTextField();
        label8 = new JLabel();
        TF_AnnualRepayments = new JTextField();
        label9 = new JLabel();
        TF_LoanLife = new JTextField();
        panel2 = new JPanel();
        Bt_FinanceData_Determine = new JButton();
        Bt_FinanceDataBackMain = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u4ef7\u683c\u4e0e\u8d22\u52a1\u6570\u636e"));
            panel1.setToolTipText("\u4ef7\u683c\u4e0e\u8d22\u52a1\u6570\u636e");
            panel1.setMinimumSize(new Dimension(480, 330));
            panel1.setPreferredSize(new Dimension(480, 330));
            panel1.setLayout(new GridLayout(9, 2));

            //---- label1 ----
            label1.setText("\u7a0e\u524d\u98de\u673a\u4ef7\u683c\uff08\u542b\u53d1\u52a8\u673a\uff09/\u7f8e\u5143");
            panel1.add(label1);
            panel1.add(TF_PreTaxJetPrice);

            //---- label2 ----
            label2.setText("\u822a\u6cb9\u4ef7\u683c/\u5143/\u5347");
            panel1.add(label2);
            panel1.add(TF_JetFuelPrice);

            //---- label3 ----
            label3.setText("\u5173\u7a0e");
            panel1.add(label3);
            panel1.add(TF_Tariff);

            //---- label4 ----
            label4.setText("\u589e\u503c\u7a0e");
            panel1.add(label4);
            panel1.add(TF_VAT);

            //---- label5 ----
            label5.setText("\u6c47\u7387");
            panel1.add(label5);
            panel1.add(TF_ExchangeRate);

            //---- label6 ----
            label6.setText("\u8d37\u6b3e\u6bd4\u4f8b");
            panel1.add(label6);
            panel1.add(TF_LoanRatio);

            //---- label7 ----
            label7.setText("\u5e74\u5229\u7387");
            panel1.add(label7);
            panel1.add(TF_AnnualRate);

            //---- label8 ----
            label8.setText("\u5e74\u8fd8\u6b3e\u6b21\u6570");
            panel1.add(label8);
            panel1.add(TF_AnnualRepayments);

            //---- label9 ----
            label9.setText("\u8d37\u6b3e\u5e74\u9650");
            panel1.add(label9);
            panel1.add(TF_LoanLife);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(1, 2));

            //---- Bt_FinanceData_Determine ----
            Bt_FinanceData_Determine.setText("\u786e\u5b9a");
            Bt_FinanceData_Determine.addActionListener(e -> {
			Bt_FinanceData_DetermineActionPerformed(e);

		});
            panel2.add(Bt_FinanceData_Determine);

            //---- Bt_FinanceDataBackMain ----
            Bt_FinanceDataBackMain.setText("\u8fd4\u56de");
            Bt_FinanceDataBackMain.addActionListener(e -> Bt_FinanceDataBackMainActionPerformed(e));
            panel2.add(Bt_FinanceDataBackMain);
        }
        contentPane.add(panel2, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        getinitData();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField TF_PreTaxJetPrice;
    private JLabel label2;
    private JTextField TF_JetFuelPrice;
    private JLabel label3;
    private JTextField TF_Tariff;
    private JLabel label4;
    private JTextField TF_VAT;
    private JLabel label5;
    private JTextField TF_ExchangeRate;
    private JLabel label6;
    private JTextField TF_LoanRatio;
    private JLabel label7;
    private JTextField TF_AnnualRate;
    private JLabel label8;
    private JTextField TF_AnnualRepayments;
    private JLabel label9;
    private JTextField TF_LoanLife;
    private JPanel panel2;
    private JButton Bt_FinanceData_Determine;
    private JButton Bt_FinanceDataBackMain;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private  FinanceData financeData = new FinanceData();
    private void getinitData(){
        financeData.setName("D40");
        if(CostView.initFinanceData!=null){
            String[] Datatemp=CostView.initFinanceData;
            TF_PreTaxJetPrice.setText(Datatemp[0]);
            TF_JetFuelPrice.setText(Datatemp[1]);
            TF_Tariff.setText(Datatemp[2]);
            TF_VAT.setText(Datatemp[3]);
            TF_ExchangeRate.setText(Datatemp[4]);
            TF_LoanRatio.setText(Datatemp[5]);
            TF_AnnualRate.setText(Datatemp[6]);
            TF_AnnualRepayments.setText(Datatemp[7]);
            TF_LoanLife.setText(Datatemp[8]);
        }
    }
}
