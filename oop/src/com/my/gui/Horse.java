package com.my.gui;

import java.awt.Canvas;
import java.awt.Graphics;

public class Horse extends Canvas implements Runnable{ //paint(), repaint()
	private static final long serialVersionUID = 1L;
	String name;
	int x = 0;
	int y = 10; // px 단위 위치
	boolean flag;
	public Horse(String name) {
		this.name = name;
	}
	@Override
	public void paint(Graphics g) { // 컨테이너에 Canvas객체가 추가되면 paint() 자동호출됨
		g.drawString(name, x, y);
	}
	@Override
	public void update(Graphics g) {
//		x = 10;
		super.update(g);
	}
	@Override
	public void run() {
		this.flag = true;
		long millis = (long)(Math.random()*1000)+1;
		while(flag) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.x +=10;
			this.repaint();
		}
	}
}
