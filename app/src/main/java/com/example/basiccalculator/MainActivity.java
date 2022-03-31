package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String Operator = "+", OldEqn = "";
    EditText eqn;
    Boolean isNewOperator = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eqn = findViewById(R.id.editText);
    }
    public void numberEvent(View view){
        if(isNewOperator)
            eqn.setText("");
        isNewOperator = false;
        String number = eqn.getText().toString();
        switch(view.getId()){
            case R.id.button1:
                number += 1;
                break;
            case R.id.button2:
                number += 2;
                break;
            case R.id.button3:
                number += 3;
                break;
            case R.id.button4:
                number += 4;
                break;
            case R.id.button5:
                number += 5;
                break;
            case R.id.button6:
                number += 6;
                break;
            case R.id.button7:
                number += 7;
                break;
            case R.id.button8:
                number += 8;
                break;
            case R.id.button9:
                number += 9;
                break;
            case R.id.button0:
                number += 0;
                break;
            case R.id.buttonDOT:
                number += ".";
                break;
            case R.id.buttonPLUSMINUS:
                number = "-" + number;
                break;
        }
        eqn.setText(number);
    }

    public void buttonEvent(View view){
        isNewOperator = true;
        OldEqn = eqn.getText().toString();
        switch(view.getId()){
            case R.id.buttonPLUS:
                Operator = "+";
                break;
            case R.id.buttonMINUS:
                Operator = "-";
                break;
            case R.id.buttonMULTIPLY:
                Operator = "*";
                break;
            case R.id.buttonDIVIDE:
                Operator = "/";
                break;
        }
    }
    public void equalEvent(View view){
        String NewEqn = eqn.getText().toString();
        double result = 0.0;
        switch(Operator){
            case "+":
                result = Double.parseDouble(OldEqn) + Double.parseDouble(NewEqn);
                break;
            case "-":
                result = Double.parseDouble(OldEqn) - Double.parseDouble(NewEqn);
                break;
            case "*":
                result = Double.parseDouble(OldEqn) * Double.parseDouble(NewEqn);
                break;
            case "/":
                result = Double.parseDouble(OldEqn) / Double.parseDouble(NewEqn);
                break;
        }
        eqn.setText(result + "");
    }
    public void acEvent(View view){
        eqn.setText("0");
        isNewOperator = true;
    }
    public void percentEvent(View view){
        double result = Double.parseDouble(eqn.getText().toString()) / 100;
        eqn.setText(result + "");
        isNewOperator = true;
    }
}