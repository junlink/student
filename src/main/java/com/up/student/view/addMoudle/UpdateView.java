
package com.up.student.view.addMoudle;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.up.student.AppConstants;
import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CouchDAO;
import com.up.student.model.CouchJudge;
import com.up.student.view.MainView;

public class UpdateView extends JFrame {
	private static final long serialVersionUID = 5292738820127102731L;
	private JPanel jPanelCenter, jPanelSouth;
	private JButton updateButton, exitButton;
	private JTextField name, teacher_code, column, column_data;
	private String Column,Column_data;
	public UpdateView() {
		init();
	}

	private void init() {
		setTitle(AppConstants.UPDATEVIEW_TITLE);
		// center panel
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(5, 2));

		jPanelCenter.add(new JLabel(AppConstants.STUDENT_NAME));
		name = new JTextField();
		jPanelCenter.add(name);

		jPanelCenter.add(new JLabel(AppConstants.STUDENT_SNO));
		teacher_code = new JTextField();
		jPanelCenter.add(teacher_code);

		jPanelCenter.add(new JLabel("需要修改的评价因素名"));
		column = new JTextField();
		jPanelCenter.add(column);

		jPanelCenter.add(new JLabel("对应的评分"));
		column_data = new JTextField();
		jPanelCenter.add(column_data);

		jPanelCenter.add(new JLabel("-------------------------------------------------"));
		jPanelCenter.add(new JLabel("-------------------------------------------------"));

		// south panel
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 2));
		updateButton = new JButton(AppConstants.UPDATEVIEW_UPDATEBUTTON);
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					CouchJudge stu = new CouchJudge();
					buildStudent(stu);
					Column=getColumn_name(Column);
					boolean isSuccess = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).update(stu,Column,Column_data);
					if (isSuccess) {
						setEmpty();
						if (MainView.currPageNum < 0 || MainView.currPageNum > 99) {
							MainView.currPageNum = 1;
						}
						String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO))
								.list(MainView.currPageNum);
						MainView.initJTable(MainView.jTable, result);
						dispose();
					}
				}
			}
		});
		jPanelSouth.add(updateButton);
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
		setBounds(470, 200, 400, 270);
		setResizable(false);
		setVisible(true);
	}

	private boolean check() {
		boolean result = false;
		if ("".equals(name.getText()) || "".equals(teacher_code.getText()) || "".equals(column.getText())
				|| "".equals(column_data.getText()) ) {
			return result;
		} else {
			result = true;
		}
		return result;
	}

	private void buildStudent(CouchJudge stu) {
		stu.setName(name.getText());
		stu.setTeacher_Code(teacher_code.getText());
		Column=column.getText();
		Column_data=column_data.getText();
	}

	private void setEmpty() {
		name.setText("");
		teacher_code.setText("");
		column.setText("");
		column_data.setText("");
	}
	private String getColumn_name(String column ){
		String column_String[]=AppConstants.AddViewString;
		String column1 = null;
		for (int i=0;i< column_String.length;i++){
			if(column.equals(column_String[i])){
				column1="c"+(i+1);
			}

		}
		return column1;
	}
}
