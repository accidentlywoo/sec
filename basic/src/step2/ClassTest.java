package step2;

import step1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person("james");
        System.out.println(person);
        //매개변수 없는 기본 생성자
        Class c1 = Class.forName("step1.Person");
        Person person1 = (Person) c1.newInstance(); //return type Object, 기본 생성자 호출
        System.out.println("Class : "+person1);
        // 매개변수가 있는 생성자
        Class[] parameterTypes= {String.class};
        Constructor cons = c1.getConstructor(parameterTypes);

        Object[] initargs = {"김유신"};
        Person person2 = (Person) cons.newInstance(initargs);
        System.out.println(person2);
    }
}
