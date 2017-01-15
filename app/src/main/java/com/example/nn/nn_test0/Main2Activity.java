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
        // TODO: make it go to different game/activity onclick different image
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent myIntent;
                switch(position) {
                    case 0:
                        myIntent = new Intent(v.getContext(), Game_001.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    default:
//                        myIntent = new Intent(v.getContext(), Game_001.class);
//                        startActivityForResult(myIntent, 0);
                }
            }});



    }
}


