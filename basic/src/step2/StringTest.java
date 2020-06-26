package step2;

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String("abc"); // �������� ��ü ����
        String str2 = "abc"; // ���Ǯ�� �ִ� ���ڿ��� ����Ŵ

        System.out.println(str1 == str2);

        String str3 = "abc";
        String str4 = "abc";
        System.out.println(str3 == str4);

        String java = new String("java");
        String android = new String("android");
        System.out.println("---------------------------");
        System.out.println(System.identityHashCode(java));
        // String�� hashcode()�� �������̵��߱⶧���� ��ü �񱳿����� ���Ұ�
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
