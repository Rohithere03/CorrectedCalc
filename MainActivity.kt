package com.example.correctedcalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.etFirstNumber)
        val secondNumber = findViewById<EditText>(R.id.etSecondNumber)
        val resultView = findViewById<TextView>(R.id.tvResult)

        fun calculate(operation: (Double, Double) -> Double) {
            val num1 = firstNumber.text.toString().toDoubleOrNull()
            val num2 = secondNumber.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                resultView.text = "Please enter valid numbers"
            } else {
                resultView.text = "Result: ${operation(num1, num2)}"
            }
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { calculate { a, b -> a + b } }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { calculate { a, b -> a - b } }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { calculate { a, b -> a * b } }
        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            if (secondNumber.text.toString() == "0") {
                resultView.text = "Cannot be divided by zero"
            } else {
                calculate { a, b -> a / b }
            }
        }
    }
}
