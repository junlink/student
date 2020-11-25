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
public class TieJingDu extends JFrame {

    private JPanel jPanelCenter, jPanelSouth;
    private JButton exitButton;
    private JTextField name;
    private DefaultTableModel myTableModel;
    ArrayList<JTextField> jTextField = new ArrayList<JTextField>();
    double H_weight[];
    String data_solution[];
    String data_Name[];
    double[] data_distancePlus;
    double[] data_distanceMins;
    double data_weight;
    private JScrollPane jScrollPane;
    public static JTable jTable;
    public String[][] data_temp;

    public TieJingDu(double p) throws SQLException {
        init(p);
    }

    private void init(double p) throws SQLException {
        setTitle(AppConstants.PARAM_TieJingDu);
        new process1().main(p);
        data_solution = new process1().getData_solution(p);
        data_Name = new process1().getData_Name(p);
        data_distancePlus=new process1().getIdeal_SolutionMax(p);
        data_distanceMins=new process1().getIdeal_SolutionMin(p);
//        data_solution= new String[]{"0.7618341", "0.7731251", "0.3293089", "0.3058901"};
//        data_solution= new String[]{"0.7618341", "0.7731251", "0.3293089", "0.3058901"};
//        data_solution= new String[]{"0.7618341", "0.7731251", "0.3293089", "0.3058901"};
//        data_distancePlus= new double[]{0.2213418, 0.2073156, 0.6104156, 0.6267938};
//        data_distanceMins= new double[]{0.7103341, 0.7071251, 0.2983089, 0.3058901};
        for(int j=0;j<data_solution.length-1;j++) {
            for (int i = 0; i < data_solution.length - 1-j; i++) {
                if (Double.parseDouble(data_solution[i]) > Double.parseDouble(data_solution[i + 1])) {
                    String temp = data_solution[i];
                    data_solution[i] = data_solution[i + 1];
                    data_solution[i + 1] = temp;

                    String temp1 = data_Name[i+1];
                    data_Name[i+1] = data_Name[i + 2];
                    data_Name[i + 2] = temp1;

                    double temp2 = data_distancePlus[i];
                    data_distancePlus[i] = data_distancePlus[i + 1];
                    data_distancePlus[i + 1] = temp2;

                    double temp3 = data_distanceMins[i];
                    data_distanceMins[i] = data_distanceMins[i + 1];
                    data_distanceMins[i + 1] = temp3;

                }
            }
        }
        jPanelCenter = new JPanel();
        data_temp=new String[3][data_solution.length+1];
	jPanelCenter.setLayout(new GridLayout(1, 1));
	for(int i=0;i<data_solution.length;i++){
	    data_temp[0][i+1]=data_solution[i];
	    data_temp[0][0]="贴进度";
        data_temp[2][0]="与负理想解距离";
        data_temp[1][0]="与正理想解距离";
	    data_temp[2][i+1]= String.valueOf(data_distanceMins[i]);
	    data_temp[1][i+1]= String.valueOf(data_distancePlus[i]);
//	    data_Name[4]="SE172";
//      data_Name[3]="PA28";
//      data_Name[2]="SR20";
//      data_Name[1]="DA40";
    }

	    jTable=new JTable(data_temp,data_Name);
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
