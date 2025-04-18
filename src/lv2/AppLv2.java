package lv2;

// import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        System.out.println("클래스를 활용한 계산기를 만들어보자");

//        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        calculator.calculate(1,2,'+');
        calculator.calculate(500,200,'-');
        calculator.calculate(451,187,'*');
        calculator.calculate(10,3,'/');
        calculator.calculate(10,0,'/');






    }
}
