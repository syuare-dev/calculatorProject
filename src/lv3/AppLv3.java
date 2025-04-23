package lv3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {

        // 프로그램 반복문 탈출 키
        boolean escape = false;

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(); // 계산
        ResultHistory resultHistory = new ResultHistory(); // 결과 조회, 저장, 삭제
        ResultFormat resultFormat = new ResultFormat(); // 결과값 형식 변경

        // 입력 메서드 선언 > 숫자, 연산기호
        InputHandler<Double> inputHandler = new InputHandler<>(); // 숫자 입력
        InputOperator inputOperator = new InputOperator(); // 연산기호 입력

        // 프로그램 설명
        System.out.println("사칙 연산이 가능한 계산기 입니다.");
        System.out.println("총 2개의 정수와 계산할 사칙연산 기호를 순서대로 입력해야 합니다.");
        System.out.println("(주의) 입력하실 정수는 0을 포함한 양의 정수일 경우에만 계산기가 동작합니다.");

        // 계산기 시작
        do { // 계산기 반복문

            System.out.println("========== 계 산 시 작 ==========");
            // 값 입력
            arithmeticCalculator.setValue1(inputHandler.inputValue());
            arithmeticCalculator.setOperator(inputOperator.inputOperator());
            arithmeticCalculator.setValue2(inputHandler.inputValue());

            // 계산
            try{ // ArithmeticException (분모 0) 예외 처리
                double result = arithmeticCalculator.calculate();

                // 결과값 형식 변환
                String formattedResult = resultFormat.formattedResult(result);

                // 결과값 출력
                System.out.println("========== 계 산 결 과 ==========");
                System.out.println(resultFormat.formattedResult(arithmeticCalculator.getValue1())
                        + " " + arithmeticCalculator.getOperator()
                        + " " + resultFormat.formattedResult(arithmeticCalculator.getValue2())
                        + " = " + formattedResult);

                // 결과값 저장
                resultHistory.addResult(formattedResult);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }


            // 결과값 조회
            resultHistory.printResultList();

            while(true) {
                System.out.println("================================");
                System.out.println("exit: 나가기 | 아무 키: 계속하기 | list: 결과 조회 | del: 오래된 결과 기록 삭제 | test: 입력한 수보다 높은 결과값만 조회");
                String inputKey = scanner.next(); // 입력값 받기
                switch (inputKey) {
                    case "exit":
                        escape = true;
                        break;
                    case "list": // 결과값 조회
                        resultHistory.printResultList();
                        scanner.nextLine();
                        continue;
                    case "del": // 결과값 삭제
                        try {
                            System.out.println("===============================");
                            String removeResult = resultHistory.removeResult();
                            System.out.println("삭제된 값: " + removeResult);
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                        continue;
                    case "test": // 비교 숫자와 저장된 값을 비교 > 비교 숫자보다 큰 값만 조회
                        System.out.println("===============================");
                        System.out.print("test: 비교할 숫자를 입력해주세요. : ");
                        double inputValue = scanner.nextDouble();
                        try {
                            System.out.println("입력된 " + resultFormat.formattedResult(inputValue)
                                    + " 보다 높은 결과값: " + resultHistory.getResultLargerThanInput(inputValue));
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                        continue;
                    default: // exit, list, del 모두 아닐 때 > switch문 종료
                        break;
                }
                break; // 내부 while문 종료
            }
        } while (!escape);

    }
}