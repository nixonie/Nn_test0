package com.example.nn.nn_test0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Main2Activity.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
//TODO: app is slow on device | do we HAVE to use a different id for _every_ image view in app xml's? (and buttons etc.) |
    // TODO: make other game templates samples
    // TODO: make backgrounds repeatable image
    // TODO: make different version of images for different densities
}
