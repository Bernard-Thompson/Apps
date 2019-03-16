package com.bernardthompson.javaquizz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {





    // member variables
    Button bTrueButton;
    Button bFalseButton;
    TextView bQuestionText;
    TextView bScoreTextView;
    ProgressBar bProgressBar;
    int bIndex;
    int bScore;
    int bQuestion;




    private TrueFalse[] bQuestionList = new TrueFalse[] {
            //Question Template  ---> ( TrueFalse testQuestion = new TrueFalse(R.string.(question#), (true or false) )

            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, false),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true),
            new TrueFalse(R.string.question_14, true)
    };

    // constants
    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / bQuestionList.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            bScore = savedInstanceState.getInt("ScoreK");
            bIndex = savedInstanceState.getInt("IndexK");
        } else {
            bScore = 0;
            bIndex = 0;
        }

        bTrueButton = findViewById(R.id.true_button);
        bFalseButton = findViewById(R.id.false_button);
        bQuestionText = findViewById(R.id.question_text_view);
        bScoreTextView = findViewById(R.id.score);
        bProgressBar = findViewById(R.id.progress_bar);
        bScoreTextView.setText("Score " + bScore + "/" + bQuestionList.length);

        bQuestion = bQuestionList[bIndex].getQuestionID();
        bQuestionText.setText(bQuestion);


        bTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("JQuizz", "Look\'s like you pressed the true button.......test passed!");
                checkAnswer(true);
                questionUpdate();

            }
        });

        bFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("JQuizz", "Look\'s like you pressed the false button.......test passed!");
                checkAnswer(false);
                questionUpdate();

            }
        });


    }

    private void questionUpdate() {
        bIndex = (bIndex + 1) % bQuestionList.length;
        if (bIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You scored " + bScore + " points!");
            alert.setPositiveButton("Close app", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        bQuestion = bQuestionList[bIndex].getQuestionID();
        bQuestionText.setText(bQuestion);
        bProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        bScoreTextView.setText("Score " + bScore + "/" + bQuestionList.length);
    }

    private void checkAnswer (boolean userSelection) {
        boolean correctAnswer = bQuestionList[bIndex].isAnswer();
        if (userSelection == correctAnswer) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            bScore = bScore + 1;
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreK", bScore);
        outState.putInt("IndexK", bIndex);
    }


}
