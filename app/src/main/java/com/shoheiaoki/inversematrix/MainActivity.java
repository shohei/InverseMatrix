package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import Jama.Matrix;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.twoBtn)
    protected void start22Activity(){
        Intent intent = new Intent(getApplicationContext(),Calc22Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.threeBtn)
    protected void start33Activity(){
        Intent intent = new Intent(getApplicationContext(),Calc33Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fourBtn)
    protected void start44Activity(){
        Intent intent = new Intent(getApplicationContext(),Calc44Activity.class);
        startActivity(intent);
    }


}
