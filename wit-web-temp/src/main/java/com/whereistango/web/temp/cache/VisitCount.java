/**
 * 
 */
package com.whereistango.web.temp.cache;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author resulav
 *
 */
public class VisitCount {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	private String date;
	private int count;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void increase() {
		count++;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static String getDateStr() {
		return DATE_FORMAT.format(new Date());
	}

	public static VisitCount newInstance(String date) {
		VisitCount visitCount = new VisitCount();
		visitCount.setDate(date);
		visitCount.setCount(1);

		return visitCount;
	}

}
