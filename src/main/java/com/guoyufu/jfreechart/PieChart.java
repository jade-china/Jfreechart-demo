package com.guoyufu.jfreechart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PieChart {

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
	public void testPieChart2D() {
		/**
		 * 图表对象：饼图（2D） 标题：允许为空 数据集：允许为空
		 * 
		 * 是否需要图例、是否生成工具提示、是否生成URL
		 */
		pieChart = ChartFactory.createPieChart("PHONE SALES", dataset);
	}

	@Test
	public void testPieChart3D() {
		/**
		 * 图表对象：饼图（3D） 标题：允许为空 数据集：允许为空
		 * 
		 * 是否需要图例、是否生成工具提示、是否生成URL
		 */
		pieChart = ChartFactory.createPieChart3D("PHONE SALES", dataset);
	}

}