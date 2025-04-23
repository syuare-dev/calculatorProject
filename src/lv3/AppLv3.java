package lv3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {

        System.out.println("LV3 계산기를 만들어볼 예정입니다.");

        boolean escape = false;

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(); // 계산
        ResultHistory resultHistory = new ResultHistory(); // 결과 조회, 저장, 삭제
        ResultFormat resultFormat = new ResultFormat(); // 결과값 형식 변경

        // 입력 메서드 선언 > 숫자, 연산기호
        InputHandler<Double> inputHandler = new InputHandler<>(scanner); // 숫자 입력
        InputOperator inputOperator = new InputOperator(scanner); // 연산기호 입력


        do {
            // 값 입력
            arithmeticCalculator.setValue1(inputHandler.inputValue());
            arithmeticCalculator.setOperator(inputOperator.inputOperator());
            arithmeticCalculator.setValue2(inputHandler.inputValue());

            scanner.nextLine(); // 내부 버퍼 초기화
            // 계산
            double result = arithmeticCalculator.calculate();

            // 결과값 형식 변환
            String formattedResult = resultFormat.formattedResult(result);

            // 결과값 출력
            System.out.println(arithmeticCalculator.getValue1()
                    + " " + arithmeticCalculator.getOperator()
                    + " " + arithmeticCalculator.getValue2()
                    + " = " + formattedResult);

            // 결과값 저장
            resultHistory.addResult(formattedResult);

            // 결과값 조회
            System.out.println("===============================");
            for (String list : resultHistory.getResultList()) {
                System.out.println(list);
            }

            while(true) {
                System.out.println("exit: 나가기 | 아무 키: 계속하기 | list: 결과 조회 | del: 오래된 결과 기록 삭제");
                String inputKey = scanner.next(); // 입력값 받기
                switch (inputKey) {
                    case "exit":
                        escape = true;
                        break;
                    case "list": // 결과값 조회
                        System.out.println("===============================");
                        for (String list : resultHistory.getResultList()) {
                            System.out.println(list);
                        }
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
                    default: // exit, list, del 모두 아닐 때 > switch문 종료
                        break;
                }
                break; // 내부 while문 종료
            }
        } while (!escape);

    }
}