package step2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPractice {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ȫ�浿", 30);
		int score = map.get("ȫ�浿");
		map.remove("ȫ�浿");
		map.put("ȫ���", 20);
		map.put("���", 24);
		map.put("�����", 56);
		
		Set<String> ketSet = map.keySet();
		Iterator<String> keyIterator = ketSet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			int value = map.get(key);
			System.out.println(value);
		}
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			System.out.println(entry);
		}
	}
}
