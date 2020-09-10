package com.example.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var current_result = 0 //the current overall result
    var current_Display= "" //the current value displayed
    var last_operator="" //the last pressed operator
    var last_string ="" //the last string
    var first_digit=true //check if it is the first digit of the number
    var first_pressed = false //check if it is the first time to press an operator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Numbers
        val buttonList_number = listOf<Button>(one,two,three,four,five,six,seven,eight,nine,zero)
        buttonList_number.map{button -> button.setOnClickListener{appendOnExpression(button.getText().toString(), true) }}
        val buttonList_operator = listOf<Button>(plus, minus, equals)
        buttonList_operator.map{button -> button.setOnClickListener{appendOnExpression(button.getText().toString(),false)}}
        equals.setOnLongClickListener{
            answer.text="0"
            current_result = 0
            current_Display= "0"
            last_operator=""
            last_string =""
            first_digit=true
            first_pressed = false
            plus.setBackgroundColor(Color.GRAY)

            minus.setBackgroundColor(Color.GRAY)

            Toast.makeText(this, "Clear All", Toast.LENGTH_SHORT).show()
            true
        }
    }

    fun appendOnExpression(string: String, number: Boolean){
        minus.setBackgroundColor(Color.GRAY)
        plus.setBackgroundColor(Color.GRAY)
        if(number){
            if(first_digit){
                current_Display=""
                first_digit=false
            }

            current_Display += string
            if(last_operator =="="){
                current_result=current_Display.toInt()
            }
        }//if a number button pressed
        else{
            if(string=="+"){
                plus.setBackgroundColor(Color.YELLOW)
            }//change the color of plus button
            if(string=="-"){
                minus.setBackgroundColor(Color.YELLOW)
            }//change the color of minus button
            if(!first_pressed){
                current_result=current_Display.toInt()
                first_pressed=true
            }
            if(last_string==last_operator){
                current_Display=current_result.toString()
            }
            else if(last_operator=="+"){
                current_result+=current_Display.toInt()
                current_Display=current_result.toString()
            }
            else if(last_operator=="-"){
                current_result-=current_Display.toInt()
                current_Display=current_result.toString()
            }

            last_operator=string

            first_digit=true
        }//operator or equal button pressed
        answer.text=current_Display
        last_string =string
    }
}
