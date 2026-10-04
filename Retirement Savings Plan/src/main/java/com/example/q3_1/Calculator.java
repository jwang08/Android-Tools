package com.example.q3_1;

public class Calculator {
    private double principal, addition, rate, years;

    public Calculator() {
    }

    public void set (double principal, double addition, double rate, double years){
        this.principal = principal;
        this.addition = addition;
        this.rate = rate;
        this.years = years;
    }

    //calculates the compound interest of variables set by the constructor
    public int getTotal(){
        double first = principal+(100*addition/rate);
        double second = (double) Math.pow((1+rate/100),years);
        double third = 100*addition/rate;

        return (int) ((first*second)-third);
    }
}
