package com.example.deafspace.childrenspace.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
import com.example.deafspace.childrenspace.modules.historymodule.activities.HistoryActivity;
import com.example.deafspace.childrenspace.modules.historymodule.activities.HistoryHistoriesActivity;
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        gvModulesChildrenSpace = (GridView) findViewById(R.id.gvModulesChildrenSpace);
        list = new ArrayList<Module>();
        list.add(new Module("","Modulo Vocabulary","Lista",String.valueOf(R.drawable.vocabularycover),0, Modules.VOCABULARY));
        list.add(new Module("","Modulo Customizado","Lista",String.valueOf(R.drawable.customizedcover),0,Modules.CUSTOMIZED_ELEMENTS));
        list.add(new Module("","Modulo História","Animação",String.valueOf(R.drawable.hystorycover),0,Modules.HISTORY));
        TestChildrenAdapter testChildrenAdapter = new TestChildrenAdapter(list,this);
        gvModulesChildrenSpace.setAdapter(testChildrenAdapter);

        gvModulesChildrenSpace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module module = (Module) parent.getAdapter().getItem(position);
                startActivity(getModuleActivity(module.getModuleType()));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    private Intent getModuleActivity(Modules moduleType) {
        switch (moduleType){
            case VOCABULARY:
                return new Intent(this,VocabularyCategoriesActivity.class);
            case HISTORY:
                return new Intent(this, HistoryHistoriesActivity.class);
        }
        return null;
    }

}
