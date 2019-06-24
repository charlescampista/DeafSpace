package com.example.deafspace.adultspace.items.articles.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.articles.model.Article;

import java.util.List;

public class ArticleAdapter extends BaseAdapter {
    private List<Article> listItens;
    private Context context;

    public ArticleAdapter(List<Article> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Article getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.article_adapter,parent,false);

        Article item = listItens.get(position);



        TextView tvArticleTitleAdapter = (TextView) view.findViewById(R.id.tvArticleTitleAdapter);
        tvArticleTitleAdapter.setText(item.getName());

        return view;
    }
}
