package com.example.deafspace.childrenspace.modules.vocabularymodule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Category;

import java.util.List;

public class VocabularyCategoryAdapter extends BaseAdapter {
    private List<Category> listItens;
    private Context context;

    public VocabularyCategoryAdapter(List<Category> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Category getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.vocabulary_category_adapter,parent,false);

        Category item = listItens.get(position);

        ImageView ivCategoryVocabularyAdapter = (ImageView) view.findViewById(R.id.ivCategoryVocabularyAdapter);

        TextView tvCategoryVocabularyAdapter = (TextView) view.findViewById(R.id.tvCategoryVocabularyAdapter);
        tvCategoryVocabularyAdapter.setText(item.getName());

        return view;
    }
}
