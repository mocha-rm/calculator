package essential.lv1;

import java.util.Scanner;

public class Lv1 {
    public static void main(String[] args) {

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
        }
    }
}