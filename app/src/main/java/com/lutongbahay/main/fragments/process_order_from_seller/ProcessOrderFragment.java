package com.lutongbahay.main.fragments.process_order_from_seller;

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
import com.lutongbahay.main.fragments.payment_method.PaymentMethodFragmentDirections;
import com.lutongbahay.main.fragments.process_order_from_seller.mvvm.ProcessOrderView;
import com.lutongbahay.main.fragments.process_order_from_seller.mvvm.ProcessOrderViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class ProcessOrderFragment extends Fragment {
    private ProcessOrderView view;
    private ProcessOrderViewModel viewModel;
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
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(ProcessOrderFragmentDirections.toProfileFragment());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.setLightStatusBar((Activity) context,"#FFFFFF");
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("kjsafhkj   "+getArguments().getInt("check"));
        viewModel = new ViewModelProvider(this).get(ProcessOrderViewModel.class);
        view = new ProcessOrderView(context,viewModel,getArguments().getInt("check"));
        return view;
    }
}
