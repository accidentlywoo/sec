package step2.lambda;

import java.util.function.Function;

public class FunctionAndThenComposeExample {
    public static void main(String[] args) {
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;
        String city;

        functionA = Member::getAddress;
        functionB = Address::getCity;

        functionAB = functionA.andThen(functionB);
        city = functionAB.apply(
                new Member("ȫ�浿", "hong",new Address("�ѱ�","����"))
        );
        System.out.println("���� ���� : " + city);

        functionAB = functionB.compose(functionA);
        city = functionAB.apply(
                new Member("ȫ���", "hong",new Address("�ѱ�","�λ�"))
        );
        System.out.println("���� ���� : " + city);
    }
}
