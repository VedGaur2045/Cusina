package com.lutongbahay.utils;

import android.os.Build;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class TextUtils {

    public static boolean isNumberExist(String value) {
        Pattern numberPat = Pattern.compile("\\d+");
        Matcher matcher = numberPat.matcher(value);
        return matcher.find();
    }

    public static void setTextMaxLength(EditText editText, int maxLength) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    public static boolean isEmailIdValid(String target) {
        return !isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean hasValidText(TextView textView) {
        if (textView != null && textView.getText() != null) {
            return !isEmpty(textView.getText().toString().trim());
        }
        return false;
    }

    public static boolean isEmpty(TextView textView) {
        if (textView != null && textView.getText() != null) {
            return isEmpty(textView.getText().toString().trim());
        }
        return true;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static int getLength(TextView textView) {
        return getText(textView).length();
    }

    public static int getLength(EditText editText) {
        return getText(editText).length();
    }

    public static String getText(TextView textView) {
        if (textView != null && textView.getText() != null) {
            return textView.getText().toString().trim();
        }
        return "";
    }


    public static boolean checkValidAddress(String address) {
        return !isEmpty(address) &&
                !address.equalsIgnoreCase("Unnamed Location") &&
                !address.equalsIgnoreCase("Null");
    }

    public static String priceFormat(String price) {
        String newPrice = String.format(Locale.getDefault(), "%.2f", Double.parseDouble(price));
        String formatPrice = NumberFormat.getNumberInstance(Locale.getDefault()).format(Double.parseDouble(newPrice));
        //Logger.DebugLog("PRICE", "FORMAT  $price - $formatPrice - $newPrice")
        return String.format("%s", formatPrice);
    }

    public static String getText(EditText editText) {
        if (editText != null && editText.getText() != null) {
            return editText.getText().toString().trim();
        }
        return "";
    }

    public static void showHTMLText(TextView textView, String value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(value, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(value));
        }
    }

    public static Spanned getHTMLText(String value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(value, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(value);
        }
    }

    public static void setPrice(TextView amountLabel, String rsFormat, String amount, View... views) {
        int i = amount == null ? 0 : Integer.valueOf(amount);
        setPrice(amountLabel, rsFormat, i, views);
    }

    public static void setPrice(TextView amountLabel, String rsFormat, int amount, View... views) {
        if (amount > 0) {
            amountLabel.setVisibility(View.VISIBLE);
            amountLabel.setText(String.format(rsFormat, TextUtils.priceFormat(String.valueOf(amount))));
            for (View view : views) {
                view.setVisibility(View.VISIBLE);
            }
        } else {
            amountLabel.setVisibility(View.GONE);
            for (View view : views) {
                view.setVisibility(View.GONE);
            }
        }
    }
}
