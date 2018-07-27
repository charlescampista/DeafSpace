package com.charlescampista.deafspace.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.charlescampista.deafspace.R;
import com.charlescampista.deafspace.activities.WelcomeScreenActivity;

import java.util.ArrayList;
import java.util.List;

import classes.Bootstrap;
import classes.Categoria;
import classes.Elemento;
import classes.ElementoAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElementosFragment extends Fragment {

    GridView gvElemetos;

    List<Elemento> listaElementos;
    Categoria categoria;

    public ElementosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_elemento, container, false);

        receberParametros();

        listaElementos = Bootstrap.getInstance().pegarElementos(categoria);
        gvElemetos = (GridView) view.findViewById(R.id.gvElementos);
        gvElemetos.setAdapter(new ElementoAdapter(getActivity(), (ArrayList<Elemento>) listaElementos));
        gvElemetos.setAdapter(new ElementoAdapter(getActivity(), (ArrayList<Elemento>) listaElementos));
        gvElemetos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WelcomeScreenActivity welcomeScreenActivity = (WelcomeScreenActivity) getActivity();
                Elemento elemento= (Elemento) gvElemetos.getAdapter().getItem(position);
                welcomeScreenActivity.chamarVideoFragment(elemento);
            }
        });


        return view;

    }

    private void receberParametros(){
        Bundle bundle = getArguments();
        if(bundle != null) {
            categoria = (Categoria) bundle.getSerializable("categoria");
        }
    }

}
