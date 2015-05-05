package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.math.BigDecimal;

import Jama.Matrix;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Calc22Activity extends Activity {
    double[][] matArr;
    EditText[][] input = new EditText[2][2];
    EditText[][] output = new EditText[2][2];
    Matrix invMat;
    private LinearLayout mainLayout;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.inject(this);
        mainLayout = (LinearLayout)findViewById(R.id.twoLayout);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        initWidgets();
    }

    @InjectView(R.id.two_11)
    EditText two_11;
    @InjectView(R.id.two_12)
    EditText two_12;
    @InjectView(R.id.two_21)
    EditText two_21;
    @InjectView(R.id.two_22)
    EditText two_22;

    @InjectView(R.id.two_11_ans)
    EditText two_11_ans;
    @InjectView(R.id.two_12_ans)
    EditText two_12_ans;
    @InjectView(R.id.two_21_ans)
    EditText two_21_ans;
    @InjectView(R.id.two_22_ans)
    EditText two_22_ans;

    protected void initWidgets() {
        input[0][0] = two_11;
        input[0][1] = two_12;
        input[1][0] = two_21;
        input[1][1] = two_22;

        output[0][0] = two_11_ans;
        output[0][1] = two_12_ans;
        output[1][0] = two_21_ans;
        output[1][1] = two_22_ans;
    }


    @OnClick(R.id.invert22)
    protected void invertTwo() {
        inputMethodManager.hideSoftInputFromWindow(mainLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        mainLayout.requestFocus();
        getNumbers();
        try {
            invMat = calcInverseMatrix();
            putNumbers(invMat);
        } catch (IOException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Singular Matrix",Toast.LENGTH_LONG).show();
        }
    }

    protected void getNumbers() {
        matArr = new double[2][2];
        String num = null;
        int i, j;
        for (i = 0; i < matArr.length; i++) {
            for (j = 0; j < matArr[0].length; j++)
                synchronized (this) {
                    num = input[i][j].getText().toString();
                    if (num.equals("")) {
                        continue;
                    } else {
                        matArr[i][j] = Double.parseDouble(num);
                    }
                }
        }
    }

    protected Matrix calcInverseMatrix() throws IOException{
        Matrix mat = new Matrix(matArr);
        try {
            Matrix _invMat = mat.inverse();
            return _invMat;
        } catch (RuntimeException e){
            throw new IOException();
        }
    }

    protected void putNumbers(Matrix _invMat) {
        double ans;
        for (int i = 0; i < matArr.length; i++) {
            for (int j = 0; j < matArr[0].length; j++) {
                synchronized (this) {
                    ans = _invMat.get(i, j);
                    BigDecimal bd = new BigDecimal(ans);
                    BigDecimal bd_rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
                    output[i][j].setText(String.valueOf(String.valueOf(bd_rounded)));
                }
            }
        }
    }

}
