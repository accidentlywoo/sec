package step2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    private static List<Person> list = Arrays.asList(
            new Person("ȫ�浿", "����", 90),
            new Person("�����", "����", 90),
            new Person("���ڹ�", "����", 95),
            new Person("���ѳ�", "����", 92)
    );
    public static double avg(Predicate<Person> predicate){
        int count = 0, sum = 0;
        for(Person person : list){
            if(predicate.test(person)){
                count++;
                sum += person.getAge();
            }
        }
        return (double)sum/count;
    }

    public static void main(String[] args) {
        double maleAvg = avg( t-> t.getSex().equals("����"));
        System.out.println("���� ��� ���� : " + maleAvg);

        double femaleAvg = avg(t-> t.getSex().equals("����"));
        System.out.println("���� ��� ���� : " + femaleAvg);
    }
}
