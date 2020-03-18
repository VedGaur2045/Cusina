package com.lutongbahay.main.fragments.order_history.mvvm;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.OrderHistoryRecyclerAdapter;
import com.lutongbahay.main.fragments.order_history.OrderHistoryFragmentDirections;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderHistoryView extends FrameLayout {
    private final OrderHistoryViewModel viewModel;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.fromDate)
    TextView fromDate;
    @BindView(R.id.fromDownImg)
    ImageButton fromDownImg;
    @BindView(R.id.toDate)
    TextView toDate;
    @BindView(R.id.toDownImg)
    ImageButton toDownImg;
    @BindView(R.id.completedOrdersTxt)
    TextView completedOrdersTxt;
    @BindView(R.id.CancelledBySellerTxt)
    TextView CancelledBySellerTxt;
    @BindView(R.id.CancelledByCustomerTxt)
    TextView CancelledByCustomerTxt;
    @BindView(R.id.completedOrdersList)
    RecyclerView completedOrdersList;
    @BindView(R.id.CancelledBySellerList)
    RecyclerView CancelledBySellerList;
    @BindView(R.id.CancelledByCustomerList)
    RecyclerView CancelledByCustomerList;
    @BindView(R.id.calenderLayout)
    RelativeLayout calenderLayout;
    @BindView(R.id.fromLayout)
    RelativeLayout fromLayout;
    @BindView(R.id.toLayout)
    RelativeLayout toLayout;
    @BindView(R.id.setDateButton)
    Button setDateButton;

    static boolean checkFromCal = true;
    static boolean checkToCal = true;

    public OrderHistoryView(@NonNull Context context, OrderHistoryViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_order_history,this);
        ButterKnife.bind(this,this);

        OrderHistoryRecyclerAdapter orderHistoryRecyclerAdapter = new OrderHistoryRecyclerAdapter();
        completedOrdersList.setAdapter(orderHistoryRecyclerAdapter);
//        CancelledBySellerList.setAdapter(orderHistoryRecyclerAdapter);
//        CancelledByCustomerList.setAdapter(orderHistoryRecyclerAdapter);

    }

    @OnClick({R.id.closeImgBtn,R.id.fromDate,R.id.toDate,R.id.setDateButton})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
//            Navigation.findNavController(view).navigate(OrderHistoryFragmentDirections.toProfileFragment());
            Navigation.findNavController(view).navigateUp();
        } else if(id == R.id.fromDate){
            calUseMethod(fromLayout,toLayout,checkFromCal);
        } else if(id == R.id.toDate){
            calUseMethod(toLayout,fromLayout,checkToCal);
        } else if (id == R.id.setDateButton){
            calenderLayout.setVisibility(GONE);
        }
    }

    private void calUseMethod(RelativeLayout firstLayout,RelativeLayout secondlayout,boolean check){
        firstLayout.setBackgroundColor(Color.parseColor("#FF8500"));
        secondlayout.setBackgroundColor(Color.parseColor("#B3FF8500"));
        if(check){
            calenderLayout.setVisibility(View.VISIBLE);
            check = false;
        } else {
            calenderLayout.setVisibility(View.GONE);
            check = true;
        }
    }

}
