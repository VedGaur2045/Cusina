package com.example.cusina.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cusina.AdapterClass.ProcessingListAdapter.listProcessingAdapterClass;
import com.example.cusina.AdapterClass.ProcessingListAdapter.listProcessingHolderClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class ProcessingFragment extends Fragment {

    private TextView orderNumber,orderDate,server;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_processing, container, false);

        setObjectId(view);

        listProcessingHolderClass[] holderClasses = new listProcessingHolderClass[]{
                new listProcessingHolderClass(R.mipmap.fish_img_6,1,"Fish 1"),
                new listProcessingHolderClass(R.mipmap.fish_img_6,2,"Fish 2"),
                new listProcessingHolderClass(R.mipmap.fish_img_6,4,"Fish 3"),
                new listProcessingHolderClass(R.mipmap.fish_img_6,3,"Fish 4"),
                new listProcessingHolderClass(R.mipmap.fish_img_6,2,"Fish 5"),
        };

        listProcessingAdapterClass adapterClass = new listProcessingAdapterClass(getContext(),holderClasses);

        UtilClass.listFixedSize(recyclerView,getContext());

        recyclerView.setAdapter(adapterClass);

        return view;
    }

    private void setObjectId(View view){
        orderNumber = view.findViewById(R.id.orderNumber);
        orderDate = view.findViewById(R.id.orderDate);
        server = view.findViewById(R.id.ServerTxt);
        recyclerView = view.findViewById(R.id.processingListItem);
    }

}
