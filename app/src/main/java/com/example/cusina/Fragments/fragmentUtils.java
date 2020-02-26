package com.example.cusina.Fragments;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cusina.R;


public class fragmentUtils {

    public static void replaceFragment(FragmentActivity fragmentActivity, Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = fragmentActivity.getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName,  0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    public static void replaceFragmentWithHide(FragmentActivity fragmentActivity, Fragment fragment, Fragment active){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = fragmentActivity.getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName,  0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment);
            ft.hide(active);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    public static void replaceFragment(FragmentActivity mContext , Fragment mFragment, int fragmentId, String TAG){
        try {
            // MethodConstants.hideSoftKeyboard(mContext);
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();

            //  mFragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
            mFragmentTransaction.replace(fragmentId, mFragment, TAG).addToBackStack(null).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("error",e.getMessage());
        }
    }

    public static void replaceFragmentWithoutAnimation(FragmentActivity mContext, Fragment mFragment, int fragmentId, String TAG) {
        try {
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();
            mFragmentTransaction.replace(fragmentId, mFragment, TAG).addToBackStack(TAG).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void replaceFragmentWithoutBackStack(FragmentActivity mContext, Fragment mFragment, int fragmentId, String TAG) {
        try {
            //      MethodConstants.hideSoftKeyboard(mContext);
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();
            mFragmentTransaction.replace(fragmentId, mFragment, TAG).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replaceFragmentWithoutBackStackWithammimation(FragmentActivity mContext, Fragment mFragment, int fragmentId, String TAG) {
        try {
            //      MethodConstants.hideSoftKeyboard(mContext);
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();
            //  mFragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);

            mFragmentTransaction.replace(fragmentId, mFragment, TAG).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Fragment currentFragment;;
    public static void openNewFragment(FragmentActivity mContext, Fragment f, int id, String tag) {
        {
            //       MethodConstants.hideSoftKeyboard(mContext);
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();
            // mFragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right);
            Fragment fragment = mContext.getSupportFragmentManager().findFragmentByTag(tag);
            if (fragment != null) {
                if (currentFragment != null) {
                    if (fragment.getClass().equals(currentFragment.getClass())) {
                        return;
                    }
                }
                mFragmentTransaction.show(fragment);
                mFragmentTransaction.remove(currentFragment);
                currentFragment = fragment;

            } else {

                if (currentFragment != null)
                    mFragmentTransaction.remove(currentFragment);

                mFragmentTransaction.add(id, f, tag);
                currentFragment = f;
            }
            mFragmentTransaction.commit();
        }
    }


    public static void popBack(FragmentActivity fragmentActivity){

        // Util.hideKeyboard(fragmentActivity);
        fragmentActivity.getSupportFragmentManager().popBackStack();
        //  AnimatorClass.disappearLeftAnimation(fragmentActivity);
    }

    public static void replaceFirstFragment(FragmentActivity mContext , Fragment mFragment, int fragmentId, String TAG){
        try {
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();

            //    mFragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
            if (mFragment.isVisible()){
                mContext.getSupportFragmentManager().beginTransaction().remove(mFragment);
            }
            mFragmentTransaction.replace(fragmentId, mFragment, TAG).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFragment(FragmentActivity mContext, Fragment mFragment, int fragmentId, String TAG) {
        try {
            FragmentTransaction mFragmentTransaction = mContext.getSupportFragmentManager().beginTransaction();
            //  mFragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
            mFragmentTransaction.add(fragmentId, mFragment, TAG).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // new methods

    private static final String HOME_FRAGMENT = "home_fragment";

    public static void onChangeFragment(FragmentManager fragmentManager, int frameId, Fragment fragment, String tag) {
        try {
            replaceFragmentCommon(fragmentManager, frameId, fragment, tag, false);
        }
        catch (Exception ignored){

        }
    }

    private static void replaceFragmentCommon(FragmentManager fragmentManager, int containerID, Fragment fragment, String tag, boolean isAddtoBackStack) {
        try {
            Fragment fragmentByTag = fragmentManager.findFragmentByTag(tag);
            boolean fragmentPopped = fragmentManager
                    .popBackStackImmediate(tag, 0);
            //   Logger.DebugLog("Fragment Utils", "Is popped Out : " + tag + " - " + fragmentPopped);
            if (!fragmentPopped && fragmentByTag == null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(containerID, fragment, tag);
                if (isAddtoBackStack) {
                    fragmentTransaction.addToBackStack(tag);
                }
                fragmentTransaction.commit();
            } else {
                int index = fragmentManager.getBackStackEntryCount() - 1;
                if (index >= 0) {
                    FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(index);
                    String foundTag = backEntry.getName();
                    //      Logger.ErrorLog("Replace", "TAG : " + foundTag);
                    if (!tag.equals(HOME_FRAGMENT) && !tag.equals(foundTag))
                        fragmentManager.popBackStackImmediate(foundTag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    else if (tag.equals(HOME_FRAGMENT))
                        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        }
        catch (Exception ignored){

        }
    }
}
