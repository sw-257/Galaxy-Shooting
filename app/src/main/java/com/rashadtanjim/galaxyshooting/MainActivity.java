package com.rashadtanjim.galaxyshooting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Button pressButton, showScoreButton;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.pressText);
        pressButton = findViewById(R.id.buttonPressed);
        showScoreButton = findViewById(R.id.buttonScored);

        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed();
                playGame();
            }
        });
        showScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGameScore();
            }
        });
    }

    private void buttonPressed() {
        myRef.child("Name").
                setValue(editText.getText().toString());
    }

    public void playGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void showGameScore() {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

}
