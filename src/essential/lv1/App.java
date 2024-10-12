package essential.lv1;

import essential.lv2.Calculator;

import java.util.Scanner;


public class App {
    public static void main(String[] args){

        final int COUNT_OF_NUMBERS = 2;

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double[] nums = new double[2];
        double result = 0;
        String operator = "";


        while (!operator.equals("exit")) {
            try {
                for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
                    System.out.println((i + 1) + "번 째 숫자를 입력하세요");
                    nums[i] = scanner.nextDouble();
                }
                scanner.nextLine();

                System.out.println("연산자를 입력해주세요 ! (+, -, *, /)");

                operator = scanner.nextLine().trim();

                result = calculator.calculate(operator, nums[0], nums[1]);
                calculator.setResults(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("계산을 계속하려면 enter, 시스템을 종료하려면 exit을 입력하세요.");
            System.out.println("가장 먼저 저장한 데이터를 삭제하시겠습니까? (remove를 입력하세요)");
            System.out.println("저장된 데이터 : " + calculator.getResults().toString());

            operator = scanner.nextLine().trim();
            if (operator.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                return;
            } else if (operator.equals("remove")) {
                calculator.removeResult();
            }
        }
    }
}

/* Legacy
//TODO: 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

        Scanner scanner = new Scanner(System.in);
        double[] nums = new double[2];
        String operator = "";


        while (!operator.equals("exit")) {

            for (int i = 0; i < nums.length; i++) {

                System.out.println((i + 1) + "번 째 숫자를 입력하세요");
                nums[i] = scanner.nextDouble();
            }
            scanner.nextLine();

            System.out.println("연산자를 입력해주세요 ! (+, -, *, /)");

            operator = scanner.nextLine();

            switch (operator) {
                case "+":
                    System.out.println(nums[0] + nums[1]);
                    break;
                case "-":
                    System.out.println(nums[0] - nums[1]);
                    break;
                case "*":
                    System.out.println(nums[0] * nums[1]);
                    break;
                case "/":
                    if (nums[1] == 0) {
                        System.out.println("0으로 나눌 수 없습니다!");
                        continue;
                    } else {
                        System.out.println(nums[0] / nums[1]);
                    }

                    break;
            }

            System.out.println("계산을 계속하려면 enter, 시스템을 종료하려면 exit을 입력하세요.");
            operator = scanner.nextLine();
            if (operator.equals("exit")) {
                return;
            }
* */