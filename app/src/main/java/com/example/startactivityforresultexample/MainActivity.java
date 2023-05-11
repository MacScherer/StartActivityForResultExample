package com.example.startactivityforresultexample;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    TextView textViewRecieved;
    FloatingActionButton floatingActionButton;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result != null && result.getResultCode() == RESULT_OK){
                if (result.getData() != null && result.getData().getStringExtra(SecondActivity.KEY_NAME) != null){
                    textViewRecieved.setText(result.getData().getStringExtra(SecondActivity.KEY_NAME));
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textViewRecieved = findViewById(R.id.textViewRecieveText);

       findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                activityResultLauncher.launch(intent);
           }
       });
    }
}