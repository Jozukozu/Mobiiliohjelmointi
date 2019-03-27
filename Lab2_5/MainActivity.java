package com.example.lab2_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    Button buttons[] = new Button[4];
    EditText nameText;
    TextView helloText;
    String writtenText;
    String randomText;
    final String TAG = "blaa";

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.englishButton:
                writtenText = nameText.getText().toString();
                helloText.setText(getString(R.string.greeting1) + " " + writtenText);
                break;
            case R.id.swedishButton:
                writtenText = nameText.getText().toString();
                helloText.setText(getString(R.string.greeting2) + " " + writtenText);
                break;
            case R.id.finnishButton:
                writtenText = nameText.getText().toString();
                helloText.setText(getString(R.string.greeting3) + " " + writtenText);
                break;
            case R.id.surpriseButton:
                Log.i(TAG, "yllätys valinnassa");
                randomText = random();
                writtenText = nameText.getText().toString();
                helloText.setText(randomText + " " + writtenText);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        nameText = findViewById(R.id.nameEditText);
        helloText = findViewById(R.id.greetTextView);

        nameText.addTextChangedListener(textWatcher);

        buttons[0] = findViewById(R.id.englishButton);
        buttons[1] = findViewById(R.id.swedishButton);
        buttons[2] = findViewById(R.id.finnishButton);
        buttons[3] = findViewById(R.id.surpriseButton);

        for(int i = 0; i < 4; i++)
        {
            buttons[i].setOnClickListener(this);
        }
    }

    String random()
    {
        Log.i(TAG, "random funktiossa");
        String greeting = "";

        final int random = new Random().nextInt(5);

        switch(random)
        {
            case 0:
                greeting = getString(R.string.greeting1) ;
                break;

            case 1:
                greeting = getString(R.string.greeting2) ;
                break;

            case 2:
                greeting = getString(R.string.greeting3) ;
                break;

            case 3:
                greeting = getString(R.string.greeting4) ;
                break;

            case 4:
                greeting = getString(R.string.greeting5) ;
                break;
        }

        return greeting;
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {

            helloText.setText(nameText.getText());
        }
    };
}
