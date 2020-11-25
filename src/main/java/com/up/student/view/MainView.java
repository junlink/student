
package com.up.student.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.up.student.AppConstants;
import com.up.student.DAO;
import com.up.student.base.BaseDAO;
import com.up.student.dao.CouchDAO;
import com.up.student.view.costMoudle.CostView;
import com.up.student.view.addMoudle.AddView;
import com.up.student.view.addMoudle.DeleteView;
import com.up.student.view.addMoudle.JudgeView;
import com.up.student.view.addMoudle.UpdateView;

public class MainView extends JFrame {
	private static final long serialVersionUID = 5870864087464173884L;
	private final int maxPageNum = 99;
	private JPanel jPanelNorth, jPanelSouth, jPanelCenter;
	private JButton jButtonFirst, jButtonLast, jButtonNext, jButtonPre, jButtonAdd, jButtonDelete, jButtonUpdate,
			jButtonFind,jButtonJudge,jButtonImport ,jButtonCostView;
	// 用于添加一级指标下的每个二级指标
	private JButton jButtonB1, jButtonB2, jButtonB3, jButtonB4, jButtonB5, jButtonB6, jButtonB7,
			jButton;
	private JLabel currPageNumJLabel;
	private JTextField condition;
	public static JTable jTable;
	private JScrollPane jScrollPane;
	private DefaultTableModel myTableModel;

	public static String[] column = { "id", AppConstants.STUDENT_NAME, AppConstants.STUDENT_SNO,
			AppConstants.AddC1,  AppConstants.AddC2,  AppConstants.AddC3,  AppConstants.AddC4,  AppConstants.AddC5,  AppConstants.AddC6,  AppConstants.AddC7,
			AppConstants.AddC8,  AppConstants.AddC9,  AppConstants.AddC10, AppConstants.AddC11, AppConstants.AddC12, AppConstants.AddC13, AppConstants.AddC14,
			AppConstants.AddC15, AppConstants.AddC16, AppConstants.AddC17, AppConstants.AddC18, AppConstants.AddC19, AppConstants.AddC20, AppConstants.AddC21,
			AppConstants.AddC22, AppConstants.AddC23, AppConstants.AddC24, AppConstants.AddC25, AppConstants.AddC26, AppConstants.AddC27, AppConstants.AddC28,
			AppConstants.AddC29, AppConstants.AddC30, AppConstants.AddC31, AppConstants.AddC32, AppConstants.AddC33,};
	public static int currPageNum = 1;
	public MainView() {
		init();
	}
	private void init() {
		setTitle(AppConstants.MAINVIEW_TITLE);

		// north panel 最上方的 区域
		jPanelNorth = new JPanel();
		jPanelNorth.setLayout(new GridLayout(1, 8));
		condition = new JTextField(AppConstants.PARAM_FIND_CONDITION);
		condition.addKeyListener(new FindListener());
		jPanelNorth.add(condition);
		// query by name
		jButtonFind = new JButton(AppConstants.PARAM_FIND);
		jButtonFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		jButtonFind.addKeyListener(new FindListener());
		// add 按钮的监听和跳转的 view
		jPanelNorth.add(jButtonFind);
		jButtonAdd = new JButton(AppConstants.PARAM_ADD);
		jButtonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddView();
			}
		});
		jPanelNorth.add(jButtonAdd);
		// delete
		jButtonDelete = new JButton(AppConstants.PARAM_DELETE);
		jButtonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteView();
			}
		});
		jPanelNorth.add(jButtonDelete);
		// update
		jButtonUpdate = new JButton(AppConstants.PARAM_UPDATE);
		jButtonUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateView();
			}
		});
		jPanelNorth.add(jButtonUpdate);
		//对教练机进行评价
		jButtonJudge=new JButton(AppConstants.PARAM_JUDGE);
		jButtonJudge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					new JudgeView();
			}
		});

		jPanelNorth.add(jButtonJudge);
		jButtonImport=new JButton(AppConstants.IMPORTVIEW_TITLE);
		jButtonImport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ImportExcel();
			}
		});
		jPanelNorth.add(jButtonImport);

		jButtonCostView=new JButton(AppConstants.COSTBUTTON);
		jButtonCostView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CostView cv=new CostView();
				cv.setVisible(true);
			}
		});
		jPanelNorth.add(jButtonCostView);
		// center panel  中间显示数据区域
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(1, 1));
		// init jTable

		String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).list(currPageNum);
		myTableModel = new DefaultTableModel(result, column);
		jTable = new JTable(myTableModel);
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		cr.setHorizontalAlignment(JLabel.CENTER);
		jTable.setDefaultRenderer(Object.class, cr);
		if(result==null){
			initJTable(jTable, null);
		}
		else{
			String[][] result1=transferdata(result);
			initJTable(jTable, result1);
		}
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(jTable.getTableHeader(),BorderLayout.PAGE_START);
		panel.add(jTable,BorderLayout.CENTER);
		jScrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jPanelCenter.add(jScrollPane,BorderLayout.CENTER);

		// south panel 最下方的区域
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 5));
		jButtonFirst = new JButton(AppConstants.MAINVIEW_FIRST);
		jButtonFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum = 1;
				String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).list(currPageNum);
				String[][] result1=transferdata(result);
				initJTable(jTable, result1);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});
		jButtonPre = new JButton(AppConstants.MAINVIEW_PRE);
		jButtonPre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum--;
				if (currPageNum <= 0) {
					currPageNum = 1;
				}
				String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).list(currPageNum);
				String[][] result1=transferdata(result);
				initJTable(jTable, result1);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});
		jButtonNext = new JButton(AppConstants.MAINVIEW_NEXT);
		jButtonNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum++;
				if (currPageNum > maxPageNum) {
					currPageNum = maxPageNum;
				}
				String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).list(currPageNum);
