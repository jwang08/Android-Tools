package com.example.q32;

public class University {
    private int credits;
    private String status;
    private boolean dorm, dining;

    public University(int credits, String status, boolean dorm, boolean dining) {
        this.credits = credits;
        this.status = status;
        this.dorm = dorm;
        this.dining = dining;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDorm(boolean dorm) {
        this.dorm = dorm;
    }

    public void setDining(boolean dining) {
        this.dining = dining;
    }

    public int getCredits() {
        return credits;
    }

    public String getStatus() {
        return status;
    }

    public boolean getDorm() {
        return dorm;
    }

    public boolean getDining() {
        return dining;
    }

    public int getTotal(){
        int total = credits;
        if(status.equals("undergraduate")){
            total = total*300;
        }else if (status.equals("graduate")){
            total = total*400;
        }
        if(dorm){
            total += 1000;
        }
        if(dining){
            total += 500;
        }
        return total;
    }
}
