package com.lutongbahay.main.fragments.favourites;

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
import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;
import com.lutongbahay.main.fragments.favourites.mvvm.FavouriteViewModel;
import com.lutongbahay.main.fragments.favourites.mvvm.FavouritesView;
import com.lutongbahay.utils.StatusBarUtils;

public class FavouritesFragment extends Fragment {

    private FavouriteViewModel viewModel;
    private FavouritesView view;
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
                Navigation.findNavController(view).navigateUp();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StatusBarUtils.redStatusBar((Activity) context);
                }
            }
        };


        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println(getArguments().getInt("check"));
        viewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
        view = new FavouritesView(context,viewModel,getArguments().getInt("check"),getArguments().getString("titleName"));
        return view;
    }
}
