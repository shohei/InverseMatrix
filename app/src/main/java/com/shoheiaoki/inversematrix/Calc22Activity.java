package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Calc22Activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.inject(this);
    }
    @InjectView(R.id.two_11) EditText two_11;
    @InjectView(R.id.two_12) EditText two_12;
    @InjectView(R.id.two_21) EditText two_21;
    @InjectView(R.id.two_22) EditText two_22;

    @InjectView(R.id.two_11_ans) EditText two_11_ans;
    @InjectView(R.id.two_12_ans) EditText two_12_ans;
    @InjectView(R.id.two_21_ans) EditText two_21_ans;
    @InjectView(R.id.two_22_ans) EditText two_22_ans;

    @OnClick(R.id.invert22)
    protected void invertTwo(){

    }

}
