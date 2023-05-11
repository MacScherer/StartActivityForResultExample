package com.example.startactivityforresultexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText editTextToSend;
    public static final String KEY_NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextToSend = findViewById(R.id.editTextToSend);
        findViewById(R.id.buttonSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enterText = editTextToSend.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(KEY_NAME, enterText);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}