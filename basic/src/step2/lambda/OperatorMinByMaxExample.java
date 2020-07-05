package step2.lambda;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxExample {
    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        binaryOperator = BinaryOperator.minBy((f1, f2)-> Integer.compare(f1.getPrice(), f2.getPrice()));
        fruit = binaryOperator.apply(new Fruit("µþ±â", 6000), new Fruit("¼ö¹Ú", 10000));
        System.out.println(fruit.getName());

        binaryOperator = BinaryOperator.maxBy((f1, f2)-> Integer.compare(f1.getPrice(), f2.getPrice()));
        fruit = binaryOperator.apply(new Fruit("µþ±â", 6000), new Fruit("¼ö¹Ú", 10000));
        System.out.println(fruit.getName());
    }
}
