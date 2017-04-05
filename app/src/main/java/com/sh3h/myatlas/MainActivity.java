package com.sh3h.myatlas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//import com.sh3h.mybundle.ui.FirstActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //Intent intent = new Intent(this, FirstActivity.class);
        //startActivity(intent);
        Intent intent = new Intent();
        intent.setClassName(this, "com.sh3h.mybundle.ui.FirstActivity");
        startActivity(intent);
    }
}
