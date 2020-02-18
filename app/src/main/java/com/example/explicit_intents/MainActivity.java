package com.example.explicit_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button btn1_id, btn2_id;
    TextView tv_results;

    final int Activity3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        btn1_id = findViewById(R.id.btn1_id);
        btn2_id = findViewById(R.id.btn2_id);
        tv_results = findViewById(R.id.tv_results);

        btn1_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please fill in the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String names = name.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this,
                                               com.example.explicit_intents.Activity2.class );
                    intent.putExtra("data", names);

                    startActivity(intent);
                }
            }
        });
        btn2_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                                           com.example.explicit_intents.Activity3.class);
                startActivityForResult(intent, Activity3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Activity3) {
            if (requestCode == RESULT_OK)
            {
                tv_results.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED){
                tv_results.setText("No data received.");

            }
        }
    }
}
