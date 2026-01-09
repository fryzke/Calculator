package Calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator<Double> calc = new Calculator<Double>();

        String cmd = "";
        System.out.println("========계산기========");
        while (!cmd.equals("exit")) {
            System.out.println("명령어를 입력하세요. 1. calc 2. print log  3. delete first log 4. search 5. exit");
            cmd = scanner.nextLine();
            ArrayList<Double> resultLog;
            if (cmd.equals("calc")) {
                System.out.print("계산식 ex) 1 + 2(공백구분): ");
                cmd = scanner.nextLine();
                String[] formular = cmd.split(" ");
                double result;

                if (formular.length != 3) {
                    System.out.println("올바른 형식으로 입력해주세요. ex) 1 + 2");
                    continue;
                }

                try {
                    double a = parseDouble(formular[0]);
                    double b = parseDouble(formular[2]);
                    String operator = formular[1];

                    Calculator.OperatorType op = Calculator.OperatorType.fromSymbol(operator);
                    result = calc.calculate(a, b, op);
                    System.out.println("result = " + result);
                    calc.addLog(result);

                }catch (ArithmeticException | IllegalArgumentException e){ //예외처리 블록
                    System.out.println("error: " + e.getMessage());
                }
            } else if (cmd.equals("print log")) {
                resultLog = calc.getLog();
                System.out.println("Log: " + resultLog);

            } else if(cmd.equals("delete first log")) {
                resultLog = calc.getLog();
                try {
                    calc.deleteLog();
                    System.out.println("Log: " + resultLog);
                }catch (NoSuchElementException e){
                    System.out.println("error: " + e.getMessage());
                }
            }else if(cmd.equals("search")){
                System.out.print("기준값을 입력하세요: ");
                try {
                    double param = scanner.nextDouble();
                    calc.searchLog(param);
                }catch (InputMismatchException e){
                    System.out.println("error: 숫자만 입력하세요.");
                }
            }else if (!cmd.equals("exit")) {
                System.out.println("error: 잘못된 입력입니다.");
            }

        }
        System.out.println("========종 료========");


    }
}
