package com.lutongbahay.utils;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */



public class StringUtils {

    // Convert ArrayList into String
    public static String convertStringArrayListToString(ArrayList<String> list) {

        StringBuilder sb = new StringBuilder();
        String delim = "";
        for (String s : list) {
            sb.append(delim);
            sb.append(s);
            delim = ",";
        }
        return sb.toString();
    }

    // Convert Strings into ArrayList
    public static ArrayList<String> convertStringToStringArrayList(String string) {

        return new ArrayList<>(Arrays.asList(string
                .split(",")));
    }

    // Convert Strings into ArrayList
    public static ArrayList<Integer> convertStringToIntegerArrayList(String string) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] splitString = string.split(",");
        for (String s : splitString) {
            arrayList.add(Integer.parseInt(s));
        }
        return arrayList;

    }

    public static String truncateLastCharacterFromString(String value, int charToTruncate) {
        if (TextUtils.isEmpty(value))
            return value;
        return value.substring(0, value.length() - charToTruncate);
    }

    public static String extractNumberFromString(String value) {
        return value.replaceAll("\\D+", "");
    }

    public static String[] splitString(String value, String delimiter) {
        if (!TextUtils.isEmpty(value)) {
            if (value.contains(delimiter)) {
                return value.split(delimiter);
            }
        }
        return new String[]{value};
    }

    public static int getCurrentSelectedItemFromStringArray(String[] listItems, String currentItem) {
        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i].equalsIgnoreCase(currentItem)) {
                return i;
            }
        }

        return -1;
    }

    public static Long[] toPrimitives(long... objects) {

        Long[] primitives = new Long[objects.length];
        for (int i = 0; i < objects.length; i++)
            primitives[i] = objects[i];

        return primitives;
    }

    public static String convertFirstLetterCaps(String value) {
        if (TextUtils.isEmpty(value))
            return value;
        try {
            value = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
            return value;
        } catch (Exception ignored) {
            return value;
        }

    }

    public static String readJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
