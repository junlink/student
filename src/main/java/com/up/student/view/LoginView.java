
package com.up.student.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import com.up.student.AppConstants;
import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.AdminDAO;
public class LoginView extends JFrame {

	private static final long serialVersionUID = -5278598737087831336L;
	private JPanel jPanelCenter, jPanelSouth,jPanelNorth;
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton, resetButton;
	private JLabel jiemian;

	public LoginView() {
		init();
	}

	private void init() {
		setTitle(AppConstants.MAINVIEW_TITLE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// 使用windows外观
		} catch (Exception e) {
			e.printStackTrace();
		}
		jPanelNorth = new JPanel();
		jiemian = new JLabel("欢迎使用!");
		Font font = new Font("楷体",Font.BOLD,20);
		jiemian.setFont(font);
		jiemian.setForeground(Color.DARK_GRAY);
		jPanelNorth.add(jiemian);

		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(3, 2));
		jPanelCenter.add(new JLabel(AppConstants.LOGIN_USERNAME));
		username = new JTextField();
		jPanelCenter.add(username);
		jPanelCenter.add(new JLabel(AppConstants.LOGIN_PASSWORD));
		password = new JPasswordField();
		// enter key listener
		password.addKeyListener(new LoginListener());
		jPanelCenter.add(password);

		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 2));
		loginButton = new JButton(AppConstants.LOGIN);
		loginButton.setBounds(new Rectangle(515, 625, 78, 26));
		loginButton.setBackground(Color.GREEN);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		jPanelSouth.add(loginButton);
		resetButton = new JButton(AppConstants.RESET);
		resetButton.setBounds(new Rectangle(515, 625, 78, 26));
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		jPanelSouth.add(resetButton);
		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(450, 250, 450, 200);
		this.setResizable(false);
		this.setVisible(true);
	}

	private class LoginListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				check();
			}
		}
	}

	private void check() {
		AdminDAO adminDAO = (AdminDAO) BaseDAO.getAbilityDAO(DAO.AdminDAO);
		if (adminDAO.queryForLogin(username.getText(), String.valueOf(password.getPassword()))) {
			dispose();
			new MainView();
		} else {
			JOptionPane.showMessageDialog(null, "用户名和密码错误","消息提示",JOptionPane.WARNING_MESSAGE);
			username.setText("");
			password.setText("");
		}
	}

}
