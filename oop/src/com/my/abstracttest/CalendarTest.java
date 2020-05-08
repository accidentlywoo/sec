package com.my.abstracttest;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar c;
		// c = new Calendar();
		c = Calendar.getInstance();
		System.out.println(c instanceof GregorianCalendar);
		System.out.println(c.getClass());
		/*
		 *  이렇게 복잡하게 쓰는 이유?
		 * 		1. Calendar라는 이름이 접근성이 더 좋다.
		 * 		2. 구체화된 하위 클래스의 변경, 삭제에대한 대비(객체간의 결합도를 떨어트린다.)
		 * 			일반화된 상위 클래스를 사용하는 것이 좋다.
		 */
		
		System.out.println(c.get(Calendar.YEAR)+ "년, "
				+ (c.get(Calendar.MONTH )+1) +"월, "
				+ c.get(Calendar.DATE)+"일");
		
		int ampm = c.get(Calendar.AM_PM);
		switch(ampm) {
		case Calendar.AM:
			System.out.println("오전");
			break;
		case Calendar.PM :
			System.out.println("오후");
			break;
		}
		
		int h = c.get(Calendar.HOUR);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		System.out.println(h + "시, "+ m +"분, " + s + "초");
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2021, 1, 30); // Month값은 index값으로 기준으로 되어있어서 주의해야한다.
		
		System.out.println(c1.get(Calendar.YEAR)+ "년, "
				+ c1.get(Calendar.MONTH ) +"월, "
				+ c1.get(Calendar.DATE)+"일");
		
	}
}
