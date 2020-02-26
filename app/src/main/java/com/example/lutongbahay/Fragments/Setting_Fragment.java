package com.example.lutongbahay.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

public class Setting_Fragment extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.M)
    ImageView back;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        back=root.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
                //getActivity().overridePendingTransition(R.animator.enter_from_left,R.animator.exit_to_right);
            }
        });
        return root;
    }

}
