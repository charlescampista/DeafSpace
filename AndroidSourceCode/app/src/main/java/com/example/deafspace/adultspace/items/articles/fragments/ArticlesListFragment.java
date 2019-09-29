package com.example.deafspace.adultspace.items.articles.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.articles.adapters.ArticleAdapter;
import com.example.deafspace.adultspace.items.articles.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArticlesListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArticlesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticlesListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public static final String TAG = "articlelistfragment";
    List<Article> articleList;

    ListView lvArticleList;




    public ArticlesListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArticlesListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticlesListFragment newInstance(String param1, String param2) {
        ArticlesListFragment fragment = new ArticlesListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_articles_list, container, false);

        articleList = new ArrayList<Article>();
        articleList.add(new Article("sd8f78s","O Papel da Família Diante da Surdez dos Filhos","https://www.portaleducacao.com.br/conteudo/artigos/idiomas/o-papel-da-familia-diante-da-surdez-dos-filhos/26895","Podemos considerar o diagnóstico da surdez como sendo o marco inicial...","imagePath","image"));
        articleList.add(new Article("c789df","ALFABETIZAÇÃO E LETRAMENTO DE CRIANÇAS SURDAS","http://mirandalibrassemfronteiras.weebly.com/-a-alfabetizaccedilatildeo-de-crianccedilas-surdas---implementaccedilatildeo-da-educaccedilatildeo-bilingue-nota-teacutecnica-052011-ndash-mecsecadigab.html","Some text","imagePath","image"));
        lvArticleList = (ListView) view.findViewById(R.id.lvArticleList);
        ArticleAdapter adapter = new ArticleAdapter(articleList,getActivity());
        lvArticleList.setAdapter(adapter);

        lvArticleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemPressed(TAG,(Article) parent.getAdapter().getItem(position));
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onItemPressed(String tag, Object object) {
        if (mListener != null) {
            mListener.onFragmentInteraction(tag,object);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String tag, Object object);
    }
}
