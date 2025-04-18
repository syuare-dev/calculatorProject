package lv2;

public class Calculator {

    // 속성
    private int value1;
    private int value2;
    private String operation;
    private double result;


    // 생성자


    // 기능(메서드)

    // 계산 기능
    public void calculate() {
        switch (operation) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                if (value2 == 0) { // 분모가 될 value2 일 때
                    System.out.println("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
                    break;
                } else {
                    result = (double) value1 / value2;
                    break;
                }

        }
    }

    // 계산 결과 출력
    public void outPutPrint() {
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("operation: " + operation);
        System.out.println("result: " + result);
        System.out.println("-------------------------");
    }



    // value1, value2, operation 의 Getter, Setter
    public int getValue1() {
        return this.value1;
    }

    public int getValue2() {
        return this.value2;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }





}

