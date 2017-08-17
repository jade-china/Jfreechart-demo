package com.guoyufu.jfreechart.details;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomPlotBackground {

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
	public void testPlot() {
		
		pieChart = ChartFactory.createPieChart("PHONE SALES", dataset);
		/**
		 * 图区：背景色（颜色、透明度）；背景图片（图片、透明度、对齐方式）;无数据提示（文本、字体、颜色）；前景透明度；边框(可见、样式、颜色)
		 */
		Plot plot = pieChart.getPlot();
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		plot.setNoDataMessage("no datas");
		plot.setForegroundAlpha(0.4F);
		plot.setOutlineVisible(true);
		plot.setOutlinePaint(Color.RED);
		
	}
}