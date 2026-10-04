package com.example.q55

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calc(view: View) {
        //read loan amount
        var creditText : EditText = findViewById(R.id.credits)
        var creditString : String = creditText.getText().toString()

        var credit: Int
        try
        {
            credit = creditString.toInt()
        }
        catch (e: NumberFormatException)
        {
            credit = 0
        }

        //determine which radio button is checked
        var statusGroup: RadioGroup = findViewById(R.id.statusGroup)
        var idStatus: Int = statusGroup.checkedRadioButtonId

        var status = 0
        if (idStatus == R.id.grad)
            status = 0
        else if (idStatus == R.id.under)
            status = 1
        else if (idStatus == R.id.non)
            status = 2

        //determine which radio button is checked
        var stateGroup: RadioGroup = findViewById(R.id.stateGroup)
        var idState: Int = stateGroup.checkedRadioButtonId

        var state = 1
        if (idState == R.id.inState)
            state = 1
        else if (idState == R.id.out)
            state = 2

        //checks the optional expenses
        var dorm: CheckBox = findViewById(R.id.dorm)
        var dine: CheckBox = findViewById(R.id.dining)
        var park: CheckBox = findViewById(R.id.parking)

        //creates the Calculator object to add up the cost
        var calc = Calculator(park.isChecked, dine.isChecked, dorm.isChecked, state, status, credit)

        var output: TextView = findViewById(R.id.output)
        output.setText(calc.calc().toString())
    }


}