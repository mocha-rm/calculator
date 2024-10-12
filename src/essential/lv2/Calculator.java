package essential.lv2;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Double> results = new ArrayList<Double>();

    public double calculate(String operator, double num1, double num2) throws Exception {

        double value = 0;

        switch (operator) {
            case "+":
                value = num1 + num2;
                break;
            case "-":
                value = num1 - num2;
                break;
            case "*":
                value = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("0으로 나눌 수 없습니다.");
                } else {
                    value = num1 / num2;
                }
                break;
            default:
                throw new Exception("제대로된 연산자가 아닙니다.");
        }

        System.out.println("계산 결과 => " + value);
        return value;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(double value) {
        results.add(value);
    }

    public void removeResult() {
        results.removeFirst();
        System.out.println("데이터가 삭제되었습니다 !");
        System.out.println("현재 데이터 : " + results.toString());
    }
}
