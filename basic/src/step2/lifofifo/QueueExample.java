package step2.lifofifo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messages = new LinkedList<Message>();
		
		messages.offer(new Message("sendMail", "ȫ�浿"));
		messages.offer(new Message("sendSMS", "�ſ��"));
		messages.offer(new Message("sendKakaotalk", "ȫ�β�"));
		
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		while(!messages.isEmpty()) {
			Message message = messages.poll();
			switch (message.command) {
			case "sendMail":
				System.out.println(message.to +"�Կ��� ������ �����ϴ�.");
				break;
			case "sendSMS":
				System.out.println(message.to + "�Կ��� SMS�� �����ϴ�.");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + "�Կ��� Kakaotalk��  �����ϴ�.");
				break;

			default:
				break;
			}
		}
	}
}
