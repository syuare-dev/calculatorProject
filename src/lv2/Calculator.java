package lv2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    // 속성
    private int value1;
    private int value2;
    private String operation;
    private double result;


    // 생성자


    // 기능(메서드)
    // 연산기호에 따른 계산 기능
    public void calculate() {
        switch (operation) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                if (value2 == 0) { // 분모가 될 value2 일 때
                    System.out.println("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
                } else {
                    result = (double) value1 / value2;
                }
                break;

        }
    }

    // 계산 결과 출력
    public void resultPrint() {
//        // 결과값 출력
//        // -> 소수점 내 불필요한 0 제거 && 소수점 15자리 지정
//        // 소수점 15자리 초과 시 근사값으로 출력 > 안보이도록 수정
        BigDecimal bigDecimalResult = new BigDecimal(result)
                .setScale(15, RoundingMode.HALF_UP)
                .stripTrailingZeros();
        System.out.println(value1 + " " + operation + " " + value2 + " = " + bigDecimalResult.toPlainString());
//        // bigDecimalResult 1의 자리 수가 0일 경우 E+5가 같이 출력되는 문제 발생 > 과학적 표기법
//        // .toPlainString() 추가: 지수(E) 없는 값이 출력되도록 함
    }



    // value1, value2, operation 의 Getter, Setter
    public int getValue1() {
        return this.value1;
    }

    public int getValue2() {
        return this.value2;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setValue1(int value1) {
        if(value1<0) { // 숫자1 입력 시 음수 값 검증 > 예외 처리
            System.out.println("음수를 입력하셨습니다. 다시 입력해주세요.");
            throw new IllegalArgumentException("음수 입력");
        } else {
            this.value1 = value1;
        }
    }

    public void setValue2(int value2) {
        if(value2<0){ // 숫자2 입력 시 음수 값 검증 > 예외 처리
            System.out.println("음수를 입력하셨습니다. 다시 입력해주세요.");
            throw new IllegalArgumentException("음수 입력");
        } else {
            this.value2 = value2;
        }
    }

    public void setOperation(String operation) {
        char op = operation.charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') { // 연산 기호 잘못 입력 시 예외 처리
            System.out.println("잘못된 연산 기호를 입력하셨습니다. 다시 입력해주세요.");
            throw new IllegalArgumentException("잘못된 기호 입력");
        } else {
            this.operation = operation;
        }
    }
}