//				String[][] result1=transferdata(result);
				initJTable(jTable, result);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});
		jButtonLast = new JButton(AppConstants.MAINVIEW_LAST);
		jButtonLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currPageNum = maxPageNum;
				String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).list(currPageNum);
//				String[][] result1=transferdata(result);
				initJTable(jTable, result);
				currPageNumJLabel.setText(AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum
						+ AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
			}
		});

		currPageNumJLabel = new JLabel(
				AppConstants.MAINVIEW_PAGENUM_JLABEL_DI + currPageNum + AppConstants.MAINVIEW_PAGENUM_JLABEL_YE);
		currPageNumJLabel.setHorizontalAlignment(JLabel.CENTER);
		jPanelSouth.add(jButtonFirst);
		jPanelSouth.add(jButtonPre);
		jPanelSouth.add(currPageNumJLabel);
		jPanelSouth.add(jButtonNext);
		jPanelSouth.add(jButtonLast);
		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		setBounds(50, 50, 850, 630);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
//	更改显示条目的宽度
	public static void initJTable(JTable jTable, String[][] result) {
		((DefaultTableModel) jTable.getModel()).setDataVector(result, column);
		jTable.setRowHeight(20);
		TableColumn idColumn = jTable.getColumnModel().getColumn(0);
		idColumn.setPreferredWidth(60);
		idColumn.setMaxWidth(60);
		idColumn.setMinWidth(60);
		TableColumn nameColumn = jTable.getColumnModel().getColumn(1);
		nameColumn.setPreferredWidth(60);
		nameColumn.setMaxWidth(60);
		nameColumn.setMinWidth(60);
		TableColumn numColumn = jTable.getColumnModel().getColumn(2);
		numColumn.setPreferredWidth(90);
		numColumn.setMaxWidth(90);
		numColumn.setMinWidth(90);
		for (int i=3;i<36;i++){
			TableColumn addColum=jTable.getColumnModel().getColumn(i);
			addColum.setPreferredWidth(150);
			addColum.setMaxWidth(150);
			addColum.setMinWidth(150);
		}
	}
	private class FindListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				find();
			}
		}
	}
	private void find() {
		currPageNum = 0;
		String param = condition.getText();
		if ("".equals(param) || param == null) {
			initJTable(MainView.jTable, null);
			currPageNumJLabel.setText(AppConstants.MAINVIEW_FIND_JLABEL);
			return;
		}
		String[][] result = ((CouchDAO) BaseDAO.getAbilityDAO(DAO.CouchDAO)).queryByName(param);
		condition.setText("");
		initJTable(MainView.jTable, result);
		currPageNumJLabel.setText(AppConstants.MAINVIEW_FIND_JLABEL);
	}
	private String[][] transferdata(String[][]a){
		String [][]transfer = new String[a.length][a[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(j<3){
					transfer[i][j]=a[i][j];
				}
				else {
					transfer[i][j]=transferString(a[i][j]);
				}
			}
		}
		return transfer;
	}
	private String transferString(String a){
		String transferstring;
		if((returnFirst(a).equals("0")&&returnThree(a).equals("3"))||
				Double.parseDouble(returnFirst(a))>0&&Double.parseDouble(returnFirst(a))<3){
			transferstring="很差（VP）";
		}
		else if((returnFirst(a).equals("1")&&returnThree(a).equals("5"))||
		Double.parseDouble(returnFirst(a))>1&&Double.parseDouble(returnFirst(a))<5){
			transferstring="较差（P）";
		}
		else if((returnFirst(a).equals("3")&&returnThree(a).equals("7"))||
				Double.parseDouble(returnFirst(a))>3&&Double.parseDouble(returnFirst(a))<7){
			transferstring="中等（F）";
		}
		else if((returnFirst(a).equals("5")&&returnThree(a).equals("9"))||
		Double.parseDouble(returnFirst(a))>5&&Double.parseDouble(returnFirst(a))<9){
			transferstring="良好（G）";
		}
		else if(((a).equals("7")&&returnThree(a).equals("10"))||
				Double.parseDouble(returnFirst(a))>7&&Double.parseDouble(returnFirst(a))<10){
			transferstring="优秀（VG）";
		}
		else {
			return a;
		}
		return transferstring;
	}
	public  String returnFirst(String array) {
		String array1[] = array.split("；");
		return array1[0];
	}
	public  String returnSecond(String array) {
		String array1[] = array.split("；");
		return array1[1];
	}
	public   String returnThree(String array) {
		String array1[] = array.split("；");
		return array1[2];
	}

}
