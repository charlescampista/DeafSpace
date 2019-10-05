package com.example.deafspace.adultspace.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.model.AdultSpaceItem;

import java.util.List;

public class TestAdultAdapter extends BaseAdapter {

    private List<AdultSpaceItem> listItens;
    private Context context;

    public TestAdultAdapter(List<AdultSpaceItem> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public AdultSpaceItem getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.test_adult_adapter,parent,false);

        AdultSpaceItem item = listItens.get(position);

        ImageView ivAdultSpaceCover = (ImageView) view.findViewById(R.id.ivAdultSpaceCover);
        ivAdultSpaceCover.setImageResource(Integer.parseInt(item.getImagePath()));

        TextView tvTitleTestAdultAdapter = (TextView) view.findViewById(R.id.tvTitleTestAdultAdapter);
        tvTitleTestAdultAdapter.setText(item.getName());

        return view;
    }
}
