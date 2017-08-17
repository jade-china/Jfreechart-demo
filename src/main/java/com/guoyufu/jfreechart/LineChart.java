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

public class LineChart {

	/**
	 * 数据集：分类数据集
	 */
	DefaultCategoryDataset line_chart_dataset;

	/**
	 * 图表对象：曲线图
	 */
	JFreeChart lineChart;

	@Before
	public void createDataSet() {

		line_chart_dataset = new DefaultCategoryDataset();
		line_chart_dataset.addValue(15, "schools", "1970");
		line_chart_dataset.addValue(30, "schools", "1980");
		line_chart_dataset.addValue(60, "schools", "1990");
		line_chart_dataset.addValue(120, "schools", "2000");
		line_chart_dataset.addValue(240, "schools", "2010");
		line_chart_dataset.addValue(300, "schools", "2014");
	}

	@After
	public void createChartPic() throws IOException {
		/**
		 * 图表图片： 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File fLineChart = new File("LineChart.jpeg");
		ChartUtilities.saveChartAsJPEG(fLineChart, lineChart, width, height);
	}

	@Test
	public void testLineChart2D() {
		/**
		 * 图表对象：曲线图（2D） 标题：允许为空 分类坐标轴标签：允许为空 值坐标轴标签：允许为空 数据集：允许为空
		 * 
		 * 生成方向：水平或垂直，默认水平，不允许为空 是否需要图例：默认true 是否生成工具提示：默认true 是否生成URL: 默认false
		 */
		lineChart = ChartFactory.createLineChart("Schools Vs Years", "Year", "Schools Count", line_chart_dataset);
	}

	@Test
	public void testLineChart2D2() {
		/**
		 * 图表对象：曲线图（2D） 标题：允许为空 分类坐标轴标签：允许为空 值坐标轴标签：允许为空 数据集：允许为空
		 * 
		 * 生成方向：水平或垂直，默认水平，不允许为空 是否需要图例：默认true 是否生成工具提示：默认true 是否生成URL: 默认false
		 */
		lineChart = ChartFactory.createLineChart("Schools Vs Years", "Year", "Schools Count", line_chart_dataset,
				PlotOrientation.VERTICAL, true, true, false);
	}

	@Test
	public void testLineChart3D() {
		/**
		 * 图表对象：曲线图（3D） 标题：允许为空 分类坐标轴标签：允许为空 值坐标轴标签：允许为空 数据集：允许为空
		 * 
		 * 生成方向：水平或垂直，默认水平，不允许为空 是否需要图例：默认true 是否生成工具提示：默认true 是否生成URL: 默认false
		 */
		lineChart = ChartFactory.createLineChart3D("Schools Vs Years", "Year", "Schools Count", line_chart_dataset);
	}
}