package com.nacoda.dzikir_mvvm;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mayburger on 1/8/18.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] data;

    public ViewPagerAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.dzikir_layout, container, false);
        TextView tvDzikir = v.findViewById(R.id.tvDzikir);
        tvDzikir.setText(data[position]);
        ((ViewPager)container).addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(((LinearLayout) object));
    }
}
