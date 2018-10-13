package com.bernardthompson.mystic8ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Button myButton;
    myButton = (Button) findViewById(R.id.askButton);


    final ImageView ballDisplay = (ImageView) findViewById(R.id.imageEightBall);


    final int [] roleOfFortune = {
            R.drawable.ball1_3x,
            R.drawable.ball2_3x,
            R.drawable.ball3_3x,
            R.drawable.ball4_3x,
            R.drawable.ball5_3x
    };

    myButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.d("Magic", "The fortune has been shared!");

            Random fortuneGen = new Random();

            int magicFortuune = fortuneGen.nextInt(5);

            ballDisplay.setImageResource(roleOfFortune[magicFortuune]);

        }
    });




    }
}




