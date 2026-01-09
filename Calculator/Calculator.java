package Calculator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Calculator {
    private ArrayList<Double> calcLog = new ArrayList<>();

    public Double calculate (int a, int b, String op) {
        return (switch (op) {
            case "+" -> (double)(a + b);
            case "-" -> (double)(a - b);
            case "*" -> (double)(a * b);
            case "/" -> {
                if (b == 0) {
                    //나누는 값이 0일 때 예외처리
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                yield (double)a / b; //yield를 통해 switch 결과값 return
            }
            default -> {
                //다른 연산기호가 들어왔을 때의 예외처리
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
            }
        });
    }

    //결과값을 컬렉션에 저장하는 함수
    public void addLog (double result){
        calcLog.add(result);
    }
    // 결과값을 저장하는 컬렉션을 반환하는 함수
    public ArrayList<Double> getLog () {
        return calcLog;
    }
    // 결과값을 저장하는 컬렉션을 초기화하는 함수
    public void setLog (){
        calcLog = new ArrayList<>();
    }
    // 결과값을 저장하는 컬렉션에 가장 처음 값을 삭제하는 함수
    public void deleteLog (){
        if(!calcLog.isEmpty())  calcLog.remove(0);
        else throw new NoSuchElementException("결과 로그가 비어있습니다.");
    }
}

