package com.example.nn.nn_test0;

import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

import static com.example.nn.nn_test0.R.id.imageView03;

public class Game_003 extends Game {

    ImageView imgToDrag, imgTargetDrop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_003);

        imgToDrag = (ImageView) findViewById(R.id.imageView3);
        imgTargetDrop = (ImageView) findViewById(imageView03);

        imgToDrag.setOnLongClickListener(onLongClickListener);
        imgTargetDrop.setOnDragListener(onDragListener);

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

    View.OnDragListener onDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageView3)
                    {
                        //todo: swap images????
                        goToBravo();
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
