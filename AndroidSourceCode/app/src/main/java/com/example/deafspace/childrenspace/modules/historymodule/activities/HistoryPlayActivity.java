package com.example.deafspace.childrenspace.modules.historymodule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.application.enums.BundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryBundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentsTags;
import com.example.deafspace.childrenspace.modules.historymodule.fragments.HistoryPartsFragment;
import com.example.deafspace.childrenspace.modules.historymodule.fragments.HistoryVideoFragment;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;

public class HistoryPlayActivity extends AppCompatActivity implements HistoryVideoFragment.OnFragmentInteractionListener, HistoryPartsFragment.OnFragmentInteractionListener{

    HistoryPartsFragment historyPartsFragment;
    HistoryVideoFragment historyVideoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_play);
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
        if(historyVideoFragment == null){
            historyVideoFragment = new HistoryVideoFragment();
        }
        replaceFragment(historyVideoFragment,R.id.historyContainerVideo, HistoryFragmentsTags.TAG_HISTORY_VIDEO_FRAGMENT.toString());

        if(historyPartsFragment == null){
            historyPartsFragment = new HistoryPartsFragment();
        }
        replaceFragment(historyPartsFragment,R.id.historyContainerParts,HistoryFragmentsTags.TAG_HISTORY_PART_FRAGMENT.toString());
    }


    @Override
    public void onFragmentInteraction(String tag, Object object) {

        if(object != null){
            switch (tag){
                case HistoryPartsFragment.TAG:
                    Toast.makeText(this,"Event Received",Toast.LENGTH_LONG).show();
                /*if(vocabularyVideoFragment == null){
                    vocabularyVideoFragment = new VocabularyVideoFragment();
                }*/
                    historyVideoFragment = new HistoryVideoFragment();
                    Part part = (Part) object;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(HistoryBundleKeys.HiSTORY_PART.toString(),part);
                    historyVideoFragment.setArguments(bundle);
                    replaceFragment(historyVideoFragment,R.id.historyContainerVideo,historyVideoFragment.TAG);
                    break;
            }
        }

        if(object == null){
            Toast.makeText(this,"O click fora da lista",Toast.LENGTH_SHORT).show();
        }





    }

}
