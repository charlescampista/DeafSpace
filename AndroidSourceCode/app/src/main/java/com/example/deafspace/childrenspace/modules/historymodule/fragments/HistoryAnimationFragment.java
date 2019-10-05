package com.example.deafspace.childrenspace.modules.historymodule.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.historymodule.activities.HistoryPlayActivity;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryBundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentResult;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoryAnimationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoryAnimationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryAnimationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;
    private OnAnimationInteraction interaction;

    public static final String TAG = "historyanimagionfragment";
    //public static final String TAG = HistoryPlayActivity.ANIMATION_FRAG;
    VideoView vvHistoryAnimation;
    Part part;

    public HistoryAnimationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryAnimationFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*public static HistoryAnimationFragment newInstance(String param1, String param2) {
        HistoryAnimationFragment fragment = new HistoryAnimationFragment();
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
        View view =  inflater.inflate(R.layout.fragment_history_animation, container, false);

        getBundleParameters();

        vvHistoryAnimation = (VideoView) view.findViewById(R.id.vvHistoryAnimation);
        vvHistoryAnimation.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {

                //onVideoFinished(part,HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);
                interaction.onAnimationFinished(part,HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);

            }
        });

        //whenVideoFinished(part,HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);



        //onButtonPressed(TAG,new Object(),HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);

        //interaction.onAnimationFinished(part,HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED);

        if(part != null){
            //String videoPath2 = "android.resource://"+getActivity().getPackageName()+"/"+R.raw.gorila;
            String videoPath = "android.resource://"+getActivity().getPackageName()+"/"+part.getAnimationVideoFilePath();
            playVideo(videoPath);

        }

        if(part == null) {

        }

        //playVideo("android.resource://"+getActivity().getPackageName()+"/"+part.getSignVideoFilePath());

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(String tag, Object object, HistoryFragmentResult result) {

        if (mListener != null) {
            mListener.onFragmentInteraction(tag,null,result);
        }
    }*/

    public void onVideoFinished(Object object, HistoryFragmentResult result) {


        if (interaction != null) {
            interaction.onAnimationFinished(object,result);
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

        if (context instanceof OnAnimationInteraction) {
            interaction = (OnAnimationInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAnimationInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
        interaction = null;
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


    private void playVideo(String videoPath) {
        Uri uriPath = Uri.parse(videoPath);
        vvHistoryAnimation.setVideoURI(uriPath);
        vvHistoryAnimation.start();
    }


    private void getBundleParameters(){
        if(getArguments() != null){
            Bundle bundle = this.getArguments();
            if(bundle != null){
                part = (Part) bundle.getSerializable(HistoryBundleKeys.HiSTORY_PART_ANIMATION.toString());
            }
        }
    }

    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String tag, Object object, HistoryFragmentResult result);
    }*/

    public interface OnAnimationInteraction {
        // TODO: Update argument type and name
        void onAnimationFinished(Object object, HistoryFragmentResult result);
    }
}
