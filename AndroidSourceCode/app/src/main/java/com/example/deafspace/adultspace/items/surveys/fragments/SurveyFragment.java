package com.example.deafspace.adultspace.items.surveys.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.surveys.model.Survey;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SurveyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SurveyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurveyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public static final String TAG = "surveyfragment";
    Survey survey;
    WebView wvSuvey;

    public SurveyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SurveyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SurveyFragment newInstance(Survey param) {
        SurveyFragment fragment = new SurveyFragment();
        Bundle args = new Bundle();
        args.putSerializable("survey",param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            survey = (Survey) getArguments().getSerializable("survey");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        wvSuvey = (WebView) view.findViewById(R.id.wvSuvey);

        wvSuvey.getSettings().setJavaScriptEnabled(true);
        wvSuvey.getSettings().setLoadWithOverviewMode(true);
        wvSuvey.getSettings().setUseWideViewPort(true);
        wvSuvey.getSettings().setBuiltInZoomControls(false);
        wvSuvey.getSettings().setPluginState(WebSettings.PluginState.ON);
        wvSuvey.setWebViewClient(new AppWebClient());
        wvSuvey.loadUrl(survey.getLink());

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


    private class AppWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }



}
