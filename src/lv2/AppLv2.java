package lv2;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 프로그램 반복문 탈출 키
        boolean escape = false;

        // 프로그램 설명
        System.out.println("사칙 연산이 가능한 계산기 입니다.");
        System.out.println("총 2개의 정수와 계산할 사칙연산 기호를 순서대로 입력해야 합니다.");
        System.out.println("(주의) 입력하실 정수는 0을 포함한 양의 정수일 경우에만 계산기가 동작합니다.");

        // 계산기 시작
        do { // 계산기 반복문
            System.out.println("========== 계 산 시 작 ==========");

            // 첫 번째 숫자 입력
            System.out.print("첫 번째 숫자를 입력해주세요: ");
            while(true) {
                try { // 음수, 문자열 입력 검증 > 예외 처리, try-catch
                    calculator.setValue1(scanner.nextInt()); // 숫자1 입력
                    break; // 문제 없으면 반복문 break
                } catch (InputMismatchException e) { // 문자열 입력 시 예외 처리
                    System.out.println(e.getMessage());
                    scanner.nextLine(); // 내부 버퍼 초기화
                } catch (IllegalArgumentException e) { // 음수 입력 시 예외 처리
                    scanner.nextLine(); // 내부 버퍼 초기화
                }
            }

            // 연산 기호 입력
            System.out.print("연산 기호를 입력해주세요: ");
            while(true) {
                String operatorCheck = scanner.next(); // 연산기호 입력
                if (operatorCheck.length() != 1) { // 여러 개의 문자를 입력 시 오류 처리
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    continue;
                }
                // 입력값 길이가 1이지만 잘못된 기호 입력 시 예외 처리
                try{
                    calculator.setOperation(operatorCheck);
                    break;
                } catch (IllegalArgumentException e){ // 예외 처리
                    scanner.nextLine(); // 내부 버퍼 초기화
                }
            }

            // 두 번째 숫자 입력
            System.out.print("두 번째 숫자를 입력해주세요: ");
            while(true) {
                try { // 음수, 문자열 입력 검증 > 예외 처리, try-catch
                    calculator.setValue2(scanner.nextInt()); // 숫자2 입력
                    break; // 문제 없으면 반복문 break
                } catch (InputMismatchException e) { // 문자열 입력 시 예외 처리
                    System.out.println(e.getMessage());
                    scanner.nextLine(); // 내부 버퍼 초기화
                } catch (IllegalArgumentException e) { // 음수 입력 시 예외 처리
                    scanner.nextLine(); // 내부 버퍼 초기화
                }
            }

            scanner.nextLine(); // 내부 버퍼 초기화

            // 계산
            try{
                // 계산된 값을 변수 calResult에 반환
                double calResult = calculator.calculate();
                System.out.println("===============================");

                // 결과값 형식 변경 > 소수점 처리, 1,000 단위 구분자(,) 추가
                DecimalFormat dfResult = new DecimalFormat("#,###.###############");
                String formattedResult = dfResult.format(calResult); // 결과값을 형식 변경 후 formattedResult에 반환

                // 결과값 출력
                System.out.println(calculator.getValue1()
                        + " " + calculator.getOperation()
                        + " " + calculator.getValue2()
                        + " = " + formattedResult);

                // 형식 변경된 값을 결과값으로 저장
                calculator.addResult(formattedResult);

            } catch (ArithmeticException e) { // 수학적 오류 예외 처리 (분모 0)
                System.out.println(e.getMessage());
            }

            System.out.println("========== 계 산 기 록 ==========");
            // 지금까지의 계산 기록 보여주기 > 향상된 for문 활용
            for (String list : calculator.getResultList()) {
                System.out.println(list);
            }
            System.out.println("===============================");

            System.out.println("프로그램을 종료하시겠습니까? (exit: 나가기, 아무 키: 계속하기)");
            String escapeKey = scanner.next();
            if(escapeKey.equals("exit")) { // exit 입력 시 escape 값 true > 반복문 종료
                escape = true;
            }
        } while(!escape);

        System.out.println("계산기 프로그램을 종료합니다.");

    }
}
