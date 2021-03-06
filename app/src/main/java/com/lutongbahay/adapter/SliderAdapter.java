package com.lutongbahay.adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.lutongbahay.R;
import com.lutongbahay.glide.GlideApp;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    ArrayList<String> image;
    private Context context;
    private LayoutInflater inflater;

    public SliderAdapter(ArrayList<String> image, Context context) {
        this.image = image;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    public Object instantiateItem(ViewGroup view, final int position) {

        System.out.println("Image : "+image.get(0));

        View layoutSlider = inflater.inflate(R.layout.adpter_image_slider_layout, view, false);

        assert layoutSlider != null;

        ImageView imageView = layoutSlider.findViewById(R.id.productImgItem);

        //imageView.setImageResource(image.get(position));
        GlideApp.with(context).load(image.get(position)).into(imageView);

        view.addView(layoutSlider, 0);

        return layoutSlider;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
