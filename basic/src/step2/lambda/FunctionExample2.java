package step2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {
    private static List<Person> list = Arrays.asList(
      new Person(1, "ȫ�浿", 90),
      new Person(2,"�ſ��", 80)
    );
    public static double avg(ToIntFunction<Person> function){
        int sum = 0;
        for (Person person : list){
            sum += function.applyAsInt(person);
        }
        double avg = (double) sum / list.size();
        return avg;
    }

    public static void main(String[] args) {
        double ageAvg = avg(Person::getAge);
        System.out.println("��� ���� : " + ageAvg);
    }
}
