package com.example.deafspace.childrenspace.modules.historymodule.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.application.utils.Bootstrap;
import com.example.deafspace.childrenspace.modules.historymodule.adapters.HistoryHistoriesAdapter;
import com.example.deafspace.childrenspace.modules.historymodule.model.History;

import java.util.List;

public class HistoryHistoriesActivity extends AppCompatActivity {


    ListView lvHistoryHistories;
    List<History> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_histories);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        lvHistoryHistories = (ListView) findViewById(R.id.lvHistoryHistories);

        historyList = Bootstrap.getInstance().getHistories();
        HistoryHistoriesAdapter adapter = new HistoryHistoriesAdapter(historyList,this);
        lvHistoryHistories.setAdapter(adapter);

        lvHistoryHistories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),HistoryPlayActivity.class);
                startActivity(intent);
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




}
