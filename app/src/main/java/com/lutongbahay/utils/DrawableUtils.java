package com.lutongbahay.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import androidx.core.graphics.drawable.DrawableCompat;

import java.util.Random;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class DrawableUtils {

    public static Drawable changeDrawableColor(Context context, int image, int color) {
        Drawable drawable = context.getResources().getDrawable(image);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, context.getResources().getColor(color));
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}


