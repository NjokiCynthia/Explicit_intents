package com.example.explicit_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    Button btn_submit;
    EditText tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        tv_2 = findViewById(R.id.tv_2);
        btn_submit = findViewById(R.id.btn_submit_);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_2.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this, "Please enter the surname.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surname = tv_2.getText().toString().trim();
                    
                    Intent intent = new Intent();
                    intent.putExtra("data", surname);
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }

            }
        });
    }
}
