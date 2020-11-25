package com.up.student.view.computeMoudle;

import com.up.student.AppConstants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by juu79 on 2019/9/3 0003.
 */
public class StandardView extends JFrame {

    private JPanel jPanelNorth, jPanelCenter, jPanelSouth, jPanelWest, jPanelEast;
    private JButton ZhiDingButton, exitButton;
    private JLabel jLabel;
    public StandardView() {
        init();
    }

    private void init() {

        setTitle(AppConstants.Judege_Standard);
        jPanelNorth=new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 5));
        jPanelNorth.add(new JLabel(" "));
        jPanelNorth.add(new JLabel("上限（a）"));
        jPanelNorth.add(new JLabel("下限（c）"));
        jPanelNorth.add(new JLabel("可能值（b）"));
        this.add(jPanelNorth,BorderLayout.NORTH);

        jPanelWest=new JPanel();
        jPanelWest.setLayout(new GridLayout(5,1));
        jPanelWest.add(new JLabel("很差（VP）"));

        jPanelWest.add(new JLabel("较差（P）"));

        jPanelWest.add(new JLabel("中等（F）"));

        jPanelWest.add(new JLabel("良好（G）"));

        jPanelWest.add(new JLabel("优秀（VG）"));

        this.add(jPanelWest,BorderLayout.WEST);

        jPanelCenter=new JPanel();
        jPanelCenter.setLayout(new GridLayout(5,4));
        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("0"));
        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("3"));

        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("1"));
        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("5"));

        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("3"));
        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("7"));

        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("5"));
        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("9"));

        jPanelCenter.add(new JLabel("    "));
        jPanelCenter.add(new JLabel("7"));
        jPanelCenter.add(new JLabel("     "));
        jPanelCenter.add(new JLabel("10"));

        this.add(jPanelCenter,BorderLayout.CENTER);

        jPanelEast=new JPanel();
        jPanelEast.setLayout(new GridLayout(5,1));
        jPanelEast.add(new JLabel("取a和c之间的"));
        jPanelEast.add(new JLabel("可能性"));
        jPanelEast.add(new JLabel("最大的值"));
        jPanelEast.add(new JLabel(" "));
        jPanelEast.add(new JLabel(" "));
        this.add(jPanelEast,BorderLayout.EAST);

        jPanelSouth=new JPanel();
        jPanelSouth.setLayout(new GridLayout(2,2));
        jPanelSouth.add(new JLabel("-------------------------------------------------"));
        jPanelSouth.add(new JLabel("-------------------------------------------------"));
        ZhiDingButton = new JButton(AppConstants.ZHIDING);
        ZhiDingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAlwaysOnTop(true);
            }
        });
        jPanelSouth.add(ZhiDingButton);
        exitButton = new JButton(AppConstants.EXITBUTTON);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jPanelSouth.add(exitButton);
        this.add(jPanelSouth, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(50, 100, 300, 300);
        setResizable(false);
        setVisible(true);
    }
}
