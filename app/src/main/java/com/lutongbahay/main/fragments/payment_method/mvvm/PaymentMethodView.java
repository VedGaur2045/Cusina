package com.lutongbahay.main.fragments.payment_method.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.list.PaymentMethodListView;
import com.lutongbahay.main.fragments.payment_method.PaymentMethodFragmentDirections;
import com.lutongbahay.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ved Gaur on 2020-03-03.
 * Copyright © 2020 Ved Gaur. All rights reserved.
 */

public class PaymentMethodView extends FrameLayout {
    private final PaymentMethodViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.paymentMethodList)
    ListView paymentMethodList;
    @BindView(R.id.Total_Amt_price)
    TextView Total_Amt_price;
    @BindView(R.id.subTotal_price)
    TextView subTotal_price;
    @BindView(R.id.payNowBtn)
    Button payNowBtn;

    ArrayList<Integer> paymentImg = new ArrayList<>();
    ArrayList<String> paymentTxtArr = new ArrayList<>();

    public PaymentMethodView(@NonNull Context context, PaymentMethodViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_payment_method,this);
        ButterKnife.bind(this,this);

        String[] payTxt = new String[]{CusinaApplication.getInstance().getString(R.string.CashOnDelivery), CusinaApplication.getInstance().getString(R.string.paymentGateway), CusinaApplication.getInstance().getString(R.string.creditCard),CusinaApplication.getInstance().getString(R.string.prepaidCard)};
        Integer[] payImg = new Integer[]{R.mipmap.cash_on_delivery_img,R.mipmap.paypal_img,R.mipmap.visa_img,R.mipmap.maestro_img};
        //paymentTxt.addAll(Arrays.asList(payTxt));
        paymentImg.addAll(Arrays.asList(payImg));

        //PaymentMethodListView listViewAdapter = new PaymentMethodListView(context,paymentImg,paymentTxt);
        paymentMethodApi((AppCompatActivity) context, Constants.TOKEN);

        titleName.setText(R.string.PaymentMode);
        closeImgBtn.setVisibility(GONE);
    }

    @OnClick(R.id.payNowBtn)
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.payNowBtn){
            Navigation.findNavController(view).navigate(PaymentMethodFragmentDirections.toOrderPlaced());
        } else if(id == R.id.backBtnImg) {
            Navigation.findNavController(view).navigateUp();
        }
    }

    public void paymentMethodApi(AppCompatActivity compatActivity, String token){
        String[] paymentTxt = new String[]{};
        viewModel.paymentMethod(compatActivity,token).observe(compatActivity, responsePaymentMethod -> {
            ProgressDialogFragment.dismissProgressDialog(compatActivity);
            if(responsePaymentMethod == null){
                showErrorAlert(compatActivity, "Oops!! Server error occurred. Please try again.");
            } else {
                if (!responsePaymentMethod.getSuccess()){
                    showErrorAlert(compatActivity, responsePaymentMethod.getMessage());
                } else {
                    for(int i=0;i<responsePaymentMethod.getData().size();i++){
                        paymentTxtArr.add(responsePaymentMethod.getData().get(i).getName());
                    }
                   // paymentTxtArr.addAll(Arrays.asList(paymentTxt));
                    PaymentMethodListView listViewAdapter = new PaymentMethodListView(compatActivity,paymentImg,paymentTxtArr);
                    paymentMethodList.setAdapter(listViewAdapter);
                }
            }
        });
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }


}
