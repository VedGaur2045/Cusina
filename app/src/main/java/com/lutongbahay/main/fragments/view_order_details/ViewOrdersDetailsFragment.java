package com.lutongbahay.main.fragments.view_order_details;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.setting.SettingFragmentDirections;
import com.lutongbahay.main.fragments.view_order_details.mvvm.ViewOrderDetailsView;
import com.lutongbahay.main.fragments.view_order_details.mvvm.ViewOrderDetailsViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class ViewOrdersDetailsFragment extends Fragment {

    private ViewOrderDetailsView view;
    private ViewOrderDetailsViewModel viewModel;
    private Context context;
    private String title = "";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null) {
            title  = bundle.getString("title");
        }
//        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
//            @Override
//            public void handleOnBackPressed() {
//                Navigation.findNavController(view).navigateUp();
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    StatusBarUtils.redStatusBar((Activity) context);
//                }
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ViewOrderDetailsViewModel.class);
        if (view == null)
        view = new ViewOrderDetailsView(context,viewModel,title);
        return view;
    }
}
