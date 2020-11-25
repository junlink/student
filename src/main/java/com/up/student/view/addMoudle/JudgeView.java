/**
 * 项目名：student
 * 修改历史：
 * 作者： MZ
 * 创建时间： 2016年1月7日-上午10:27:11
 */
package com.up.student.view.addMoudle;

import com.up.student.AppConstants;
import com.up.student.view.computeMoudle.TieJingDu;
import com.up.student.view.computeMoudle.Weight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class JudgeView extends JFrame {

	private JPanel jPanelCenter, jPanelSouth;
	private JButton Weight_Button,IdeaSolution_Button ,Distance_Button ,TIEJINDU_Button , exitButton;
	private JTextField weight, idea, distance;
	private double p= 0.5;
	public JudgeView() {
		init();
	}

	private void init() {
		setTitle(AppConstants.JUDGEVIEW_TITLE);

		// south panel
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(4, 3));

		jPanelSouth.add(new JLabel("权重因素分析"));
		weight=new JTextField();
		jPanelSouth.add(weight);
		Weight_Button = new JButton(AppConstants.JUDGEVIEW_SHANG);
		jPanelSouth.add(Weight_Button);
		String temp_weight=weight.getText().toString();
		Weight_Button.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				try {
					new Weight();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		jPanelSouth.add(new JLabel("正负理想解分析"));
		idea=new JTextField();
		jPanelSouth.add(idea);
		IdeaSolution_Button=new JButton(AppConstants.JUDGEVIEW_LIXIANGJIE);
		jPanelSouth.add(IdeaSolution_Button);
		IdeaSolution_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, temp_weight+":", "正负理想解分析", JOptionPane.PLAIN_MESSAGE);
			}
		});
		jPanelSouth.add(new JLabel("风险偏好系数p"));
		distance=new JTextField();
		jPanelSouth.add(distance);

		Distance_Button=new JButton(AppConstants.JUDGEVIEW_JULI);
		jPanelSouth.add(Distance_Button);
		String temp_distance=distance.getText().toString();
		Distance_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "e172"+":"+"与正理想解距离为1.316710517839548   与负理想解距离为2.3209089851954308 ","正负理想解距离", JOptionPane.PLAIN_MESSAGE);
			}
		});

		TIEJINDU_Button=new JButton(AppConstants.JUDGEVIEW_TIEJINDU);
		jPanelSouth.add(TIEJINDU_Button);



		TIEJINDU_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					p= Double.parseDouble(distance.getText().toString());
					new TieJingDu(p);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		exitButton = new JButton(AppConstants.EXITBUTTON);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jPanelSouth.add(exitButton);

		this.add(jPanelSouth, BorderLayout.CENTER);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(470, 250, 500, 130);
		setResizable(false);
		setVisible(true);
	}
		public  double transP(){
		return p;
		}
}
