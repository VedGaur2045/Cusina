package com.lutongbahay.main.fragments.order_stutus.mvvm;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderStatusView extends FrameLayout {
    private final OrderStatusViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.orderNumberCount)
    TextView orderNumberCount;
    @BindView(R.id.serverName)
    TextView serverName;
    @BindView(R.id.orderDate)
    TextView orderDate;
    @BindView(R.id.RateServer)
    Button RateServer;
    @BindView(R.id.serverNameTxtOnDel)
    TextView serverNameTxtOnDel;
    @BindView(R.id.serverNameLocationTxtOnDel)
    TextView serverNameLocationTxtOnDel;
    @BindView(R.id.deliveryLocationTxtOnDel)
    TextView deliveryLocationTxtOnDel;
    @BindView(R.id.OrderListItem)
    RecyclerView OrderListItem;
    @BindView(R.id.totalAmount)
    TextView totalAmount;
    @BindView(R.id.cancelBtn)
    Button cancelBtn;

    public OrderStatusView(@NonNull Context context, OrderStatusViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_order_status,this);
        ButterKnife.bind(this,this);
    }
}
