package com.example.deafspace.application.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.example.deafspace.adultspace.activities.AdultSpaceLockScreenActivity;
import com.example.deafspace.childrenspace.activities.ChildrenSpaceActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.deafspace.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.navigation_children_space:
                    intent = new Intent(getBaseContext(), ChildrenSpaceActivity.class);
                    startActivity(intent);

                    return true;
                case R.id.navigation_adult_space:
                    intent = new Intent(getBaseContext(), AdultSpaceLockScreenActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
