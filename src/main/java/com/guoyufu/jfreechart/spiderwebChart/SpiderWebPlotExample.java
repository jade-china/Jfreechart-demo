package com.guoyufu.jfreechart.spiderwebChart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpiderWebPlotExample {

	private DefaultCategoryDataset createDataSet2(Map<String, Map<String, Object>> resultMap,
			List<String> dimNameList) {
		dataset = new DefaultCategoryDataset();// 创建默认的种类数据类型就可以了，蜘蛛图的每个维度可以看成一种类型
		Set<String> keySet = resultMap.keySet();
		for (String key : keySet) {
			Map<String, Object> infoMap = resultMap.get(key);
			String vendorCode = key.split("&")[0];
			String vendorName = key.split("&")[1];
			for (String dimName : dimNameList) {
				if (infoMap.get(dimName) == null) {
					continue;
				}
				double score = (Double) infoMap.get(dimName);
				dataset.addValue(score, vendorName.trim() + "(" + vendorCode.trim() + ")", dimName);
			}
		}
		return dataset;
	}

	private JFreeChart createChart2(DefaultCategoryDataset dataset) {
		
		/**
		 * 通用蜘蛛网图
		 */
		SpiderWebPlot plot = new SpiderWebPlot(dataset);
		
		/**
		 * 自定义带刻度的蜘蛛网图
		 */
//		SpiderWebPlotExpand plot = new SpiderWebPlotExpand(dataset);
		
//		MySpiderWebPlot plot = new MySpiderWebPlot(dataset);
		JFreeChart chart = new JFreeChart("维度得分分析", plot);
		return chart;
	}

	/**
	 * 数据源
	 */
	DefaultCategoryDataset dataset;

	/**
	 * 图表对象：蜘蛛图（带刻度）
	 */
	JFreeChart spiderChart;

	@Before
	public void createDataSet() throws IOException {

		Map<String, Map<String, Object>> resultMap = new HashMap<>();
		Map<String, Object> attributeMap = new HashMap<>();
		attributeMap.put("质量", 100.0);
		attributeMap.put("成本", 100.0);
		attributeMap.put("交期", 100.0);
		resultMap.put("AP0004&英特换热设备（浙江）有限公司", attributeMap);
		attributeMap = new HashMap<>();
		attributeMap.put("质量", 50.0);
		attributeMap.put("成本", 70.0);
		attributeMap.put("交期", 90.0);
		resultMap.put("AO0250&昆山市玉山镇博科电子器材厂", attributeMap);
		List<String> dimNameList = new ArrayList<>();
		dimNameList.add("质量");
		dimNameList.add("成本");
		dimNameList.add("交期");
		dataset = createDataSet2(resultMap, dimNameList);
	}

	@After
	public void createChartPic() throws IOException {
		/**
		 * 图表图片： 图表文件、图表对象、图片宽高尺寸
		 */
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File fSpiderChart = new File("spiderChart3.jpeg");
		ChartUtilities.saveChartAsJPEG(fSpiderChart, spiderChart, width, height);
	}
	
	@Test
	public void testSpiderChart() {

		spiderChart = createChart2(dataset);
	}

}
