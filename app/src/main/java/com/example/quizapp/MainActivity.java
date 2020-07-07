package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ScrollView scroll;
    private RadioGroup radioGroupOne;
    private RadioGroup radioGroupTwo;
    private RadioGroup radioGroupThree;
    private RadioGroup radioGroupFour;
    private RadioGroup radioGroupFive;
    private RadioButton question1;
    private RadioButton question2;
    private RadioButton question3;
    private RadioButton question4;
    private RadioButton question7;
    private CheckBox question8_1;
    private CheckBox question8_2;
    private CheckBox question8_4;
    private CheckBox wrongAnswerEight;
    private EditText question5;
    private EditText question6;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = (ScrollView) findViewById(R.id.Scroll);

        question1 = (RadioButton) findViewById(R.id.rb_CorrectAnswerOne);
        question2 = (RadioButton) findViewById(R.id.rb_CorrectAnswerTwo);
        question3 = (RadioButton) findViewById(R.id.rb_CorrectAnswerThree);
        question4 = (RadioButton) findViewById(R.id.rb_CorrectAnswerFour);
        question5 = (EditText) findViewById(R.id.userResponse_AnswerFive);
        question6 = (EditText) findViewById(R.id.userResponse_AnswerSix);
        question7 = (RadioButton) findViewById(R.id.rb_CorrectAnswerSeven);
        question8_1 = (CheckBox) findViewById(R.id.cb_CorrectAnswerEight_1);
        question8_2 = (CheckBox) findViewById(R.id.cb_CorrectAnswerEight_2);
        question8_4 = (CheckBox) findViewById(R.id.cb_CorrectAnswerEight_3);

        wrongAnswerEight = (CheckBox) findViewById(R.id.cb_WrongAnswerEight);
        radioGroupOne = (RadioGroup) findViewById(R.id.radioGroupOne);
        radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);
        radioGroupThree = (RadioGroup) findViewById(R.id.radioGroupThree);
        radioGroupFour = (RadioGroup) findViewById(R.id.radioGroupFour);
        radioGroupFive = (RadioGroup) findViewById(R.id.radioGroupFive);

    }

    public void SubmitResponse(View v) {

        String answerFive = getResources().getString(R.string.AnswerFive);
        String answerSix = getResources().getString(R.string.AnswerSix);
        String wrongAnswers = "Check this question and try again :-\n";
        if (question1.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 1\n";
        }
        if (question2.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 2\n";
        }
        if (question3.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 3\n";
        }

        if (question4.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 4\n";
        }

        if (answerFive.equals(question5.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 5\n";
        }

        if (answerSix.equals(question6.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 6\n";
        }

        if (question7.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 7\n";
        }

        if (question8_1.isChecked() && question8_2.isChecked() && question8_4.isChecked() && !(wrongAnswerEight.isChecked())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 8\n";
        }


        if (correctAnswers == 8) {
            Toast.makeText(this, "Congrats, All Answers Correct  \n Thanks for attempting this Quiz ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + " /8\n" + wrongAnswers, Toast.LENGTH_LONG).show();
        }

        ResetQuiz(findViewById(R.id.all));

    }

    public void ResetQuiz(View v) {

        correctAnswers = 0;

        question5.getText().clear();
        question6.getText().clear();

        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();
        radioGroupFive.clearCheck();

        if (question8_1.isChecked()) {
            question8_1.toggle();
        }

        if (question8_2.isChecked()) {
            question8_2.toggle();
        }

        if (question8_4.isChecked()) {
            question8_4.toggle();
        }

        if (wrongAnswerEight.isChecked()) {
            wrongAnswerEight.toggle();
        }

        scroll.fullScroll(ScrollView.FOCUS_UP);
    }
}