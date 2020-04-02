package com.lutongbahay.utils;


/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class Constants {

    public static double LAT;
    public static double LNG;
    public static boolean isRegistered = false;
    public static boolean openProfile = false;
    public static int constVal;
    public static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjllODAxYTkwZjJjZDg0ZDI1ZWE1YTZhNmE0YTBmNjE0NzBmYTcyMTE1ZWJkY2FkM2JlNmQ0ZDVlMzE0NjQ4NmI3NWMwMjZmMTEwZDQ0Mjk4In0.eyJhdWQiOiIyIiwianRpIjoiOWU4MDFhOTBmMmNkODRkMjVlYTVhNmE2YTRhMGY2MTQ3MGZhNzIxMTVlYmRjYWQzYmU2ZDRkNWUzMTQ2NDg2Yjc1YzAyNmYxMTBkNDQyOTgiLCJpYXQiOjE1ODM2OTI0NjUsIm5iZiI6MTU4MzY5MjQ2NSwiZXhwIjoxNjE1MjI4NDY1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.WsVHwfus2vs9gA0fbiv5LVmOFhhUmn28OrnKtXx_e5O7VCOy3fQ_plRXJiLNkatGBnGBCSgny-bjI1kUOf_6m9e1Vou17WT6ouGdUZQCA5Kp0gLnxPrCLveop4qqwBGR_tl0Myvphz1UCTnHuciePYtQaqyrsuAV3ub9tZf3gJcAeH3jF2hFz1gdu_r6-ZUaMcU3nKAjQXpxZtiCGUrVPwvzjQNN7nHED_EE7xXM-JQf2_qe4AS0hVfZjUWvNPDAQZ0BfiqD0xpWObMfIkGkf5C2eMRlISEhrdobHsGd7_3XyM7gKE7pm8cZqWlAPig4tHeRSa1vfEV48tbjsXi-_-Ufr4_AQmGIe4HzsrWcnQ3ZaCEiGYeBdKdkGe2xtw64mRKtIBAEupiZtAQExvCc3ziWW64_LtZZ5THWB-4PCUzPnwQTVu_ck0PKAQ87xsZyjNPNNfyjHs-ykyGoN3N3hL-c_BmoLukGu9sDCsRrFxfkQvF5AdTZvkIhANEVXpXBqQnFzK5JwaV_-xsjQKywRRBlX1s1xMNjAD5fo4wJ3bnylL1GQBIMm4tEpKZn_MzCHcJ7bhs0j7f80yj3Hr0USDdN4xmnEN5yc0R0hKSKTaO7YpNaezpAyfJPVbsXc-7qKbIyO97RwOBLHNSh5yRXD-wIssAwstyt2DwRPpPQmiQ";
    public static String startTime;
    public static String endTime;
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
