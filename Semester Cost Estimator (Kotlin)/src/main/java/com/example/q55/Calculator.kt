package com.example.q55

class Calculator {
    var credit = 0
    //status: 0 = grad/1 = under/2 = non degree
    var status = 0
    //state: 1 = in state/2 = out of state
    var state = 1
    var dorm = false
    var dine = false
    var park = false

    constructor(park: Boolean, dine: Boolean, dorm: Boolean, state: Int, status: Int, credit: Int) {
        this.park = park
        this.dine = dine
        this.dorm = dorm
        this.state = state
        this.status = status
        this.credit = credit
    }

    fun calc(): Int {
        var total = credit
        if (status == 0){
            total *= 800
        }else if (status == 1){
            total *= 500
        }else if (status == 2){
            total *= 300
        }
        total *= state
        if(dorm){
            total += 5000
        }
        if(dine){
            total += 2000
        }
        if(park){
            total += 1000
        }
        return total
    }
}