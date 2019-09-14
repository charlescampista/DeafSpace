package com.example.deafspace.childrenspace.modules.historymodule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.historymodule.model.History;

import java.util.List;

public class HistoryHistoriesAdapter extends BaseAdapter {
    private List<History> listItens;
    private Context context;

    public HistoryHistoriesAdapter(List<History> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public History getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.history_histories_adapter,parent,false);

        History item = listItens.get(position);

        ImageView ivHistoriesHistoryAdapter = (ImageView) view.findViewById(R.id.ivHistoriesHistoryAdapter);
        ivHistoriesHistoryAdapter.setImageResource(Integer.parseInt(item.getImageFilePath()));

        TextView tvHistoriesHistoryAdapter = (TextView) view.findViewById(R.id.tvHistoriesHistoryAdapter);
        tvHistoriesHistoryAdapter.setText(item.getName());

        return view;
    }
}
