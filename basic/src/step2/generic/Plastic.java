package step2.generic;

public class Plastic extends Material{
    @Override
    public String toString() {
        return "재료는 Plastic 입니다.";
    }

    @Override
    public void doPrint() {
        System.out.println("Plastic 프린팅입니다.");
    }
}
