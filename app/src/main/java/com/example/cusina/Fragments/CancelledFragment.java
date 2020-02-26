package com.example.cusina.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cusina.AdapterClass.CancelledListAdapter.listCancelledAdapterClass;
import com.example.cusina.AdapterClass.CancelledListAdapter.listCancelledHolderClass;
import com.example.cusina.R;
import com.example.cusina.UtilClasses.UtilClass;

public class CancelledFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cancelled, container, false);

        recyclerView = view.findViewById(R.id.cancelledListItem);

        listCancelledHolderClass[] cancelledHolderClasses = new listCancelledHolderClass[]{
            new listCancelledHolderClass("2100","12-01-2019","Reggie's Kitchen","LT-151516141-11-19","3","310"),
                new listCancelledHolderClass("2500","11-04-2019","Reggie's Kitchen","LT-151516141-11-19","5","210"),
                new listCancelledHolderClass("3000","21-04-2019","Reggie's Kitchen","LT-151516141-11-19","6","400"),
                new listCancelledHolderClass("1500","15-08-2019","Reggie's Kitchen","LT-151516141-11-19","7","200"),
                new listCancelledHolderClass("1700","26-01-2019","Reggie's Kitchen","LT-151516141-11-19","1","100"),
        };

        listCancelledAdapterClass adapterClass = new listCancelledAdapterClass(getContext(),cancelledHolderClasses);

        UtilClass.listFixedSize(recyclerView,getContext());

        recyclerView.setAdapter(adapterClass);

        return view;
    }

}
