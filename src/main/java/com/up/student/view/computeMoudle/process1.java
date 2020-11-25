package com.up.student.view.computeMoudle;

import com.up.student.base.BaseDAO;
import com.up.student.util.DBUtil;
import com.up.student.view.addMoudle.JudgeView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * Created by juu79 on 2019/7/26 0026.
 */

//  存储的方式是 A；B;C  需要先把整个这些抓取出来
public class process1 extends BaseDAO {
    double H_weight[];
    double data_solution[];
    String data_Name[];
    double distance_p[] = new double[33];
    double distance_m[] = new double[33];
    double Dis_p[]=new double[4];
    double Dis_m[]=new double[4];
    private static Object[][] getDataArray(ResultSet rs) throws SQLException {
        List<Object[]> list = new LinkedList();
        while (rs.next()) {
            // 改成你的列名
            Object[] objects = new Object[]{rs.getString("name"), rs.getString("c1"), rs.getString("c2"), rs.getString("c3"),
                    rs.getString("c4"), rs.getString("c5"), rs.getString("c6"), rs.getString("c7"),
                    rs.getString("c8"), rs.getString("c9"), rs.getString("c10"), rs.getString("c11"),
                    rs.getString("c12"), rs.getString("c13"), rs.getString("c14"), rs.getString("c15"),
                    rs.getString("c16"), rs.getString("c17"), rs.getString("c18"), rs.getString("c19"),
                    rs.getString("c20"), rs.getString("c21"), rs.getString("c22"), rs.getString("c23"),
                    rs.getString("c24"), rs.getString("c25"), rs.getString("c26"), rs.getString("c27"),
                    rs.getString("c28"), rs.getString("c29"), rs.getString("c30"), rs.getString("c31"),
                    rs.getString("c32"), rs.getString("c33")
            };
            list.add(objects);
        }
        return list.toArray(new Object[0][0]);
    }

    private static Object[][] getData_Name(ResultSet rs) throws SQLException {
        List<Object[]> list = new LinkedList();
        while (rs.next()) {
            // 改成你的列名
            Object[] objects = new Object[]{
                    rs.getString("name"),
            };
            list.add(objects);
        }
        return list.toArray(new Object[0][0]);
    }

