/**
 * 项目名：student
 * 修改历史：
 * 作者： MZ
 * 创建时间： 2016年1月6日-下午4:56:01
 */
package com.up.student.view.addMoudle;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.up.student.AppConstants;
import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CouchDAO;
import com.up.student.model.CouchJudge;
import com.up.student.view.MainView;
import com.up.student.view.computeMoudle.StandardView;

/**
 * 模块说明： 添加学生
 * 
 */
public class AddView extends JFrame {

	private static final long serialVersionUID = -1984182788841566838L;

	private JPanel jPanelCenter, jPanelSouth;
	private JButton addButton, exitButton;

	private JButton addButtonB1,addButtonB7;

	private JTextField name;   //文本框
	static public String Data_33[]=new String[34];
	public AddView() {
		init();
	}
	public AddView(int i){
		getName();
	}
	private void init() {
		setTitle(AppConstants.ADDVIEW_TITLE);
		// center panel
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(4, 2));

		jPanelCenter.add(new JLabel(AppConstants.STUDENT_NAME));
		name = new JTextField();
		jPanelCenter.add(name);

		jPanelCenter.add(new JLabel(AppConstants.ADDVIEW_TITLEB1));
		addButtonB1 = new JButton(AppConstants.ADDVIEW_ADDBUTTON);
		addButtonB1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getName() == "" || getName() == null) {
					JOptionPane.showMessageDialog(null, "请确认打分对象的名字，再点击按钮继续打分", "无评价对象姓名", JOptionPane.PLAIN_MESSAGE);
				} else {
					new AddB1View().reciveName(getName());
					new StandardView();
				}
			}
		});
		jPanelCenter.add(addButtonB1);

		jPanelCenter.add(new JLabel(AppConstants.ADDVIEW_TITLEB7));
		addButtonB7 = new JButton(AppConstants.ADDVIEW_ADDBUTTON);
		addButtonB7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddB7View();
			}
		});
		jPanelCenter.add(addButtonB7);

		// 分隔符
		jPanelCenter.add(new JLabel("-------------------------------------------------"));
		jPanelCenter.add(new JLabel("-------------------------------------------------"));

		// south panel
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 2));
		addButton = new JButton(AppConstants.ADDVIEW_ADDBUTTON);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					CouchJudge stu = new CouchJudge();
					buildStudent(stu);
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
		setBounds(470, 200, 400, 270);
		setResizable(false);
		setVisible(true);
	}

	private boolean check() {
		boolean result = false;

		return result;
	}
	private void buildStudent(CouchJudge stu) {

	}
	private void setEmpty() {

	}
	public String getName(){
		return this.name.getText().toString();
	}
}
