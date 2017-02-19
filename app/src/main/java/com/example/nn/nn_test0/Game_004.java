package com.example.nn.nn_test0;

import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

public class Game_004 extends Game {

    ImageView imgToDrag1, imgTargetDrop1, imgToDrag2, imgTargetDrop2, imgToDrag3, imgTargetDrop3;
    boolean result1, result2, result3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_004);
        result1 = false;
        result2 = false;
        result3 = false;

        imgToDrag1     = (ImageView) findViewById(R.id.imageView4);
        imgTargetDrop1 = (ImageView) findViewById(R.id.imageView3);
        imgToDrag2     = (ImageView) findViewById(R.id.imageView5);
        imgTargetDrop2 = (ImageView) findViewById(R.id.imageView1);
        imgToDrag3     = (ImageView) findViewById(R.id.imageView6);
        imgTargetDrop3 = (ImageView) findViewById(R.id.imageView2);

        imgToDrag1.setOnLongClickListener(onLongClickListener);
        imgToDrag2.setOnLongClickListener(onLongClickListener);
        imgToDrag3.setOnLongClickListener(onLongClickListener);
        imgTargetDrop1.setOnDragListener(onDragListener1);
        imgTargetDrop2.setOnDragListener(onDragListener2);
        imgTargetDrop3.setOnDragListener(onDragListener3);


    }

    void proveriRezultat()
    {
        if(result1 && result2 && result3)
        {
            goToBravo();
        }
    }
    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data,dragShadowBuilder,view,0);
            return true;
        }
    };

    View.OnDragListener onDragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageView4)
                    {
                        //todo: swap images???
                        result1 =true;
                        proveriRezultat();
                    }
                    break;
            }

            return true;
        }
    };
    View.OnDragListener onDragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageView5)
                    {
                        result2 = true;
                        proveriRezultat();
                    }
                    break;
            }

            return true;
        }
    };
    View.OnDragListener onDragListener3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageView6)
                    {
                        result3 = true;
                        proveriRezultat();
                    }

                    break;
            }

            return true;
        }
    };
    private void goToBravo()
    {
        doBarkSound();
        //todo navigate to Bravo screen, accept argument "current game", send argument to Bravo screen "next game"
        //todo compute the total number of games OR use a magic number, if next game > total, send arg goto home to Bravo screen
        showBravoScreen();

    }
}
