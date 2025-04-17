package lv1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {

        // 입력받을 수 있도록 Scanner 클래스 인스턴스화
        Scanner scanner = new Scanner(System.in);
        // exit key
        boolean escape = false;
        // 계산 결과값 변수 선언
        double result;

        // 입력값 변수 선언
        int v1;
        int v2;
        char operation;

        // 프로그램 설명
        System.out.println("사칙연산이 가능한 계산기 입니다.");
        System.out.println("총 2개의 정수와 계산할 사칙연산 기호를 순서대로 입력해야 합니다.");
        System.out.println("(주의) 입력하실 정수는 0을 포함한 양의 정수일 경우에만 계산기가 동작합니다.");

        // 계산기 반복 > escape 값이 true 가 되면 계산기 종료
        do {
            System.out.println("====== 계산 시작 ======");
            //결과값 초기화
            result = 0;

            // 정수1 입력 & 입력값이 정수형인지 확인, 정수형이 아니면 true 일 때까지 반복
            System.out.print("첫 번째 정수를 입력해주세요: ");
            while(true) {
                if(scanner.hasNextInt()) {
                    v1 = scanner.nextInt();
                    scanner.nextLine(); // 내부 버퍼 초기화 (개행문자(\n) 제거)
                    if (v1>=0) {
                        break;
                    } else {
                        System.out.println("음수를 입력하셨습니다. 다시 입력해주세요.");
                    }
                }
                else {
                    System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
                    scanner.nextLine(); // 내부 버퍼 초기화
                }
            }

            // 정수2 입력 & 입력값이 정수형인지 확인, 정수형이 아니면 true 일 때까지 반복
            System.out.print("두 번째 정수를 입력해주세요: ");
            while(true) {
                if(scanner.hasNextInt()) {
                    v2 = scanner.nextInt();
                    scanner.nextLine(); // 내부 버퍼 초기화 (개행문자(\n) 제거)
                    if (v2>=0) {
                        break;
                    } else {
                        System.out.println("음수를 입력하셨습니다. 다시 입력해주세요.");
                    }
                } else {
                    System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
                    scanner.nextLine(); // 내부 버퍼 초기화
                }
            }

            // 사칙연산 기호 입력 & 잘못 입력하면 true 일 때까지 반복
            System.out.print("연산 기호(+, - , *, /) 중 하나를 입력해주세요: ");
            while(true){
                String strCheck = scanner.next();
                scanner.nextLine(); // 내부 버퍼 초기화

                // 기호+다른 문자를 입력해도 동작하는 것을 방지
                if(strCheck.length() == 1) {
                    operation = strCheck.charAt(0);
                    if (operation == '+' || operation == '-'|| operation == '*' || operation == '/') {
                        break;
                    }
                }
                System.out.println("잘못된 사칙연산 기호를 입력하셨습니다. 다시 입력해주세요.");
            }

            System.out.println("==========계 산 결 과 ===========");

            // 사칙 연산 기호에 맞는 계산 진행
            switch (operation){
                case '+':
                    result = v1 + v2;
                    break;
                case '-':
                    result = v1 - v2;
                    break;
                case '*':
                    result = v1 * v2;
                    break;
                case '/':
                    if(v2!=0) {
                        result = (double)v1 / v2;
                    } else {
                        System.out.println("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
                    }
                    break;
            }
            // 결과값 출력
            // 소수점 처리 방법 적용 > BigDecimal 을 사용 > trailing zero 제거
            // -> 소수점 뒤가 0인 것들을 안보이게 출력값에 제거
//            BigDecimal bdresult = new BigDecimal(result);
            // 소수점 15자리까지 출력 > 소수점 15자리 초과 시 비정상적인 값으로 출력되어 소수점 자리 지정
            BigDecimal bdresult = new BigDecimal(result).setScale(15, RoundingMode.HALF_UP);
            bdresult = bdresult.stripTrailingZeros();
            System.out.println(v1 + " " + operation + " " + v2 + " = " + bdresult);

            // 프로그램 종료 확인
            System.out.println("프로그램을 종료하시겠습니까? (exit: 나가기, 아무 키: 계속하기)");
            String escapeKey = scanner.next();
            if(escapeKey.equals("exit")) {
                escape = true;
            }

        } while(!escape);

        System.out.println("계산기 프로그램을 종료합니다.");
    }
}