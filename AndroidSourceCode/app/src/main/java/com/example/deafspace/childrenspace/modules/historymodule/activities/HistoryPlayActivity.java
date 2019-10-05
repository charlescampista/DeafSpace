package com.example.deafspace.childrenspace.modules.historymodule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.deafspace.R;
import com.example.deafspace.application.enums.BundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryBundleKeys;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentResult;
import com.example.deafspace.childrenspace.modules.historymodule.enums.HistoryFragmentsTags;
import com.example.deafspace.childrenspace.modules.historymodule.fragments.HistoryAnimationFragment;
import com.example.deafspace.childrenspace.modules.historymodule.fragments.HistoryPartsFragment;
import com.example.deafspace.childrenspace.modules.historymodule.fragments.HistoryVideoFragment;
import com.example.deafspace.childrenspace.modules.historymodule.fragments.SinglePartFragment;
import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;

public class HistoryPlayActivity extends AppCompatActivity implements HistoryVideoFragment.OnVideoSignInteractionListener, HistoryPartsFragment.OnPartsFragmentInteractionListener, SinglePartFragment.OnSinglePartInteractionListener, HistoryAnimationFragment.OnAnimationInteraction{

    HistoryPartsFragment historyPartsFragment;
    HistoryVideoFragment historyVideoFragment;

    //Toogle frag tags USED JUST FOR TOOGLE FRAGS WITHOUT HAVE TO KILL THIS
    public static final String PARTS_FRAG = "partsFrag";
    //public static final String ANIMATION_FRAG = "animationFrag";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //startFragments();
        //startPartsFragment();
        HistoryPartsFragment historyPartsFragment = new HistoryPartsFragment();
        //R.id.historyContainerParts,new HistoryPartsFragment(),PARTS_FRAG
        replaceFragment(historyPartsFragment,R.id.historyContainerParts,historyVideoFragment.TAG);

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

