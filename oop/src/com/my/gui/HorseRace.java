package com.my.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		horses[0] = new Horse((1)+" 번 말");
		horses[1] = new Horse((2)+" 번 말");
		horses[2] = new Horse((3)+" 번 말");
		
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
					horse.flag = false;
					horse.repaint();
				}
			}
		}); // 이벤트 소스와 이벤트 핸들러 연결
		
		horseRun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < horsesLen; i++) {
					Thread t = new Thread(horses[i]);
					t.start();
				}
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
