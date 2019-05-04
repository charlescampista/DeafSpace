package com.charlescampista.deafspace.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.charlescampista.deafspace.R;
import com.charlescampista.deafspace.activities.WelcomeScreenActivity;

import java.util.ArrayList;
import java.util.List;

import classes.Bootstrap;
import classes.Categoria;
import classes.CategoriaAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment {

    Categoria categoriaFruta, categoriaAnimal;

    List<Categoria> listaCategorias;

    ListView lvCategorias;


    public CategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);

        lvCategorias = (ListView) view.findViewById(R.id.lvCategorias);

        listaCategorias = Bootstrap.getInstance().pegarCategorias();

        lvCategorias.setAdapter(new CategoriaAdapter(getActivity(), (ArrayList<Categoria>) listaCategorias));

        lvCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WelcomeScreenActivity welcomeScreenActivity = (WelcomeScreenActivity) getActivity();
                Categoria categoria = (Categoria) lvCategorias.getAdapter().getItem(position);
                welcomeScreenActivity.chamarElementosFragment(categoria);
            }
        });

        return view;
    }

}
