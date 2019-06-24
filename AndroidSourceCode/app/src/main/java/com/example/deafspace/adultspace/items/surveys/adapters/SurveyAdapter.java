package com.example.deafspace.adultspace.items.surveys.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.surveys.model.Survey;

import java.util.List;

public class SurveyAdapter extends BaseAdapter {
    private List<Survey> listItens;
    private Context context;

    public SurveyAdapter(List<Survey> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Survey getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.survey_adapter,parent,false);

        Survey item = listItens.get(position);

        TextView tvSurveyTitleAdapter = (TextView) view.findViewById(R.id.tvSurveyTitleAdapter);
        tvSurveyTitleAdapter.setText(item.getTitle());

        return view;
    }
}
