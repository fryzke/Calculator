package Calculator;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cmd = "";
        System.out.println("========계산기========");
        while (!cmd.equals("exit")) {
            System.out.println("명령어를 입력하세요. 1. calc  2. exit");
            cmd = scanner.nextLine();
            if (cmd.equals("calc")) {
                System.out.print("계산식(양의 정수만 입력 가능): ");
                cmd = scanner.nextLine();
                String[] formular = cmd.split(" ");

                if (formular.length != 3) {
                    System.out.println("올바른 형식으로 입력해주세요. ex) 1 + 2");
                    continue;
                }

                try {
                    int a = parseInt(formular[0]);
                    int b = parseInt(formular[2]);
                    String operator = formular[1];
                    if (a < 0 || b < 0) {
                        System.out.println("error: 양의 정수만 계산 가능합니다.");
                        continue;
                    }

                    switch (operator) {
                        case "+" -> System.out.println("result: " + (a + b));
                        case "-" -> System.out.println("result: " + (a - b));
                        case "*" -> System.out.println("result: " + (a * b));
                        case "/" -> {
                            if (b == 0) {
                                System.out.println("0으로 나눌 수 없습니다.");
                            } else {
                                System.out.println("result: " + (a / b));
                            }
                        }
                        default -> System.out.println("error: 지원하지 않는 연산자입니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("error: 정수가 아닌 값은 입력할 수 없습니다.");
                }
            } else if (!cmd.equals("exit")) {
                System.out.println("잘못된 입력입니다.");
            }

        }
        System.out.println("========종 료========");


    }
}
