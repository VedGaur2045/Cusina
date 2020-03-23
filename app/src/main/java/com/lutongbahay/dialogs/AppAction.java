package com.lutongbahay.dialogs;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.main.fragments.my_tray.MyTrayFragmentDirections;
import com.lutongbahay.utils.StatusBarUtils;

import java.text.DecimalFormat;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class AppAction {
    private static final int STORAGE_PERMISSION_CODE = 902;
    private static DecimalFormat dFormat = new DecimalFormat("#0.00");

    public static void addCountWithSetValue(int count, double productPriceOrdered, TextView textView, TextView textView2, TextView textView3) {
        count = (Integer.parseInt(textView.getText().toString()) + 1);
        textView.setText(String.valueOf(count));
        textView2.setText(dFormat.format(count * productPriceOrdered));
        textView3.setText(dFormat.format(count * productPriceOrdered));
    }

    public static void minusCountWithSetValue(int count, double productPriceOrdered, TextView textView, TextView textView2, TextView textView3) {
        count = Integer.parseInt(textView.getText().toString()) - 1;
        if (count < 1) {
            count = 1;
            textView.setText(String.valueOf(count));
            textView2.setText(dFormat.format(count * productPriceOrdered));
            textView3.setText(dFormat.format(count * productPriceOrdered));
        } else {
            textView.setText(String.valueOf(count));
            textView2.setText(dFormat.format(count * productPriceOrdered));
            textView3.setText(dFormat.format(count * productPriceOrdered));
        }
    }

    public static void addCount(int count, TextView textView) {
        count = (Integer.parseInt(textView.getText().toString()) + 1);
        textView.setText(String.valueOf(count));
    }

    public static void minusCount(int count, TextView textView) {
        count = Integer.parseInt(textView.getText().toString()) - 1;
        if (count < 1) {
            count = 1;
            textView.setText(String.valueOf(count));
        } else {
            textView.setText(String.valueOf(count));

        }
    }

    public static void onBackPress(Activity context, View view, Fragment fragmentActivity, NavDirections navDirections) {
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


    public static void callPhoneByGivenNumber(String number, Context context) {
        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context,
                new String[]{CALL_PHONE},
                STORAGE_PERMISSION_CODE)) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + number));

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            context.startActivity(callIntent);
        }
    }

    public static void smsOnNumber(){

    }


}
