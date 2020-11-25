package com.up.student.view.costMoudle;

import java.awt.event.*;

import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CostDataDAO;
import com.up.student.model.CostJudge.TeacherData;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class GetTeacherDataView extends JFrame {
    public GetTeacherDataView() {
        initComponents();
        init();

    }
    private void init() {
        this.setTitle("教员资料");
        this.setBackground(Color.black);
    }

    private void Bt_TeacherDate_determineActionPerformed(ActionEvent e) {
        // TODO add your code here
        teacherData.setTeacherSalary(TF_teacherSalary.getText());
        boolean isSuccess = ((CostDataDAO) BaseDAO.getAbilityDAO(DAO.CostDataDAO)).addTeacherData(teacherData);
        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "打分成功，已将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
            TF_teacherSalary.setText("");
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "打分失败，为将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
        }

    }

    private void Bt_TeacherData_BackMainActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        TF_teacherSalary = new JTextField();
        panel2 = new JPanel();
        Bt_TeacherDate_determine = new JButton();
        Bt_TeacherData_BackMain = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u6559\u5458\u6570\u636e"));
            panel1.setMinimumSize(new Dimension(480, 90));
            panel1.setPreferredSize(new Dimension(480, 90));
            panel1.setLayout(new GridLayout(2, 2));

            //---- label1 ----
            label1.setText("\u6559\u5458\u5de5\u8d44");
            panel1.add(label1);
            panel1.add(TF_teacherSalary);
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(1, 2));

            //---- Bt_TeacherDate_determine ----
            Bt_TeacherDate_determine.setText("\u786e\u5b9a");
            Bt_TeacherDate_determine.addActionListener(e -> Bt_TeacherDate_determineActionPerformed(e));
            panel2.add(Bt_TeacherDate_determine);

            //---- Bt_TeacherData_BackMain ----
            Bt_TeacherData_BackMain.setText("\u8fd4\u56de");
            Bt_TeacherData_BackMain.addActionListener(e -> Bt_TeacherData_BackMainActionPerformed(e));
            panel2.add(Bt_TeacherData_BackMain);
        }
        contentPane.add(panel2, BorderLayout.PAGE_END);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        getinitData();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField TF_teacherSalary;
    private JPanel panel2;
    private JButton Bt_TeacherDate_determine;
    private JButton Bt_TeacherData_BackMain;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TeacherData teacherData=new TeacherData();
    private void getinitData(){
        teacherData.setName("D40");
        if(CostView.initTeacherData!=null){
            String[] Datatemp=CostView.initTeacherData;
            TF_teacherSalary.setText(Datatemp[0]);
        }
    }
}
