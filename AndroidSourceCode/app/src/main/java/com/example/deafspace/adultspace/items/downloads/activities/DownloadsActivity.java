package com.example.deafspace.adultspace.items.downloads.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.deafspace.R;
import com.example.deafspace.adultspace.items.articles.fragments.ArticleFragment;
import com.example.deafspace.adultspace.items.downloads.fragments.DownloadFragment;
import com.example.deafspace.adultspace.items.downloads.fragments.DownloadsListFragment;

public class DownloadsActivity extends AppCompatActivity implements DownloadsListFragment.OnFragmentInteractionListener, DownloadFragment.OnFragmentInteractionListener {

    DownloadsListFragment downloadsListFragment;
    DownloadFragment downloadFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);

        if(downloadsListFragment == null){
            downloadsListFragment = new DownloadsListFragment();
        }
        replaceFragment(downloadsListFragment,R.id.downloadsContainer,downloadsListFragment.TAG);
    }


    protected void replaceFragment(Fragment fragment, int container, String tag){
        getSupportFragmentManager().beginTransaction().replace(container,fragment,tag).commit();
    }

    @Override
    public void onFragmentInteraction(String tag) {
        if(tag.equals(DownloadsListFragment.TAG)){
            if(downloadFragment == null){
                downloadFragment = new DownloadFragment();
            }
            replaceFragment(downloadFragment,R.id.downloadsContainer,downloadFragment.TAG);
        }
    }


}
