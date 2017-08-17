package com.guoyufu.jfreechart.details;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomBackground {

	/**
	 * 数据集：饼图数据集
	 */
	DefaultPieDataset dataset;

	/**
	 * 图表对象：饼图
	 */
	JFreeChart pieChart;

	@Before
	public void createDataSet() throws IOException {
		
		dataset = new DefaultPieDataset();
		dataset.setValue("IPhone 5s", new Double(20));
		dataset.setValue("SamSung Grand", new Double(20));
		dataset.setValue("MotoG", new Double(40));
		dataset.setValue("Nokia Lumia", new Double(10));
	}

	@After
	public void createChartPic() throws IOException {
		/**
		 * 图表图片： 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File fPieChart = new File("PieChart.jpeg");
		ChartUtilities.saveChartAsJPEG(fPieChart, pieChart, width, height);
	}

	@Test
	public void testBackground() {
		
		pieChart = ChartFactory.createPieChart("PHONE SALES", dataset);
		/**
		 * 图表背景颜色：比如Color、GradientPaint（渐变颜色）和TexturePaint（质感涂料）等
		 */
		Paint paint = new GradientPaint(0, 0, Color.white, 1000, 0, Color.green, true);
		pieChart.setBackgroundPaint(paint);
	}
	
}