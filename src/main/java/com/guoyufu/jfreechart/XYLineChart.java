package com.guoyufu.jfreechart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XYLineChart {
	public static void main(String[] args) throws Exception {
		final XYSeries firefox = new XYSeries("Firefox");
		firefox.add(1.0, 1.0);
		firefox.add(2.0, 4.0);
		firefox.add(3.0, 3.0);
		final XYSeries chrome = new XYSeries("Chrome");
		chrome.add(1.0, 4.0);
		chrome.add(2.0, 5.0);
		chrome.add(3.0, 6.0);
		final XYSeries iexplorer = new XYSeries("InternetExplorer");
		iexplorer.add(3.0, 4.0);
		iexplorer.add(4.0, 5.0);
		iexplorer.add(5.0, 4.0);
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(firefox);
		dataset.addSeries(chrome);
		dataset.addSeries(iexplorer);

		JFreeChart xylineChart = ChartFactory.createXYLineChart("Browser usage statastics", "Category", "Score",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File XYChart = new File("XYLineChart.jpeg");
		ChartUtilities.saveChartAsJPEG(XYChart, xylineChart, width, height);
	}
	
	/**
	 * 数据集：XY系列对象的集合
	 */
	XYSeriesCollection dataset;
	
	/**
	 * 图表对象：xy曲线图
	 */
	JFreeChart xylineChart;
	
	@Before
	public void createDataSet() {
		
		final XYSeries firefox = new XYSeries("Firefox");
		firefox.add(1.0, 1.0);
		firefox.add(2.0, 4.0);
		firefox.add(3.0, 3.0);
		final XYSeries chrome = new XYSeries("Chrome");
		chrome.add(1.0, 4.0);
		chrome.add(2.0, 5.0);
		chrome.add(3.0, 6.0);
		final XYSeries iexplorer = new XYSeries("InternetExplorer");
		iexplorer.add(3.0, 4.0);
		iexplorer.add(4.0, 5.0);
		iexplorer.add(5.0, 4.0);
		
		dataset = new XYSeriesCollection();
		dataset.addSeries(firefox);
		dataset.addSeries(chrome);
		dataset.addSeries(iexplorer);
	}
	
	@After
	public void createChartPic() throws IOException {
		/**
		 * 图表图片：
		 * 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File fXYLineChart = new File("XYLineChart.jpeg");
		ChartUtilities.saveChartAsJPEG(fXYLineChart, xylineChart, width, height);
	}
	
	@Test
	public void testXYLineChart2D() {
		/**
		 * 图表对象：XY曲线图（2D） 标题：允许为空 X坐标轴标签：允许为空 Y坐标轴标签：允许为空 数据集：允许为空
		 * 
		 * 生成方向：水平或垂直，默认水平，不允许为空 是否需要图例：默认true 是否生成工具提示：默认true 是否生成URL: 默认false
		 */
		xylineChart = ChartFactory.createXYLineChart("Browser usage statastics", "Category", "Score", dataset);
	}
	
	@Test
	public void testXYLineChart2D2() {
		/**
		 * 图表对象：XY曲线图（2D）
		 */
		xylineChart = ChartFactory.createXYLineChart("Browser usage statastics", "Category", "Score",
				dataset, PlotOrientation.VERTICAL, true, true, false);
	}
	
}