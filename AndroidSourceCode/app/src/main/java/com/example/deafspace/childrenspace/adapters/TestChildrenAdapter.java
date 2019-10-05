package com.example.deafspace.childrenspace.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deafspace.R;
import com.example.deafspace.application.model.Module;

import java.util.List;

public class TestChildrenAdapter extends BaseAdapter {

    private List<Module> listItens;
    private Context context;

    public TestChildrenAdapter(List<Module> listItens, Context context) {
        this.listItens = listItens;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Module getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; //Get the id of the element clicked from list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.test_children_adapter,parent,false);

        Module item = listItens.get(position);

        ImageView ivModulesCover = (ImageView) view.findViewById(R.id.ivModuleCover);
        ivModulesCover.setImageResource(Integer.parseInt(item.getImagePath()));

        //TextView tvTitleTestAdultAdapter = (TextView) view.findViewById(R.id.tvTitleTestChildrenAdapter);
        //tvTitleTestAdultAdapter.setText(item.getName());

        return view;
    }

}
