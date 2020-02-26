package com.example.cusina.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cusina.AdapterClass.InboxMsgListAdapter.inboxAdapterClass;
import com.example.cusina.AdapterClass.InboxMsgListAdapter.inboxModalClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class InboxPageFragment extends Fragment {
    TextView titleBarTxt;
    RecyclerView inboxListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inbox_page, container, false);

        setObjectId(root);

        titleBarTxt.setText(getString(R.string.inboxTxt));
        root.findViewById(R.id.closeImgBtn).setVisibility(View.GONE);
        root.findViewById(R.id.backBtnImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        inboxListViewMetod();

        return root;
    }

    private void setObjectId(View root){
        titleBarTxt = root.findViewById(R.id.titleName);
        inboxListView = root.findViewById(R.id.inboxListView);
    }

    private void inboxListViewMetod(){
        inboxModalClass[] modalClasses = new inboxModalClass[]{
                new inboxModalClass("Earn Points with Lutong Bahay","November 15, 2019"),
                new inboxModalClass("Your order is being delivered","November 15, 2019"),
                new inboxModalClass("Order Received by Reggie's Kitchen","November 15, 2019"),
                new inboxModalClass("Get Php 10.00 when your refer a friend","November 15, 2019"),
                new inboxModalClass("Freshly cooked dishes available now!","November 15, 2019"),
                new inboxModalClass("Use your free discount code before it exp..","Promo code: EATNOW15"),
                new inboxModalClass("Be a food server in Lutong Bahay! ","November 15, 2019"),
        };

        UtilClass.listFixedSize(inboxListView,getContext());

        inboxAdapterClass adapterClass = new inboxAdapterClass(getContext(),modalClasses);

        UtilClass.setDividerOnRecycler(inboxListView,getContext());

        inboxListView.setAdapter(adapterClass);

    }

}
