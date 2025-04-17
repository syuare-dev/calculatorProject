package lv1;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {

        // 입력받을 수 있도록 Scanner 클래스 인스턴스화
        Scanner scanner = new Scanner(System.in);
        // exit key
        boolean escape = false;
        // 계산 결과값 변수 선언
        double result;

        // 프로그램 설명
        System.out.println("사칙연산이 가능한 계산기 입니다.");
        System.out.println("총 2개의 정수와 계산할 사칙연산 기호를 순서대로 입력해야 합니다.");
        System.out.println("(주의) 입력하실 정수는 0을 포함한 양의 정수일 경우에만 계산기가 동작합니다.");

        // 계산기 반복 > escape값이 true가 되면 계산기 종료
        do {
            System.out.println("====== 계산 시작 ======");
            //결과값 초기화
            result = 0;

            // 정수1 입력
            System.out.print("첫 번째 정수를 입력해주세요: ");
            int v1 = scanner.nextInt();
            // 정수2 입력
            System.out.print("두 번째 정수를 입력해주세요: ");
            int v2 = scanner.nextInt();
            // 사칙연산 기호 입력
            System.out.print("사칙연산 기호(+, - , *, /) 중 하나를 입력해주세요: ");
            char at = scanner.next().charAt(0);

            //개행(\n) 제거
            scanner.nextLine();

            System.out.println("==========계 산 결 과 ===========");

            // 사칙연산 기호에 맞는 계산 진행
            if (v1<0 || v2<0) {
                System.out.println("음수의 계산은 지원하지 않습니다.");
            } else {
                switch (at){
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
                    default:
                        System.out.println("잘못된 사칙연산 기호를 입력하셨습니다.");
                        continue;
                }
                // 결과값 출력
                // 소수점 처리 방법 적용 > BigDecimal을 사용 > trailing zero 제거
                BigDecimal bdresult = new BigDecimal(Double.toString(result));
                bdresult = bdresult.stripTrailingZeros();
                System.out.println(v1 + " " + at + " " + v2 + " = " + bdresult.toPlainString());

                // 프로그램 종료 확인
                System.out.println("프로그램을 종료하시겠습니까? (exit: 나가기, 아무 키: 계속하기)");
                String escapeKey = scanner.next();
                if(escapeKey.equals("exit")) {
                    escape = true;
                }
            }
        } while(!escape);

        scanner.close(); // 스캐너 닫기 > 리소스 누수 방지
        System.out.println("계산기 프로그램을 종료합니다.");

    }
}