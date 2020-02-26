package com.asksira.bsimagepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class cTextView extends TextView {


    public cTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public cTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public cTextView(Context context) {
        super(context);
        init(null);
    }


    private void init(AttributeSet attrs) {
        if (attrs!=null) {

            this.setFocusable(false);

            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.customfontstyle);
            String fontName = a.getString(R.styleable.customfontstyle_fontName);
            if (fontName!=null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(),fontName);
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }

}