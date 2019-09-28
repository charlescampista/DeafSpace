package com.example.deafspace.childrenspace.modules.historymodule.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.deafspace.R;
import com.example.deafspace.application.utils.Bootstrap;
import com.example.deafspace.childrenspace.modules.historymodule.adapters.HistoryPartFragmentAdapter;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryBundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentResult;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;

import java.util.List;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoryPartsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoryPartsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryPartsFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnPartsFragmentInteractionListener mListener;

    public static final String TAG = "historypartsfragment";

    List<Part> partsList;
    List<Fragment> fragmentList;
    ViewPager vpHistoryParts;


    public HistoryPartsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryPartsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryPartsFragment newInstance(String param1, String param2) {
        HistoryPartsFragment fragment = new HistoryPartsFragment();
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
        View view = inflater.inflate(R.layout.fragment_history_parts, container, false);

        vpHistoryParts = (ViewPager) view.findViewById(R.id.vpHistoryParts);

        partsList = Bootstrap.getInstance().getParts();
        HistoryPartFragmentAdapter adapter = preparateViewPager(partsList);
        vpHistoryParts.setAdapter(adapter);


        //Part part = partsList.get(2);
        // playVideo("android.resource://"+getActivity().getPackageName()+"/"+part.getSignVideoFilePath());
        return view;
    }

    private HistoryPartFragmentAdapter preparateViewPager(List<Part> partsList){
        fragmentList = new Vector<Fragment>();
        for(Part item : partsList){
            SinglePartFragment fragment = new SinglePartFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HistoryBundleKeys.HISTORY_SINGLE_PART_ARGUMENT.toString(),item);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
        HistoryPartFragmentAdapter adapter = new HistoryPartFragmentAdapter(getActivity().getSupportFragmentManager(),fragmentList);
        return adapter;
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onItemPressed(Object object, HistoryFragmentResult result) {
        if (mListener != null) {
            mListener.onPartsInteraction(object,result);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPartsFragmentInteractionListener) {
            mListener = (OnPartsFragmentInteractionListener) context;
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
    public interface OnPartsFragmentInteractionListener {
        // TODO: Update argument type and name
        void onPartsInteraction(Object object, HistoryFragmentResult result);
    }


}
