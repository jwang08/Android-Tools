package com.example.q4;

import java.util.Arrays;

public class Calculator {
    private double[] values;
    private int size;

    public Calculator(String numbers) {
        String[] temp = numbers.split(" ");
        double[] convert = new double[temp.length];
        for(int i = 0; i < temp.length; i++){
            convert[i] = Double.parseDouble(temp[i]);
        }

        size = convert.length;
        values = convert;
        sort();
    }

    public double getSum(){
        double total = 0;
        for(int i = 0; i < size; i++){
            total += values[i];
        }
        return total;
    }
    public double getMin(){
        return values[0];
    }
    public double getMax(){
        return values[values.length-1];
    }
    public double getMean(){
        return this.getSum()/size;
    }
    public double getSTDV(){
        double avg = getMean();
        double total = 0;
        for(int i = 0; i < size; i++){
            total = total + Math.pow(values[i]-avg, 2);
        }
        total = total / size;
        total = Math.sqrt(total);
        return total;
    }
    public double getMedian(){
        if(size % 2 == 0){
            return (values[(size/2)] + values[(size/2) - 1])/2;
        }else{
            return values[(size/2)];
        }
    }
    public void sort(){
        Arrays.sort(values);
    }
}
