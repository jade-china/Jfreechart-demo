package com.guoyufu.jfreechart.details;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 解决中文乱码问题
 */
public class GarbledChineseCharacters {

	/**
	 * 数据集：饼图数据集
	 */
	DefaultPieDataset dataset;

	/**
	 * 图表对象：饼图
	 */
	JFreeChart pieChart;

	/**
	 * 图表标准主题
	 */
	StandardChartTheme standardChartTheme;
	
	@Before
	public void createDataSet() throws IOException {
		
		dataset = new DefaultPieDataset();
		dataset.setValue("苹果5s系列", new Double(20));
		dataset.setValue("三星Grand系列", new Double(20));
		dataset.setValue("摩托罗拉G系列", new Double(40));
		dataset.setValue("诺基亚Lumia系列", new Double(10));
		dataset.setValue("华为", new Double(30));
		
		/**
		 * 解决中文乱码问题：需要在调用ChartFactory创建图表对象之前定义
		 */
		standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("宋体", Font.BOLD, 20));
		standardChartTheme.setLargeFont(new Font("宋体", Font.BOLD, 14));
		standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 12));
		standardChartTheme.setSmallFont(new Font("宋体", Font.PLAIN, 10));
		ChartFactory.setChartTheme(standardChartTheme);
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
	public void testGarbledChineseCharacters() {
		
		pieChart = ChartFactory.createPieChart(null, dataset);
		pieChart.setTitle("手机销量");
		
	}
}