package com.example.deafspace.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.adapters.TestAdultAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdultSpaceActivity extends AppCompatActivity {

    ListView lvTrocarPorGridAdult;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_space);

        lvTrocarPorGridAdult = (ListView) findViewById(R.id.lvTrocarPorGridAdult);
        list = new ArrayList<String>();
        for(int i=0; i<30; i++) list.add("Adult Space"+i);
        TestAdultAdapter testAdultAdapter = new TestAdultAdapter(list,this);
        lvTrocarPorGridAdult.setAdapter(testAdultAdapter);

        lvTrocarPorGridAdult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Item Clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
