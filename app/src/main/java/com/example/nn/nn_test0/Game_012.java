package com.example.nn.nn_test0;

import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

public class Game_012 extends Game {

    ImageView imgToDrag112, imgTargetDrop112, imgToDrag212, imgTargetDrop212, imgToDrag312, imgTargetDrop312;
    boolean result112, result212, result312;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_012);
        result112 = false;
        result212 = false;
        result312 = false;

        imgToDrag112     = (ImageView) findViewById(R.id.imageViewA112);
        imgTargetDrop112 = (ImageView) findViewById(R.id.imageViewDrop212);
        imgToDrag212     = (ImageView) findViewById(R.id.imageViewA212);
        imgTargetDrop212 = (ImageView) findViewById(R.id.imageViewDrop112);
        imgToDrag312     = (ImageView) findViewById(R.id.imageViewA312);
        imgTargetDrop312 = (ImageView) findViewById(R.id.imageViewDrop312);

        imgToDrag112.setOnLongClickListener(onLongClickListener);
        imgToDrag212.setOnLongClickListener(onLongClickListener);
        imgToDrag312.setOnLongClickListener(onLongClickListener);
        imgTargetDrop112.setOnDragListener(onDragListener112);
        imgTargetDrop212.setOnDragListener(onDragListener212);
        imgTargetDrop312.setOnDragListener(onDragListener312);


    }

    void proveriRezultat()
    {
        if(result112 && result212 && result312)
        {
            goToBravo();
        }
    }
    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            // example usage 2x larger shadow
            // View.DragShadowBuilder dragShadowBuilder = new MyDragShadowBuilder(view);
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data,dragShadowBuilder,view,0);
            return true;
        }
    };

    View.OnDragListener onDragListener112 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageViewA112)
                    {
                        //swap images
                        ImageView imageSwap112 = (ImageView) findViewById(R.id.imageViewDrop212);
                        imageSwap112.setImageResource(R.drawable.five);
                        result112 =true;
                        proveriRezultat();
                    }
                    break;
            }

            return true;
        }
    };
    View.OnDragListener onDragListener212 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageViewA212)
                    {
                        //swap images
                        ImageView imageSwap212 = (ImageView) findViewById(R.id.imageViewDrop112);
                        imageSwap212.setImageResource(R.drawable.two);
                        result212 = true;
                        proveriRezultat();
                    }
                    break;
            }

            return true;
        }
    };
    View.OnDragListener onDragListener312 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag = dragEvent.getAction();
            switch(drag)
            {
                case DragEvent.ACTION_DROP:
                    final View localView =(View) dragEvent.getLocalState();

                    if(localView.getId() == R.id.imageViewA312)
                    {
                        //swap images
                        ImageView imageSwap312 = (ImageView) findViewById(R.id.imageViewDrop312);
                        imageSwap312.setImageResource(R.drawable.seven);
                        result312 = true;
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
