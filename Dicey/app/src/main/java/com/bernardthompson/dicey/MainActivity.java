package com.bernardthompson.dicey;

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


        Button buttonToRoll;
        buttonToRoll = (Button) findViewById(R.id.buttonToRoll);

        final ImageView diceLeft = (ImageView) findViewById(R.id.diceLeft);

        final ImageView diceRight = (ImageView) findViewById(R.id.diceRight);

        final int[] diceRolls = {
                R.drawable.dice1_2x,
                R.drawable.dice2_2x,
                R.drawable.dice3_2x,
                R.drawable.dice4_2x,
                R.drawable.dice5_2x,
                R.drawable.dice6_2x
        };

        buttonToRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Dice", "De Button has been pressed!");

                Random randomDiceGen = new Random();

                int dicerLeft = randomDiceGen.nextInt(6);
                int dicerRight = randomDiceGen.nextInt(6);

                Log.d("Dicey", "The random numbers are: " +  dicerLeft + " and " + dicerRight);

                diceLeft.setImageResource(diceRolls[dicerLeft]);
                diceRight.setImageResource(diceRolls[dicerRight]);

            }
        });
    }
}
