package lv1;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {

        // 입력받을 수 있도록 Scanner 클래스 인스턴스화
        Scanner scanner = new Scanner(System.in);

        // 프로그램 설명
        System.out.println("사칙연산이 가능한 계산기 입니다.");
        System.out.println("총 2개의 정수와 계산할 사칙연산 기호를 순서대로 입력해야 합니다.");
        System.out.println("(주의) 입력하실 정수는 0을 포함한 양의 정수일 경우에만 계산기가 동작합니다.");
        System.out.println("====== 사 칙 연 산 계 산 기 ======");
        System.out.print("첫 번째 정수를 입력해주세요: ");
        int v1 = scanner.nextInt();
//
        System.out.print("두 번째 정수를 입력해주세요: ");
        int v2 = scanner.nextInt();

        System.out.print("사칙연산 기호(+, - , *, /) 중 하나를 입력해주세요: ");
        char at = scanner.next().charAt(0);

        System.out.println("==========계 산 결 과 ===========");

        // 계산 결과값 변수 선언
        double result = 0;

        // 사칙연산 기호에 맞는 계산
        if (v1<0 || v2<0) {
            System.out.println("정수 값을 잘못 입력했습니다.");
        } else {
            switch (at){
                case '+':
                    result = v1 + v2;
                    System.out.println(v1 + " " + at + " " + v2 + " = " + String.format("%.0f",result));
                    break;
                case '-':
                    result = v1 - v2;
                    System.out.println(v1 + " " + at + " " + v2 + " = " + String.format("%.0f",result));
                    break;
                case '*':
                    result = v1 * v2;
                    System.out.println(v1 + " " + at + " " + v2 + " = " + String.format("%.0f",result));
                    break;
                case '/':
                    if(v2!=0) {
                        result = (double)v1 / v2;

                        // 소수점 처리 방법 > BigDecimal을 사용 > trailing zero 제거
                        BigDecimal bdresult = new BigDecimal(Double.toString(result));
                        bdresult = bdresult.stripTrailingZeros();
                        System.out.println(v1 + " " + at + " " + v2 + " = " + bdresult.toPlainString());
                    } else {
                        System.out.println("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
                    }
                    break;
                default:
                    System.out.println("사칙연산 기호를 잘못 입력하셨습니다.");
            }
        }
    }
}