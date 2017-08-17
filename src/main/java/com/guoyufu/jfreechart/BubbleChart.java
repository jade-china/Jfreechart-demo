package com.guoyufu.jfreechart;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleChart {

	/**
	 * 数据集：XYZ数据集，存储双精度数组中的数据值
	 */
	DefaultXYZDataset defaultxyzdataset;

	/**
	 * 图表对象：气泡图
	 */
	JFreeChart bubblechart;

	@Before
	public void createDataSet() {

		defaultxyzdataset = new DefaultXYZDataset();
		double ad[] = { 30, 40, 50, 60, 70, 80 };
		double ad1[] = { 10, 20, 30, 40, 50, 60 };
		double ad2[] = { 4, 5, 10, 8, 9, 6 };
		double ad3[][] = { ad, ad1, ad2 };
		defaultxyzdataset.addSeries("Series 1", ad3);
	}

	@After
	public void createChartPic() throws IOException {
		/**
		 * 图表图片： 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 560; /* Width of the image */
		int height = 370; /* Height of the image */
		File fBubbleChart = new File("BubbleChart.jpeg");
		ChartUtilities.saveChartAsJPEG(fBubbleChart, bubblechart, width, height);
	}

	@Test
	public void testBubbleChart() {
		bubblechart = ChartFactory.createBubbleChart("AGE vs WEIGHT vs WORK", "Weight", "AGE", defaultxyzdataset,
				PlotOrientation.HORIZONTAL, true, true, false);

		XYPlot xyplot = (XYPlot) bubblechart.getPlot();
		xyplot.setForegroundAlpha(0.65F);
		XYItemRenderer xyitemrenderer = xyplot.getRenderer();
		xyitemrenderer.setSeriesPaint(0, Color.blue);
		NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
		numberaxis.setLowerMargin(0.2);
		numberaxis.setUpperMargin(0.5);
		NumberAxis numberaxis1 = (NumberAxis) xyplot.getRangeAxis();
		numberaxis1.setLowerMargin(0.8);
		numberaxis1.setUpperMargin(0.9);
	}

}