package lv2;

public class AppLv2 {
    public static void main(String[] args) {
        System.out.println("클래스를 활용한 계산기를 만들어보자");

        Calculator calculator = new Calculator();

        int a = calculator.sum(2,3);
        System.out.println("덧셈 = " + a);
        int b = calculator.sub(10,3);
        System.out.println("뺄셈 = " + b);
        int c = calculator.mul(5,20);
        System.out.println("곱셈 = " + c);
        double d = calculator.div(100,5);
        System.out.println("나눗셈 = " + d);

    }
}
