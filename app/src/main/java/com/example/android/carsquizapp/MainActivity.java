package com.example.android.carsquizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.String;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialization Question 1
    RadioButton radioButtonQuestionOneAnswerOne;

    //Initialization Question 2
    CheckBox checkBoxQuestionTwoAnswerOne;
    CheckBox checkBoxQuestionTwoAnswerThree;

    //Initialization Question 3
    RadioButton radioButtonQuestionThreeAnswerTwo;

    //Initialization Question 4
    RadioButton radioButtonQuestionFourAnswerTwo;


    //Initialization Question 5
    RadioButton radioButtonQuestionFiveAnswerOne;

    //Initialization Question 6
    CheckBox checkBoxQuestionSixAnswerTwo;

    //Initialization Question 7
    EditText favouriteCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //variable to keep the overall score.
    int score = 0;

    /*
    *   Method that submits the answers. OnClick method of the Submit Score Button.
     */
    public void submitScore(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        radioButtonQuestionOneAnswerOne = (RadioButton) findViewById(R.id.radio_button_q1a1);
        boolean questionOneCorrect = radioButtonQuestionOneAnswerOne.isChecked();

        checkBoxQuestionTwoAnswerOne = (CheckBox) findViewById(R.id.check_box_q2a1);
        boolean questionTwoCorrectAnswerOne = checkBoxQuestionTwoAnswerOne.isChecked();

        checkBoxQuestionTwoAnswerThree = (CheckBox) findViewById(R.id.check_box_q2a3);
        boolean questionTwoCorrectAnswerThree = checkBoxQuestionTwoAnswerThree.isChecked();

        radioButtonQuestionThreeAnswerTwo = (RadioButton) findViewById(R.id.radio_button_q3a2);
        boolean questionThreeCorrect = radioButtonQuestionThreeAnswerTwo.isChecked();

        radioButtonQuestionFourAnswerTwo = (RadioButton) findViewById(R.id.radio_button_q4a2);
        boolean questionFourCorrecct = radioButtonQuestionFourAnswerTwo.isChecked();

        radioButtonQuestionFiveAnswerOne = (RadioButton) findViewById(R.id.radio_button_q5a1);
        boolean questionFiveCorrect = radioButtonQuestionFiveAnswerOne.isChecked();

        checkBoxQuestionSixAnswerTwo = (CheckBox) findViewById(R.id.check_box_q6a2);
        boolean questionSixCorrect = checkBoxQuestionSixAnswerTwo.isChecked();

        favouriteCharacter = (EditText) findViewById(R.id.insert_favourite_character);
        String favouriteChar = favouriteCharacter.getText().toString();

        int score = calculateScore(questionOneCorrect, questionTwoCorrectAnswerOne, questionTwoCorrectAnswerThree, questionThreeCorrect, questionFourCorrecct, questionFiveCorrect, questionSixCorrect, favouriteChar);

        displayScore(score);

        if (score == 8) {
            Context context = getApplicationContext();
            CharSequence text = "You got the highest score!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (score <= 7) {
            Context context = getApplicationContext();
            CharSequence text = "You did well, try again for the highest score!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /*
    * This method calculates the score.
     */
    private int calculateScore(boolean questionOneCorrect, boolean questionTwoCorrectAnswerOne, boolean questionTwoCorrectAnswerThree, boolean questionThreeCorrect, boolean questionFourCorrect, boolean questionFiveCorrect, boolean questionSixCorrect, String favouriteChar) {
        //question 1
        if (questionOneCorrect) {
            score++;
        }
        //question 2
        if (questionTwoCorrectAnswerOne) {
            score++;
        }
        //question 2
        if (questionTwoCorrectAnswerThree) {
            score++;
        }
        //question 3
        if (questionThreeCorrect) {
            score++;
        }
        //question 4
        if (questionFourCorrect) {
            score++;
        }
        //question 5
        if (questionFiveCorrect) {
            score++;
        }
        //question 6
        if (questionSixCorrect) {
            score++;
        }
        //question 7
        if (favouriteChar.equals("Bliksem")) {
            score++;
        }
        return score;
    }


    /*
    * This method displays the score.
     */
    public String displayScore(int score) {
        String scoreMessage = "You scored " + score + "points!";
        TextView scoreText = (TextView) findViewById(R.id.score_text_view);
        scoreText.setText(scoreMessage);
        return scoreMessage;
   }

}
