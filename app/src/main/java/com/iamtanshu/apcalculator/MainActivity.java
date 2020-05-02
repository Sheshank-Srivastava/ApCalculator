package com.iamtanshu.apcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, MINUS, MULTIPLY, DIVIDE, EQUAL
    }

    ImageButton one, two, three,
            four, five, six,
            seven, eight, nine,
            zero,
            plus, subs, divide, multi;
    Button clear;
    TextView txtEquation, txtNumber;
    String number = "";
    String mEquation = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtNumber = findViewById(R.id.edt_number);
        txtEquation = findViewById(R.id.txtFullEquation);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        clear = findViewById(R.id.clearall);
        plus = findViewById(R.id.plus);
        subs = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        divide = findViewById(R.id.divide);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        clear.setOnClickListener(this);
        plus.setOnClickListener(this);
        subs.setOnClickListener(this);
        multi.setOnClickListener(this);
        divide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        number = txtNumber.getText().toString().trim();
        mEquation = txtEquation.getText().toString().trim();
        switch (view.getId()) {
            case R.id.one:
                number += "1";
                mEquation += "1";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.two:
                number += "2";
                mEquation += "2";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.three:
                number += "3";
                mEquation += "3";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.four:
                number += "4";
                mEquation += "4";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.five:
                number += "5";
                mEquation += "5";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.six:
                number += "6";
                mEquation += "6";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.seven:
                number += "7";
                mEquation += "7";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.eight:
                number += "8";
                mEquation += "8";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.nine:
                number += "9";
                mEquation += "9";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.zero:
                number += "0";
                mEquation += "0";
                txtNumber.setText(number);
                txtEquation.setText(mEquation);
                break;
            case R.id.plus:
                txtNumber.setText("");
                mEquation += "+";
                txtEquation.setText(mEquation);
                break;
            case R.id.sub:
                txtNumber.setText("");
                mEquation += "-";
                txtEquation.setText(mEquation);

                break;
            case R.id.multi:
                txtNumber.setText("");
                mEquation += "x";
                txtEquation.setText(mEquation);
                break;
            case R.id.divide:
                txtNumber.setText("");
                mEquation += "/";
                txtEquation.setText(mEquation);
                break;
            case R.id.clearall:
                clearArea();
                break;
        }
    }

    private boolean checkEquation() {
        String current = "", previous = "";
        boolean isSign = false;
        boolean isCorrectEquation = true;
        for (int i = 0; i < mEquation.length(); i++) {
            current = String.valueOf(mEquation.charAt(i));
            if (i == 0 && (current.equals("+") || current.equals("-") || current.equals("x") || current.equals("/"))) {
                isCorrectEquation = false;
                clearArea();
                break;
            }
            if (current.equals("+") || current.equals("-") || current.equals("x") || current.equals("/")) {
                if (isSign) {
                    isCorrectEquation = false;
                    clearArea();
                    break;
                }
                isSign = true;
            } else {
                isSign = false;
            }
        }
        if (!isCorrectEquation)
            Toast.makeText(MainActivity.this, "Corrupet Equation", Toast.LENGTH_SHORT).show();
        return isCorrectEquation;
    }

    private void clearArea() {
        txtNumber.setText("");
        txtEquation.setText("");
        mEquation = number = "";
    }
}
