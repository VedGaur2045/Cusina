package com.lutongbahay.dialogs;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.lutongbahay.main.fragments.my_tray.MyTrayFragmentDirections;
import com.lutongbahay.utils.StatusBarUtils;

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

    public static void onBackPress(Activity context, View view, Fragment fragmentActivity, NavDirections navDirections){
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view)
                        .navigate(navDirections);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar(context);
                }
            }
        };
        fragmentActivity.requireActivity().getOnBackPressedDispatcher().addCallback(fragmentActivity, callback);
    }


}
