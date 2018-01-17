package com.peony.api.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 获取指定时间的那天 0:0:0 的时间
	 *
	 * @param date
	 * @return
	 */
	public final static Date dayStart(final Date date) {
		if (null == date) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取指定时间的那天 23:59:59.999 的时间
	 *
	 * @param date
	 * @return
	 */
	public final static Date dayEnd(final Date date) {
		if (null == date) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 获取指定时间的那天 0:0:0 的时间
	 *
	 * @param date
	 * @return
	 */
	public final static Date hourStart(final Date date) {
		if (null == date) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取指定时间的那天 23:59:59.999 的时间
	 *
	 * @param date
	 * @return
	 */
	public final static Date hourEnd(final Date date) {
		if (null == date) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}
	
	public static void main(String[] args) {
		System.out.println(hourStart(new Date())+"     "+hourEnd(new Date()));
	}
}
