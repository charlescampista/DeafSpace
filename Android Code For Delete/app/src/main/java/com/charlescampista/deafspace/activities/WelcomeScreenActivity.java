package com.charlescampista.deafspace.activities;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.charlescampista.deafspace.fragments.CategoriaFragment;
import com.charlescampista.deafspace.fragments.ElementosFragment;
import com.charlescampista.deafspace.R;
import com.charlescampista.deafspace.fragments.VideoFragment;

import classes.Categoria;
import classes.Elemento;

public class WelcomeScreenActivity extends AppCompatActivity {

    Button btPlaySound;
    MediaPlayer introductionSound;
    ImageView ivPlay;

    CategoriaFragment categoriaFragment;
    ElementosFragment elementosFragment;
    VideoFragment videoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ivPlay = (ImageView) findViewById(R.id.ivPlay);
        introductionSound = MediaPlayer.create(this,R.raw.introductionsound);
        introductionSound.start();

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarCategoriaFragment();
                ivPlay.setVisibility(View.GONE);
            }
        });

    }

    protected void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,"TAG").commit();
    }

    public void chamarCategoriaFragment(){
        if(categoriaFragment== null){
            categoriaFragment = new CategoriaFragment();
        }
        replaceFragment(categoriaFragment);
    }

    public void chamarElementosFragment(Categoria categoria){
        if(elementosFragment == null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("categoria",categoria);
            elementosFragment = new ElementosFragment();
            elementosFragment.setArguments(bundle);
        }
        replaceFragment(elementosFragment);
    }

    public void chamarVideoFragment(Elemento elemento){
        if(videoFragment== null){
            Bundle bundle = new Bundle();
            bundle.putSerializable("elemento",elemento);
            videoFragment = new VideoFragment();
            videoFragment.setArguments(bundle);
        }
        replaceFragment(videoFragment);
    }

    public void pausarMusica(){
        introductionSound.pause();
    }

    public void tocarMusica(){
        introductionSound.start();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
