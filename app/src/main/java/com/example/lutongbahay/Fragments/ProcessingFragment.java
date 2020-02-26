package com.example.lutongbahay.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lutongbahay.R;

public class ProcessingFragment extends Fragment {

    private TextView orderNumber,orderDate,server;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_processing, container, false);

        orderNumber = view.findViewById(R.id.orderNumber);
        orderDate = view.findViewById(R.id.orderDate);
        server = view.findViewById(R.id.ServerTxt);
        recyclerView = view.findViewById(R.id.processingListItem);

        return view;
    }

}
