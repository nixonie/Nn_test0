package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Game_002 extends Activity {
    private SoundPool soundPool;
    private AudioManager audioManager;
    // Maximum sound stream.
    private static final int MAX_STREAMS = 5;
    // Stream type.
    private static final int streamType = AudioManager.STREAM_MUSIC;
    private boolean loaded;
    private int soundIdBarks;
    private float volume;

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
        setContentView(R.layout.activity_game_002);

        //todo add Audio to read question
        //todo replay the Audio on click of the question
        final ImageView image21 = (ImageView) this.findViewById(R.id.imageView21);
        final ImageView image22 = (ImageView) this.findViewById(R.id.imageView22);
        final ImageView image23 = (ImageView) this.findViewById(R.id.imageView23);
        final ImageView image24 = (ImageView) this.findViewById(R.id.imageView24);

        image21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image21.setVisibility(View.INVISIBLE);
                image24.setVisibility(View.VISIBLE);
                //goto bravo play shit etc.
                gotoBravo();
            }
        });
        image22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: bad choice actions
            }
        });
        image23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: bad choice actions
            }
        });


        //prepare to play audio two_barks from raw
        // AudioManager audio settings for adjusting the volume
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Current volumn Index of particular stream type.
        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);

        // Get the maximum volume index for a particular stream type.
        float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);

        // Volumn (0 --> 1)
        this.volume = currentVolumeIndex / maxVolumeIndex;

        // Suggests an audio stream whose volume should be changed by
        // the hardware volume controls.
        this.setVolumeControlStream(streamType);

        // For Android SDK >= 21
        AudioAttributes audioAttrib = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        SoundPool.Builder builder= new SoundPool.Builder();
        builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

        this.soundPool = builder.build();

        // When Sound Pool load complete.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        // Load sound file (two_barks.mp3) into SoundPool.
        this.soundIdBarks = this.soundPool.load(this, R.raw.two_barks,1);
    }

    private void gotoBravo() {
        //play audio two_barks from raw
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundIdBarks,leftVolumn, rightVolumn, 1, 0, 1f);
        }
        //todo navigate to Bravo screen, accept argument "current game", send argument to Bravo screen "next game"
        //todo compute the total number of games OR use a magic number, if next game > total, send arg goto home to Bravo screen
        //temp code START
        Intent myIntent2 = new Intent(this, Bravo1.class);
        startActivity(myIntent2);
        //temp code END
    }
}
