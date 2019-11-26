

import java.util.Calendar;
import java.util.Date;

/**
 * 鏃ユ湡宸ュ叿绫�
 * 
 * @author 浜庝慨褰�
 *
 */
public class DateUtil {
	public static long millisecondsOfOneDay = 1000 * 60 * 60 * 24L;

	/**
	 * 涓や釜涓嶅悓Date绫诲瀷鐨勮浆鎹� <b>sql.Date鏄痷til.Date鐨勫瓙绫�</b>
	 * 
	 * @param date
	 *            java.util.date
	 * @return java.sql.date
	 */
	public static java.sql.Date util2sql(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 鑾峰彇浠婂ぉ鐨勬棩鏈�
	 * 
	 * @return java.util.date
	 */
	public static Date getToday() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());

		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		return c.getTime();
	}

	/**
	 * 鑾峰彇鏈湀鐨勬湀鍒濈涓�澶�
	 * 
	 * @return java.util.date
	 */
	public static Date getMonthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		return c.getTime();

	}

	/**
	 * 鑾峰彇鏈堟湯
	 * 
	 * @return
	 */
	public static Date getMonthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());

		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);

		return c.getTime();
	}

	/**
	 * 鑾峰彇鏈湀涓�鍏卞灏戝ぉ
	 * 
	 * @return
	 */
	public static int thisMonthTotalDay() {
		long lastDayMillisecs = getMonthEnd().getTime();
		long firstDayMillisecs = getMonthBegin().getTime();
		return (int) ((lastDayMillisecs - firstDayMillisecs) / millisecondsOfOneDay) + 1;
	}

	/**
	 * 鑾峰彇鏈湀杩樺墿澶氬皯澶╋紙涓嶇畻浠婂ぉ锛�
	 * 
	 * @return
	 */

	public static int thisMonthLeftDay() {
		long lastDayMilliSeconds = getMonthEnd().getTime();
		long todayMilliSeconds = getToday().getTime();
		return (int) ((lastDayMilliSeconds - todayMilliSeconds) / millisecondsOfOneDay);
	}

	/**
	 * 鑾峰彇鏈湀宸茬粡杩囦簡澶氬皯澶╋紙鍔犱笂浠婂ぉ锛�
	 * 
	 * @return
	 */
	public static int thisMonthSpentDay() {
		long firstDayMillisecs = getMonthBegin().getTime();
		long todayMilliSecs = getToday().getTime();

		return (int) ((todayMilliSecs - firstDayMillisecs) / millisecondsOfOneDay) + 1;
	}

//	public static void main(String[] args) {
//		System.out.println(DateUtil.thisMonthSpentDay());
//	}
}