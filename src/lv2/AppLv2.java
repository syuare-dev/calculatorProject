package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 계산기 시작

        //정수1 입력
//        System.out.print("숫자1을 입력해주세요: ");
//        calculator.setValue1(scanner.nextInt());
//        System.out.println("입력된 값: " + calculator.getValue1());
//

        //정수1 입력 > 정수 확인 절차 포함
        System.out.print("숫자1을 입력해주세요: ");
        while(true) {
            try { // 음수, 문자열 입력 검증 > 예외 처리, try-catch
                calculator.setValue1(scanner.nextInt());
                break;
            } catch (InputMismatchException e) { // 문자열 입력 시 예외 처리
                System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
                scanner.nextLine(); // 내부 버퍼 초기화
            } catch (IllegalArgumentException e) { // 음수 입력 시 예외 처리
                scanner.nextLine(); // 내부 버퍼 초기화
            }
        }


        // if문으로 입력값 > 음수, 문자열 오류 처리
//        while(true){
//            if (scanner.hasNextInt()){
//                int value1Check = scanner.nextInt();
//                calculator.setValue1(value1Check);
//                scanner.nextLine();
//                break;
//            } else {
//                System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
//                scanner.nextLine();
//            }
//        }
//
//        System.out.print("연산 기호를 입력해주세요: ");
//        calculator.setOperation(scanner.next());
//        System.out.println("입력된 값: " + calculator.getOperation());
//
//        scanner.nextLine(); // 내부 버퍼 초기화
//
//        System.out.print("숫자2를 입력해주세요: ");
//        calculator.setValue2(scanner.nextInt());
//        System.out.println("입력된 값: " + calculator.getValue2());
//
//        scanner.nextLine(); // 내부 버퍼 초기화

//        calculator.calculate();
//        calculator.outPutPrint();






    }
}
