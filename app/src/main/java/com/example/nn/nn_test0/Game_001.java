package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Game_001 extends Activity {

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
                //todo Play Audio "happy bark"
                image1.setVisibility(View.INVISIBLE);
                imageF1.setVisibility(View.VISIBLE);
                checkAll(imageF1, imageF2, imageF3);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //todo Play Audio "happy bark"
                image2.setVisibility(View.INVISIBLE);
                imageF2.setVisibility(View.VISIBLE);
                checkAll(imageF1, imageF2, imageF3);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //todo Play Audio "happy bark"
                image3.setVisibility(View.INVISIBLE);
                imageF3.setVisibility(View.VISIBLE);
                checkAll(imageF1, imageF2, imageF3);
            }
        });
}
    public void checkAll(ImageView check1, ImageView check2, ImageView check3) {
        if ((check1.getVisibility() == View.VISIBLE) && (check2.getVisibility() == View.VISIBLE) && (check3.getVisibility() == View.VISIBLE)) {
            //todo navigate to Bravo screen, accept argument "current game", send argument to Bravo screen "next game"
            //todo compute the total number of games OR use a magic number, if next game > total, send arg goto home tp Bravo screen
            //Toast.makeText(getApplicationContext(), "Bravo!", Toast.LENGTH_SHORT).show();

            //temp code START
            //TODO fix: this shit below works in emulator but not on device :(
            Intent myIntent2 = new Intent(this, Bravo1.class);
            startActivity(myIntent2);
            //temp code END
        }
    }
}
