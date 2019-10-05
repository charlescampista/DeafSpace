package com.example.deafspace.childrenspace.modules.historymodule.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryBundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentResult;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentsTags;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoryVideoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoryVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryVideoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnVideoSignInteractionListener mListener;

    //public static final String TAG = HistoryFragmentsTags.TAG_HISTORY_VIDEO_FRAGMENT.toString();
    public static final String TAG = "historyvideofragment";
    private VideoView vvHistoryPartTranslation;
    private Part part;

    public HistoryVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*public static HistoryVideoFragment newInstance(String param1, String param2) {
        HistoryVideoFragment fragment = new HistoryVideoFragment();
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
        View view = inflater.inflate(R.layout.fragment_history_video, container, false);

        getBundleParameters();


        vvHistoryPartTranslation = (VideoView)  (VideoView) view.findViewById(R.id.vvHistoryPartTranslation);
        vvHistoryPartTranslation.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                onButtonPressed(part,HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);
            }
        });

        //onButtonPressed(part,HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);

        if(part != null){
            //String videoPath2 = "android.resource://"+getActivity().getPackageName()+"/"+R.raw.gorila;
            String videoPath = "android.resource://"+getActivity().getPackageName()+"/"+part.getSignVideoFilePath();
            playVideo(videoPath);

        }

        if(part == null) {
            Toast.makeText(getActivity(), "Fragment Iniciado",Toast.LENGTH_SHORT).show();
        }


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Object object, HistoryFragmentResult result) {
        if (mListener != null) {
            mListener.onReprodutionFinish(object,result);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnVideoSignInteractionListener) {
            mListener = (OnVideoSignInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnVideoSignInteractionListener");
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
    public interface OnVideoSignInteractionListener {
        // TODO: Update argument type and name
        void onReprodutionFinish(Object object, HistoryFragmentResult result);
    }

    private void playVideo(String videoPath) {
        Uri uriPath = Uri.parse(videoPath);
        vvHistoryPartTranslation.setVideoURI(uriPath);
        vvHistoryPartTranslation.start();
    }

    private void getBundleParameters(){
        if(getArguments() != null){
            Bundle bundle = this.getArguments();
            if(bundle != null){
                part = (Part) bundle.getSerializable(HistoryBundleKeys.HiSTORY_PART_SIGN.toString());
            }
        }
    }




}
