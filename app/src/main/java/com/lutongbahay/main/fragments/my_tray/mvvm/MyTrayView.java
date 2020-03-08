package com.lutongbahay.main.fragments.my_tray.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;
import com.lutongbahay.adapter.TrayOrderItemsAdapter;
import com.lutongbahay.main.fragments.my_tray.MyTrayFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTrayView extends FrameLayout {
    private final MyTrayViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.yourLocation)
    TextView yourLocation;
    @BindView(R.id.myLocation)
    TextView myLocation;
    @BindView(R.id.changeAddress)
    TextView changeAddress;
    @BindView(R.id.firstAddress)
    TextView firstAddress;
    @BindView(R.id.secondAddress)
    TextView secondAddress;
    @BindView(R.id.addOtherAddress)
    TextView addOtherAddress;
//    @BindView(R.id.changeAddressPencilBtn)
//    TextView changeAddressPencilBtn;
    @BindView(R.id.myTrayListVertical)
    RecyclerView myTrayListVertical;
    @BindView(R.id.totalAmount)
    TextView totalAmount;
    @BindView(R.id.placeOrder)
    TextView placeOrder;

    public MyTrayView(@NonNull Context context, MyTrayViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_my_tray,this);
        ButterKnife.bind(this,this);

        TrayOrderItemsAdapter trayOrderItemsAdapter = new TrayOrderItemsAdapter();
        myTrayListVertical.setAdapter(trayOrderItemsAdapter);
    }

    @OnClick(R.id.closeImgBtn)
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.closeImgBtn){
           // Navigation.findNavController(view).navigate(MyTrayFragmentDirections.toHomeFragment());
        }
    }

}
