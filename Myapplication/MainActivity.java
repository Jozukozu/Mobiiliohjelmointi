package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    int buttonCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button gameButton = new Button(this);
        gameButton.setText("Hello, I'm the button.");


        setContentView(gameButton);
        gameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                buttonCount = buttonCount +1;
                gameButton.setText("You have pressed the button " + buttonCount + " times.");
                Toast.makeText(MainActivity.this,"Olet painanut nappia " + buttonCount +
                        " kertaa.", Toast.LENGTH_LONG).show();
            }
        });
    }
}


