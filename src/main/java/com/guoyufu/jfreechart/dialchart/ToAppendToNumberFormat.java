package com.guoyufu.jfreechart.dialchart;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * 追加单位：默认单位摄氏度℃
 */
public class ToAppendToNumberFormat extends NumberFormat {

	private static final long serialVersionUID = -2812938665273939619L;

	private String toAppendTo = " ℃";
	
	public ToAppendToNumberFormat() {
		super();
	}

	public ToAppendToNumberFormat(String toAppendTo) {
		super();
		this.toAppendTo = toAppendTo;
	}

	@Override
	public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
		StringBuffer result = new StringBuffer();
		result.append(number).append(this.toAppendTo);
        return result;
	}

	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		StringBuffer result = new StringBuffer();
		result.append(number).append(this.toAppendTo);
        return result;
	}

	@Override
	public Number parse(String source, ParsePosition parsePosition) {
		return null; // don't bother with parsing
	}

  
}
