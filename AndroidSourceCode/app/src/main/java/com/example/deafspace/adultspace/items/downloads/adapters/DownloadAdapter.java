package com.example.deafspace.adultspace.items.downloads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.application.model.ModulePackage;

import java.util.List;

public class DownloadAdapter extends BaseAdapter {
    private List<ModulePackage> listItens;
    private Context context;

    public DownloadAdapter(List<ModulePackage> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public ModulePackage getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.download_adapter,parent,false);

        ModulePackage item = listItens.get(position);



        TextView tvDownloadPackageNameAdapter = (TextView) view.findViewById(R.id.tvDownloadPackageNameAdapter);
        tvDownloadPackageNameAdapter.setText(item.getName());

        return view;
    }
}
