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
        PLUS, MINUS, MULTIPLY, DIVIDE, EQUAL, NONE
    }

    ImageButton one, two, three,
            four, five, six,
            seven, eight, nine,
            zero,
            plus, subs, divide, multi, equal;
    Button clear;
    TextView txtEquation, txtNumber;
    String number = "";
    String mEquation = "";
    OPERATOR operator;
    long first = 0, second = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtNumber = findViewById(R.id.edt_number);
        txtEquation = findViewById(R.id.txtFullEquation);
        operator = OPERATOR.NONE;

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
        number = txtNumber.getText().toString().trim();
        mEquation = txtEquation.getText().toString().trim();
        if (operator == OPERATOR.EQUAL) {
            clearArea();
            operator = OPERATOR.NONE;
        }
        switch (view.getId()) {
            case R.id.one:
                setNumber(1 + "", true);
                break;
            case R.id.two:
                setNumber(2 + "", true);
                break;
            case R.id.three:
                setNumber(3 + "", true);
                break;
            case R.id.four:
                setNumber(4 + "", true);
                break;
            case R.id.five:
                setNumber(5 + "", true);
                break;
            case R.id.six:
                setNumber(6 + "", true);
                break;
            case R.id.seven:
                setNumber(7 + "", true);
                break;
            case R.id.eight:
                setNumber(8 + "", true);
                break;
            case R.id.nine:
                setNumber(9 + "", true);
                break;
            case R.id.zero:
                setNumber(0 + "", true);
                break;
            case R.id.plus:
                first = setFirst(txtNumber);
                setNumber("+", false);
                operator = OPERATOR.PLUS;
                break;
            case R.id.sub:
                first = setFirst(txtNumber);
                setNumber("-", false);
                operator = OPERATOR.MINUS;
                break;
            case R.id.multi:
                first = setFirst(txtNumber);
                setNumber("x", false);
                operator = OPERATOR.MULTIPLY;
                break;
            case R.id.divide:
                first = setFirst(txtNumber);
                setNumber("/", false);
                operator = OPERATOR.DIVIDE;
                break;
            case R.id.clearall:
                clearArea();
                break;
            case R.id.equal:
                second = setFirst(txtNumber);
                if (checkEquation()) {
                    switch (operator) {
                        case PLUS:
                            txtNumber.setText((first + second) + "");
                            break;
                        case MINUS:
                            txtNumber.setText((first - second) + "");
                            break;
                        case MULTIPLY:
                            txtNumber.setText((first * second) + "");
                            break;
                        case DIVIDE:
                            txtNumber.setText((first / second) + "");
                            break;
                    }
                    operator = OPERATOR.EQUAL;
                }
                break;
        }
    }

    private long setFirst(TextView view) {
        long number = 0;
        if (view.getText().toString().trim().equals("")) {
            number = 0;
        } else {
            number = Long.parseLong(view.getText().toString().trim());
        }
        return number;
    }

    private boolean checkEquation() {
        String current = "", previous = "";
        boolean isSign = false;
        boolean isCorrectEquation = true;
        int length = mEquation.length();
        for (int i = 0; i < length; i++) {
            current = String.valueOf(mEquation.charAt(i));
            final boolean x = current.equals("+") || current.equals("-") || current.equals("x") || current.equals("/");
            if (i == 0 && (x)) {
                isCorrectEquation = false;
                clearArea();
                break;
            } else if (i == (length - 1) && (x)) {
                isCorrectEquation = false;
                clearArea();
                break;

            } else if (x) {
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
        first = second = 0;
    }

    private void setNumber(String ch, boolean isfocus) {
        if (isfocus) {
            number += ch;
            mEquation += ch;
            txtNumber.setText(number);
            txtEquation.setText(mEquation);
        } else {
            txtNumber.setText("");
            mEquation += ch;
            txtEquation.setText(mEquation);
        }
    }
}
