package com.example.deafspace.modules.vocabularymodule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.modules.vocabularymodule.adapters.VocabularyCategoryAdapter;
import com.example.deafspace.modules.vocabularymodule.model.Category;

import java.util.ArrayList;
import java.util.List;

public class VocabularyCategoriesActivity extends AppCompatActivity {

    GridView gvVocabularyCategories;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_context);

        gvVocabularyCategories = (GridView) findViewById(R.id.gvVocabularyCategories);
        categoryList = new ArrayList<Category>();
        for(int i=0; i<30; i++){
            categoryList.add(new Category(String.valueOf(i),"Categoria"+i,"Path Image"));
        }
        VocabularyCategoryAdapter adapter = new VocabularyCategoryAdapter(categoryList,this);
        gvVocabularyCategories.setAdapter(adapter);

        gvVocabularyCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Chamar Activity Vocabulario", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,"TAG").commit();
    }
}