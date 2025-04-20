package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 계산기 시작

        //숫자1 입력 코드
        System.out.print("숫자1을 입력해주세요: ");
        while(true) {
            try { // 음수, 문자열 입력 검증 > 예외 처리, try-catch
                calculator.setValue1(scanner.nextInt()); // 숫자1 입력
                break; // 문제 없으면 반복문 break
            } catch (InputMismatchException e) { // 문자열 입력 시 예외 처리
                System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
                scanner.nextLine(); // 내부 버퍼 초기화
            } catch (IllegalArgumentException e) { // 음수 입력 시 예외 처리
                scanner.nextLine(); // 내부 버퍼 초기화
            }
        }

        System.out.println("입력된 값: " + calculator.getValue1());


        System.out.print("연산 기호를 입력해주세요: ");
        calculator.setOperation(scanner.next());
        System.out.println("입력된 값: " + calculator.getOperation());

        scanner.nextLine(); // 내부 버퍼 초기화


        //숫자2 입력 코드
        System.out.print("숫자2를 입력해주세요: ");
        while(true) {
            try { // 음수, 문자열 입력 검증 > 예외 처리, try-catch
                calculator.setValue2(scanner.nextInt()); // 숫자2 입력
                break; // 문제 없으면 반복문 break
            } catch (InputMismatchException e) { // 문자열 입력 시 예외 처리
                System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
                scanner.nextLine(); // 내부 버퍼 초기화
            } catch (IllegalArgumentException e) { // 음수 입력 시 예외 처리
                scanner.nextLine(); // 내부 버퍼 초기화
            }
        }

        System.out.println("입력된 값: " + calculator.getValue2());
        scanner.nextLine(); // 내부 버퍼 초기화

        calculator.calculate(); // 게산 메서드
        calculator.outPutPrint(); // 결과 출력 메서드






    }
}
