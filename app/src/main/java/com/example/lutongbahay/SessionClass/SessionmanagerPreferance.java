package com.example.lutongbahay.SessionClass;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionmanagerPreferance {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Context context;

    public SessionmanagerPreferance(Context parameterContext) {
        this.context = parameterContext;
        this.sharedPref = this.context.getSharedPreferences("Lutong Bahay", Context.MODE_PRIVATE);
        this.editor = this.sharedPref.edit();
    }

    public void userLogInSession(String userid,String name,String mobile,String email,String password,String auth_key,String usertype){
        this.editor.putBoolean("IsUserLoggedIn",true);
        this.editor.putString("userid",userid);
        this.editor.putString("username",name);
        this.editor.putString("usermobile",mobile);
        this.editor.putString("useremail",email);
        this.editor.putString("userpassword",password);
        this.editor.putString("userkey",auth_key);
        this.editor.putString("usertype",usertype);
        this.editor.commit();
    }

    public void setCurrentAddress(String address){
        this.editor.putString("currentAddress",address);
        this.editor.commit();
    }

    public String getCurrentAddress(){
        return this.sharedPref.getString("currentAddress",null);
    }

    public void userLogOut(){
        editor.clear();
        editor.commit();
    }
}
