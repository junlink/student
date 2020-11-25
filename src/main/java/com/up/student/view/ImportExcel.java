package com.up.student.view;

/**
 * Created by juu79 on 2019/11/23 0023.
 */
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportExcel extends JFrame {
    private JButton btn;
    private JPanel contentPanel;    //内容面板
    private JTextField text_Field_getUrl;    //文本框

    public ImportExcel(){
        setTitle("导入excel文件");    //设置窗体的标题
        setBounds(100, 100, 800, 400);    //设置窗体位置和大小

        contentPanel=new JPanel();    //创建内容面板
        contentPanel.setBorder(new EmptyBorder(100,5,5,5));    //设置面板的边框
        contentPanel.setLayout(new BorderLayout(0,0));    //设置内容面板为边界布局
        setContentPane(contentPanel);    //应用内容面板
        JPanel panel1=new JPanel();    //新建面板用于保存文本框
        panel1.setBounds(5,100,800,100);
        contentPanel.add(panel1,BorderLayout.NORTH);    //将面板放置在边界布局的北部
        text_Field_getUrl=new JTextField();    //新建文本框
        panel1.add(text_Field_getUrl);    //将文本框增加到面板中
        text_Field_getUrl.setPreferredSize(new Dimension (400,40));
        final JButton btn=new JButton("选择文件");
        btn.setPreferredSize(new Dimension (100,40));
        panel1.add(btn);
        btn.setBackground(Color.GREEN);

        JPanel panel2=new JPanel();    //新建面板用于保存按钮
        contentPanel.add(panel2, BorderLayout.CENTER);    //将面板放置在边界布局的中央
        JButton okBtn=new JButton("确定");

        okBtn.setPreferredSize(new Dimension(100,40));
        panel2.add(okBtn);

        setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //按钮点击事件
                JFileChooser chooser = new JFileChooser();             //设置选择器
                chooser.setMultiSelectionEnabled(true);             //设为多选
                int returnValue = chooser.showOpenDialog(btn);        //是否打开文件选择框
                System.out.println("returnValue="+returnValue);
                if (returnValue == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
                    System.out.println(filepath);
                    text_Field_getUrl.setText(filepath);
                }
            }
        });

    /* 确定点击 */
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filepath=text_Field_getUrl.getText();
                if("".equals(filepath)||filepath==null){
                    JOptionPane.showMessageDialog(getContentPane(), "请先选择文件~",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String suffix=filepath.substring(filepath.lastIndexOf(".")+1);
                System.out.println(suffix);
                if(!(suffix.equals("xlsx")||(suffix.equals("xls")))){
                    JOptionPane.showMessageDialog(getContentPane(), "请选择Excel文件~",
                            "警告", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            /* 打开文件 */
                try {
                    openFile(filepath);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    /* 打开对应的Excel文件 */
    public void openFile(String filepath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filepath));
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());
        queryRows(workbook,"教练机选型");
    }

/* 检索需要信息 */

    public java.util.List<Row> queryRows(XSSFWorkbook workbook, String keys){
        List<Row> list=new ArrayList<>();
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(int i=2;i<=sheet.getLastRowNum();i++){
            System.out.println(sheet.getRow(i).getCell(2).getStringCellValue());
            if(sheet.getRow(i).getCell(2).getStringCellValue().contains(keys)){
                list.add(sheet.getRow(i));
            }
        }
        return list;
    }


    public static void main(String args[]) {
        new ImportExcel();
    }
}
