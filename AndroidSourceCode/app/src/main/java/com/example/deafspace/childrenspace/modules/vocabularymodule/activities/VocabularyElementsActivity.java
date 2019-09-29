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
import com.example.deafspace.application.enums.AdultItems;
import com.example.deafspace.application.enums.BundleKeys;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyListFragment;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyVideoFragment;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Element;

public class VocabularyElementsActivity extends AppCompatActivity implements VocabularyVideoFragment.OnFragmentInteractionListener, VocabularyListFragment.OnFragmentInteractionListener {

    VocabularyVideoFragment vocabularyVideoFragment;
    VocabularyListFragment vocabularyListFragment;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_elements);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.category = (Category) getIntent().getExtras().getSerializable("category");
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
            vocabularyListFragment = VocabularyListFragment.newInstance(this.category);
            /*Bundle bundle = new Bundle();
            bundle.putSerializable("category",this.category);
            vocabularyVideoFragment.setArguments(bundle);*/
            Toast.makeText(this,this.category.getName(),Toast.LENGTH_SHORT).show();
        }
        replaceFragment(vocabularyListFragment,R.id.vocabularContainerList,vocabularyListFragment.TAG);
    }

    @Override
    public void onFragmentInteraction(String tag, Object object) {

        if(object != null){
            switch (tag){
                case VocabularyListFragment.TAG:
                    Toast.makeText(this,"Event Received",Toast.LENGTH_LONG).show();
                /*if(vocabularyVideoFragment == null){
                    vocabularyVideoFragment = new VocabularyVideoFragment();
                }*/
                    vocabularyVideoFragment = new VocabularyVideoFragment();
                    Element element = (Element) object;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(BundleKeys.VOCABULARY_ELEMENT.toString(),element);
                    vocabularyVideoFragment.setArguments(bundle);
                    replaceFragment(vocabularyVideoFragment,R.id.vocabularContainerVideo,vocabularyVideoFragment.TAG);
                    break;
            }
        }

        if(object == null){
            Toast.makeText(this,"O click fora da lista",Toast.LENGTH_SHORT).show();
        }





    }


}
