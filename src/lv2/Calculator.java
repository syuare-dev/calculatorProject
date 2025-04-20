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
                    break;
                } else {
                    result = (double) value1 / value2;
                    break;
                }

        }
    }

    // 계산 결과 출력
    public void outPutPrint() {
        // 결과값 출력
        // -> 소수점 내 불필요한 0 제거
        // -> 소수점 15자리 지정 > 소수점 15자리 초과 시 비정상적인 값으로 출력
        BigDecimal bdresult = new BigDecimal(result).setScale(15, RoundingMode.HALF_UP);
        bdresult = bdresult.stripTrailingZeros();
        System.out.println(value1 + " " + operation + " " + value2 + " = " + bdresult);
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
        this.operation = operation;
    }





}

