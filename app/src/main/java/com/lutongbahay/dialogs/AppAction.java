package com.lutongbahay.dialogs;

import android.widget.TextView;

public class AppAction {
    public static void addCount(int count, TextView textView){
        count=(Integer.parseInt(textView.getText().toString())+1);
        textView.setText(String.valueOf(count));
    }

    public static void minusCount(int count, TextView textView){
        count = Integer.parseInt(textView.getText().toString())-1;
        if(count<1)
        {
            count = 1;
            textView.setText(String.valueOf(count));
        }
        else {
            textView.setText(String.valueOf(count));
        }
    }
}
