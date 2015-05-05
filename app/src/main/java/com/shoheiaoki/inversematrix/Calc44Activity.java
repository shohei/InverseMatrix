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

public class Calc44Activity extends Activity {
    double matArr[][];
    EditText[][] input = new EditText[4][4];
    EditText[][] output = new EditText[4][4];
    Matrix invMat;
    private LinearLayout mainLayout;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ButterKnife.inject(this);
        initWidgets();
        mainLayout = (LinearLayout)findViewById(R.id.fourLayout);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @InjectView(R.id.four_11)
    EditText four_11;
    @InjectView(R.id.four_12)
    EditText four_12;
    @InjectView(R.id.four_13)
    EditText four_13;
    @InjectView(R.id.four_14)
    EditText four_14;
    @InjectView(R.id.four_21)
    EditText four_21;
    @InjectView(R.id.four_22)
    EditText four_22;
    @InjectView(R.id.four_23)
    EditText four_23;
    @InjectView(R.id.four_24)
    EditText four_24;
    @InjectView(R.id.four_31)
    EditText four_31;
    @InjectView(R.id.four_32)
    EditText four_32;
    @InjectView(R.id.four_33)
    EditText four_33;
    @InjectView(R.id.four_34)
    EditText four_34;
    @InjectView(R.id.four_41)
    EditText four_41;
    @InjectView(R.id.four_42)
    EditText four_42;
    @InjectView(R.id.four_43)
    EditText four_43;
    @InjectView(R.id.four_44)
    EditText four_44;

    @InjectView(R.id.four_11_ans)
    EditText four_11_ans;
    @InjectView(R.id.four_12_ans)
    EditText four_12_ans;
    @InjectView(R.id.four_13_ans)
    EditText four_13_ans;
    @InjectView(R.id.four_14_ans)
    EditText four_14_ans;
    @InjectView(R.id.four_21_ans)
    EditText four_21_ans;
    @InjectView(R.id.four_22_ans)
    EditText four_22_ans;
    @InjectView(R.id.four_23_ans)
    EditText four_23_ans;
    @InjectView(R.id.four_24_ans)
    EditText four_24_ans;
    @InjectView(R.id.four_31_ans)
    EditText four_31_ans;
    @InjectView(R.id.four_32_ans)
    EditText four_32_ans;
    @InjectView(R.id.four_33_ans)
    EditText four_33_ans;
    @InjectView(R.id.four_34_ans)
    EditText four_34_ans;
    @InjectView(R.id.four_41_ans)
    EditText four_41_ans;
    @InjectView(R.id.four_42_ans)
    EditText four_42_ans;
    @InjectView(R.id.four_43_ans)
    EditText four_43_ans;
    @InjectView(R.id.four_44_ans)
    EditText four_44_ans;

    protected void initWidgets() {
        input[0][0] = four_11;
        input[0][1] = four_12;
        input[0][2] = four_13;
        input[0][3] = four_14;
        input[1][0] = four_21;
        input[1][1] = four_22;
        input[1][2] = four_23;
        input[1][3] = four_24;
        input[2][0] = four_31;
        input[2][1] = four_32;
        input[2][2] = four_33;
        input[2][3] = four_34;
        input[3][0] = four_41;
        input[3][1] = four_42;
        input[3][2] = four_43;
        input[3][3] = four_44;

        output[0][0] = four_11_ans;
        output[0][1] = four_12_ans;
        output[0][2] = four_13_ans;
        output[0][3] = four_14_ans;
        output[1][0] = four_21_ans;
        output[1][1] = four_22_ans;
        output[1][2] = four_23_ans;
        output[1][3] = four_24_ans;
        output[2][0] = four_31_ans;
        output[2][1] = four_32_ans;
        output[2][2] = four_33_ans;
        output[2][3] = four_34_ans;
        output[3][0] = four_41_ans;
        output[3][1] = four_42_ans;
        output[3][2] = four_43_ans;
        output[3][3] = four_44_ans;
    }

    @OnClick(R.id.invert44)
    protected void invertFour() {
        inputMethodManager.hideSoftInputFromWindow(mainLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        mainLayout.requestFocus();
        getNumbers();
        try {
            invMat = calcInverseMatrix();
            putNumbers(invMat);
        } catch (IOException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Singular Matrix", Toast.LENGTH_LONG).show();
        }
    }

    protected void getNumbers() {
        matArr = new double[4][4];
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
