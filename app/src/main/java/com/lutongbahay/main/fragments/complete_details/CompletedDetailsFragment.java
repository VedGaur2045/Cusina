package com.lutongbahay.main.fragments.complete_details;

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
import android.view.WindowManager;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.choose_category.ChooseCategoryFragmentDirections;
import com.lutongbahay.main.fragments.complete_details.mvvm.CompletedDetailsView;
import com.lutongbahay.main.fragments.complete_details.mvvm.CompletedDetailsViewModel;
import com.lutongbahay.utils.StatusBarUtils;

public class CompletedDetailsFragment extends Fragment {

    private CompletedDetailsView view;
    private CompletedDetailsViewModel viewModel;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(CompletedDetailsFragmentDirections.toChooseCategory());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String categoryName = getArguments().getString("categoryName");
        viewModel = new ViewModelProvider(this).get(CompletedDetailsViewModel.class);
        view = new CompletedDetailsView(context,viewModel, categoryName);
        return view;
    }
}
