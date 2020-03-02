package com.lutongbahay.utils;

import android.app.DatePickerDialog;
import android.content.Context;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class DatePickerHelper {

    public static void showDatePicker(Context context,
                                      int day,
                                      int month,
                                      int year,
                                      int dayMin,
                                      int monthMin,
                                      int yearMin,
                                      DatePickerDialog.OnDateSetListener onDateSetListener) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(
                DateUtils.getTimeInMillis(dayMin + "/" + (monthMin + 1) + "/" + yearMin,
                        DateUtils.SIMPLE_DATE_FORMAT));

        datePickerDialog.show();
    }
}
