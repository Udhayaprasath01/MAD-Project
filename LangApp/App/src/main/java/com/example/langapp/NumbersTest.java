package com.example.langapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersTest extends AppCompatActivity {

    Button buttonA, buttonB, buttonC, buttonD;
    TextView questionText, quizText, timeText, resultText, coinText;
    Question currentQuestion;
    List<Question> list;
    int qid = 0;
    int coinValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_test);

        //Initializing variables
        questionText = (TextView) findViewById(R.id.triviaQuestion);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        quizText = (TextView) findViewById(R.id.quizText);
        timeText = (TextView) findViewById(R.id.timeText);
        resultText = (TextView) findViewById(R.id.resultText);
        coinText = (TextView) findViewById(R.id.coinText);

        quizText.setText("Numbers");

        //This will return us a list of data type TriviaQuestion
        list = new ArrayList<Question>();
        list.add(new Question("one", "lutti", "tolookosu", "kenekaku","wo’e","lutti"));
        list.add(new Question("two", "otiiko", "wo’e", "kenekaku","oyyisa","otiiko"));
        list.add(new Question("three", "oyyisa", "tolookosu", "wo’e","kawinta", "tolookosu"));
        list.add(new Question("four", "kenekaku", "otiiko", "massokka","oyyisa", "oyyisa"));
        list.add(new Question("five", "temmokka", "otiiko", "massokka","wo’e","massokka"));
        list.add(new Question("six", "temmokka", "otiiko","massokka", "wo’e","temmokka"));
        list.add(new Question("seven","temmokka", "kenekaku", "otiiko",  "wo’e","kenekaku"));
        list.add(new Question("eight", "wo’e", "kawinta", "otiiko", "na’aacha","kawinta"));
        list.add(new Question("nine", "wo’e", "temmokka", "otiiko", "massokka","wo’e"));
        list.add(new Question("ten", "na’aacha", "temmokka", "otiiko", "massokka","na’aacha"));

        Collections.shuffle(list);

        currentQuestion = list.get(qid);
        updateQueAndOptions();


    }


    public void updateQueAndOptions() {

        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOptA());
        buttonB.setText(currentQuestion.getOptB());
        buttonC.setText(currentQuestion.getOptC());
        buttonD.setText(currentQuestion.getOptD());

        coinText.setText(String.valueOf(coinValue));
        coinValue++;

    }

    public void buttonA(View view) {
        
        if (currentQuestion.getOptA().equals(currentQuestion.getAnswer())) {
            int color = ContextCompat.getColor(this,R.color.category_family);
            buttonA.setBackgroundColor(color);
            
            if (qid < 4) {
                disableButton();
                correctDialog();
            }
            
            else {
                gameWon();
            }
        }
        
        else {
            buttonA.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_red));
            wrongDialog();


        }
    }

    public void buttonB(View view) {
        if (currentQuestion.getOptB().equals(currentQuestion.getAnswer())) {
            int color = ContextCompat.getColor(this,R.color.category_family);
            buttonB.setBackgroundColor(color);
            if (qid < 4) {
                disableButton();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            buttonB.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_red));
            wrongDialog();
        }
    }

    public void buttonC(View view) {
        if (currentQuestion.getOptC().equals(currentQuestion.getAnswer())) {
            int color = ContextCompat.getColor(this,R.color.category_family);
            buttonC.setBackgroundColor(color);
            if (qid < 4) {
                disableButton();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            buttonC.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_red));
            wrongDialog();
        }
    }

    public void buttonD(View view) {
        if (currentQuestion.getOptD().equals(currentQuestion.getAnswer())) {
            int color = ContextCompat.getColor(this,R.color.category_family);
            buttonD.setBackgroundColor(color);
            if (qid < 4) {
                disableButton();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            buttonD.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_red));
            wrongDialog();
        }
    }

    public void gameWon() {
        Intent intent = new Intent(this, GameWon.class);
        intent.putExtra("activity","Numbers");
        startActivity(intent);
        finish();
    }

    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, PlayAgain.class);
        intent.putExtra("activity","Numbers");
        startActivity(intent);
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //countDownTimer.start();
    }

    //When activity is destroyed then this will cancel the timer
    @Override
    protected void onStop() {
        super.onStop();
        //countDownTimer.cancel();
    }

    //This will pause the time
    @Override
    protected void onPause() {
        super.onPause();
        //countDownTimer.cancel();
    }

    //On BackPressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    
    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog(NumbersTest.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        onPause();


        TextView correctText = (TextView) dialogCorrect.findViewById(R.id.correctText);
        Button buttonNext = (Button) dialogCorrect.findViewById(R.id.dialogNext);
        correctText.setText("Correct");
        buttonNext.setText("Next");
        buttonNext.setTextColor(Color.BLACK);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                dialogCorrect.dismiss();                
                qid++;                
                currentQuestion = list.get(qid);           
                updateQueAndOptions();              
                resetColor(); 
                enableButton();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void wrongDialog() {
        final Dialog dialogCorrect = new Dialog(NumbersTest.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        onPause();


        TextView correctText = (TextView) dialogCorrect.findViewById(R.id.correctText);
        Button buttonNext = (Button) dialogCorrect.findViewById(R.id.dialogNext);
        correctText.setText("Wrong");
        correctText.setTextColor(getResources().getColor(R.color.red, null));
        buttonNext.setText("OK");
        buttonNext.setTextColor(Color.BLACK);
        //buttonNext.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
               // LinearLayout.LayoutParams.WRAP_CONTENT));
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameLostPlayAgain();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void resetColor() {
        //int color = ContextCompat.getColor(this,R.color.category_numbers);
        buttonA.setBackground(ContextCompat.getDrawable(this,R.drawable.rounded_corner));
        buttonB.setBackground(ContextCompat.getDrawable(this,R.drawable.rounded_corner));
        buttonC.setBackground(ContextCompat.getDrawable(this,R.drawable.rounded_corner));
        buttonD.setBackground(ContextCompat.getDrawable(this,R.drawable.rounded_corner));
    }

    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }
}