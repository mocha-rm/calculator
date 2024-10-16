package plus.lv3;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        final int COUNT_OF_NUMBERS = 2;

        Scanner scanner = new Scanner(System.in);
        double[] nums = new double[2];
        double result;
        String input = "";

        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();


        while (!input.equals("exit")) {
            try {
                System.out.println("계산을 시작합니다.");
                for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
                    System.out.println((i + 1) + "번 째 숫자를 입력하세요");
                    nums[i] = scanner.nextDouble();
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            System.out.println("연산자를 입력해주세요 ! (+, -, *, /)");
            input = scanner.nextLine().trim();
            try {
                result = calculator.calculate(nums[0], nums[1], OperatorType.getOperator(input));
                calculator.setCalculateResults(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }


            while (!input.equals("r")) {

                System.out.println("\u001B[0m");
                System.out.println("계산을 계속하려면 r, 시스템을 종료하려면 \u001B[31mexit\u001B[0m 을 입력하세요.");
                System.out.println("가장 먼저 저장한 데이터를 삭제하시겠습니까? (remove 를 입력하세요)");
                System.out.println("계산 내역을 보려면 history 를 입력하세요");
                System.out.println("계산 데이터 중 가장 큰 값을 출력하려면 max 를 입력하세요");

                input = scanner.nextLine().trim();


                switch (input) {
                    case "exit" -> {
                        System.out.println("계산기를 종료합니다.");
                        return;
                    }
                    case "remove" -> calculator.removeResult();
                    case "history" -> {
                        if (!calculator.getHistory().isEmpty()) {
                            for(int i = 0; i < calculator.getHistory().size(); i++) {
                                var calculateResults = calculator.getCalculateResults().stream().toList();
                                System.out.println((i + 1) + ". " + calculator.getHistory().get(i) + calculateResults.get(i));
                            }
                        } else {
                            System.out.println("출력한 내용이 없습니다.");
                        }
                    }
                    case "max" -> {
                        if (!calculator.getCalculateResults().isEmpty()) {
                            System.out.println("가장 큰 값 => " + calculator.getCalculateResults().stream().mapToDouble(num -> num).max().getAsDouble());
                        } else {
                            System.out.println("출력한 내용이 없습니다.");
                        }
                    }
                }
            }
        }
    }
}
