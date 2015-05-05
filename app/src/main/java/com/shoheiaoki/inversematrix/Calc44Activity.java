package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Calc44Activity extends Activity {
    double matArr[][] = new double[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ButterKnife.inject(this);
    }

    @InjectView(R.id.four_11) EditText four_11;
    @InjectView(R.id.four_12) EditText four_12;
    @InjectView(R.id.four_13) EditText four_13;
    @InjectView(R.id.four_14) EditText four_14;
    @InjectView(R.id.four_21) EditText four_21;
    @InjectView(R.id.four_22) EditText four_22;
    @InjectView(R.id.four_23) EditText four_23;
    @InjectView(R.id.four_24) EditText four_24;
    @InjectView(R.id.four_31) EditText four_31;
    @InjectView(R.id.four_32) EditText four_32;
    @InjectView(R.id.four_33) EditText four_33;
    @InjectView(R.id.four_34) EditText four_34;
    @InjectView(R.id.four_41) EditText four_41;
    @InjectView(R.id.four_42) EditText four_42;
    @InjectView(R.id.four_43) EditText four_43;
    @InjectView(R.id.four_44) EditText four_44;

    @InjectView(R.id.four_11_ans) EditText four_11_ans;
    @InjectView(R.id.four_12_ans) EditText four_12_ans;
    @InjectView(R.id.four_13_ans) EditText four_13_ans;
    @InjectView(R.id.four_14_ans) EditText four_14_ans;
    @InjectView(R.id.four_21_ans) EditText four_21_ans;
    @InjectView(R.id.four_22_ans) EditText four_22_ans;
    @InjectView(R.id.four_23_ans) EditText four_23_ans;
    @InjectView(R.id.four_24_ans) EditText four_24_ans;
    @InjectView(R.id.four_31_ans) EditText four_31_ans;
    @InjectView(R.id.four_32_ans) EditText four_32_ans;
    @InjectView(R.id.four_33_ans) EditText four_33_ans;
    @InjectView(R.id.four_34_ans) EditText four_34_ans;
    @InjectView(R.id.four_41_ans) EditText four_41_ans;
    @InjectView(R.id.four_42_ans) EditText four_42_ans;
    @InjectView(R.id.four_43_ans) EditText four_43_ans;
    @InjectView(R.id.four_44_ans) EditText four_44_ans;

    @OnClick(R.id.invert44)
    protected void invertFour(){
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
