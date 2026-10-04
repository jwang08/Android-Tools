package com.example.q1;

public class Calculator {
    private int program;
    private int midterm;
    private int finals;

    public Calculator(int program, int midterm, int finals) {
        this.program = program;
        this.midterm = midterm;
        this.finals = finals;
    }
    public int getScore(){
       return (60*program/200) +
               (20*midterm/100) +
               (20*finals/100);
    }

    public String getGrade(){
        int i = getScore();
        if(i >= 90){
            return "A";
        }else if(i >= 80){
            return "B";
        }else if(i >= 70){
            return "C";
        }else{
            return "D";
        }
    }
}
