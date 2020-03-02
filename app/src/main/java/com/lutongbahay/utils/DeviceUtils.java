package com.lutongbahay.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class DeviceUtils {

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isMyServiceRunning(Context context, Class serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningServiceInfo runningService : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(runningService.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppRunning(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND &&
                    processInfo.processName.equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDeviceSupportCamera(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        }
        // ToastUtils.longToast(R.string.camera_not_supported);
        return false;
    }


}
