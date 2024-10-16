package plus.lv3;
import java.util.ArrayList;


public class ArithmeticCalculator<T extends Number> {

    ArrayList<Double> calculateResults = new ArrayList<>();
    ArrayList<String> history = new ArrayList<>();

    public T calculate(T num1, T num2, OperatorType operator) throws IllegalAccessException {

        history.add(num1 + " " + operator.getOperator() + " " + num2 + " = ");

        Double value = 0.0;

        switch (operator) {
            case ADD:
                value = num1.doubleValue() + num2.doubleValue();
                break;
            case SUBTRACT:
                value = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                value = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                if (num2.doubleValue() != 0) {
                    value = num1.doubleValue() / num2.doubleValue();
                } else {
                    throw new IllegalAccessException("0으로 나눌 수 없습니다.");
                }
                break;
        }
        System.out.println();
        System.out.println("\u001B[33m계산 결과 => " + value + "\u001B[33m");
        return (T) value;
    }

    public ArrayList<Double> getCalculateResults() {
        return calculateResults;
    }

    public void setCalculateResults(double value) {
        calculateResults.add(value);
    }

    public ArrayList<String> getHistory() {
        return history;
    }


    public void removeResult() {
        calculateResults.removeFirst();
        history.removeLast();
        System.out.println("데이터가 삭제되었습니다 ! ");
        System.out.println("현재 데이터 : " + calculateResults.toString());
    }
}
