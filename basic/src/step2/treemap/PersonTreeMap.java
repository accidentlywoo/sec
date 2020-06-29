package step2.treemap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class PersonTreeMap {

    private TreeMap<Integer, Person> treeMap;

    public PersonTreeMap(){
        treeMap = new TreeMap<>();
    }
    public void addPerson(Person person){
        treeMap.put(person.getId(), person);
    }
    public boolean removePerson(int personId){
        if(treeMap.containsKey(personId)){
            treeMap.remove(personId);
            return true;
        }
        System.out.println("ȸ�� ��ȣ�� �����ϴ�.");
        return false;
    }

    public void showAllPerson(){
//        hashMap.keySet().iterator(); // �ߺ� x iterator�� ��ȯ
//        hashMap.values(); // �ߺ����� Collection���� ��ȯ
        Iterator<Integer> ir = treeMap.keySet().iterator();
        while (ir.hasNext()){
            int key = ir.next();
            Person person = treeMap.get(key);
            System.out.println(person);
        }
        System.out.println();
    }
}
