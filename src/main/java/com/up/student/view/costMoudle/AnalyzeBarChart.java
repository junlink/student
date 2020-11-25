package com.up.student.view.costMoudle;

import com.up.student.view.ROI_Analysis.ROIView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import java.awt.*;


public class AnalyzeBarChart  {

    ChartPanel frame1;
    public  AnalyzeBarChart(){
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                "净现值",
                "",
                "数值",
                dataset, // 数据集
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        CategoryPlot plot=chart.getCategoryPlot();
        CategoryAxis domainAxis=plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
        frame1=new ChartPanel(chart,true);

        BarRenderer3D renderer=(BarRenderer3D) plot.getRenderer();
        /* 解决负数不显示问题 */
        ItemLabelPosition itemLabelPosition= new ItemLabelPosition(
                ItemLabelAnchor.INSIDE12,TextAnchor.CENTER_RIGHT,
                TextAnchor.CENTER_RIGHT,-1.57D);
        ItemLabelPosition itemLabelPositionFallback=new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT,
                TextAnchor.HALF_ASCENT_LEFT,-1.57D);
        renderer.setPositiveItemLabelPosition(itemLabelPosition);
        renderer.setNegativeItemLabelPosition(itemLabelPosition);
        renderer.setPositiveItemLabelPositionFallback(itemLabelPositionFallback);
        renderer.setNegativeItemLabelPositionFallback(itemLabelPositionFallback);
       //

    }
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i< ROIView.year;i++){
            if(Double.parseDouble(ROIView.PresentValue[i])< 0.00){
                dataset.addValue(Double.parseDouble(  ROIView.PresentValue[i]), "第"+ (i+1)+"年净现值为负", "");
            }
           else  dataset.addValue(Double.parseDouble(ROIView.PresentValue[i]), "第"+ (i+1) +"年净现值", "");
        }
        return dataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;

    }

}
