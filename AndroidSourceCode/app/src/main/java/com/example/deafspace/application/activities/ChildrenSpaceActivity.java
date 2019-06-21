package com.example.deafspace.application.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.application.adapters.TestChildrenAdapter;
import com.example.deafspace.application.model.Module;

import java.util.ArrayList;
import java.util.List;

public class ChildrenSpaceActivity extends AppCompatActivity {

    GridView gvModulesChildrenSpace;
    List<Module> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_space);

        gvModulesChildrenSpace = (GridView) findViewById(R.id.gvModulesChildrenSpace);
        list = new ArrayList<Module>();
        list.add(new Module("","Vocabulary","Lista","",0));
        list.add(new Module("","Customizado","Lista","",0));
        list.add(new Module("","Historia","Animação","",0));
        TestChildrenAdapter testChildrenAdapter = new TestChildrenAdapter(list,this);
        gvModulesChildrenSpace.setAdapter(testChildrenAdapter);

        gvModulesChildrenSpace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Item Clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
