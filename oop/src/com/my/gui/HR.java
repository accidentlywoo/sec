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
class Horse2 extends Canvas{ //paint(), repaint()->update()자동호출됨 :Canvas영역CLEAR->paint()자동호출됨
	String name;
	int x=0, y=10;
	Horse2(String name){
		this.name = name;
	}
	@Override
	public void paint(Graphics g) { //컨테이너에 Canvas객체가 추가되면 paint()자동호출됨 
		g.drawString(name, x, y);
	}
	@Override
	public void update(Graphics g) {
		//x = 10;
		super.update(g);
	}
	
}
public class HR {
	public static void main(String[] args) {
		JButton btReady, btStart;
		JFrame frame;
		Container c;
		Horse2[] horses;
		
		frame = new JFrame("달리기");
		c = frame.getContentPane();
		
		horses = new Horse2[3];
		for(int i=0; i<horses.length; i++) {
			horses[i] = new Horse2("말" + (i+1));
		}
		btReady = new JButton("준비");
		btStart = new JButton("달려");
		
		c.setLayout(new GridLayout(4,1));
		c.add(horses[0]);  c.add(horses[1]); c.add(horses[2]);
		
		JPanel pBt = new JPanel();
		pBt.add(btStart);   pBt.add(btReady);
		c.add(pBt);
		
		frame.setSize(400, 200);
		frame.setVisible(true);
		
		
		btReady.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<horses.length; i++) {
					horses[i].x = 10;
					horses[i].repaint();//update()자동호출-> CLEAR-> paint()
				}
			}
			
		}); //이벤트소스와  이벤트핸들러 연결 
		
		btStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<horses.length; i++) {
					for(int j=0; j<20; j++) {
						horses[i].x += 10;
						horses[i].repaint();//update()자동호출-> CLEAR-> paint()
					}
				}
			}
		}); //이벤트소스와  이벤트핸들러 연결 
	}
}