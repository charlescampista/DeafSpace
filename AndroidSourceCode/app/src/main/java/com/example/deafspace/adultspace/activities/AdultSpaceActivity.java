package com.example.deafspace.adultspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.adapters.TestAdultAdapter;
import com.example.deafspace.adultspace.items.articles.activities.ArticlesActivity;
import com.example.deafspace.adultspace.items.downloads.activities.DownloadsActivity;
import com.example.deafspace.adultspace.items.surveys.activities.SurveyActivity;
import com.example.deafspace.adultspace.model.AdultSpaceItem;
import com.example.deafspace.application.enums.AdultItems;

import java.util.ArrayList;
import java.util.List;

public class AdultSpaceActivity extends AppCompatActivity {

    GridView gvItensAdultSpace;
    List<AdultSpaceItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_space);

        gvItensAdultSpace = (GridView) findViewById(R.id.gvItensAdultSpace);
        list = new ArrayList<AdultSpaceItem>();
        list.add(new AdultSpaceItem("f78d","",-1,"Artigos", AdultItems.ARTICLES));
        list.add(new AdultSpaceItem("f78fds","",-1,"Pesquisas", AdultItems.SURVEYS));
        list.add(new AdultSpaceItem("gf89d","",-1,"Downloads", AdultItems.DOWNLOADS));
        list.add(new AdultSpaceItem("fds78s","",-1,"Módulos", AdultItems.MODULES));
        list.add(new AdultSpaceItem("l23fn","",-1,"Opine", AdultItems.TALK_TO_US));

        TestAdultAdapter testAdultAdapter = new TestAdultAdapter(list,this);
        gvItensAdultSpace.setAdapter(testAdultAdapter);

        gvItensAdultSpace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Item Clicado", Toast.LENGTH_SHORT).show();
                AdultSpaceItem item =(AdultSpaceItem) parent.getAdapter().getItem(position);
                Intent intent = getItemActivity(item.getAdultItems());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private Intent getItemActivity(AdultItems item) {
        switch (item){
            case ARTICLES:
                return new Intent(this, ArticlesActivity.class);
            case SURVEYS:
                return new Intent(this, SurveyActivity.class);
            case DOWNLOADS:
                return new Intent(this, DownloadsActivity.class);
        }
        return null;
    }

}
