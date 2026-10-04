package com.example.q2;

public class Calculator {
    private float price;
    private Boolean warranty;
    private Boolean insurance;
    private String shipping;

    public Calculator(float price, Boolean warranty, Boolean insurance, String shipping) {
        this.price = price;
        this.warranty = warranty;
        this.insurance = insurance;
        this.shipping = shipping;
    }

    public float getTotal(){
        float total = price;
        if(warranty){
            total = (float) (total + (0.1*price));
        }
        if(insurance){
            total = (float) (total + (0.05*price));
        }
        if(shipping.equals("Next day")){
            total += 20;
        }else if (shipping.equals("Second day")){
            total += 10;
        } else if (shipping.equals("Normal")) {
            total += 5;
        }
        return total;
    }
}
