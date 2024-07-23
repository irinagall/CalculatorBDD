package idg;

import java.util.List;

public class Calculator {
    private int num1;
    private int num2;
    private List<Integer> numbers;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public Integer add() {
        return num1 + num2;
    }

    public Integer subtract() {
        return num1 - num2;
    }

    public Integer multiply() {
        return num1 * num2;
    }

    public Integer divide() throws DivideByZeroException {
        if (num2 == 0) {
            throw new DivideByZeroException("Cannot Divide By Zero");
        }
        return num1 / num2;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sumEvenNumbers() {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
