package com.lutongbahay.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.lutongbahay.R;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

public class DialogHelperClass {

    public static void showMessageOKCancel(Context context,
                                           String message,
                                           String positiveButton,
                                           String negativeButton,
                                           DialogInterface.OnClickListener okListener,
                                           DialogInterface.OnClickListener cancelListener) {
        new AlertDialog.Builder(context, R.style.DialogTheme)
                .setMessage(message)
                .setPositiveButton(positiveButton, okListener)
                .setNegativeButton(negativeButton, cancelListener)
                .setCancelable(false)
                .create()
                .show();
    }

    public static void showMessageThreeButton(Context context,
                                              String message,
                                              String positiveButton,
                                              String neutralButton,
                                              String negativeButton,
                                              DialogInterface.OnClickListener okListener,
                                              DialogInterface.OnClickListener neutralnListener,
                                              DialogInterface.OnClickListener cancelListener) {
        new AlertDialog.Builder(context, R.style.DialogTheme)
                .setMessage(message)
                .setPositiveButton(positiveButton, okListener)
                .setNeutralButton(neutralButton, neutralnListener)
                .setNegativeButton(negativeButton, cancelListener)
                .setCancelable(false)
                .create()
                .show();
    }




}
