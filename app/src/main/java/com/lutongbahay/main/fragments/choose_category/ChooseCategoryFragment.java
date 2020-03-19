package com.lutongbahay.main.fragments.choose_category;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragmentDirections;
import com.lutongbahay.main.fragments.choose_category.mvvm.ChooseCategoryView;
import com.lutongbahay.main.fragments.choose_category.mvvm.ChooseCategoryViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class ChooseCategoryFragment extends Fragment {
    private ChooseCategoryView view;
    private ChooseCategoryViewModel viewModel;
    private Context context;
    private AppCompatActivity compatActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.compatActivity  = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.redStatusBar((Activity) context);
        }
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(ChooseCategoryFragmentDirections.toCameraFragment());
                compatActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ChooseCategoryViewModel.class);
        view = new ChooseCategoryView(context,viewModel);
        return view;
    }

}
