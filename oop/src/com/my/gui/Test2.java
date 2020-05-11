package com.my.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Test2 {
	public static void main(String[] args) {
		JFrame frame; // 창 window
		JButton button; // 
		JTextField field; // 한줄 입력란
		JTextArea ta;
		JScrollPane sp; // 스크롤
		Container container; // Back Board 역할  - 기본 레이아웃 : BoardLayout(동서남북중앙)
		JCheckBox[] checkBoxs = {
				 new JCheckBox("Java"),
				 new JCheckBox("jQuery"),
				 new JCheckBox("Servlet"),
				 new JCheckBox("Spring"),
		};
		
		
		frame = new JFrame();
		button = new JButton("클릭하세요!");
		field = new JTextField(10);
		
		ta = new JTextArea(3, 20);
		sp = new JScrollPane(ta);
		
		container = frame.getContentPane();
		JPanel jPanelTop = new JPanel();
		jPanelTop.add(field);
		jPanelTop.add(button);
		container.add(jPanelTop);
		
		JPanel jPanelMid = new JPanel(); // 패널 - 기본레이아웃 : FlowLayOut
		for(JCheckBox checkBox : checkBoxs) {
			jPanelMid.add(checkBox);
		}
		container.add(jPanelMid);
		
		//container.setLayout(new FlowLayout()); // 레이아웃 변경 - FlowLayout(중앙상단부터 차례로 컴포넌트 나열)
		container.setLayout(new GridLayout(3, 1)); // 레이아웃 변경 : GridLayout(3행 1열 표)
		
		JPanel jPanelBottom = new JPanel();
		jPanelBottom.add(sp);
		container.add(jPanelBottom);
		
		field.setText("우여니");  
		
		class MyButtonHandler implements ActionListener{
			int cnt = 0;
			@Override
			public void actionPerformed(ActionEvent e) { // 클릭하면 자동 호출 Invoked when an action occurs.
				cnt += 1;
				System.out.println(field.getText()+" 입력,  "+cnt+" 번 클릭되었습니다.");
			}
		}
		
		button.addActionListener(new MyButtonHandler()); // -> 클래스 이름이 있어야 하나? 생성자로 받아서 넘겨야 된다.
		
		class MyCheckBoxHandler implements ActionListener{
			String checkBox;
			
			@Override
			public void actionPerformed(ActionEvent e) { // 클릭하면 자동 호출 Invoked when an action occurs.
				JCheckBox cb = (JCheckBox) e.getSource();
				System.out.println(cb.isSelected());
				String log =ta.getText()+"\n"+checkBox;
				if(cb.isSelected()) {
					//ta.setText(checkBox+"을 선택하셨습니다.");
					log+="을 선택하셨습니다.";
				}else {
					//ta.setText(checkBox+"을 선택해지 하셨습니다.");
					log+="을 선택해지 하셨습니다.";
				}
				ta.setText(log);
			}
			public MyCheckBoxHandler(JCheckBox checkBox) {
				this.checkBox = checkBox.getText();
			}
			
		}
		for(JCheckBox checkBox : checkBoxs) {
			checkBox.addActionListener(new MyCheckBoxHandler(checkBox));
		}
		
		field.getText();// 입력 텍스트 들고오기 
		frame.setSize(300, 300); // window size setting
		frame.setVisible(true); // window visible
		
	}
}
