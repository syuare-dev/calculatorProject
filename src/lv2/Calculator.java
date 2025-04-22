package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Calculator {

    // 속성
    private int value1;
    private int value2;
    private String operation;
    private double result;
    private final List<String> resultList = new ArrayList<>(); // 결과값을 저장할 리스트

    // 생성자


    // 기능(메서드)
    // 연산기호에 따른 계산 기능 > 입력값을 매개변수로 사용
    public double calculate() {
        switch (operation) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = (double) value1 * value2;
                break;
            case "/":
                if (value2 == 0) { // 분모가 될 value2=0 일 때
                    throw new ArithmeticException("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
                } else {
                    result = (double) value1 / value2;
                }
                break;

        }

//        resultList.add(result); //계산 값을 resultList 컬렉션에 저장

        return result;
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
            throw new IllegalArgumentException("음수를 입력하셨습니다. 다시 입력해주세요.");
        } else {
            this.value1 = value1;
        }
    }

    public void setValue2(int value2) {
        if(value2<0){ // 숫자2 입력 시 음수 값 검증 > 예외 처리
            throw new IllegalArgumentException("음수를 입력하셨습니다. 다시 입력해주세요.");
        } else {
            this.value2 = value2;
        }
    }

    public void setOperation(String operation) {
        char op = operation.charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') { // 연산 기호 잘못 입력 시 예외 처리
            throw new IllegalArgumentException("잘못된 연산 기호를 입력하셨습니다. 다시 입력해주세요.");
        } else {
            this.operation = operation;
        }
    }

    // 저장된 결과값을 조회할 수 있도록 resultList의 Getter 메서드
    public List<String> getResultList() {
        //return resultList; // resultList에 직접 접근 가능 > 캡슐화(private) 의미가 없어져 수정 필요 ↓
        return new ArrayList<>(resultList); // resultList의 값을 가진 신규 배열 생성 > 복사본으로 사용

    }

   // 형식이 변화된 결과값을 저장할 수 있는 메서드
   public void addResult (String formattedResult) {
        resultList.add(formattedResult);
   }

   // 결과값 삭제 메서드 (수동, 가장 먼저 저장된 값부터 삭제)
    public String removeResult () {
        if(resultList.isEmpty()) {
            throw new NoSuchElementException("저장된 결과값이 없습니다.");
        }
        return resultList.remove(0);
    }


}

