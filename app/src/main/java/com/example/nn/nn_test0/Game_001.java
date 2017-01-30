package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Game_001 extends Game {
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
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
    protected void prepareImagesAndActions()
    {

        final ImageView image1 = (ImageView) this.findViewById(R.id.imageView6);
        final ImageView image2 = (ImageView) this.findViewById(R.id.imageView5_1);
        final ImageView image3 = (ImageView) this.findViewById(R.id.imageView4_2);
        final ImageView imageF1 = (ImageView) this.findViewById(R.id.imageView001_1);
        final ImageView imageF2 = (ImageView) this.findViewById(R.id.imageView001_2);
        final ImageView imageF3 = (ImageView) this.findViewById(R.id.imageView001_3);

        image1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image1.setVisibility(View.INVISIBLE);
                imageF1.setVisibility(View.VISIBLE);
                checkResults(imageF1, imageF2, imageF3);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image2.setVisibility(View.INVISIBLE);
                imageF2.setVisibility(View.VISIBLE);
                checkResults(imageF1, imageF2, imageF3);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image3.setVisibility(View.INVISIBLE);
                imageF3.setVisibility(View.VISIBLE);
                checkResults(imageF1, imageF2, imageF3);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_001);
        prepareImagesAndActions();
    }
    public void checkResults(ImageView check1, ImageView check2, ImageView check3)
    {
        if (isVisible(check1) && isVisible(check2) && isVisible(check3))
        {
            //todo navigate to Bravo screen, accept argument "current game", send argument to Bravo screen "next game"
            //todo compute the total number of games OR use a magic number, if next game > total, send arg goto home to Bravo screen
            //Toast.makeText(getApplicationContext(), "Bravo!", Toast.LENGTH_SHORT).show()
            doBarkSound();
            //TODO fix: this shit below works in emulator but on device NOT the first time you try :(
            showBravoScreen();
        }
    }
    protected boolean isVisible(ImageView imageView)
    {
        if(imageView.getVisibility()== View.VISIBLE)
            return true;

        return false;
    }
}
