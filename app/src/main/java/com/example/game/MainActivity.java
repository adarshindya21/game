package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText guess;
    private static final int MAX_NUMBER = 10;
    public static final Random r = new Random();
    TextView msg;
    Button chkbtn;
    private int number , tries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.msgtv);
        chkbtn= findViewById(R.id.chkbntn);
        guess = findViewById(R.id.guesset);
        chkbtn.setOnClickListener(this);

        newGame();

    }

    @Override
    public void onClick(View v) {
        if (v == chkbtn)
            validate();

    }

    private void validate() {
        int n = Integer.parseInt(guess.getText().toString());
        tries++;

        if(n == number)
        {
            Toast.makeText(this,"You hit the bull's eye "+number+" in "+tries+"attempts",Toast.LENGTH_LONG).show();
            newGame();
        }
        else if(n > number)
        {
            msg.setText("It is Greater");
        }
        else if(n < number)
        {
            msg.setText("It is Lower");

        }

    }

    private void newGame() {

        number = r.nextInt(MAX_NUMBER)+1;
        guess.setText("");
        msg.setText("");
        tries = 0;
    }
}

