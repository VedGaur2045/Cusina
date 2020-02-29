package com.example.cusina.UtilClasses;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cusina.R;
import com.kaopiz.kprogresshud.KProgressHUD;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class UtilClass {
    public  static KProgressHUD loaderHUD;

    public static int getVal;

    public static Integer count=1;


    public  static  void backbtn(Activity context){
        context.finish();
        context.overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
    }

    public boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public  static  void fullsreenui(Activity context, String color){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor(color));
            // window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }

    }

    public static void showAlertDialogWithTwoOption(final Context context,String title, String message, String firstOption, String secondOption){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton(firstOption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + context.getPackageName()));
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        builder.setNegativeButton(secondOption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }


    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isNetwork = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (!isNetwork) {

            displayNoInternetAlertBox(context);
        }
        return !isNetwork;
    }


    //for displaynointernetalertbox..
    public static void displayNoInternetAlertBox(Context context) {


        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(context.getString(R.string.alert));

        builder.setMessage(context.getString(R.string.net_not_connected));

        builder.setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }
    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
        }
    }

    public static void enableTranslucentStatus(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static String streamToString(InputStream is) throws IOException {
        String str = "";

        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is));

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                reader.close();
            } finally {
                is.close();
            }

            str = sb.toString();
        }

        return str;
    }


    public static boolean resetExternalStorageMedia(Context context,
                                                    String filePath) {
        try {
            if (Environment.isExternalStorageEmulated())
                return (false);
            Uri uri = Uri.parse("file://" + new File(filePath));
            Intent intent = new Intent(Intent.ACTION_MEDIA_MOUNTED, uri);

            context.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
            return (false);
        }

        return (true);
    }

