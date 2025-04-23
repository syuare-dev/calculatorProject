package lv3;

// 계산 클래스
//
public class ArithmeticCalculator <T extends Number> {

    // 속성
    private T value1;
    private T value2;
    private Operator operator;
    private double result;


    // 생성자


    // 기능(메서드)

    // 계산
    public double calculate() {
        double val1 = value1.doubleValue(); // generic 으로 선언된 value1을 double형 변수 val1로 변환
        double val2 = value2.doubleValue(); // generic 으로 선언된 value1을 double형 변수 val1로 변환

        switch (operator) {
            case PLUS:
                result = val1 + val2;
                break;
            case MINUS:
                result = val1 - val2;
                break;
            case MULTIPLE:
                result = val1 * val2;
                break;
            case DIVIDE:
                if (val2 == 0) { // 분모가 될 value2=0 일 때
                    throw new ArithmeticException("나눗셈을 진행할 수 없습니다. - 분모가 0 입니다.");
                } else {
                    result = val1 / val2;
                }
                break;

        }
        return result;
    }
    // value1, value2, operation 의 Getter, Setter

    // 어떤 타입의 자료형이 와도 값을 입력받을 수 있도록 generic 매개변수로 메서드 생성
    public void setValue1(T value1) {
        this.value1 = value1;
    }

    // 어떤 타입의 자료형이 와도 값을 입력받을 수 있도록 generic 매개변수로 메서드 생성
    public void setValue2(T value2) {
        this.value2 = value2;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public T getValue1() {
        return this.value1;
    }

    public T getValue2() {
        return this.value2;
    }

    public String getOperator() {
        return this.operator.getOperator();
    }
}

