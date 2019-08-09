package com.example.deafspace.childrenspace.modules.vocabularymodule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Element;

import java.util.List;

public class VocabularyElementAdapter extends BaseAdapter {

    private List<Element> listItens;
    private Context context;

    public VocabularyElementAdapter(List<Element> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Element getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.vocabulary_element_adapter,parent,false);

        Element item = listItens.get(position);

        ImageView ivElementVocabularyAdapter = (ImageView) view.findViewById(R.id.ivElementVocabularyAdapter);
        ivElementVocabularyAdapter.setImageResource(Integer.parseInt(item.getPathImage()));



        return view;
    }
}
