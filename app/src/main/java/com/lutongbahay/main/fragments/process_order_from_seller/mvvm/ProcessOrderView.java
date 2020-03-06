package com.lutongbahay.main.fragments.process_order_from_seller.mvvm;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lutongbahay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProcessOrderView extends FrameLayout {
    private final ProcessOrderViewModel viewModel;
    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.orderNumber)
    TextView orderNumber;
    @BindView(R.id.ellipse_1)
    ImageView ellipse_1;
    @BindView(R.id.ellipse_2)
    ImageView ellipse_2;
    @BindView(R.id.ellipse_3)
    ImageView ellipse_3;
    @BindView(R.id.ellipse_4)
    ImageView ellipse_4;
    @BindView(R.id.line_1)
    ImageView line_1;
    @BindView(R.id.line_2)
    ImageView line_2;
    @BindView(R.id.line_3)
    ImageView line_3;
    @BindView(R.id.ConfirmOrder)
    TextView ConfirmOrder;
    @BindView(R.id.Preparing)
    TextView Preparing;
    @BindView(R.id.Deliver)
    TextView Deliver;
    @BindView(R.id.Complete)
    TextView Complete;
    @BindView(R.id.ORDER_TIME_TXT)
    TextView ORDER_TIME_TXT;
    @BindView(R.id.hourTime)
    TextView hourTime;
    @BindView(R.id.minuteTime)
    TextView minuteTime;
    @BindView(R.id.secondTime)
    TextView secondTime;
    @BindView(R.id.customerName)
    TextView customerName;
    @BindView(R.id.callImgBtn)
    ImageButton callImgBtn;
    @BindView(R.id.messageImgBtn)
    ImageButton messageImgBtn;
    @BindView(R.id.customerEmail)
    TextView customerEmail;
    @BindView(R.id.customerPhone)
    TextView customerPhone;
    @BindView(R.id.firstAddress)
    TextView firstAddress;
    @BindView(R.id.secondAddress)
    TextView secondAddress;
    @BindView(R.id.addOtherAddress)
    TextView addOtherAddress;
    @BindView(R.id.itemList)
    RecyclerView itemList;
    @BindView(R.id.phpAmount)
    TextView phpAmount;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.pickUpOnly)
    RadioButton pickUpOnly;
    @BindView(R.id.delivery)
    RadioButton delivery;
    @BindView(R.id.feeInPHPTxt)
    EditText feeInPHPTxt;
    @BindView(R.id.weekAndDateOfOrder)
    TextView weekAndDateOfOrder;
    @BindView(R.id.expectedTimeOrder)
    TextView expectedTimeOrder;
    @BindView(R.id.ConfirmOrderBtn)
    Button ConfirmOrderBtn;
    @BindView(R.id.CancelBtn)
    Button CancelBtn;

    public ProcessOrderView(@NonNull Context context, ProcessOrderViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_process_order,this);
        ButterKnife.bind(this,this);
    }
}
