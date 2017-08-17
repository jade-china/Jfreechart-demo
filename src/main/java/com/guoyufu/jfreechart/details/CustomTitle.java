package com.guoyufu.jfreechart.details;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 自定义图表标题
 */
public class CustomTitle {

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
		
		pieChart = ChartFactory.createPieChart(null, dataset);
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
	public void testCustomTitle0() {
		
		/**
		 * 定制标题：文本、颜色、位置、水平对齐、垂直对齐；字体、填充
		 */
		TextTitle title = pieChart.getTitle();
		title.setText("PHONE SALES");
		title.setPaint(ChartColor.LIGHT_RED);
		title.setPosition(RectangleEdge.TOP);
		title.setHorizontalAlignment(HorizontalAlignment.CENTER);
		title.setVerticalAlignment(VerticalAlignment.CENTER);
	}
	
	@Test
	public void testCustomTitle1() {
		
		TextTitle title = new TextTitle();
		title.setText("PHONE SALES");
		title.setPaint(ChartColor.LIGHT_RED);
		title.setPosition(RectangleEdge.TOP);
		pieChart.setTitle(title);
	}
	
	@Test
	public void testCustomTitle2() {
		
		TextTitle title = new TextTitle("PHONE SALES");
		title.setPaint(ChartColor.LIGHT_RED);
		title.setPosition(RectangleEdge.TOP);
		pieChart.setTitle(title);
	}
	
	@Test
	public void testCustomTitle3() {
		
		TextTitle title = new TextTitle("PHONE SALES");
//		new TextTitle(text, font);
//		new TextTitle(text, font, paint, position, horizontalAlignment, verticalAlignment, padding)
		title.setPaint(ChartColor.LIGHT_RED);
		title.setPosition(RectangleEdge.TOP);
		pieChart.setTitle(title);
	}
}