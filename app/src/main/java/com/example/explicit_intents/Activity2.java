package com.example.explicit_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv_welcome = findViewById(R.id.tv_welcome);

        String names = getIntent().getStringExtra("data");
         tv_welcome.setText(names +"Welcome to Activity 2");
    }
}
