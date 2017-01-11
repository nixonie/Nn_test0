package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bravo1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bravo1);

        Button next2 = (Button) findViewById(R.id.button2);
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                Intent myIntent3 = new Intent(view2.getContext(), Main2Activity.class);
                startActivityForResult(myIntent3, 0);
            }

        });
    }
}
