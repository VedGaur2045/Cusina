package com.example.cusina.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cusina.R;

import org.w3c.dom.Text;

public class Setting_Fragment extends Fragment {

    private ImageView backBtn;
    private RelativeLayout favDishBtn,msgAndNoti,toReview,changePassword;
    private TextView newMsgCount,newToReview,titleBarTxt;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        setObjectId(root);

        titleBarTxt.setText(getString(R.string.settings));
        root.findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        root.findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        favDishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment favDish = new FavouritePageFragment();
                openSelectedFragment(favDish);
            }
        });

        msgAndNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment msgAndNoti = new InboxPageFragment();
                openSelectedFragment(msgAndNoti);
            }
        });

        toReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment msgMap = new MessageMapFragment();
//                openSelectedFragment(msgMap);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }

    private void setObjectId(View root){
        titleBarTxt = root.findViewById(R.id.titleName);
        favDishBtn = root.findViewById(R.id.favDishes);
        msgAndNoti = root.findViewById(R.id.msgAndNotification);
        toReview = root.findViewById(R.id.toReview);
        changePassword = root.findViewById(R.id.changePassword);
        newMsgCount = root.findViewById(R.id.msgCount);
        newToReview = root.findViewById(R.id.toReviewCount);
    }

    private void openSelectedFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.silde_in_left, R.animator.silde_out_left,
                R.animator.silde_out_right, R.animator.silde_in_right);
        transaction.replace(R.id.profile, fragment );

        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }

}
