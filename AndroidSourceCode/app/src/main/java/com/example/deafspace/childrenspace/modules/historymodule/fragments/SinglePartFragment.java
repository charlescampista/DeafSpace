package com.example.deafspace.childrenspace.modules.historymodule.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.application.utils.Bootstrap;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryBundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentResult;
import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SinglePartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SinglePartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SinglePartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;
    private OnSinglePartInteractionListener interacton;

    public static final String TAG = "singlepartfragment";

    ImageView ivHistorySinglePartCover;
    ImageView ivHistorySinglePartPlay;


    Part part;



    public SinglePartFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SinglePartFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*public static SinglePartFragment newInstance(String param1, String param2) {
        SinglePartFragment fragment = new SinglePartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

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
        View view = inflater.inflate(R.layout.fragment_single_part, container, false);

        ivHistorySinglePartCover = (ImageView) view.findViewById(R.id.ivHistorySinglePartCover);
        ivHistorySinglePartPlay = (ImageView) view.findViewById(R.id.ivHistorySinglePartPlay);

        getBundleParameters();

        ivHistorySinglePartPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(part,HistoryFragmentResult.ARGUMENT_PASSED);
            }
        });


        ivHistorySinglePartCover.setImageResource(Bootstrap.getInstance().getPartImageResource(part));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(String tag, Object object, HistoryFragmentResult result) {
        if (mListener != null) {
            mListener.onFragmentInteraction(tag, object,result);
        }
    }*/

    public void onButtonPressed(Object object, HistoryFragmentResult result) {
        if (interacton != null) {
            interacton.onPlayClicked(object,result);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
        if (context instanceof OnSinglePartInteractionListener) {
            interacton = (OnSinglePartInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSinglePartInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
        interacton = null;
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


    private void getBundleParameters() {
        if (getArguments() != null) {
            Bundle bundle = this.getArguments();
            if (bundle != null) {
                part = (Part) bundle.getSerializable(HistoryBundleKeys.HISTORY_SINGLE_PART_ARGUMENT.toString());
            }
        }
    }

    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String tag, Object object, HistoryFragmentResult result);
    }*/

    public interface OnSinglePartInteractionListener {
        // TODO: Update argument type and name
        void onPlayClicked(Object object, HistoryFragmentResult result);
    }
}
