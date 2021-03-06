package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent myIntent;

                switch(position) {
                    case 0:
                        myIntent = new Intent(v.getContext(), Game_001.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent = new Intent(v.getContext(), Game_002.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 2:
                        myIntent = new Intent(v.getContext(), Game_003.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 3:
                        myIntent = new Intent(v.getContext(), Game_004.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 4:
                        myIntent = new Intent(v.getContext(), Game_005.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 5:
                        myIntent = new Intent(v.getContext(), Game_006.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 6:
                        myIntent = new Intent(v.getContext(), Game_007.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 7:
                        myIntent = new Intent(v.getContext(), Game_008.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 8:
                        myIntent = new Intent(v.getContext(), Game_009.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 9:
                        myIntent = new Intent(v.getContext(), Game_010.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 10:
                        myIntent = new Intent(v.getContext(), Game_011.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 11:
                        myIntent = new Intent(v.getContext(), Game_012.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    default:
                        myIntent = new Intent(v.getContext(), Game_001.class);
                        startActivityForResult(myIntent, 0);
                }
            }});



    }

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
}


