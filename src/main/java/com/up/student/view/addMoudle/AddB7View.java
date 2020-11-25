package com.up.student.view.addMoudle;

import com.up.student.AppConstants;
import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CouchDAO;
import com.up.student.model.CouchJudge;
import com.up.student.util.DBUtil;
import com.up.student.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by juu79 on 2019/4/24 0024.
 */
public class AddB7View extends JFrame {

    private static final long serialVersionUID = 5292738820127102731L;

    private JPanel jPanelCenter, jPanelSouth;
    private JButton addButton, exitButton;

    private JTextField name, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, C26, C27, C28, C29, C30, C31, C32, C33;
    ArrayList<JTextField> jTextField = new ArrayList<JTextField>();
    ArrayList<String> text = new ArrayList<String>();
    private int num;
    public AddB7View() {
        init();
    }


    private void init() {
        setTitle(AppConstants.ADDVIEW_TITLEB7);
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(18, 2, 5, 10));
        jPanelCenter.add(new JLabel(AppConstants.STUDENT_NAME));
        name = new JTextField();
        jPanelCenter.add(name);
        jTextField.add(name);
        for (int i = 0; i < 33; i++) {
            JTextField jtf = new JTextField();
            jPanelCenter.add(new JLabel(AppConstants.AddViewString[i]));
            jPanelCenter.add(jtf);
            jTextField.add(jtf);
        }

        jPanelCenter.add(new JLabel("-------------------------------------------------------------------------------------------------------------------------"));
        jPanelCenter.add(new JLabel("-------------------------------------------------------------------------------------------------------------------------"));

        // south panel
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));

        addButton = new JButton(AppConstants.ADDVIEW_ADDBUTTON);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transform(jTextField, text);
                if (check1(text)) {
                    CouchJudge stu = new CouchJudge();
                    num=getColumn();
                    buildStudent(stu, text,num);
                    boolean isSuccess = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).add(stu);
                        if (isSuccess) {
                            setEmpty();
                            if (MainView.currPageNum < 0 || MainView.currPageNum > 99) {
                                MainView.currPageNum = 1;
                            }
                            String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO))
                                    .list(MainView.currPageNum);
                            MainView.initJTable(MainView.jTable, result);
                    }
                }
            }
        });
        jPanelSouth.add(addButton);
        exitButton = new JButton(AppConstants.EXITBUTTON);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jPanelSouth.add(exitButton);
        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(300, 0, 850, 700);
        setResizable(false);
        setVisible(true);
    }

    private void transform(ArrayList<JTextField> jTextFields, ArrayList text) {
        for (int i = 0; i < 34; i++) {
            text.add(jTextFields.get(i).getText());
        }
    }

    private boolean check1(ArrayList arrayList) {
        boolean result = false;
        for (int i = 0; i < 34; i++) {
            if (arrayList.get(i).equals("")) {
                result = false;
                return result;
            } else {
                result = true;
            }

        }
        return result;
    }

    private void buildStudent(CouchJudge stu, ArrayList text, int i) {
        stu.setId(i+1);
        stu.setName(text.get(0).toString());
        stu.setTeacher_Code(text.get(0).toString());
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

    private void setEmpty() {
        name.setText("");
        for(int i=0;i<34;i++){
         jTextField.get(i).setText("");
        }

    }
    private int getColumn()  {
        final DBUtil db = DBUtil.getDBUtil();
        ResultSet rs;
        int i=0;
        String sql = "select * from student";
//        String[] param = {"%" + name + "%"};
        rs = db.executeQuery(sql);
        try {
//            i=rs.getMetaData().getColumnCount();
            while(rs.next()){
                i++;
            }
        } catch (SQLException e) {
           i=0;
        }
        return i;
    }
}
