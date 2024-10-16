package plus.lv3;


enum OperatorType {
//클래스에 상수를 추가했다 라고 이해하면 편하다
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");


    // 상수 구체화
    private final String operator;

    //private or 생략만 가능
    OperatorType(String operator) {
        this.operator = operator;
    } //생성자를 호출하는 것이 아니라 만듬으로써 변수를 생성할 때 셋팅이 되었다고 생각하면 된다.
    //OperatorType op = OperatorType.ADD; <- 세팅완료

    public String getOperator() {
        return operator;
    }

    public static OperatorType getOperator(String str) throws Exception {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.operator.equals(str)) {
                return operatorType;
            }
        }
        throw new Exception("제대로 된 연산자가 아닙니다.");
    }
}
