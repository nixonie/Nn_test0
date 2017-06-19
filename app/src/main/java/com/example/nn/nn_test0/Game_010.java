package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Game_010 extends Game {
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        final View decorView = this.getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_010);
        this.prepareImagesAndActions();
        //todo add Audio to read question
        //todo replay the Audio on click of the question

    }
    protected void prepareImagesAndActions()
    {
        final ImageView image2110 = (ImageView) this.findViewById(R.id.imageView2110);
        final ImageView image2210 = (ImageView) this.findViewById(R.id.imageView2210);
        final ImageView image2310 = (ImageView) this.findViewById(R.id.imageView2310);
        final ImageView image2410 = (ImageView) this.findViewById(R.id.imageView2410);

        image2310.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image2310.setVisibility(View.INVISIBLE);
                image2410.setVisibility(View.VISIBLE);
                //goto bravo play shit etc.
                goToBravo();
            }
        });
        image2110.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: bad choice actions
            }
        });
        image2210.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: bad choice actions
            }
        });
    }
    private void goToBravo()
    {
        doBarkSound();
        //todo navigate to Bravo screen, accept argument "current game", send argument to Bravo screen "next game"
        //todo compute the total number of games OR use a magic number, if next game > total, send arg goto home to Bravo screen
        showBravoScreen();

    }
}
