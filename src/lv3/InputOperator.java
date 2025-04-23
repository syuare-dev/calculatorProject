package lv3;

import java.util.Scanner;

// 연산 기호 입력 기능 클래스
public class InputOperator {
    // 속성
    private final Scanner scanner;

    // 생성자
    /**
     *@param scanner 문자열 입력 Scanner(System.in)
     *               main 메서드에서 입력한 Scanner 값을 매개 변수로 활용
     */
    public InputOperator (Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    // 기능(메서드)
    // 연산 기호 입력 기능 > enum 활용
    public Operator inputOperator() {
        System.out.println("연산 기호를 입력해주세요 (+, -, *, /): ");
        while(true){
            String operator = scanner.nextLine().trim();
            try {
                return Operator.inputString(operator);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
