package com.up.student.view.computeMoudle;

import com.up.student.AppConstants;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by juu79 on 2019/8/26 0026.
 */
public class Weight extends JFrame {

    private JPanel jPanelCenter, jPanelSouth;
    private JButton exitButton;
    private JTextField name;
    private DefaultTableModel myTableModel;
    ArrayList<JTextField> jTextField = new ArrayList<JTextField>();
    String H_weight[];
    String data_solution[];
    String data_Name[];
    double[] data_weight;
    private JScrollPane jScrollPane;
    public static JTable jTable;
    public String[][] data_temp;
    public static String[] column = { "id", AppConstants.STUDENT_NAME, AppConstants.STUDENT_SNO,
            AppConstants.AddC1,  AppConstants.AddC2,  AppConstants.AddC3,  AppConstants.AddC4,  AppConstants.AddC5,  AppConstants.AddC6,  AppConstants.AddC7,
            AppConstants.AddC8,  AppConstants.AddC9,  AppConstants.AddC10, AppConstants.AddC11, AppConstants.AddC12, AppConstants.AddC13, AppConstants.AddC14,
            AppConstants.AddC15, AppConstants.AddC16, AppConstants.AddC17, AppConstants.AddC18, AppConstants.AddC19, AppConstants.AddC20, AppConstants.AddC21,
            AppConstants.AddC22, AppConstants.AddC23, AppConstants.AddC24, AppConstants.AddC25, AppConstants.AddC26, AppConstants.AddC27, AppConstants.AddC28,
            AppConstants.AddC29, AppConstants.AddC30, AppConstants.AddC31, AppConstants.AddC32, AppConstants.AddC33,};
    public Weight() throws SQLException {
        init();
    }

    private void init() throws SQLException {
        setTitle(AppConstants.PARAM_TieJingDu);
        data_solution = new process1().getData_solution(0.5);
        data_Name = new process1().getData_Name(0.5);
        data_weight=new process1().getH_weight(0.5);

        jPanelCenter = new JPanel();
        data_temp=new String[1][data_solution.length];
        jPanelCenter.setLayout(new GridLayout(1, 1));
        for(int i=0;i<data_solution.length;i++){
            H_weight[i]=String.valueOf(data_weight[i]);
        }
        for(int i=0;i<data_solution.length;i++){
            data_temp[0][i]=H_weight[i];
        }
        jTable=new JTable(data_temp,column);
        jScrollPane = new JScrollPane(jTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jPanelCenter.add(jScrollPane,BorderLayout.CENTER);

        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
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
        setBounds(370, 200, 800, 300);
        setResizable(false);
        setVisible(true);
    }

}
