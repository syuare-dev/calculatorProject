package lv3;

import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {

        System.out.println("LV3 계산기를 만들어볼 예정입니다.");

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
        ResultHistory resultHistory = new ResultHistory();
        ResultFormat resultFormat = new ResultFormat();

        // 입력값, 결과값 변수 선언
        double value1 = 0;
        double value2 = 0;
        double result = 0;

        // 입력 메서드 선언 > 숫자, 연산기호
        InputHandler<Double> inputHandler = new InputHandler<>(scanner);
        InputHandler<Operator> inputOperator = new InputHandler<>(scanner);


        // 값 입력
        arithmeticCalculator.setValue1(inputHandler.inputValue());
        arithmeticCalculator.setOperator(inputOperator.inputOperator());
        arithmeticCalculator.setValue2(inputHandler.inputValue());


        // 계산
        result = arithmeticCalculator.calculate();


        // 결과 조회
        System.out.println("result = " + result);



//        System.out.println(arithmeticCalculator.calculate());




    }
}