package lv2;

public class Calculator {

    // 속성
    private char operation;
    private double result;


    // 생성자


    // 기능(메서드)

    // 계산 기능
    public void calculate(int value1, int value2, char operation) {
        if (value2 == 0) {
            System.out.println("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
        } else {
            switch (operation) {
                case '+':
                    result = value1 + value2;
                    break;
                case '-':
                    result = value1 - value2;
                    break;
                case '*':
                    result = value1 * value2;
                    break;
                case '/':
                    result = (double) value1 / value2;
                    break;

            }
            System.out.println("value1: " + value1);
            System.out.println("value2: " + value2);
            System.out.println("operation: " + operation);
            System.out.println("result: " + result);
        }
        System.out.println("-------------------------");
    }





}

