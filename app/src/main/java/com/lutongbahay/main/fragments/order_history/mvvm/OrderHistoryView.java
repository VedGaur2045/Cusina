package com.lutongbahay.main.fragments.order_history.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.order_history.OrderHistoryFragmentDirections;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public OrderHistoryView(@NonNull Context context, OrderHistoryViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_order_history,this);
        ButterKnife.bind(this,this);
    }

    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigate(OrderHistoryFragmentDirections.toOrdersFragment());
        }
    }

}
