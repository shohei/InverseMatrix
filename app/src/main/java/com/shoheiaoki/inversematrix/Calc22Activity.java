package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import Jama.Matrix;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Calc22Activity extends Activity {
    double[][] matArr = new double[2][2];
    EditText[][] input = new EditText[2][2];
    EditText[][] output = new EditText[2][2];
    Matrix invMat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.inject(this);
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
        getNumbers();
        invMat = calcInverseMatrix();
        putNumbers(invMat);
    }

    protected void getNumbers() {
        String num = null;
        int i, j;
        for (i = 0; i < matArr.length; i++) {
            for (j = 0; j < matArr[0].length; j++)
                synchronized (this) {
                    num = input[i][j].getText().toString();
                    if (num.equals("")) {
                        break;
                    } else {
                        matArr[i][j] = Double.parseDouble(num);
                    }
                }
        }
    }

    protected Matrix calcInverseMatrix() {
        Matrix mat = new Matrix(matArr);
        Matrix _invMat = mat.inverse();
        return _invMat;
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
