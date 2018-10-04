package com.example.adagiom.smsinst;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Device extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
    }
    public void volver(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
