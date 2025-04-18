package lv2;

import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 계산기 시작

        System.out.print("숫자1을 입력해주세요: ");
        calculator.setValue1(scanner.nextInt());
        System.out.println("입력된 값: " + calculator.getValue1());

        scanner.nextLine();

        System.out.print("연산 기호를 입력해주세요: ");
        calculator.setOperation(scanner.next());
        System.out.println("입력된 값: " + calculator.getOperation());

        scanner.nextLine();

        System.out.print("숫자2를 입력해주세요: ");
        calculator.setValue2(scanner.nextInt());
        System.out.println("입력된 값: " + calculator.getValue2());

        scanner.nextLine();

        calculator.calculate();
        calculator.outPutPrint();
















    }
}
