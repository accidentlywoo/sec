package com.my.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Third extends Thread{

	@Override
	public void run() {
		Thread cur = Thread.currentThread();
		String curName = cur.getName();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:m:s");
		for(int i = 0; i < 10; i++) {
			System.out.println(curName+" : "+getName()+sdf.format(new Date()));
//			try {
//				long millis = 1000;
//				Thread.sleep(millis); // Runnable 상태로 가서 대기하는 시간까지 추가될 수 있다. 
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
