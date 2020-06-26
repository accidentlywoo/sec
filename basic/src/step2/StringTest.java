package step2;

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String("abc"); // 힙영역에 객체 생성
        String str2 = "abc"; // 상수풀에 있는 문자열을 가리킴

        System.out.println(str1 == str2);

        String str3 = "abc";
        String str4 = "abc";
        System.out.println(str3 == str4);

        String java = new String("java");
        String android = new String("android");
        System.out.println("---------------------------");
        System.out.println(System.identityHashCode(java));
        // String은 hashcode()를 오버라이드했기때문에 객체 비교용으로 사용불가
        System.out.println("hashCode : "+ java.hashCode());

        java = java.concat(android);
        System.out.println(java);
        System.out.println(System.identityHashCode(java));
        System.out.println("hashCode : "+ java.hashCode());
        System.out.println("---------------------------");
        java = new String("java");
        StringBuilder stringBuilder = new StringBuilder(java);
        stringBuilder.append("android");

        java = stringBuilder.toString();
        System.out.println(java);
    }
}
