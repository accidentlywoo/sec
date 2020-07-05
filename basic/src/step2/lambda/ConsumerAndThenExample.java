package step2.lambda;

import java.util.function.Consumer;

public class ConsumerAndThenExample {
    public static void main(String[] args) {
        Consumer<Person> consumerA = (m) -> {
            System.out.println("consumerA : " + m.getName());
        };
        Consumer<Person> consumerB = (m) -> {
            System.out.println("consumberB : " + m.getSex());
        };

        Consumer<Person> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Person("È«±æµ¿", "³²ÀÚ", 0));
    }
}
