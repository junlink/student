package com.up.student.view.costMoudle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;


public class AnalyzeChart  extends ApplicationFrame {
    public AnalyzeChart(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }
    private Container createDemoPanel() {
        JFreeChart jFreeChart = createChart(createDataset());
        return new ChartPanel(jFreeChart);
    }
    private PieDataset createDataset() {
        DefaultPieDataset dp = new DefaultPieDataset();
//        dp.setValue("折旧",AnalyzeFixedCost.cost[0]);
//        dp.setValue("利息",AnalyzeFixedCost.cost[1]);
//        dp.setValue("保险费",AnalyzeFixedCost.cost[2]);
//        dp.setValue("换发费用",AnalyzeFixedCost.cost[3]);
//        dp.setValue("机身大修理费",AnalyzeFixedCost.cost[4]);
//        dp.setValue("教员工资",AnalyzeFixedCost.cost[5]);
//        dp.setValue("燃油成本",AnalyzeFixedCost.cost[6]);
//        dp.setValue("航务保障费",AnalyzeFixedCost.cost[7]);
//        dp.setValue("小型修理费",AnalyzeFixedCost.cost[8]);
        dp.setValue("Depreciation",AnalyzeFixedCost.cost[0]);
        dp.setValue("Interest",AnalyzeFixedCost.cost[1]);
        dp.setValue("Insurance",AnalyzeFixedCost.cost[2]);
        dp.setValue("Engine replace",AnalyzeFixedCost.cost[3]);
        dp.setValue("Major repairs",AnalyzeFixedCost.cost[4]);
        dp.setValue("Faculty salary",AnalyzeFixedCost.cost[5]);
        dp.setValue("Fuel cost",AnalyzeFixedCost.cost[6]);
        dp.setValue("flight support fee",AnalyzeFixedCost.cost[7]);
        dp.setValue("Small maintenance cost",AnalyzeFixedCost.cost[8]);
        return dp;
    }
    private JFreeChart createChart(PieDataset piedataset) {

        JFreeChart jFreeChart = ChartFactory.createPieChart("Cost Analysis", piedataset, true, true, false);
        PiePlot piePlot = (PiePlot) jFreeChart.getPlot();
        Font font= new Font("新宋体",Font.BOLD,15);
        jFreeChart.getTitle().setFont(font);
        jFreeChart.getLegend().setItemFont(font);
        piePlot.setLabelFont(new Font("新宋体", Font.BOLD, 12));
        piePlot.setCircular(true);
        piePlot.setLabelFont(font);
        piePlot.setLabelGap(0.01D);
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}/{2}"));
        return jFreeChart;
    }
}
