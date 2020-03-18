package com.lutongbahay.dialogs;

import android.widget.TextView;

import java.text.DecimalFormat;

public class AppAction {
    private static DecimalFormat dFormat = new DecimalFormat("#0.00");
    public static void addCountWithSetValue(int count,double productPriceOrdered, TextView textView,TextView textView2, TextView textView3){
        count=(Integer.parseInt(textView.getText().toString())+1);
        textView.setText(String.valueOf(count));
        textView2.setText(dFormat.format(count*productPriceOrdered));
        textView3.setText(dFormat.format(count*productPriceOrdered));
    }

    public static void minusCountWithSetValue(int count,double productPriceOrdered, TextView textView,TextView textView2, TextView textView3){
        count = Integer.parseInt(textView.getText().toString())-1;
        if(count<1)
        {
            count = 1;
            textView.setText(String.valueOf(count));
            textView2.setText(dFormat.format(count*productPriceOrdered));
            textView3.setText(dFormat.format(count*productPriceOrdered));
        }
        else {
            textView.setText(String.valueOf(count));
            textView2.setText(dFormat.format(count*productPriceOrdered));
            textView3.setText(dFormat.format(count*productPriceOrdered));
        }
    }

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
