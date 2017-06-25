package com.example.nn.nn_test0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            //issue: sets height and width but this does not work on all screen sizes, 385 is good for big, 200 or something for small :(
            //imageView.setLayoutParams(new GridView.LayoutParams(200, 200)); //fix below
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.th_q001, R.drawable.th_q004,
            R.drawable.th_q003, R.drawable.th_q002,
            R.drawable.th_q005, R.drawable.th_q006,
            R.drawable.th_q007, R.drawable.th_q008,
            R.drawable.th_q009, R.drawable.th_q010,
            R.drawable.th_q011, R.drawable.th_q012,
            R.drawable.th_q001, R.drawable.th_q002,
            R.drawable.th_q003, R.drawable.th_q004,
            R.drawable.th_q005, R.drawable.th_q002,
            R.drawable.th_q003, R.drawable.th_q001
    };
}
