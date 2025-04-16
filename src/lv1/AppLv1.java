package lv1;

import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        System.out.println("계산기를 만들어 봅시다.");

        // 입력받을 수 있도록 Scanner 클래스 인스턴스화
        Scanner scanner = new Scanner(System.in);

        System.out.println("사칙연산이 가능한 계산기 입니다.");
        System.out.println("총 2개의 정수와 계산할 사칙연산 기호를 순서대로 입력해야 합니다.");
        System.out.println("========== 사칙 연산 계산기 =========");
        System.out.print("첫 번째 정수를 입력해주세요: ");
        int v1 = scanner.nextInt();
//
        System.out.print("두 번째 정수를 입력해주세요: ");
        int v2 = scanner.nextInt();

        System.out.print("사칙연산 기호(+, - , *, /) 중 하나를 입력해주세요: ");
        char at = scanner.next().charAt(0);

        int result = 0;

        // 사칙연산 기호에 맞는 계산
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
            default:
                System.out.println("사칙연산 기호를 잘못 입력하셨습니다.");
        }

        // 결과 테스트
        System.out.println("==========================");
        System.out.println(v1 + " " + at + " " + v2 + " = " + result);


        


    }
}