    private static void printArray(double[] data) {
        for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

    private static void printArray1(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void main(double p) throws SQLException {
        final DBUtil db = DBUtil.getDBUtil();
        ResultSet rs;
        int id = 0;
        String sql = "select * from student ";
        rs = db.executeQuery(sql);
        List StudentInfo = new ArrayList();

        Object[][] data = getDataArray(rs);
        data_Name = new String[data.length+1];
        String[][] data_normal = new String[data.length][data[0].length-1];

        for (int i = 0; i < data_normal.length; i++) {
            for (int j = 0; j < data_normal[i].length; j++) {
                data_normal[i][j] = data[i][j + 1].toString();//data 数据数组第一位为初教机的名称 故而j+1
            }
        }
//        data_Name=judge_name(data_Name,p);
        for (int i = 0; i < data_normal.length;i++) {
            data_Name[0]="机型名称";
            data_Name[i+1] = data[i][0].toString();//机型名称

            }
//        if(p<=0.2){
//            String temp;
//            temp=data_Name[1];
//            data_Name[1]=data_Name[2];
//            data_Name[2]=temp;
//        }

//        printArray1(data_normal);

        String[][] data_transfer = Normalization(data_normal, data.length);
//        printArray1(data_transfer);
        H_weight = weight_vector(p, data_normal, data.length);//data.length =4
        System.out.print(accumulation(H_weight));
//        printArray(H_weight);
        data_solution = ideal_Solution(data_transfer, H_weight, data_transfer);
//        printArray(data_solution);
    }

    String[][] Normalization(String student[][], int num) {
//      标准化处理
        String data1[][] = new String[num][33];
//        String data_MinMax[][] = new String[num + 2][33]; //每列中的最大值//
        String data_MinMax[][] = new String[num +2][33];//每行中的最大值//
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 33; j++) {
                data_MinMax[i][j] = student[i][j];
            }
        }
        for (int j = 0; j< 33; j++) {
            double max = Double.valueOf(returnThree(student[0][j]));
            double min = Double.valueOf(returnFirst(student[0][j]));
//            String max=student[0][j];
//            String min=student[0][j];
         for (int i = 0; i < num; i++) {//每行中的最大值//
                max = getMax(max, Double.valueOf((returnThree(student[i][j]))));
                min = getMin(min, Double.valueOf((returnFirst(student[i][j]))));
//             max=getStandardMax(max,student[i][j]);
//             min=getStandardMin(min,student[i][j]);
             data_MinMax[5][j] = String.valueOf(max);
             data_MinMax[4][j] = String.valueOf(min);
//             data_MinMax[5][j] = max;
//             data_MinMax[4][j] = min;
//             System.out.println(data_MinMax[5][j]);
//             System.out.println(data_MinMax[4][j]);
            }
        }
//        for (int j = 0; j < 33; j++) {//每列中的最大值//
//            String max = student[0][0];
//            String min = student[0][0];
//            for (int i = 0; i< num; i++) {
//                max = getMax(max, (student[i][j]));
//                min = getMin(min, (student[i][j]));
//            }
//            data_MinMax[num + 1][j] = max;
//            data_MinMax[num][j] = min;
//        }
        double MAX=getArrayMaX(data_MinMax[5]);
        double MIN=getArrayMin(data_MinMax[4]);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 33; j++) {
                String temp;
                double stand_a,stand_b, stand_c;
                double test;
                test = Double.parseDouble(returnFirst(student[i][j]));
                 stand_a = (
                        (Double.parseDouble(returnFirst(student[i][j]))
                                - MIN) / (MAX- MIN)
                );
//                stand_a = (
//                        (Double.parseDouble(returnFirst(student[i][j]))
//                                - Double.parseDouble((data_MinMax[4][j])))
//                                / (Double.parseDouble((data_MinMax[5][j])) - Double.parseDouble((data_MinMax[4][j])))
//                );
//                stand_a = (
//                        (Double.parseDouble(returnFirst(student[i][j]))
//                                - Double.parseDouble(returnFirst(data_MinMax[4][j])))
//                                / (Double.parseDouble(returnFirst(data_MinMax[5][j])) - Double.parseDouble(returnFirst(data_MinMax[4][j])))
//                );
//                Double.isNaN(stand_a);
                stand_b = (
                        (Double.parseDouble(returnSecond(student[i][j]))
                                - MIN) /(MAX-MIN)
                );
//                stand_b = (
//                        (Double.parseDouble(returnSecond(student[i][j]))
//                                - Double.parseDouble((data_MinMax[4][j])))
//                                / (Double.parseDouble((data_MinMax[5][j]))
//                                - Double.parseDouble((data_MinMax[4][j])))
//                );
//                stand_b = (
//                        (Double.parseDouble(returnSecond(student[i][j]))
//                                - Double.parseDouble(returnSecond(data_MinMax[4][j])))
//                                / (Double.parseDouble(returnSecond(data_MinMax[5][j]))
//                                - Double.parseDouble(returnSecond(data_MinMax[4][j])))
//                );
                stand_c = (
                        (Double.parseDouble(returnThree(student[i][j]))
                                - MIN) / (MAX - MIN)
                );
//
//                stand_c = (
//                        (Double.parseDouble(returnThree(student[i][j])) - Double.parseDouble(returnThree(data_MinMax[4][j])))
//                                / (Double.parseDouble(returnThree(data_MinMax[5][j]))
//                                - Double.parseDouble(returnThree(data_MinMax[4][j])))
//                );
                stand_a=transferNaNInF(stand_a);
                stand_b=transferNaNInF(stand_b);
                stand_c= transferNaNInF(stand_c);
                temp = stand_a + "；" + stand_b + "；" + stand_c;
                data1[i][j] = temp;
            }
        }
        return data1;
    }

    double[] weight_vector(double p, String[][] student, int m) {
        // 计算熵测度
        int H, Wei;
        List reason_List = new ArrayList();
        List Variance_List = new ArrayList();
        double data_shang[] = new double[33];
        double variance[] = new double[33];
        double sancanshu[] = new double[33];
        String data1[][];
        data1 = student;

        for (int j = 0; j < 33; j++) {
            double data_temp[] = new double[m];
            for (int i = 0; i < m; i++) {
                double temp = Double.parseDouble(returnSecond(student[i][j]));
                data_temp[i] = temp;
            }
            reason_List.add(data_temp);
        }
        for (int i = 0; i < 33; i++) {
            double data_temp[] = new double[m];
            for (int j = 0; j < m; j++) {
                double temp = (get_Variance(student[j][i]));
                data_temp[j] = temp;
            }
            Variance_List.add(data_temp);
        }
        // 使重心点的值保存在数组向量中 对其进行操作方便
        //计算熵测度中的括号部分
        for (int i = 0; i < reason_List.size(); i++) {
            double mid_temp[] = (double[]) reason_List.get(i);
            double mid_variance[] = (double[]) Variance_List.get(i);
            sancanshu[i] = mid_progress(mid_temp, m);
            variance[i] = mid_progress(mid_variance, m);
            data_shang[i] = p * sancanshu[i] + (1 - p) * variance[i];
        }

        // 计算权重
        double mul_shang = accumulation(data_shang);
        double H_weight[] = new double[33];
        for (int i = 0; i < 33; i++) {
            H_weight[i] = (1 - data_shang[i]) / (33 - mul_shang);
        }
        return H_weight;
    }

    double[] ideal_Solution(String[][] array, double[] H_weight, String[][] array_transfer) {
//        计算理想解
        String array1_max[] = new String[array[0].length];
        String array1_min[] = new String[array[0].length];
        double CC[] = new double[array.length];

        List normol_data = new ArrayList();

        for (int j = 0; j < array[0].length; j++) {//array[0].length 33
            String MAX=array_transfer[0][j];
            String MIN=array_transfer[0][j];
         for (int i = 0; i < array.length ; i++) {
//                array1_max[j] = getStandardMax(array_transfer[i][j], array_transfer[i + 1][j]);
//                array1_min[j] = getStandardMin(array_transfer[i][j], array_transfer[i + 1][j]);
             MAX = getStandardMax(MAX,array_transfer[i][j]);
             MIN = getStandardMin(MIN,array_transfer[i][j]);
            }
         array1_max[j]=MAX;
         array1_min[j]=MIN;
        }
//        for (int i = 0; i < array.length; i++) {
//            String normol_array[] = new String[array[0].length];
//            for (int j = 0; j < array[0].length; j++) {
//                normol_array[i] = array[i][j];
//            }
//            normol_data.add(normol_array);
//        }
//        和理想解的距离

        for (int j = 0; j < array_transfer.length; j++) {
            double distance_plus = 0, distance_minus = 0;
            for (int i = 0; i < 33; i++) {
                distance_p[i] = get_distance(array_transfer[j][i], array1_max[i]) * H_weight[i];
                distance_m[i] = get_distance(array_transfer[j][i], array1_min[i]) * H_weight[i];
                distance_plus = distance_p[i] + distance_plus;
                distance_minus = distance_m[i] + distance_minus;
            }
            // 计算贴进度
            Dis_m[j]=distance_minus;
            Dis_p[j]=distance_plus;
            CC[j] = distance_minus / (distance_minus + distance_plus);

//            if(j==2){
//                CC[j]=CC[j]/2;
//            }
        }
        return CC;
    }

    double get_distance(String a, String b) {
        double dis_first = Double.parseDouble(returnFirst(a)) - Double.parseDouble(returnFirst(b));
        double dis_sec = Double.parseDouble(returnSecond(a)) - Double.parseDouble(returnSecond(b));
        double dis_third = Double.parseDouble(returnThree(a)) - Double.parseDouble(returnThree(b));
        double dis=Math.sqrt(dis_first*dis_first + dis_sec*dis_sec + dis_third*dis_third);
        return dis;
    }
    Double returnMax(String a, String b) {
        double max;
        Double num1=Double.parseDouble(a);
        Double num2=Double.parseDouble(b);
        if(num1>num2){
            max=num1;
        }
        else {max=num2;}
        return max;
    }
    Double returnMin(String a, String b) {
        double min;
        Double num1=Double.parseDouble(a);
        Double num2=Double.parseDouble(b);
        if(num1<num2){
            min=num1;
        }
        else {min=num2;}
        return min;
    }


    public static String returnFirst(String array) {
        String array1[] = array.split("；");
        return array1[0];
    }

    public static String returnSecond(String array) {
        String array1[] = array.split("；");
        return array1[1];
    }

    public  static String returnThree(String array) {
        String array1[] = array.split("；");
        return array1[2];
    }

    String getStandardMax(String a, String b) {
        double  a_first = Double.parseDouble(returnFirst(a));
        double  a_sec = Double.parseDouble(returnSecond(a));
        double  a_third = Double.parseDouble(returnThree(a));
        double  b_first = Double.parseDouble(returnFirst(b));
        double  b_sec = Double.parseDouble(returnSecond(b));
        double  b_third = Double.parseDouble(returnThree(b));

        double L_a=a_third-a_first;
        double L_b=b_third-b_first;
        double M_a=(a_third+a_first)/2;
        double M_b=(b_third+b_first)/2;
        double p;
//        double temp=((a_third + a_first)/2-(a_third + a_first)/2+a_sec+b_sec)/(a_third-a_first+b_third-b_first)+0.5;
        double temp=(a_third - b_first +a_sec-b_sec)/(L_a+L_b);
        p=getMin((double) 1,getMax(temp, (double) 0));
        if(p>0.5){//这里的P不是风险系数
            return a;
        }
        else{
            return b;
        }

//        double temp_a,temp_b,temp_c;
//        String temp;
//        temp_a=getMax(a_first,b_first);
//        temp_b=getMax(a_sec,b_sec);
//        temp_c=getMax(a_third,b_third);
//        temp=temp_a+"；"+temp_b+"；"+temp_c;
//        return temp;

    }
    String getStandardMin(String a, String b) {
        double  a_first = Double.parseDouble(returnFirst(a));
        double  a_sec = Double.parseDouble(returnSecond(a));
        double  a_third = Double.parseDouble(returnThree(a));
        double  b_first = Double.parseDouble(returnFirst(b));
        double  b_sec = Double.parseDouble(returnSecond(b));
        double  b_third = Double.parseDouble(returnThree(b));

        double L_a=a_third-a_first;
        double L_b=b_third-b_first;
        double M_a=(a_third+a_first)/2;
        double M_b=(b_third+b_first)/2;
        double p;
        double temp=(a_third - b_first +a_sec-b_sec)/(L_a+L_b);
        p=getMin((double)1,getMax(temp , (double) 0));
//        double temp=( (a_third + a_first)/2 - (a_third + a_first)/2 + a_sec - b_sec) / (a_third-a_first + b_third-b_first)+0.5;
//        p=getMin((double) 1,getMax(temp, (double) 0));
        if(p>0.5){
            return b;
        }
        else{
            return a;
        }

//        double temp_a,temp_b,temp_c;
//        String temp;
//        temp_a=getMin(a_first,b_first);
//        temp_b=getMin(a_sec,b_sec);
//        temp_c=getMin(a_third,b_third);
//        temp=temp_a+"；"+temp_b+"；"+temp_c;
//        return temp;
    }
    String getStandardMax_1(String a, String b) {
        double  a_first = Double.parseDouble(returnFirst(a));
        double  a_sec = Double.parseDouble(returnSecond(a));
        double  a_third = Double.parseDouble(returnThree(a));
        double  b_first = Double.parseDouble(returnFirst(b));
        double  b_sec = Double.parseDouble(returnSecond(b));
        double  b_third = Double.parseDouble(returnThree(b));

        if(a_third == getMax(a_third,b_third)){
            return a;
        }
        else{
            return b;
        }

    }
    String getStandardMin_1(String a, String b) {
        double  a_first = Double.parseDouble(returnFirst(a));
        double  a_sec = Double.parseDouble(returnSecond(a));
        double  a_third = Double.parseDouble(returnThree(a));
        double  b_first = Double.parseDouble(returnFirst(b));
        double  b_sec = Double.parseDouble(returnSecond(b));
        double  b_third = Double.parseDouble(returnThree(b));

        if(a_first == getMin(a_first,b_first)){
            return a;
        }
        else{
            return b;
        }

    }
    Double getMax(Double a,Double b){
        if(a-b>0){
            return a;
        }
        else{
            return b;
        }
    }
    Double getMin(Double a,Double b){
//        if(a==0||b==0){
//            return Math.sqrt((a-b)*(a-b));
//        }
        if(a-b>0){
            return b;
        }
        else{
            return a;
        }
    }
    double getArrayMaX(String array[] ) {
        double max=Double.parseDouble(array[0]);
        for(int i=0;i<array.length;i++){
           max=getMax(max,Double.parseDouble(array[i]));
        }
        return max;
    }
    double getArrayMin(String array[] ) {
        Double min=Double.parseDouble(array[0]);
        for(int i=0;i<array.length;i++){
            min=getMin(min,Double.parseDouble(array[i]));
        }
        return min;
    }
    String getMin(String a, String b) {
        if(a==null){
            return b;
        }
        else if(b==null)  {
            return a;
        }else {
            String min;
            double min_a, min_b, min_c;
            min_a = returnMin(returnFirst(a), returnFirst(b));
            min_b = returnMin(returnSecond(a), returnSecond(b));
            min_c = returnMin(returnThree(a), returnThree(b));
            min = min_a + "；" + min_b + "；" + min_c;
            return min;
        }
    }
    String getMax(String a, String b) {
        if(a==null){
            return b;
        }
        else if(b==null)  {
            return a;
        }else{
        double  max_a, max_b,max_c;
        String max;
        max_a = returnMax(returnFirst(a), returnFirst(b));
        max_b = returnMax(returnSecond(a), returnSecond(b));
        max_c = returnMax(returnThree(a), returnThree(b));
        max = max_a + "；" + max_b + "；" + max_c;
        return max;
        }
    }

    double get_Variance(String array) {
        String array1[] = array.split("；");
        double a = Double.parseDouble(array1[0]);
        double b = Double.parseDouble(array1[1]);
        double c = Double.parseDouble(array1[2]);
        double average = (a + b + c) / 3;
        double variance = ((a - average) * (a - average) + (b - average) * (b - average) + (c - average) * (c - average)) / 3;
//        double variance = ((a - b) * (a - b) + (b - c) * (b - c) )/2 ;
        return variance;

    }

    double mid_progress(double array[], int m) {
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < m; i++) {
            sum1 = array[i] + sum1;
        }
        for (int i = 0; i < m; i++) {
            sum2 = ((array[i] / sum1) * Math.log(array[i] / sum1)) + sum2;
        }
        double temp = (-1 / Math.log(m)) * (sum2);
        return temp;
    }

    double accumulation(double array[]) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = array[i] + sum;
        }
        return sum;
    }

    public double[] getH_weight(double p) throws SQLException {
        main(p);
        return H_weight;
    }

    public String[] getData_solution(double p) throws SQLException {
        main(p);
        String stringData_Solution[] = new String[data_solution.length];
        for (int i = 0; i < data_solution.length; i++) {
            stringData_Solution[i] = String.valueOf(data_solution[i]);
        }
        return stringData_Solution;
    }

    public double[] getIdeal_SolutionMax(double p) throws SQLException {
        main(p);
        return Dis_p;
    }
    public double[] getIdeal_SolutionMin(double p) throws SQLException {
        main(p);
        return Dis_m;
    }
    public String[] getData_Name(double p) throws SQLException {
        main(p);
        return data_Name;
    }
    double transferNaNInF(double a){
        if(Double.isNaN(a)){
            a=0.0;
        }else  if(Double.isInfinite(a)){
            a=1.0;
        }
       return a;
    }

    public double getP(double p) {
        return p;
    }
}

