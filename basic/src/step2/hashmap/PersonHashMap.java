package step2.hashmap;

import java.util.HashMap;
import java.util.Iterator;

public class PersonHashMap {

    private HashMap<Integer, Person> hashMap;

    public PersonHashMap(){
        hashMap = new HashMap<>();
    }
    public void addPerson(Person person){
        hashMap.put(person.getId(), person);
    }
    public boolean removePerson(int personId){
        if(hashMap.containsKey(personId)){
            hashMap.remove(personId);
            return true;
        }
        System.out.println("ȸ�� ��ȣ�� �����ϴ�.");
        return false;
    }

    public void showAllPerson(){
//        hashMap.keySet().iterator(); // �ߺ� x iterator�� ��ȯ
//        hashMap.values(); // �ߺ����� Collection���� ��ȯ
        Iterator<Integer> ir = hashMap.keySet().iterator();
        while (ir.hasNext()){
            int key = ir.next();
            Person person = hashMap.get(key);
            System.out.println(person);
        }
        System.out.println();
    }
}
