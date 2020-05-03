package com.iamtanshu.apcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, MINUS, MULTIPLY, DIVIDE, EQUAL, NONE
    }

    ImageButton one, two, three,
            four, five, six,
            seven, eight, nine,
            zero,
            plus, subs, divide, multi, equal;
    Button clear;
    TextView txtEquation, txtNumber;

    //Instance Variable
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationResult;

    private String calculationString;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResult = 0;
        calculationString = "";

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
        equal = findViewById(R.id.equal);

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
        equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                numberIsTapped(1);
                break;
            case R.id.two:
                numberIsTapped(2);
                break;
            case R.id.three:
                numberIsTapped(3);
                break;
            case R.id.four:
                numberIsTapped(4);
                break;
            case R.id.five:
                numberIsTapped(5);
                break;
            case R.id.six:
                numberIsTapped(6);
                break;
            case R.id.seven:
                numberIsTapped(7);
                break;
            case R.id.eight:
                numberIsTapped(8);
                break;
            case R.id.nine:
                numberIsTapped(9);
                break;
            case R.id.zero:
                numberIsTapped(0);
                break;
            case R.id.plus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationString += " + ";
                break;
            case R.id.sub:
                operatorIsTapped(OPERATOR.MINUS);
                calculationString += " - ";
                break;
            case R.id.multi:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationString += " * ";

                break;
            case R.id.divide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationString += " / ";

                break;
            case R.id.clearall:
                txtNumber.setText("");
                txtEquation.setText("");
                currentNumber = "";
                calculationResult = 0;
                calculationString = "";
                break;
            case R.id.equal:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
        }
        txtEquation.setText(calculationString);
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtNumber.setText(currentNumber);
        calculationString = currentNumber;
        txtEquation.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR operator) {
        if (currentOperator != null) {
            if (currentNumber != "") {


                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case MINUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) -
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) *
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) /
                                Integer.parseInt(stringNumberAtRight);
                        break;
                }

                stringNumberAtLeft = String.valueOf(calculationResult);
                txtNumber.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;
            }
        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = operator;
    }
}
