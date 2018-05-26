package com.cs385.alancampbell.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.util.Random;

//The purpose of this Quiz.java file is to provide the make up of the quiz and what is carried out upon each users entry

//Created by Alan Campbell & Cathal McCabe

public class Quiz extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;                          // declaring and assigning buttons answers1,2,3,4

    TextView score, question;                                           // declaring and assigning textviews score, question

    private Questions mQuestions = new Questions ();

    private String mAnswer;
    private int mScore = 0;                                             // to keeps track of the score
    private int mQuestionLenght = mQuestions.mQuestions.length;
    private  int mQuestionNumber = 0;                                   // keeps track of the questions



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        answer1 = (Button) findViewById(R.id.answer1);              //answer 1 findView
        answer2 = (Button) findViewById(R.id.answer2);              //answer 2 findView
        answer3 = (Button) findViewById(R.id.answer3);              //answer 3 findView
        answer4 = (Button) findViewById(R.id.answer4);              //answer 4 findView

        score = (TextView) findViewById(R.id.score);                // score findView
        question = (TextView) findViewById(R.id.question);

        score.setText("Score: " + mScore);                          // displays score on screen, score will be updated each time

        updateQuestion();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                           // just for answer 1
                                                                     // if answer is correct update score
                if(answer1.getText() == mAnswer){
                    mScore++;                                       // if correct answer score plus 1

                    score.setText("Score: " + mScore);                                  // updates score on screen
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();    // displays a toast if correct answer
                    updateQuestion();
                }
                                                                                        // wrong answer use gameOver Method call
                else
                {
                    gameOver();                                                         // gameover method call
                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                               // same process as answer1 OnClickListener


                if(answer2.getText() == mAnswer){
                    mScore++;

                    score.setText("Score: " + mScore);
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }else {
                    gameOver();
                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(answer3.getText() == mAnswer){
                    mScore++;

                    score.setText("Score: " + mScore);
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }else {
                    gameOver();
                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(answer4.getText() == mAnswer){
                    mScore++;

                    score.setText("Score: " + mScore);
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }


                else {
                    gameOver();
                }

            }
        });


    }
    // method that updates the question and choices using a counter mQuestionNumber
    private void updateQuestion(){

        if(mScore == 10)                // if mscore gets to high end the game
        {
            gameOver();                 // gameover method call
        }
        else {                                                                  // else update to the next question
            question.setText(mQuestions.getQuestion(mQuestionNumber));          // loads up the correct question choice options
            answer1.setText(mQuestions.getChoice1(mQuestionNumber));            // loads up the multiple choice options
            answer2.setText(mQuestions.getChoice2(mQuestionNumber));
            answer3.setText(mQuestions.getChoice3(mQuestionNumber));
            answer4.setText(mQuestions.getChoice4(mQuestionNumber));

            mAnswer = mQuestions.getCorrectAnswer(mQuestionNumber);


            mQuestionNumber++;                                              // mQuestionNumber +1

        }


    }


    // gameover method used to create a gameover alert
    private void  gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);            // creates new dialog box for gameover for gameover
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points")                   // displays your score using mScore
                .setCancelable(false)
                // new game option restarts the quiz
                .setPositiveButton("New Game",                                                  // creates button for new game
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(),Quiz.class));  // new game button loads up
                                finish();
                            }
                        })
                // exit will return to main menu of app
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();;
                            }
                        }   );


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();                                                                     // shows the dialog box
    }

}
