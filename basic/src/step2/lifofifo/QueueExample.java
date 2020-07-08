package step2.lifofifo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messages = new LinkedList<Message>();
		
		messages.offer(new Message("sendMail", "È«±æµ¿"));
		messages.offer(new Message("sendSMS", "½Å¿ë±Ç"));
		messages.offer(new Message("sendKakaotalk", "È«µÎ²²"));
		
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		while(!messages.isEmpty()) {
			Message message = messages.poll();
			switch (message.command) {
			case "sendMail":
				System.out.println(message.to +"´Ô¿¡°Ô ¸ÞÀÏÀ» º¸³À´Ï´Ù.");
				break;
			case "sendSMS":
				System.out.println(message.to + "´Ô¿¡°Ô SMS¸¦ º¸³À´Ï´Ù.");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + "´Ô¿¡°Ô KakaotalkÀ»  º¸³À´Ï´Ù.");
				break;

			default:
				break;
			}
		}
	}
}