    protected void replaceVideoFragment(Bundle bundle){
        if(bundle != null){
            HistoryVideoFragment fragment = new HistoryVideoFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.historyContainerVideo,fragment,HistoryFragmentsTags.TAG_HISTORY_VIDEO_FRAGMENT.toString()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.historyContainerVideo,new HistoryVideoFragment(),HistoryFragmentsTags.TAG_HISTORY_VIDEO_FRAGMENT.toString()).commit();
        }
    }

    /*private void startFragments(){
        if(historyVideoFragment == null){
            historyVideoFragment = new HistoryVideoFragment();
        }
        //replaceFragment(new HistoryVideoFragment(),R.id.historyContainerVideo, HistoryFragmentsTags.TAG_HISTORY_VIDEO_FRAGMENT.toString());

        if(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG) != null){
            getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG)).commit();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.historyContainerParts,new HistoryPartsFragment(),PARTS_FRAG).commit();
        }

        if(getSupportFragmentManager().findFragmentByTag(ANIMATION_FRAG) != null){
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag(ANIMATION_FRAG)).commit();
        }

    }*/

    private void startPartsFragment(){
        getSupportFragmentManager().beginTransaction().add(R.id.historyContainerParts,new HistoryPartsFragment(),PARTS_FRAG).commit();
    }

    private void showPartsFragment(){
        getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG)).commit();
    }

    private void hidePartsFragment(){
        getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG)).commit();
    }

    /*private void toggleFragments(String tag, Bundle animationBundle){
        switch (tag){
            case PARTS_FRAG:
                if(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG) != null){
                    getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG)).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().add(R.id.historyContainerParts,new HistoryPartsFragment(),PARTS_FRAG).commit();
                }
                if(getSupportFragmentManager().findFragmentByTag(ANIMATION_FRAG) != null){
                    getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag(ANIMATION_FRAG)).commit();
                }
                break;

            case ANIMATION_FRAG:
                HistoryAnimationFragment historyAnimationFragment = new HistoryAnimationFragment();
                historyAnimationFragment.setArguments(animationBundle);

                if(getSupportFragmentManager().findFragmentByTag(ANIMATION_FRAG) != null){
                    getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(ANIMATION_FRAG)).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.historyContainerParts,historyAnimationFragment,ANIMATION_FRAG).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().add(R.id.historyContainerParts,historyAnimationFragment,ANIMATION_FRAG).commit();
                }

                if(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG) != null){
                    getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentByTag(PARTS_FRAG)).commit();
                }
                break;

        }
    }*/




    /*@Override
    public void onFragmentInteraction(String tag, Object object, HistoryFragmentResult result) {

        if(object != null){

            Bundle bundle = null;
            Toast.makeText(this, "ENTROU NO INTERACTION",Toast.LENGTH_SHORT).show();
            switch (tag){
                case HistoryAnimationFragment.TAG:
                    Toast.makeText(this, "RECONHECEU O ANIMATION TAG PART",Toast.LENGTH_SHORT).show();
                    if(result == HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED){
                        //historyVideoFragment = new HistoryVideoFragment();
                        //bundle = new Bundle();
                        //bundle.putSerializable(HistoryBundleKeys.HiSTORY_PART_SIGN.toString(),(Part) object)
                        //historyVideoFragment.setArguments(bundle);
                        //replaceFragment(historyVideoFragment,R.id.historyContainerVideo,historyVideoFragment.TAG);

                        Toast.makeText(this, "RECONHECEU O ANIMATION RESULT",Toast.LENGTH_SHORT).show();
                    }
                    break;

                case SinglePartFragment.TAG:
                    Toast.makeText(this, "RECONHECEU O TAG SINGLE PART",Toast.LENGTH_SHORT).show();
                    if(result == HistoryFragmentResult.ARGUMENT_PASSED){
                        hidePartsFragment();

                        HistoryAnimationFragment animationFragment = new HistoryAnimationFragment();
                        bundle = new Bundle();
                        bundle.putSerializable(HistoryBundleKeys.HiSTORY_PART_ANIMATION.toString(),(Part) object);
                        animationFragment.setArguments(bundle);
                        replaceFragment(animationFragment,R.id.historyContainerParts,animationFragment.TAG);
                        //toggleFragments(ANIMATION_FRAG,bundle);
                        Toast.makeText(this, "RECONHECEU O RESULT",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }

        if(tag.equals(SinglePartFragment.TAG)){
            hidePartsFragment();

            HistoryAnimationFragment animationFragment = new HistoryAnimationFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HistoryBundleKeys.HiSTORY_PART_ANIMATION.toString(),(Part) object);
            animationFragment.setArguments(bundle);
            replaceFragment(animationFragment,R.id.historyContainerParts,animationFragment.TAG);
            //toggleFragments(ANIMATION_FRAG,bundle);
            Toast.makeText(this, "CHAMOU O ANIMATION",Toast.LENGTH_SHORT).show();
        }

        if(object == null){
            Toast.makeText(this,"O click fora da lista",Toast.LENGTH_SHORT).show();
        }

    }*/

    /*@Override
    public void onAnimationFinished() {
       Part part = (Part) object;
        if(part != null){
            Toast.makeText(this,part.getName(),Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this,tag,Toast.LENGTH_SHORT).show();
        if(result == HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED){
            Toast.makeText(this,"O RESULT ESTA CORRETO",Toast.LENGTH_SHORT).show();

        Toast.makeText(this,"VOLTOU NA ACTIVITY",Toast.LENGTH_SHORT).show();

    }*/

    @Override
    public void onAnimationFinished(Object object, HistoryFragmentResult result) {

        //showPartsFragment();
        if(result == HistoryFragmentResult.VIDEO_FINISHED_AND_ARGUMENT_PASSED){

            historyVideoFragment = new HistoryVideoFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HistoryBundleKeys.HiSTORY_PART_SIGN.toString(),(Part) object);
            historyVideoFragment.setArguments(bundle);
            replaceFragment(historyVideoFragment,R.id.historyContainerVideo,historyVideoFragment.TAG);
        }
    }

    @Override
    public void onPartsInteraction(Object object, HistoryFragmentResult result) {

    }

    @Override
    public void onReprodutionFinish(Object object, HistoryFragmentResult result) {

        HistoryPartsFragment historyPartsFragment = new HistoryPartsFragment();
        //R.id.historyContainerParts,new HistoryPartsFragment(),PARTS_FRAG
        replaceFragment(historyPartsFragment,R.id.historyContainerParts,historyPartsFragment.TAG);
    }

    @Override
    public void onPlayClicked(Object object, HistoryFragmentResult result) {

        if(result == HistoryFragmentResult.ARGUMENT_PASSED){

            //hidePartsFragment();
            HistoryAnimationFragment animationFragment = new HistoryAnimationFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HistoryBundleKeys.HiSTORY_PART_ANIMATION.toString(),(Part) object);
            animationFragment.setArguments(bundle);
            replaceFragment(animationFragment,R.id.historyContainerParts,animationFragment.TAG);

            //toggleFragments(ANIMATION_FRAG,bundle);

        }
    }
}
