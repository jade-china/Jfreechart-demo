package com.guoyufu.jfreechart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BarChart {
	
	/**
	 * 数据集：分类数据集
	 */
	DefaultCategoryDataset dataset;

	/**
	 * 图表对象：柱状图
	 */
	JFreeChart barChart;

	@Before
	public void createDataSet() {

		final String fiat = "FIAT";
		final String audi = "AUDI";
		final String ford = "FORD";
		final String speed = "Speed";
		final String millage = "Millage";
		final String userrating = "User Rating";
		final String safety = "safety";

		dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, fiat, speed);
		dataset.addValue(3.0, fiat, userrating);
		dataset.addValue(5.0, fiat, millage);
		dataset.addValue(5.0, fiat, safety);

		dataset.addValue(4.0, ford, speed);
		dataset.addValue(2.0, ford, userrating);
		dataset.addValue(3.0, ford, millage);
		dataset.addValue(6.0, ford, safety);

		dataset.addValue(5.0, audi, speed);
		dataset.addValue(6.0, audi, userrating);
		dataset.addValue(10.0, audi, millage);
		dataset.addValue(4.0, audi, safety);
	}

	@After
	public void createChartPic() throws IOException {
		/*
		 * 图表图片：
		 * 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File fBarChart = new File("BarChart.jpeg");
		ChartUtilities.saveChartAsJPEG(fBarChart, barChart, width, height);
	}

	@Test
	public void testBarChart2D() {
		/**
		 * 图表对象：柱状图（2D）
		 * 标题:	允许为空
		 * 分类坐标轴标签：允许为空
		 * 值坐标轴标签：允许为空
		 * 数据集：允许为空
		 * 
		 * 生成方向：水平或垂直，默认水平，不允许为空
		 * 是否需要图例：默认true
		 * 是否生成工具提示：默认true
		 * 是否生成URL: 默认false
		 */
		barChart = ChartFactory.createBarChart("CAR USAGE STATIStICS", "Category", "Score", dataset);
	}
	
	@Test
	public void testBarChart2D2() {
		/**
		 * 图表对象：柱状图（2D）
		 */
		barChart = ChartFactory.createBarChart("CAR USAGE STATIStICS", "Category", "Score", dataset,
				PlotOrientation.VERTICAL, true, true, false);
	}
	
	@Test
	public void testBarChart3D() {
		/**
		 * 图表对象：柱状图（3D）
		 */
		barChart = ChartFactory.createBarChart3D("CAR USAGE STATIStICS", "Category", "Score", dataset);
	}
	
	@Test
	public void testStackedBarChart2D() {
		/**
		 * 图表对象：堆叠柱状图（2D）
		 */
		barChart = ChartFactory.createStackedBarChart("CAR USAGE STATIStICS", "Category", "Score", dataset);
	}
	
	@Test
	public void testStackedBarChart3D() {
		/**
		 * 图表对象：堆叠柱状图（3D）
		 */
		barChart = ChartFactory.createStackedBarChart3D("CAR USAGE STATIStICS", "Category", "Score", dataset);
	}
}