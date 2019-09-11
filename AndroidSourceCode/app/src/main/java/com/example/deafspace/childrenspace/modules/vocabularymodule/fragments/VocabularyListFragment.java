package com.example.deafspace.childrenspace.modules.vocabularymodule.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.deafspace.R;
import com.example.deafspace.application.utils.Bootstrap;
import com.example.deafspace.childrenspace.modules.vocabularymodule.adapters.VocabularyElementAdapter;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VocabularyListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VocabularyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VocabularyListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static final String TAG = "elementsfragment";

    ListView lvVocabularyElements;
    List<Element> elementsList;

    public VocabularyListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VocabularyListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VocabularyListFragment newInstance(String param1, String param2) {
        VocabularyListFragment fragment = new VocabularyListFragment();
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
        View view = inflater.inflate(R.layout.fragment_vocabulary_list, container, false);

        elementsList = Bootstrap.getInstance().pegarElementos();


        lvVocabularyElements = (ListView) view.findViewById(R.id.lvVocabularyElements);
        VocabularyElementAdapter adapter = new VocabularyElementAdapter(elementsList,getActivity());
        lvVocabularyElements.setAdapter(adapter);

        lvVocabularyElements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Element element = (Element) parent.getAdapter().getItem(position);
                onItemPressed(TAG,element);
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
