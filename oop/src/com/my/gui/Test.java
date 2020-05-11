package com.my.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * 이벤트 처리 방법
 *  1. 이벤트 소스와 이벤트 결정(button, ActionEvent)
 *  2. 이벤트핸들러 작성
 *  	class MyButtonHandler implements ActionListener{
 *  		public void actionPerformed(ActionEvent e){
 *  			
 *  		}
 *  	}
 *  3. 이벤트소스와 이벤트핸들러를 연결
 *  	button.addActionListener(new MyButtonHandler());
 * @author user
 *
 */
//class MyButtonHandler implements ActionListener{
//	int cnt = 0;
//	JTextField field;
//	
//	@Override
//	public void actionPerformed(ActionEvent e) { // 클릭하면 자동 호출
//		cnt += 1;
//		System.out.println(field.getText());
//		System.out.println(cnt+" 번 클릭되었습니다.");
//	}
//	public MyButtonHandler(JTextField field) {
//		this.field = field;
//	}
//	
//}
public class Test {
	public static void main(String[] args) {
		JFrame frame; // 창 window
		JButton button; // 
		JTextField field; // 한줄 입력란
		Container container; // Back Board 역할  - 기본 레이아웃 : BoardLayout(동서남북중앙)
		
		frame = new JFrame();
		button = new JButton("클릭하세요!");
		field = new JTextField(10);
		container = frame.getContentPane();
		
		//container.add(button); 정중앙에 button이 꽉차게 보인다
//		container.add("South", button);
//		container.add("Center", field);
		container.setLayout(new FlowLayout()); // 레이아웃 변경 - FlowLayout(중앙상단부터 차례로 컴포넌트 나열)
		container.add(field);
		container.add(button);

//		button.addActionListener(new MyButtonHandler(field));
		
		class MyButtonHandler implements ActionListener{
			int cnt = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) { // 클릭하면 자동 호출
				cnt += 1;
				System.out.println(field.getText()+" 입력,  "+cnt+" 번 클릭되었습니다.");
			}
		}
		
		button.addActionListener(new MyButtonHandler());
		
		field.setText("우여니");
		field.getText();// 입력 텍스트 들고오기 
		frame.setSize(300, 300); // window size setting
		frame.setVisible(true); // window visible
		
	}
}
