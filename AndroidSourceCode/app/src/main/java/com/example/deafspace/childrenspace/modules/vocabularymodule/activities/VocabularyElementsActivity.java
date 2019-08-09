package com.example.deafspace.childrenspace.modules.vocabularymodule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.articles.fragments.ArticleFragment;
import com.example.deafspace.adultspace.items.articles.fragments.ArticlesListFragment;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyListFragment;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyVideoFragment;

public class VocabularyElementsActivity extends AppCompatActivity implements VocabularyVideoFragment.OnFragmentInteractionListener, VocabularyListFragment.OnFragmentInteractionListener {

    VocabularyVideoFragment vocabularyVideoFragment;
    VocabularyListFragment vocabularyListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_elements);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        startFragments();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    protected void replaceFragment(Fragment fragment, int container, String tag){
        getSupportFragmentManager().beginTransaction().replace(container,fragment,tag).commit();
    }

    private void startFragments(){
        if(vocabularyVideoFragment == null){
            vocabularyVideoFragment = new VocabularyVideoFragment();
        }
        replaceFragment(vocabularyVideoFragment,R.id.vocabularContainerVideo,vocabularyVideoFragment.TAG);

        if(vocabularyListFragment == null){
            vocabularyListFragment = new VocabularyListFragment();
        }
        replaceFragment(vocabularyListFragment,R.id.vocabularContainerList,vocabularyListFragment.TAG);
    }

    @Override
    public void onFragmentInteraction(String tag) {

        switch (tag){
            case VocabularyListFragment.TAG:
                Toast.makeText(this,"Event Received",Toast.LENGTH_LONG).show();
                /*if(vocabularyVideoFragment == null){
                    vocabularyVideoFragment = new VocabularyVideoFragment();
                }*/
                vocabularyVideoFragment = new VocabularyVideoFragment();
                replaceFragment(vocabularyVideoFragment,R.id.vocabularContainerVideo,vocabularyVideoFragment.TAG);
                break;
        }
    }
}
