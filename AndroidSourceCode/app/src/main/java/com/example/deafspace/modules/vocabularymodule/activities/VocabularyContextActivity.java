package com.example.deafspace.modules.vocabularymodule.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.adapters.TestAdultAdapter;
import com.example.deafspace.modules.vocabularymodule.adapters.VocabularyCategoryAdapter;
import com.example.deafspace.modules.vocabularymodule.model.Category;

import java.util.ArrayList;
import java.util.List;

public class VocabularyContextActivity extends AppCompatActivity {

    ListView lvTrocarPorGridVocabularyContext;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_context);

        lvTrocarPorGridVocabularyContext = (ListView) findViewById(R.id.lvTrocarPorGridVocabularyContext);
        categoryList = new ArrayList<Category>();
        for(int i=0; i<30; i++){
            categoryList.add(new Category(String.valueOf(i),"Categoria"+i,"Path Image"));
        }
        VocabularyCategoryAdapter adapter = new VocabularyCategoryAdapter(categoryList,this);
        lvTrocarPorGridVocabularyContext.setAdapter(adapter);

        lvTrocarPorGridVocabularyContext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Chamar Activity Vocabulario", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
