package com.example.deafspace.childrenspace.modules.vocabularymodule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyListFragment;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyVideoFragment;

public class VocabularyElementsActivity extends AppCompatActivity implements VocabularyVideoFragment.OnFragmentInteractionListener, VocabularyListFragment.OnFragmentInteractionListener {

    VocabularyVideoFragment vocabularyVideoFragment;
    VocabularyListFragment vocabularyListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_elements);

        startFragments();
    }

    protected void replaceFragment(Fragment fragment,int container,String tag){
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
    public void onFragmentInteraction(Uri uri) {

    }
}
