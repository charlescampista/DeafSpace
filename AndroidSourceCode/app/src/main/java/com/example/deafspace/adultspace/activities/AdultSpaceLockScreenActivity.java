package com.example.deafspace.adultspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deafspace.R;

public class AdultSpaceLockScreenActivity extends AppCompatActivity {

    Button btAdultSpaceUnlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_space_lock_screen);

        btAdultSpaceUnlock = (Button) findViewById(R.id.btAdultSpaceUnlock);

        btAdultSpaceUnlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),AdultSpaceActivity.class);
                startActivity(intent);
            }
        });
    }
}
