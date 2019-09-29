package com.example.deafspace.adultspace.items.surveys.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.surveys.fragments.SurveyFragment;
import com.example.deafspace.adultspace.items.surveys.fragments.SurveyListFragment;
import com.example.deafspace.adultspace.items.surveys.model.Survey;

public class SurveyActivity extends AppCompatActivity implements SurveyListFragment.OnFragmentInteractionListener, SurveyFragment.OnFragmentInteractionListener{

    SurveyListFragment surveyListFragment;
    SurveyFragment surveyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        if(surveyListFragment == null){
            surveyListFragment = new SurveyListFragment();
        }
        replaceFragment(surveyListFragment,R.id.surveysContainer,surveyListFragment.TAG);

    }

    protected void replaceFragment(Fragment fragment, int container, String tag){
        getSupportFragmentManager().beginTransaction().replace(container,fragment,tag).commit();
    }

    @Override
    public void onFragmentInteraction(String tag, Object object) {
        if(tag.equals(SurveyListFragment.TAG)){
            if(surveyFragment == null){
                surveyFragment = SurveyFragment.newInstance((Survey) object);
            }
            replaceFragment(surveyFragment,R.id.surveysContainer,surveyFragment.TAG);
        }
    }
}
