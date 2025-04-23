package lv3;

// enum 활용 > 연산 기호 4개를 Operator 타입으로 묶어보자
public enum Operator {
    PLUS("+"), //
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    // 속성
    private final String operator;


    // 생성자
    Operator(String operator) {
        this.operator = operator;
    }


    // 기능(매서드)

    // 연산기호 확인, 반환
    public static Operator inputString(String str) {
        for(Operator op : values()) {
            if(op.operator.equals(str)) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다.: " + str);
    }


}
