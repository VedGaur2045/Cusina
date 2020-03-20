package com.lutongbahay.utils;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class Constants {

    public static boolean isRegistered = false;
    public static boolean openProfile = false;
    public static int constVal;

    // Month Name
    public static final String JAN = "January";
    public static final String FAB = "February";
    public static final String MAR = "March";
    public static final String APR = "April";
    public static final String MAY = "May";
    public static final String JUN = "June";
    public static final String JUL = "July";
    public static final String AUG = "August";
    public static final String SEP = "September";
    public static final String OCT = "October";
    public static final String NOV = "November";
    public static final String DEC = "December";

    public static int getMonthValInt(String month){
        int monthVal = -1;
        switch (month){
            case Constants.JAN : monthVal=0; break;
            case Constants.FAB : monthVal=1; break;
            case Constants.MAR : monthVal=2; break;
            case Constants.APR : monthVal=3; break;
            case Constants.MAY : monthVal=4; break;
            case Constants.JUN : monthVal=5; break;
            case Constants.JUL : monthVal=6; break;
            case Constants.AUG : monthVal=7; break;
            case Constants.SEP : monthVal=8; break;
            case Constants.OCT : monthVal=9; break;
            case Constants.NOV : monthVal=10; break;
            case Constants.DEC : monthVal=11; break;
        }
        return monthVal;
    }

    public static String getMonthValStr(String month){
        String str = "";
        switch (month){
            case "Jan" : str = Constants.JAN; break;
            case "Fab" : str = Constants.FAB; break;
            case "Mar" : str = Constants.MAR; break;
            case "Apr" : str = Constants.APR; break;
            case "May" : str = Constants.MAY; break;
            case "Jun" : str = Constants.JUN; break;
            case "Jul" : str = Constants.JUL; break;
            case "Aug" : str = Constants.AUG; break;
            case "Sep" : str = Constants.SEP; break;
            case "Oct" : str = Constants.OCT; break;
            case "Nov" : str = Constants.NOV; break;
            case "Dec" : str = Constants.DEC; break;
        }
        return str;
    }

}
