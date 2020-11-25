package com.up.student.view.addMoudle;
import com.up.student.AppConstants;
import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CouchDAO;
import com.up.student.model.CouchJudge;
import com.up.student.util.DBUtil;
import com.up.student.view.MainView;
import com.up.student.view.computeMoudle.StandardView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddB1View extends JFrame {

    private static final long serialVersionUID = 5292738820127102731L;

    private JPanel jPanelNorth, jPanelCenter, jPanelSouth, jPanelCenterLeft, jPanelCenterMid, jPanelCenterRight;
    private JButton JdugeStandardButton, exitButton, addButton;

    ArrayList<JComboBox> cmbList = new ArrayList<JComboBox>();
    ArrayList<JTextField> jtfList = new ArrayList<JTextField>();
    ArrayList<String> cmbStringList = new ArrayList<String>();
    ArrayList<String> finalText = new ArrayList<String>();
    private int num;
    private String name;

    public AddB1View() {
        init();
    }

    private void init() {
        setTitle(AppConstants.ADDVIEW_TITLEB1);
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 3));
        jPanelNorth.add(new JLabel(AppConstants.PARAM_reason));
        jPanelNorth.add(new JLabel(AppConstants.PARAM_rank));
        jPanelNorth.add(new JLabel(AppConstants.PARAM_possible));

        // center panel
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(1, 3));

        jPanelCenterLeft = new JPanel();
        jPanelCenterLeft.setLayout(new GridLayout(33, 1));

        for (int i = 0; i < 33; i++) {
            jPanelCenterLeft.add(new JLabel(AppConstants.AddViewString[i]));
        }
        jPanelCenterMid = new JPanel();
        jPanelCenterMid.setLayout(new GridLayout(33, 1));
        for (int i = 1; i <= 33; i++) {
            JComboBox cmb = new JComboBox();    //创建JComboBox
            cmb.addItem("--请选择--");    //向下拉列表中添加一项
            cmb.addItem("很差（VP）");
            cmb.addItem("较差（P）");
            cmb.addItem("中等（F）");
            cmb.addItem("良好（G）");
            cmb.addItem("优秀（VG）");
            jPanelCenterMid.add(cmb);
            cmbList.add(cmb);
        }
        jPanelCenterRight = new JPanel();
        jPanelCenterRight.setLayout(new GridLayout(33, 1));
        for (int i = 1; i <= 33; i++) {
            JTextField jtf = new JTextField();    //创建JComboBox
            jPanelCenterRight.add(jtf);
            jtfList.add(jtf);
        }
        jPanelCenter.add(jPanelCenterLeft, BorderLayout.WEST);
        jPanelCenter.add(jPanelCenterMid, BorderLayout.CENTER);
        jPanelCenter.add(jPanelCenterRight, BorderLayout.EAST);

        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 3));
        JdugeStandardButton = new JButton(AppConstants.MAINVIEW_JudgeStandard);
        JdugeStandardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StandardView();
            }
        });
        jPanelSouth.add(JdugeStandardButton);
        addButton = new JButton(AppConstants.ADDVIEW_ADDBUTTON);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbStringList = getComeBoxdata(cmbList);
                String temp = null;
                if (!IsJtfEmpty(jtfList)) {
                    if (!IsEmpty(cmbStringList)) {
                        if (IsRightSection(jtfList, cmbStringList)) {
                            finalText.add("1"); // 添加老师的评分代码
                            for (int i = 0; i < cmbStringList.size(); i++) {
                                switch (cmbStringList.get(i).toString()) {
                                    case "很差（VP）":
                                            temp = 0 + "；" + jtfList.get(i).getText() + "；" + 3;
                                            finalText.add(temp);
                                            continue;
                                    case "较差（P）":
                                            temp = 1 + "；" + jtfList.get(i).getText() + "；" + 5;
                                            finalText.add(temp);
                                            continue;
                                    case "中等（F）":
                                            temp = 3 + "；" + jtfList.get(i).getText() + "；" + 7;
                                            finalText.add(temp);
                                            continue;
                                    case "良好（G）":
                                            temp = 5 + "；" + jtfList.get(i).getText() + "；" + 9;
                                            finalText.add(temp);
                                            continue;
                                    case "优秀（VG）":
                                            temp = 7 + "；" + jtfList.get(i).getText() + "；" + 10;
                                            finalText.add(temp);
                                            continue;
                                }
                            }
                            CouchJudge stu = new CouchJudge();
                            num = getColumn();
                            buildStudent(stu, finalText, num, name);
                            boolean isSuccess = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).add(stu);
                            if (isSuccess) {
                                JOptionPane.showMessageDialog(null, "打分成功，已将数据保存", "通知", JOptionPane.PLAIN_MESSAGE);
                                setEmpty();
                                if (MainView.currPageNum < 0 || MainView.currPageNum > 99) {
                                    MainView.currPageNum = 1;
                                }
                                String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO))
                                        .list(MainView.currPageNum);
                                MainView.initJTable(MainView.jTable, result);
                                dispose();
//                                StandardView.setDefaultCloseOperation(2);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "清空的所填因素值的重心不在所选区间内，请你确认后再输入再点击添加", "警告", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "请确认所有重心值是否填入，再点击添加", "警告", JOptionPane.PLAIN_MESSAGE);
                }
            }


        });
        jPanelSouth.add(addButton);
        exitButton = new JButton(AppConstants.EXITBUTTON);
        addButton.setBackground(Color.RED);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jPanelSouth.add(exitButton);

        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(370, 30, 550, 700);
        setResizable(false);
        setVisible(true);
    }

    public Boolean IsJtfEmpty(ArrayList<JTextField> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("".equals(list.get(i).getText())||list.get(i).getText()==null) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
    public Boolean IsEmpty(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString()==""||list.get(i).toString()==null) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean IsRightSection(ArrayList<JTextField> jtfList, ArrayList<String> cmbStringList) {

        if (!IsJtfEmpty(jtfList)) {
            if (!IsEmpty(cmbStringList)) {
                for (int i = 0; i < cmbStringList.size(); i++) {
                    switch (cmbStringList.get(i).toString()) {
                        case "很差（VP）":
                            if (Integer.parseInt(jtfList.get(i).getText()) < 3 && Integer.parseInt(jtfList.get(i).getText()) > 0) {}
                            else {
                                setEmptyOne(i,jtfList);
                                return false;
                            }
                            continue;
                        case "较差（P）":
                            if (Integer.parseInt(jtfList.get(i).getText()) < 5 && Integer.parseInt(jtfList.get(i).getText()) > 1) {}
                            else {
                                setEmptyOne(i,jtfList);
                                return false;
                            }
                            continue;
                        case "中等（F）":
                            if (Integer.parseInt(jtfList.get(i).getText()) < 7 && Integer.parseInt(jtfList.get(i).getText()) > 3){ }
                            else {
                                setEmptyOne(i,jtfList);
                                return false;
                            }
                            continue;
                        case "良好（G）":
                            if (Integer.parseInt(jtfList.get(i).getText()) < 9 && Integer.parseInt(jtfList.get(i).getText()) > 5) { }
                            else {
                                setEmptyOne(i,jtfList);
                                return false;
                            }
                            continue;
                        case "优秀（VG）":
                            if (Integer.parseInt(jtfList.get(i).getText()) < 10 && Integer.parseInt(jtfList.get(i).getText()) > 7) {}
                            else {
                                setEmptyOne(i,jtfList);
                                return false;
                            }
                            continue;
                        case "--请选择--":
                            setEmptyOne(i,jtfList);
                            return false;
                    }
                }
            }
        }
        if(!IsEmpty(jtfList)){
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList getComeBoxdata(ArrayList<JComboBox> list) {
        ArrayList<String> list1 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i).getSelectedItem().toString().trim());
        }
        return list1;
    }


    public CouchJudge tran_Couch_Data(CouchJudge stu) {
        return stu;
    }

    private void buildStudent(CouchJudge stu, ArrayList text, int i, String name ) {
        stu.setId(i+1);
        stu.setName(name);
        stu.setTeacher_Code(name);
        stu.setAddC1(text.get(1).toString());
        stu.setAddC2(text.get(2).toString());
        stu.setAddC3(text.get(3).toString());
        stu.setAddC4(text.get(4).toString());
        stu.setAddC5(text.get(5).toString());
        stu.setAddC6(text.get(6).toString());
        stu.setAddC7(text.get(7).toString());
        stu.setAddC8(text.get(8).toString());
        stu.setAddC9(text.get(9).toString());
        stu.setAddC10(text.get(10).toString());
        stu.setAddC11(text.get(11).toString());
        stu.setAddC12(text.get(12).toString());
        stu.setAddC13(text.get(13).toString());
        stu.setAddC14(text.get(14).toString());
        stu.setAddC15(text.get(15).toString());
        stu.setAddC16(text.get(16).toString());
        stu.setAddC17(text.get(17).toString());
        stu.setAddC18(text.get(18).toString());
        stu.setAddC19(text.get(19).toString());
        stu.setAddC20(text.get(20).toString());
        stu.setAddC21(text.get(21).toString());
        stu.setAddC22(text.get(22).toString());
        stu.setAddC23(text.get(23).toString());
        stu.setAddC24(text.get(24).toString());
        stu.setAddC25(text.get(25).toString());
        stu.setAddC26(text.get(26).toString());
        stu.setAddC27(text.get(27).toString());
        stu.setAddC28(text.get(28).toString());
        stu.setAddC29(text.get(29).toString());
        stu.setAddC30(text.get(30).toString());
        stu.setAddC31(text.get(31).toString());
        stu.setAddC32(text.get(32).toString());
        stu.setAddC33(text.get(33).toString());
    }
    private int getColumn()  {
        final DBUtil db = DBUtil.getDBUtil();
        ResultSet rs;
        int i=0;
        String sql = "select * from student ";
//        String[] param = {"%" + name + "%"};
        rs = db.executeQuery(sql);
        try {
            while(rs.next()){
                i++;
            }
        } catch (SQLException e) {
            i=0;
        }
        return i;
    }
    void setEmpty () {
        for (int i = 0; i < 33;i++) {
            jtfList.get(i).setText("");
        }
    }
    void setEmptyOne(int i,ArrayList<JTextField> jtfList){
        jtfList.get(i).setText(null);
    }
    void  reciveName(String name){
        this.name=name;
    }
}
