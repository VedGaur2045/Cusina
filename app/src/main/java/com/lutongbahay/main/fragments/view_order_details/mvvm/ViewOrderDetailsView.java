package com.lutongbahay.main.fragments.view_order_details.mvvm;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.main.fragments.view_order_details.ViewOrdersDetailsFragment;
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
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
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

    public ViewOrderDetailsView(@NonNull Context context, ViewOrderDetailsViewModel viewOrderDetailsViewModel) {
        super(context);
        this.viewOrderDetailsViewModel = viewOrderDetailsViewModel;
        inflate(context, R.layout.fragment_view_orders_details,this);
        ButterKnife.bind(this,this);

        titleName.setText("Acc Condition");
        backBtnImg.setVisibility(GONE);
    }

    @OnClick({R.id.closeImgBtn,R.id.RateServer})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.closeImgBtn:
                Navigation.findNavController(view).navigate(ViewOrdersDetailsFragmentDirections.toMyOrdersFragment());
                break;
            case R.id.RateServer:

                break;
        }
    }

//    @RequiresApi(api = Build.VERSION_CODES.M)
//    public void rateServerBtnOnClick(View view) {
//
//        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View popupView = inflater.inflate(R.layout.custom_popup_add_review, null);
//
//        setObjectIdOfPopUp(popupView);
//
//        viewStub.setLayoutResource(R.layout.set_review_layout_for_server);
//
//        setViewStubObjectId(viewStub);
//
//        final AlertDialog dialog = new AlertDialog.Builder(getContext()).create();
//        dialog.setView(popupView);
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
//        Window window = dialog.getWindow();
//        assert window != null;
//        //window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        dialog.show();
//
//        closeImgBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        submitBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CompletedOrdersActivity.this, Choose_address.class) ;
//                intent.putExtra("id","6");
//                Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(CompletedOrdersActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
//                startActivity(intent,bndlAnimation);
//            }
//        });
//
//    }


}
