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
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjllODAxYTkwZjJjZDg0ZDI1ZWE1YTZhNmE0YTBmNjE0NzBmYTcyMTE1ZWJkY2FkM2JlNmQ0ZDVlMzE0NjQ4NmI3NWMwMjZmMTEwZDQ0Mjk4In0.eyJhdWQiOiIyIiwianRpIjoiOWU4MDFhOTBmMmNkODRkMjVlYTVhNmE2YTRhMGY2MTQ3MGZhNzIxMTVlYmRjYWQzYmU2ZDRkNWUzMTQ2NDg2Yjc1YzAyNmYxMTBkNDQyOTgiLCJpYXQiOjE1ODM2OTI0NjUsIm5iZiI6MTU4MzY5MjQ2NSwiZXhwIjoxNjE1MjI4NDY1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.WsVHwfus2vs9gA0fbiv5LVmOFhhUmn28OrnKtXx_e5O7VCOy3fQ_plRXJiLNkatGBnGBCSgny-bjI1kUOf_6m9e1Vou17WT6ouGdUZQCA5Kp0gLnxPrCLveop4qqwBGR_tl0Myvphz1UCTnHuciePYtQaqyrsuAV3ub9tZf3gJcAeH3jF2hFz1gdu_r6-ZUaMcU3nKAjQXpxZtiCGUrVPwvzjQNN7nHED_EE7xXM-JQf2_qe4AS0hVfZjUWvNPDAQZ0BfiqD0xpWObMfIkGkf5C2eMRlISEhrdobHsGd7_3XyM7gKE7pm8cZqWlAPig4tHeRSa1vfEV48tbjsXi-_-Ufr4_AQmGIe4HzsrWcnQ3ZaCEiGYeBdKdkGe2xtw64mRKtIBAEupiZtAQExvCc3ziWW64_LtZZ5THWB-4PCUzPnwQTVu_ck0PKAQ87xsZyjNPNNfyjHs-ykyGoN3N3hL-c_BmoLukGu9sDCsRrFxfkQvF5AdTZvkIhANEVXpXBqQnFzK5JwaV_-xsjQKywRRBlX1s1xMNjAD5fo4wJ3bnylL1GQBIMm4tEpKZn_MzCHcJ7bhs0j7f80yj3Hr0USDdN4xmnEN5yc0R0hKSKTaO7YpNaezpAyfJPVbsXc-7qKbIyO97RwOBLHNSh5yRXD-wIssAwstyt2DwRPpPQmiQ";
        paymentMethodApi((AppCompatActivity) context,token);

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