//    public static void notifyMediaScannerService(Context context,
//                                                 String filePath) {
//
//        MediaScannerConnection.scanFile(context, new String[]{filePath},
//                null, new MediaScannerConnection.OnScanCompletedListener() {
//                    public void onScanCompleted(String path, Uri uri) {
//                        Debug.i("ExternalStorage", "Scanned " + path + ":");
//                        Debug.i("ExternalStorage", "-> uri=" + uri);
//                    }
//                });
//    }

    public static void setPref(Context c, String pref, String val) {
        SharedPreferences.Editor e = PreferenceManager.getDefaultSharedPreferences(c).edit();
        e.putString(pref, val);
        e.commit();

    }

    public static String getPref(Context c, String pref, String val) {
        return PreferenceManager.getDefaultSharedPreferences(c).getString(pref,
                val);
    }

    public static void setPref(Context c, String pref, boolean val) {
        SharedPreferences.Editor e = PreferenceManager.getDefaultSharedPreferences(c).edit();
        e.putBoolean(pref, val);
        e.commit();

    }

    public static boolean getPref(Context c, String pref, boolean val) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(
                pref, val);
    }

    public static void delPref(Context c, String pref) {
        SharedPreferences.Editor e = PreferenceManager.getDefaultSharedPreferences(c).edit();
        e.remove(pref);
        e.commit();
    }





    public static void  showAlertDialog(Context context,String title,String desc)
    {


        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title);
        builder.setPositiveButton(context.getString(R.string.ok),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        }) ;

        builder.setMessage(desc);

        builder.show();

    }
    public static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target)
                    .matches();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public  static  void redStatusBar(Activity context){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#A00000"));
           // window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        }
    public static void setLightStatusBar(Activity activity,String color){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = activity.getWindow();
            View view = window.getDecorView();
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.parseColor(color));
        }
    }


    public static void customalert(View view,Activity context,String headingmessage,String message){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.customalert, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.FILL_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        final AlertDialog deleteDialog = new AlertDialog.Builder(context).create();
        deleteDialog.setView(popupView);
        deleteDialog.show();
        boolean focusable = true; // lets taps outside the popup also dismiss it
//        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        TextView heading=popupView.findViewById(R.id.main);
        TextView msg=popupView.findViewById(R.id.msg);
        Button ok=popupView.findViewById(R.id.ok);
        ImageView close=popupView.findViewById(R.id.close);
        heading.setText(headingmessage);
        msg.setText(message);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog.dismiss();
            }
        });


    }

    public static void sendExceptionReport(Exception e) {
        e.printStackTrace();

        try {
            // Writer result = new StringWriter();
            // PrintWriter printWriter = new PrintWriter(result);
            // e.printStackTrace(printWriter);
            // String stacktrace = result.toString();
            // new CustomExceptionHandler(c, URLs.URL_STACKTRACE)
            // .sendToServer(stacktrace);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static int getDeviceWidth(Context context) {
        try {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            return metrics.widthPixels;
        } catch (Exception e) {
            UtilClass.sendExceptionReport(e);
        }

        return 480;
    }

    public static int getDeviceHeight(Context context) {
        try {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            return metrics.heightPixels;
        } catch (Exception e) {
            UtilClass.sendExceptionReport(e);
        }

        return 800;
    }

    public static void hideKeyBoard(Context c, View v) {
        InputMethodManager imm = (InputMethodManager) c
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static String parseCalendarFormat(Calendar c, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,
                Locale.getDefault());
        return sdf.format(c.getTime());
    }

    public static String parseTime(long time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,
                Locale.getDefault());
        return sdf.format(new Date(time));
    }

    public static Date parseTime(String time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,
                Locale.getDefault());
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    public static String parseTime(String time, String fromPattern,
                                   String toPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(fromPattern,
                Locale.getDefault());
        try {
            Date d = sdf.parse(time);
            sdf = new SimpleDateFormat(toPattern, Locale.getDefault());
            return sdf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String nullSafe(String content) {
        if (content == null) {
            return "";
        }

        return content;
    }

    public static String nullSafe(String content, String defaultStr) {
        if (content.isEmpty()) {
            return defaultStr;
        }

        return content;
    }

    public static String nullSafeDash(String content) {
        if (content.isEmpty()) {
            return "-";
        }

        return content;
    }

    public static String nullSafe(int content, String defaultStr) {
        if (content == 0) {
            return defaultStr;
        }

        return "" + content;
    }

    public static Typeface getRobotoRegular(Context c) {
        try {
            return Typeface.createFromAsset(c.getAssets(),
                    "fonts/Roboto-Regular.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Typeface getRobotoLight(Context c) {
        try {
            return Typeface.createFromAsset(c.getAssets(),
                    "fonts/Roboto-Thin.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Typeface getRobotoBold(Context c) {
        try {
            return Typeface.createFromAsset(c.getAssets(),
                    "fonts/Roboto-Bold.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Typeface getCondensedNormal(Context c) {
        try {
            return Typeface.createFromAsset(c.getAssets(),
                    "fonts/RobotoCondensed-Regular.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean isGPSProviderEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static boolean isNetworkProviderEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);

        return locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    public static boolean isLocationProviderEnabled(Context context) {
        return (isGPSProviderEnabled(context) || isNetworkProviderEnabled(context));
    }

    public static ArrayList<String> asList(String str) {
        ArrayList<String> items = new ArrayList<String>(Arrays.asList(str
                .split("\\s*,\\s*")));

        return items;
    }

    public static String implode(ArrayList<String> data) {
        try {
            String devices = "";
            for (String iterable_element : data) {
                devices = devices + "," + iterable_element;
            }

            if (devices.length() > 0 && devices.startsWith(",")) {
                devices = devices.substring(1);
            }

            return devices;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getExtenstion(String urlPath) {
        if (urlPath.contains(".")) {
            String extension = urlPath.substring(urlPath.lastIndexOf(".") + 1);
            return extension;
        }

        return "";
    }



    public static void clearLoginCredetials(Activity c) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(c).edit();
        editor.clear();
        editor.commit();
//        FacebookSdk.sdkInitialize(c);
//        LoginManager.getInstance().logOut();
    }

//
//    public static void printHashKey(Context context) {
//        try {
//            PackageInfo info = context.getPackageManager().getPackageInfo(Constant.PACKAGE_NAME,
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = null;
//                try {
//                    md = MessageDigest.getInstance("SHA");
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                }
//                md.update(signature.toByteArray());
//                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//            Log.e("hashkey_error", e.toString());
//        }
//    }


    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static void hideloaderDialog()
    {
//        if(Utils.loaderdialog!=null) {
//            Utils.loaderdialog.dismiss();
//            Utils.loaderdialog=null;
//        }


        if(UtilClass.loaderHUD!=null) {
            UtilClass.loaderHUD.dismiss();
            UtilClass.loaderHUD=null;
        }


    }
    public static boolean ifLoaderShown()
    {

//        return (Utils.loaderdialog!=null);

        return (UtilClass.loaderHUD!=null);


    }

    public static void  showloaderDialog(Activity context,String loadertext)
    {

        showloaderDialog(context,loadertext,false);

    }

    public static void showloaderDialogProgress(Activity context,final int p)
    {


        if(ifLoaderShown())
        {
//            if(Utils.loaderdialog!=null) {
//                ProgressBar progressBarH=(ProgressBar)Utils.loaderdialog.findViewById(R.id.progressBarH);
//
//                progressBarH.setProgress(p);
//            }
//


            if(UtilClass.loaderHUD!=null) {
//                ProgressBar progressBarH=(ProgressBar)Utils.loaderdialog.findViewById(R.id.progressBarH);
//
//                progressBarH.setProgress(p);


                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UtilClass.loaderHUD.setProgress(p);
                    }
                });


            }




        }

    }

    public static void  showloaderDialog(Activity context,String loadertext,boolean bar)
    {
        hideloaderDialog();
        loadertext=String.format("    %s    ",loadertext);

        if(bar)
        {

            UtilClass.loaderHUD =  KProgressHUD.create(context)
                    .setStyle(KProgressHUD.Style.ANNULAR_DETERMINATE)
                    .setMaxProgress(100)
                    .setLabel(loadertext)
                    .setCancellable(false)
                    .setAutoDismiss(false)
                    .setBackgroundColor(context.getResources().getColor(R.color.colorPrimary))
                    .show();

            UtilClass.loaderHUD.setProgress(0);
        }
        else
        {
            ProgressBar pbar=new ProgressBar(context);
            pbar.setIndeterminate(true);
            pbar.getIndeterminateDrawable().setColorFilter(
                    Color.WHITE,
                    android.graphics.PorterDuff.Mode.SRC_IN);


            UtilClass.loaderHUD =  KProgressHUD.create(context)
                    //  .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(loadertext)
                    .setCancellable(false)
                    .setCustomView(pbar)
                    .setBackgroundColor(context.getResources().getColor(R.color.colorPrimary))
                    .show();


        }


//        Utils.loaderdialog=new Dialog(context);
//        Utils.loaderdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Utils.loaderdialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        Utils.loaderdialog.setContentView(R.layout.loader);
//        Utils.loaderdialog.setCancelable(false);
//
//        ProgressBar progressBar=(ProgressBar)Utils.loaderdialog.findViewById(R.id.progressBar);
//        ProgressBar progressBarH=(ProgressBar)Utils.loaderdialog.findViewById(R.id.progressBarH);
//        if(bar)
//        {
//
//            progressBar.setVisibility(View.GONE);
//            progressBarH.setProgress(0);
//            progressBarH.setMax(100);
//
//
//        }
//else
//            progressBarH.setVisibility(View.GONE);
//
//        TextView text=(TextView)Utils.loaderdialog.findViewById(R.id. loadingtext);
//        text.setText(loadertext);
//        Utils.loaderdialog.show();
//


    }


    public static void listSetHorizontal(RecyclerView listView, Context context){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        listView.setLayoutManager(linearLayoutManager);
    }
    public static void listFixedSize(RecyclerView itemList, Context context){
        itemList.setHasFixedSize(true);
        itemList.setLayoutManager(new LinearLayoutManager(context));
    }

    public  static String  getCurrentdate(){
        Date c_date = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("EE, MMM d yyyy");
        //textView.setText(format.format(c_date));
        return  format.format(c_date);
    }
    public  static String  getTomorrowdate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("EE, MMM d yyyy");
        //textView.setText(format.format(c_date));
        return  format.format(tomorrow);
    }

    public static void DateDialog(Context context,int day,int month,int year,final TextView textView){
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                Calendar calander2 = Calendar.getInstance();

                calander2.setTimeInMillis(0);

                calander2.set(year, monthOfYear, dayOfMonth, 0, 0, 0);

                Date SelectedDate = calander2.getTime();
                SimpleDateFormat format = new SimpleDateFormat("EE, MMM d yyyy");

                textView.setText(format.format(SelectedDate));

            }};
        DatePickerDialog dpDialog=new DatePickerDialog(context, listener, year, month, day);
        dpDialog.show();
    }

    public static void  TimeDialog(Context context,int hour,int minutes,final TextView textView){

        TimePickerDialog picker = new TimePickerDialog(context,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        Calendar calander2 = Calendar.getInstance();

                        calander2.setTimeInMillis(0);

                        calander2.set(0, 0, 0, sHour, sMinute, 0);

                        Date SelectedDate = calander2.getTime();
                        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm a");
                        //textView.setText(sHour + ":" + sMinute);
                        textView.setText(timeformat.format(SelectedDate));
                    }
                },hour, minutes, false);
        picker.show();
    }

    public static  void counterminus(TextView textView){

        count = Integer.valueOf(textView.getText().toString())-1;

        //double price = Double.parseDouble(holder.productPriceOrdered.getText().toString());

        if(count<1)
        {
            count = 1;
            textView.setText(String.valueOf(count));
            //calculatePrice(count,price,holder);
        }
        else {
            textView.setText(String.valueOf(count));
            //calculatePrice(count,price,holder);
        }
    }
    public  static  void  counterplus(TextView textView){
        //double price = Double.parseDouble(holder.productPriceOrdered.getText().toString());
        count=(Integer.valueOf(textView.getText().toString())+1);

        textView.setText(""+count);
        //calculatePrice(count,price,holder);
    }

    public static void setDividerOnRecycler(RecyclerView recycler,Context context){
        DividerItemDecoration verticalDecoration = new DividerItemDecoration(recycler.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable verticalDivider = ContextCompat.getDrawable(context, R.drawable.divider);
        verticalDecoration.setDrawable(verticalDivider);
        recycler.addItemDecoration(verticalDecoration);
    }

//    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
//        private int space;
//
//        public SpacesItemDecoration(int space) {
//            this.space = space;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            outRect.right = space;
//            outRect.bottom = space;
//
//            // Add top margin only for the first item to avoid double space between items
//            if (parent.getChildLayoutPosition(view) == 0) {
//                outRect.top = space;
//            } else {
//                outRect.top = 0;
//            }
//        }
//    }

}
