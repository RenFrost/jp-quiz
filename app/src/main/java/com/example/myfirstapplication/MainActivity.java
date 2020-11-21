package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.jar.Attributes;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    Button btnStart;

    AppCompatEditText et;

    String st;


    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        et=findViewById(R.id.et_name); // declare your editText

        btnStart = (Button) findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayName = new Intent(MainActivity.this, QuizQuestionsActivity.class);
                st=et.getText().toString();
                displayName.putExtra("UserInput",st);
                startActivity(displayName);
                finish();
            }
                });


        };
    }
