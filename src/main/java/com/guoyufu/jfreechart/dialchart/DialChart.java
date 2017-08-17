package com.guoyufu.jfreechart.dialchart;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialCap;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.junit.After;
import org.junit.Test;

public class DialChart {

	DialPlot dialplot;
	
	@Test
	public void testCreateDialChart() throws IOException {
		
		/**
		 * 创建刻度盘对象：由用户可定义层组成
		 * 刻度盘属性：数据集合、可见范围、外框、背景色、刻度、表盘帽
		 * 刻度盘图层：文本注释、指示器、刻度区间
		 */
		dialplot = new DialPlot();
		
		/**
		 * 刻度盘属性：数据集合（当前指针指向的位置）
		 */
		DefaultValueDataset dataset = new DefaultValueDataset();
		dataset.setValue(28D);
		dialplot.setDataset(dataset);
		/**
		 * 刻度盘属性：可见矩形范围（左上顶点x/y轴坐标、宽、高）
		 */
		dialplot.setView(0.0D, 0.0D, 1.0D, 1.0D);
		/**
		 * 刻度盘属性：外框（背景色、前景色）
		 */
		StandardDialFrame simpledialframe = new StandardDialFrame();
		simpledialframe.setBackgroundPaint(Color.lightGray);
		simpledialframe.setForegroundPaint(Color.darkGray);
		dialplot.setDialFrame(simpledialframe);
		/**
		 * 刻度盘属性：背景色（渐变色）
		 */
		GradientPaint gradientpaint = new GradientPaint(new Point(),
				new Color(255, 255, 220), new Point(), new Color(170, 100, 220));
		DialBackground dialbackground = new DialBackground(gradientpaint);
		dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(
				GradientPaintTransformType.VERTICAL));
		dialplot.setBackground(dialbackground);
		/**
		 * 刻度盘属性：刻度
		 * 范围（下界、上界；起始角度、程度-逆时针计量；主刻度增量、次刻度数量）
		 * 刻度标记（半径、标签偏移、标签字体）
		 */
		StandardDialScale standarddialscale = new StandardDialScale(-40D, 60D, -120D, -300D, 10, 10);
		standarddialscale.setTickRadius(0.88D);
		standarddialscale.setTickLabelOffset(0.14999999999999999D);
		standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
		dialplot.addScale(0, standarddialscale);
		/**
		 * 刻度盘属性：针盘盖/表盘帽
		 */
		DialCap dialcap = new DialCap();
		dialcap.setRadius(0.07000000000000001D);
		dialcap.setFillPaint(Color.LIGHT_GRAY);
		dialplot.setCap(dialcap);
		
		/**
		 * 刻度盘图层：指针
		 */
		DialPointer.Pointer pointer = new DialPointer.Pointer();
		dialplot.addLayer(pointer);
		
		/**
		 * 刻度盘图层：文本注释（表盘中央位置的信息）
		 */
		DialTextAnnotation dialtextannotation = new DialTextAnnotation("温度");
		dialtextannotation.setFont(new Font("Dialog", 1, 14));
		dialtextannotation.setRadius(0.69999999999999996D);
		dialplot.addLayer(dialtextannotation);

		/**
		 * 刻度盘图层：指示器
		 */
		DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
		dialvalueindicator.setNumberFormat(new ToAppendToNumberFormat(" ℉"));
		dialplot.addLayer(dialvalueindicator);
		
		/**
		 * 刻度盘图层： 刻度区间（红色、橘黄色、绿色）
		 */
		StandardDialRange standarddialrange = new StandardDialRange(40D, 60D, Color.red);
		standarddialrange.setInnerRadius(0.52000000000000002D);
		standarddialrange.setOuterRadius(0.55000000000000004D);
		dialplot.addLayer(standarddialrange);
		StandardDialRange standarddialrange1 = new StandardDialRange(10D, 40D, Color.orange);
		standarddialrange1.setInnerRadius(0.52000000000000002D);
		standarddialrange1.setOuterRadius(0.55000000000000004D);
		dialplot.addLayer(standarddialrange1);
		StandardDialRange standarddialrange2 = new StandardDialRange(-40D, 10D, Color.green);
		standarddialrange2.setInnerRadius(0.52000000000000002D);
		standarddialrange2.setOuterRadius(0.55000000000000004D);
		dialplot.addLayer(standarddialrange2);

		
		
	}
	
	
	@After
	public void createChartPic() throws IOException {
		
		/**
		 * 图表对象：刻度盘
		 * 图表属性：标题 ……
		 */
		JFreeChart dialChart = new JFreeChart(dialplot);
		dialChart.setTitle("设备取水温度采样");
		dialChart.getTitle().setPosition(RectangleEdge.BOTTOM);
		
		/**
		 * 图表图片： 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File fDialChart = new File("dialChart.jpeg");
		ChartUtilities.saveChartAsJPEG(fDialChart, dialChart, width, height);
	}
}
