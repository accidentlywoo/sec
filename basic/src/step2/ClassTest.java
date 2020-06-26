package step2;

import step1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person("james");
        System.out.println(person);
        //�Ű����� ���� �⺻ ������
        Class c1 = Class.forName("step1.Person");
        Person person1 = (Person) c1.newInstance(); //return type Object, �⺻ ������ ȣ��
        System.out.println("Class : "+person1);
        // �Ű������� �ִ� ������
        Class[] parameterTypes= {String.class};
        Constructor cons = c1.getConstructor(parameterTypes);

        Object[] initargs = {"������"};
        Person person2 = (Person) cons.newInstance(initargs);
        System.out.println(person2);
    }
}
