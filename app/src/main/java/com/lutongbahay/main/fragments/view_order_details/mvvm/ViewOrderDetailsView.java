package com.lutongbahay.main.fragments.view_order_details.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.OrderSummaryItemRecyclerAdapter;
import com.lutongbahay.main.fragments.view_order_details.ViewOrdersDetailsFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewOrderDetailsView extends FrameLayout {
    private final ViewOrderDetailsViewModel viewOrderDetailsViewModel;
    @BindView(R.id.titleName)
    TextView titleName;
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
    @BindView(R.id.completedOrdersListItem)
    RecyclerView completedOrdersListItem;
    @BindView(R.id.totalAmount)
    TextView totalAmount;
    @BindView(R.id.cancelBtn)
    Button cancelBtn;
    Context context;

    public ViewOrderDetailsView(@NonNull Context context, ViewOrderDetailsViewModel viewOrderDetailsViewModel,String title) {
        super(context);
        this.context = context;
        this.viewOrderDetailsViewModel = viewOrderDetailsViewModel;
        inflate(context, R.layout.fragment_view_orders_details,this);
        ButterKnife.bind(this,this);

        OrderSummaryItemRecyclerAdapter orderSummaryItemRecyclerAdapter = new OrderSummaryItemRecyclerAdapter(context,title);
        completedOrdersListItem.setAdapter(orderSummaryItemRecyclerAdapter);


        if (!title.equalsIgnoreCase("Delivered Order")){
            RateServer.setVisibility(GONE);
        }
        titleName.setText(title);
    }

    @OnClick({R.id.closeImgBtn,R.id.RateServer})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.closeImgBtn:
                Navigation.findNavController(view).navigateUp();
                break;
            case R.id.RateServer:
                openRateServer();
                break;
        }
    }

    private void openRateServer(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.custom_popup_add_review, null);



        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setView(popupView);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        assert window != null;

        dialog.show();
        ImageButton closeBtn = popupView.findViewById(R.id.closeImgBtn);
        Button getStarted = popupView.findViewById(R.id.submitBtn);

        closeBtn.setOnClickListener(v -> dialog.dismiss());
        getStarted.setOnClickListener(v -> dialog.dismiss());
    }



}
