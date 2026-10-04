package com.example.q6;

public class Calculator {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    public boolean isPrime(){
        boolean isPrime = number > 1;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return isPrime;
    }
}
