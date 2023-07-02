package edu.aceplora.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate: AppCompatButton = findViewById(R.id.btnCalculate)
        calculate.setOnClickListener { setValue() }
    }

    private fun setValue() {
        val weightText: TextInputEditText = findViewById(R.id.etWeight)
        val heightText: TextInputEditText = findViewById(R.id.etHeight)
        val bmiValue: TextView = findViewById(R.id.tvBMIValue)
        val bmiDescription : TextView = findViewById(R.id.tvBmiDesc)
        val bmiInfo : TextView = findViewById(R.id.tvBmiInfo)


        val weight = weightText.text.toString()
        val height = heightText.text.toString()

        when{
            weight.isEmpty() -> Toast.makeText(this, "Add a weight value", Toast.LENGTH_SHORT).show()
            height.isEmpty() -> Toast.makeText(this, "Add a height value", Toast.LENGTH_SHORT).show()
            else-> {
                val bmi = weight.toFloat() /(height.toFloat() * height.toFloat())
                var bmiText = ""
                when{
                    bmi < 18.50 -> bmiText = "Underweight"
                    bmi in 18.50..24.99 -> bmiText = "Healthy"
                    bmi in 25.00..29.99 -> bmiText = "Overweight"
                    bmi > 29.99 -> bmiText = "Obese"
                }
                // get result with two decimal places
                val bmi2Digits =  String.format("%.2f", bmi)
                bmiValue.text = getString(R.string.bmi_value, bmi2Digits)
                bmiInfo.text = "(Normal range is 18.5 - 24.9)"

                bmiDescription.text = bmiText
                
            }

        }

    }

    // TODO: Complete the following tasks...
    // 1. Calculate the BMI and display it.
    //    The BMI should be displayed in the middle
    // 2. Using a new textView: Tell the user of the app
    //    if they are overweight, under weight etc...
}


