package lv3;

import java.util.Scanner;

// 숫자값 입력 기능 클래스
public class InputHandler <T extends Number> {

    // 속성
    private final Scanner scanner = new Scanner(System.in);

    // 생성자

    // 기능(메서드)
    // 숫자 입력 기능
    public T inputValue() {
        System.out.println("숫자를 입력해주세요: ");
        while (true) {
            String inputStr = scanner.nextLine().trim();
            try {
                T value = (T) Double.valueOf(inputStr);
                return value ;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
