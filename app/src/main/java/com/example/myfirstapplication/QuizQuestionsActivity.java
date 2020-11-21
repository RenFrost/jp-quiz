package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizQuestionsActivity extends AppCompatActivity {

    Button b_answer1, b_answer2, b_answer3, b_answer4;

    ImageView iv_items;

    TextView tv;
    String st;

    List<Questions> list;

    Random r;

    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        r = new Random();

        Bundle Extra = getIntent().getExtras();
        String textView = Extra.getString("UserInput");

        tv=findViewById(R.id.UserInput);

        st=getIntent().getExtras().getString("UserInput");
        tv.setText(st);

        iv_items = (ImageView) findViewById(R.id.iv_items);

        b_answer1 = (Button) findViewById(R.id.b_answer1);
        b_answer2 = (Button) findViewById(R.id.b_answer2);
        b_answer3 = (Button) findViewById(R.id.b_answer3);
        b_answer4 = (Button) findViewById(R.id.b_answer4);

        list = new ArrayList<>();

        for(int i = 0; i < new Database().answers.length; i++) {
            list.add(new Questions(new Database().answers[i], new Database().items[i]));
        }

        //shuffle the items
        Collections.shuffle(list);

        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(QuizQuestionsActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizQuestionsActivity.this, "You have finished the game!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuizQuestionsActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(QuizQuestionsActivity.this, "You lost the game!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(QuizQuestionsActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizQuestionsActivity.this, "You have finished the game!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuizQuestionsActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(QuizQuestionsActivity.this, "You lost the game!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(QuizQuestionsActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizQuestionsActivity.this, "You have finished the game!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuizQuestionsActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(QuizQuestionsActivity.this, "You lost the game!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(QuizQuestionsActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizQuestionsActivity.this, "You have finished the game!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuizQuestionsActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(QuizQuestionsActivity.this, "You lost the game!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });


    }

    private void newQuestion(int number){
        iv_items.setImageResource(list.get(number - 1).getImage());

        //to decide which button to place the correct answer
        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correct_answer) {
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());

                break;
            case 2:

                b_answer2.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer1.setText(list.get(firstButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:

                b_answer3.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(firstButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:

                b_answer4.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                } while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(firstButton).getName());
                break;

        }


    }
}