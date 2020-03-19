package com.lutongbahay.main.fragments.my_tray;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.AppAction;
import com.lutongbahay.main.fragments.my_tray.mvvm.MyTrayView;
import com.lutongbahay.main.fragments.my_tray.mvvm.MyTrayViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class MyTrayFragment extends Fragment {

    private MyTrayView view;
    private MyTrayViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.setLightStatusBar((Activity) context,"#FFFFFF");
        }

        //AppAction.onBackPress((Activity) context,view,this,MyTrayFragmentDirections.toHomeFragment());

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(MyTrayFragmentDirections.toHomeFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

    }
//
//    public boolean onKey(View v, int keyCode, KeyEvent event) {
//        if (event.getAction() == KeyEvent.ACTION_UP) {
//            if (keyCode == KeyEvent.KEYCODE_BACK) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    StatusBarUtils.red((Activity) context,"#FFFFFF");
//                }
//                return true;
//            }
//        }
//
//        return false;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MyTrayViewModel.class);
        view = new MyTrayView(context,viewModel);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (view != null && view.mapFragment != null){
            ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().remove(view.mapFragment).commit();
        }
    }

}
