package com.charlescampista.deafspace.fragments;


import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.charlescampista.deafspace.R;
import com.charlescampista.deafspace.activities.WelcomeScreenActivity;

import classes.Elemento;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
     VideoView videoView;
     WelcomeScreenActivity welcomeScreenActivity;
     Elemento elemento;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        receberParamentros();
        welcomeScreenActivity = (WelcomeScreenActivity) getActivity();

        videoView = view.findViewById(R.id.videoView);
        String videopath = "android.resource://"+welcomeScreenActivity.getPackageName()+"/"+elemento.getVideo();
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.start();
        return view;
    }

    private void receberParamentros(){
        Bundle bundle = getArguments();
        if(bundle != null){
            elemento = (Elemento) bundle.getSerializable("elemento");
        }
    }

}
