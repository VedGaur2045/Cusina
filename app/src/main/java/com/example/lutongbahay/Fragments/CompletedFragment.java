package com.example.lutongbahay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lutongbahay.AdapterClass.CompletedListAdapter.listCompletedAdapterClass;
import com.example.lutongbahay.AdapterClass.CompletedListAdapter.listCompletedHolderClass;
import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

public class CompletedFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed, container, false);

        recyclerView = view.findViewById(R.id.completedListItem);

        listCompletedHolderClass[] completedHolderClasses = new listCompletedHolderClass[]{
                new listCompletedHolderClass("2100","12-01-2019","Reggie's Kitchen","LT-151516141-11-19","3","310"),
                new listCompletedHolderClass("2500","11-04-2019","Reggie's Kitchen","LT-151516141-11-19","5","210"),
                new listCompletedHolderClass("3000","21-04-2019","Reggie's Kitchen","LT-151516141-11-19","6","400"),
                new listCompletedHolderClass("1500","15-08-2019","Reggie's Kitchen","LT-151516141-11-19","7","200"),
                new listCompletedHolderClass("1700","26-01-2019","Reggie's Kitchen","LT-151516141-11-19","1","100"),
        };

        listCompletedAdapterClass adapterClass = new listCompletedAdapterClass(completedHolderClasses,getContext());

        UtilClass.listFixedSize(recyclerView,getContext());

        recyclerView.setAdapter(adapterClass);

        return view;
    }

}
