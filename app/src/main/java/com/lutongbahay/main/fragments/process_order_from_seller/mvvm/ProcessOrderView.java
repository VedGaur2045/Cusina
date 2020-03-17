package com.lutongbahay.main.fragments.process_order_from_seller.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.ProcessOrderRecyclerAdapter;
import com.lutongbahay.main.fragments.process_order_from_seller.ProcessOrderFragment;
import com.lutongbahay.main.fragments.process_order_from_seller.ProcessOrderFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProcessOrderView extends FrameLayout {
    private final ProcessOrderViewModel viewModel;

    @BindView(R.id.itemList)
    RecyclerView itemList;

    public ProcessOrderView(@NonNull Context context, ProcessOrderViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_process_order,this);
        ButterKnife.bind(this,this);

        ProcessOrderRecyclerAdapter processOrderRecyclerAdapter = new ProcessOrderRecyclerAdapter();
        itemList.setAdapter(processOrderRecyclerAdapter);

    }

    @OnClick(R.id.backButton)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.backButton){
            Navigation.findNavController(view).navigate(ProcessOrderFragmentDirections.toOrdersFragment());
        }
    }

}
