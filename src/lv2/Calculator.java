package lv2;

public class Calculator {

    // 속성
    int v1;
    int v2;
    char operation;


    // 생성자




    // 기능
    public int sum(int value1, int value2) {
        int result = value1 + value2;
        return result;
    }

    public int sub(int value1, int value2) {
        int result = value1 - value2;
        return result;
    }

    public int mul(int value1, int value2) {
        int result = value1 * value2;
        return result;
    }

    public int div(int value1, int value2) {
        int result = value1 / value2;
        return result;
    }




}
