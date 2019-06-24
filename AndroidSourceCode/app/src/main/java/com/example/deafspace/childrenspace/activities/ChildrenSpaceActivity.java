package com.example.deafspace.childrenspace.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.adapters.TestChildrenAdapter;
import com.example.deafspace.application.enums.Modules;
import com.example.deafspace.application.model.Module;
import com.example.deafspace.childrenspace.modules.vocabularymodule.activities.VocabularyCategoriesActivity;

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
        list.add(new Module("","Modulo Vocabulary","Lista","",0, Modules.VOCABULARY));
        list.add(new Module("","Modulo Customizado","Lista","",0,Modules.CUSTOMIZED_ELEMENTS));
        list.add(new Module("","Modulo História","Animação","",0,Modules.HISTORY));
        TestChildrenAdapter testChildrenAdapter = new TestChildrenAdapter(list,this);
        gvModulesChildrenSpace.setAdapter(testChildrenAdapter);

        gvModulesChildrenSpace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Item Clicado", Toast.LENGTH_SHORT).show();
                Module module = (Module) parent.getAdapter().getItem(position);
                startActivity(getModuleActivity(module.getModuleType()));
            }
        });
    }

    private Intent getModuleActivity(Modules moduleType) {
        switch (moduleType){
            case VOCABULARY:
                return new Intent(this,VocabularyCategoriesActivity.class);
        }
        return null;
    }

}
