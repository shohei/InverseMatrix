package com.shoheiaoki.inversematrix;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class Calc44Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ButterKnife.inject(this);
    }
}
