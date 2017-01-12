package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Game_001 extends Activity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_001);

        //todo add Audio to read question
        //todo replay the Audio on click of the question

        //used to be a home button
//        Button home = (Button) findViewById(R.id.button_home);
//        home.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), Main2Activity.class);
//                startActivityForResult(myIntent, 0);
//            }
//        });

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
                checkAll(imageF1, imageF2, imageF3);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image2.setVisibility(View.INVISIBLE);
                imageF2.setVisibility(View.VISIBLE);
                checkAll(imageF1, imageF2, imageF3);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image3.setVisibility(View.INVISIBLE);
                imageF3.setVisibility(View.VISIBLE);
                checkAll(imageF1, imageF2, imageF3);
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
    public void checkAll(ImageView check1, ImageView check2, ImageView check3) {
        if ((check1.getVisibility() == View.VISIBLE) && (check2.getVisibility() == View.VISIBLE) && (check3.getVisibility() == View.VISIBLE)) {
            //todo navigate to Bravo screen, accept argument "current game", send argument to Bravo screen "next game"
            //todo compute the total number of games OR use a magic number, if next game > total, send arg goto home to Bravo screen
            //Toast.makeText(getApplicationContext(), "Bravo!", Toast.LENGTH_SHORT).show();

            //play audio two_barks from raw
            if(loaded)  {
                float leftVolumn = volume;
                float rightVolumn = volume;

                // Play sound objects destroyed. Returns the ID of the new stream.
                int streamId = this.soundPool.play(this.soundIdBarks,leftVolumn, rightVolumn, 1, 0, 1f);
            }

            //temp code START
            //TODO fix: this shit below works in emulator but on device NOT the first time you try :(
            Intent myIntent2 = new Intent(this, Bravo1.class);
            startActivity(myIntent2);
            //temp code END
        }
    }
}
