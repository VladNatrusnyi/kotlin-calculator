package com.example.mycalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var Myintent: Intent?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber = findViewById(R.id.editText) as EditText
        val inputNumberTwo = findViewById(R.id.editText2) as EditText
        val result = findViewById(R.id.textView3) as TextView
        val btnAdd = findViewById(R.id.button) as Button
        val btnMinus = findViewById(R.id.button2) as Button
        val btnMul = findViewById(R.id.button3) as Button
        val btnDiv = findViewById(R.id.button4) as Button
        val btnToRes = findViewById(R.id.button5) as Button
        val btnClear = findViewById(R.id.button6) as Button

        val Myintent = Intent(this, ResultActivity::class.java)

        btnAdd.setOnClickListener {
            if(inputNumber.text.toString() != "" && inputNumberTwo.text.toString() != "") {
                val res = (getNumber() + getNumberTwo()).toInt().toString()
                result.text = res
                Myintent.putExtra("Res", res)
                startActivity(Myintent)
            } else {
                result.text = "Unable to perform calculation"
            }
        }
        btnMinus.setOnClickListener {
            if(inputNumber.text.toString() != "" && inputNumberTwo.text.toString() != "") {
                val res = (getNumber() - getNumberTwo()).toInt().toString()
                result.text = res
                Myintent.putExtra("Res", res)
                startActivity(Myintent)
            } else {
                result.text = "Unable to perform calculation"
            }
        }
        btnMul.setOnClickListener {
            if(inputNumber.text.toString() != "" && inputNumberTwo.text.toString() != "") {
                val res = (getNumber() * getNumberTwo()).toInt().toString()
                result.text = res
                Myintent.putExtra("Res", res)
                startActivity(Myintent)
            } else {
                result.text = "Unable to perform calculation"
            }
        }
        btnDiv.setOnClickListener {
            if(inputNumber.text.toString() != "" && inputNumberTwo.text.toString() != "") {
                if (getNumberTwo() != 0.toFloat()) {
                    val res = (getNumber() / getNumberTwo()).toString()
                    result.text = res
                    Myintent.putExtra("Res", res)
                    startActivity(Myintent)
                } else {
                    val res = "Сannot be divided by zero"
                    result.text = res
                    Myintent.putExtra("Res", res)
                    startActivity(Myintent)
                }
            } else {
                result.text = "Unable to perform calculation"
            }
        }
        btnToRes.setOnClickListener {
            var value = ""
            if (result.text.toString() != "") {
                value = result.text.toString()
            } else {
                value =  "No result"
            }
            Myintent.putExtra("Res", value)
            startActivity(Myintent)
        }
        btnClear.setOnClickListener {
            inputNumber.setText("")
            inputNumberTwo.setText("")
            result.text = ""
        }
    }


    fun getNumber() : Float{
        val inputNumber = findViewById(R.id.editText) as EditText
        val value: Float = inputNumber.text.toString().toFloat()
        return value
    }

    fun getNumberTwo() : Float{
        val inputNumberTwo = findViewById(R.id.editText2) as EditText
        val value: Float = inputNumberTwo.text.toString().toFloat()
        return value
    }

}


