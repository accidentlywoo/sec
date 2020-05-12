package com.my.gui;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Horse extends Canvas{ //paint(), repaint()
	String name;
	int x = 0, y = 10; // px 단위 위치
	public Horse(String name) {
		this.name = name;
	}
	@Override
	public void paint(Graphics g) { // 컨테이너에 Canvas객체가 추가되면 paint() 자동호출됨
		g.drawString(name, x, y);
	}
	@Override
	public void update(Graphics g) {
		x = 10;
		super.update(g);
	}
}

public class HorseRace {
	public static void main(String[] args) {
		JButton horseRun, horseReady;
		JFrame frame;
		Container c;
		Horse[] horses;
		
		frame = new JFrame("말 달리기");
		c = frame.getContentPane();
		
		horses = new Horse[3];
		int horsesLen = horses.length;
		for(int i = 0; i < horsesLen; i++) {
			horses[i] = new Horse((i+1)+" 번 말");
		}
		
		horseRun = new JButton("달려");
		horseReady = new  JButton("준비");
		
		c.setLayout(new GridLayout(4, 1));

		for(Horse horse : horses ) {
			c.add(horse);
		}
		
		JPanel panel = new JPanel();
		
		panel.add(horseRun);
		panel.add(horseReady);
		c.add(panel);
		
		frame.setSize(400, 200);
		frame.setVisible(true);
		
		horseReady.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// repaint() -> update() 자동호출됨 : Canvas영역 CLEAR -> paint() 자동 호출됨
				for(Horse horse : horses) {
					horse.x = 10;
					horse.repaint();
				}
			}
		}); // 이벤트 소스와 이벤트 핸들러 연결
		
		horseRun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < horsesLen; i++) {
					for(int j = 0; j < 20; j++) {
						horses[i].x += 10;
						horses[i].repaint();
					}
				}
			}
		});
	}
}
