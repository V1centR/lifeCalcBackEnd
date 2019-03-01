package com.lifecalc.lifecalcBack;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateFormatTest {

	@Test
	public void datePrinter() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		String novaData = sdf.format(c.getTime());
		
		System.out.println(novaData);
	}
}
