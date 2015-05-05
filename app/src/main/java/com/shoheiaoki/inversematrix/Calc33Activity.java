package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Calc33Activity extends Activity{
    double matArr[][] = new double[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.inject(this);
    }

    @InjectView(R.id.three_11) EditText three_11;
    @InjectView(R.id.three_12) EditText three_12;
    @InjectView(R.id.three_13) EditText three_13;
    @InjectView(R.id.three_21) EditText three_21;
    @InjectView(R.id.three_22) EditText three_22;
    @InjectView(R.id.three_23) EditText three_23;
    @InjectView(R.id.three_31) EditText three_31;
    @InjectView(R.id.three_32) EditText three_32;
    @InjectView(R.id.three_33) EditText three_33;

    @InjectView(R.id.three_11_ans) EditText three_11_ans;
    @InjectView(R.id.three_12_ans) EditText three_12_ans;
    @InjectView(R.id.three_13_ans) EditText three_13_ans;
    @InjectView(R.id.three_21_ans) EditText three_21_ans;
    @InjectView(R.id.three_22_ans) EditText three_22_ans;
    @InjectView(R.id.three_23_ans) EditText three_23_ans;
    @InjectView(R.id.three_31_ans) EditText three_31_ans;
    @InjectView(R.id.three_32_ans) EditText three_32_ans;
    @InjectView(R.id.three_33_ans) EditText three_33_ans;

    @OnClick(R.id.invert33)
    protected void invertThree(){
        getNumbers();
        putNumbers();
    }

    protected void getNumbers(){
        for (int i=0;i<matArr.length;i++){
            for(int j=0;j<matArr[0].length;j++)
                matArr[i][j] = j;
        }
        for (double[] m : matArr){
            for(double a: m) {
                Log.v("check if inserted", String.valueOf(a));
            }
        }
    }

    protected void putNumbers(){

    }

}
