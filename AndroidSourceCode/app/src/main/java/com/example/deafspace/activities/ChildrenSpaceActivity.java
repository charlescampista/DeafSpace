package com.example.deafspace.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.adapters.TestAdultAdapter;
import com.example.deafspace.adapters.TestChildrenAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChildrenSpaceActivity extends AppCompatActivity {

    ListView lvTrocarPorGridChildren;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_space);

        lvTrocarPorGridChildren = (ListView) findViewById(R.id.lvTrocarPorGridChildren);
        list = new ArrayList<String>();
        for(int i=0; i<30; i++) list.add("Adult Space"+i);
        TestChildrenAdapter testChildrenAdapter = new TestChildrenAdapter(list,this);
        lvTrocarPorGridChildren.setAdapter(testChildrenAdapter);

        lvTrocarPorGridChildren.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Item Clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
