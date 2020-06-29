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
        System.out.println("회원 번호가 없습니다.");
        return false;
    }

    public void showAllPerson(){
//        hashMap.keySet().iterator(); // 중복 x iterator로 반환
//        hashMap.values(); // 중복가능 Collection으로 반환
        Iterator<Integer> ir = hashMap.keySet().iterator();
        while (ir.hasNext()){
            int key = ir.next();
            Person person = hashMap.get(key);
            System.out.println(person);
        }
        System.out.println();
    }
}
