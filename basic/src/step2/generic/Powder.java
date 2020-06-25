package step2.generic;

public class Powder extends Material{
    @Override
    public String toString() {
        return "재료는 Powder입니다.";
    }

    @Override
    public void doPrint() {
        System.out.println("powder printing 입니다.");
    }
}
