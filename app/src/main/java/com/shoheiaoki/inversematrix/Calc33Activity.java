package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import Jama.Matrix;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Calc33Activity extends Activity {
    double matArr[][];
    EditText[][] input = new EditText[3][3];
    EditText[][] output = new EditText[3][3];
    Matrix invMat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.inject(this);
        initWidgets();
    }

    @InjectView(R.id.three_11)
    EditText three_11;
    @InjectView(R.id.three_12)
    EditText three_12;
    @InjectView(R.id.three_13)
    EditText three_13;
    @InjectView(R.id.three_21)
    EditText three_21;
    @InjectView(R.id.three_22)
    EditText three_22;
    @InjectView(R.id.three_23)
    EditText three_23;
    @InjectView(R.id.three_31)
    EditText three_31;
    @InjectView(R.id.three_32)
    EditText three_32;
    @InjectView(R.id.three_33)
    EditText three_33;

    @InjectView(R.id.three_11_ans)
    EditText three_11_ans;
    @InjectView(R.id.three_12_ans)
    EditText three_12_ans;
    @InjectView(R.id.three_13_ans)
    EditText three_13_ans;
    @InjectView(R.id.three_21_ans)
    EditText three_21_ans;
    @InjectView(R.id.three_22_ans)
    EditText three_22_ans;
    @InjectView(R.id.three_23_ans)
    EditText three_23_ans;
    @InjectView(R.id.three_31_ans)
    EditText three_31_ans;
    @InjectView(R.id.three_32_ans)
    EditText three_32_ans;
    @InjectView(R.id.three_33_ans)
    EditText three_33_ans;

    protected void initWidgets() {
        input[0][0] = three_11;
        input[0][1] = three_12;
        input[0][2] = three_13;
        input[1][0] = three_21;
        input[1][1] = three_22;
        input[1][2] = three_23;
        input[2][0] = three_31;
        input[2][1] = three_32;
        input[2][2] = three_33;

        output[0][0] = three_11_ans;
        output[0][1] = three_12_ans;
        output[0][2] = three_13_ans;
        output[1][0] = three_21_ans;
        output[1][1] = three_22_ans;
        output[1][2] = three_23_ans;
        output[2][0] = three_31_ans;
        output[2][1] = three_32_ans;
        output[2][2] = three_33_ans;
    }

    @OnClick(R.id.invert33)
    protected void invertThree() {
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
        matArr = new double[3][3];
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
                    ans = (double) _invMat.get(i, j);
                    output[i][j].setText(String.valueOf(String.valueOf(ans)));
                }
            }
        }
    }

}
