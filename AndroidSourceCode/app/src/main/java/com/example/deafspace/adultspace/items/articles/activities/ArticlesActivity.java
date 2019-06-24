package com.example.deafspace.adultspace.items.articles.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.articles.fragments.ArticleFragment;
import com.example.deafspace.adultspace.items.articles.fragments.ArticlesListFragment;
import com.example.deafspace.childrenspace.modules.vocabularymodule.fragments.VocabularyVideoFragment;

public class ArticlesActivity extends AppCompatActivity implements ArticlesListFragment.OnFragmentInteractionListener, ArticleFragment.OnFragmentInteractionListener {

    ArticleFragment articleFragment;
    ArticlesListFragment articlesListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        if(articlesListFragment == null){
            articlesListFragment = new ArticlesListFragment();
        }
        replaceFragment(articlesListFragment,R.id.articlesContainer,articlesListFragment.TAG);
    }

    protected void replaceFragment(Fragment fragment, int container, String tag){
        getSupportFragmentManager().beginTransaction().replace(container,fragment,tag).commit();
    }

    @Override
    public void onFragmentInteraction(String tag) {
        if(tag.equals(ArticlesListFragment.TAG)){
            if(articleFragment == null){
                articleFragment = new ArticleFragment();
            }
            replaceFragment(articleFragment,R.id.articlesContainer,articleFragment.TAG);
        }
    }
}
