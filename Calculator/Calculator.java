package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Calculator<T extends  Number & Comparable<T>> {
    private ArrayList<T> calcLog = new ArrayList<>();
    public enum OperatorType {
        //각 연산기호 매핑
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVISION("/");
        private final String symbol; //final field
        OperatorType(String symbol){ this.symbol = symbol; } //생성자
        public String getSymbol () {
            return symbol;
        }
        public static OperatorType fromSymbol(String op){
            for(OperatorType type : values()){
                if(type.getSymbol().equals(op)){
                    return type;
                }
            }
            throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }

    public Double calculate (T a, T b, OperatorType op) {
        double n1 = a.doubleValue();
        double n2 = b.doubleValue();

        return (switch (op) {
            case ADD -> (n1 + n2);
            case SUBTRACT -> (n1 - n2);
            case MULTIPLY -> (n1 * n2);
            case DIVISION -> {
                if (n2 == 0) {
                    //나누는 값이 0일 때 예외처리
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                yield (n1 / n2); //yield를 통해 switch 결과값 return
            }
        });
    }

    //결과값을 컬렉션에 저장하는 함수
    public void addLog (T result){
        calcLog.add(result);
    }
    // 결과값을 저장하는 컬렉션을 반환하는 함수
    public ArrayList<T> getLog () {
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
    //기준값보다 큰 결과값을 조회하는 함수
    public void searchLog (T param) {
        List<T> result = calcLog.stream()
                .filter(num -> num.compareTo(param) > 0)
                .toList();
        System.out.println("result: " + result);
    }
}

