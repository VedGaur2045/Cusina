package com.lutongbahay.main.fragments.process_order_from_seller.mvvm;

import android.content.Context;
import android.graphics.Color;
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
import androidx.core.content.ContextCompat;
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

    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.itemList)
    RecyclerView itemList;
    @BindView(R.id.ConfirmOrderBtn)
    Button ConfirmOrderBtn;
    @BindView(R.id.CancelBtn)
    Button CancelBtn;
    @BindView(R.id.DELIVER_Btn)
    Button DELIVER_Btn;
    @BindView(R.id.COMPLETE_ORDER_Btn)
    Button COMPLETE_ORDER_Btn;
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
    @BindView(R.id.ORDER_TIME_TXT)
    TextView ORDER_TIME_TXT;
    @BindView(R.id.STATUS_COMPLETE)
    TextView STATUS_COMPLETE;
    @BindView(R.id.hourTime)
    TextView hourTime;
    @BindView(R.id.minuteTime)
    TextView minuteTime;
    @BindView(R.id.secondTime)
    TextView secondTime;
    @BindView(R.id.colonTXTFirst)
    TextView colonTXTFirst;
    @BindView(R.id.colonTXTSecond)
    TextView colonTXTSecond;

    public ProcessOrderView(@NonNull Context context, ProcessOrderViewModel viewModel,int check) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_process_order,this);
        ButterKnife.bind(this,this);

        try {
            System.out.println(check);
            if(check == 0){
                custom();
            } else if(check == 11){
                orderHistoryItemClickEvent();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //ellipse_1.setColorFilter(ContextCompat.getColor(context, R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);

        ProcessOrderRecyclerAdapter processOrderRecyclerAdapter = new ProcessOrderRecyclerAdapter();
        itemList.setAdapter(processOrderRecyclerAdapter);

    }

    @OnClick({R.id.closeImgBtn,R.id.ConfirmOrderBtn,R.id.DELIVER_Btn,R.id.COMPLETE_ORDER_Btn})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
            Navigation.findNavController(view).navigate(ProcessOrderFragmentDirections.toProfileFragment());
        } else if(id == R.id.ConfirmOrderBtn){
            colorChange(line_1,ellipse_2);
            ORDER_TIME_TXT.setText(R.string.Preparing);
            CancelBtn.setVisibility(GONE);
            ConfirmOrderBtn.setVisibility(GONE);
            DELIVER_Btn.setVisibility(VISIBLE);
            COMPLETE_ORDER_Btn.setVisibility(GONE);
            STATUS_COMPLETE.setVisibility(GONE);
        } else if(id == R.id.DELIVER_Btn){
            colorChange(line_2,ellipse_3);
            ORDER_TIME_TXT.setText(R.string.Delivery);
            CancelBtn.setVisibility(GONE);
            ConfirmOrderBtn.setVisibility(GONE);
            DELIVER_Btn.setVisibility(GONE);
            COMPLETE_ORDER_Btn.setVisibility(VISIBLE);
            STATUS_COMPLETE.setVisibility(GONE);
        } else if(id == R.id.COMPLETE_ORDER_Btn){
            Navigation.findNavController(view).navigate(ProcessOrderFragmentDirections.OrderCompleteFragment());
        }
    }

    private void colorChange(ImageView imageView,ImageView imageView2){
        imageView.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        imageView2.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    private void orderHistoryItemClickEvent(){
        CancelBtn.setVisibility(GONE);
        ConfirmOrderBtn.setVisibility(GONE);
        DELIVER_Btn.setVisibility(GONE);
        COMPLETE_ORDER_Btn.setVisibility(GONE);
        ellipse_1.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        ellipse_2.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        ellipse_3.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        ellipse_4.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        line_1.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        line_2.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        line_3.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        STATUS_COMPLETE.setVisibility(VISIBLE);
        ORDER_TIME_TXT.setText(R.string.TIME_TO_COMPLETE);
        ORDER_TIME_TXT.setTextColor(Color.parseColor("#7BCC86"));
        hourTime.setTextColor(Color.parseColor("#7BCC86"));
        minuteTime.setTextColor(Color.parseColor("#7BCC86"));
        secondTime.setTextColor(Color.parseColor("#7BCC86"));
        colonTXTFirst.setTextColor(Color.parseColor("#7BCC86"));
        colonTXTSecond.setTextColor(Color.parseColor("#7BCC86"));
    }

    private void custom(){
        CancelBtn.setVisibility(VISIBLE);
        ConfirmOrderBtn.setVisibility(VISIBLE);
        DELIVER_Btn.setVisibility(GONE);
        COMPLETE_ORDER_Btn.setVisibility(GONE);
        ellipse_1.setColorFilter(ContextCompat.getColor(getContext(), R.color._7BCC86), android.graphics.PorterDuff.Mode.MULTIPLY);
        ellipse_2.setColorFilter(ContextCompat.getColor(getContext(), R.color._4D000000), android.graphics.PorterDuff.Mode.MULTIPLY);
        ellipse_3.setColorFilter(ContextCompat.getColor(getContext(), R.color._4D000000), android.graphics.PorterDuff.Mode.MULTIPLY);
        ellipse_4.setColorFilter(ContextCompat.getColor(getContext(), R.color._4D000000), android.graphics.PorterDuff.Mode.MULTIPLY);
        line_1.setColorFilter(ContextCompat.getColor(getContext(), R.color._4D000000), android.graphics.PorterDuff.Mode.MULTIPLY);
        line_2.setColorFilter(ContextCompat.getColor(getContext(), R.color._4D000000), android.graphics.PorterDuff.Mode.MULTIPLY);
        line_3.setColorFilter(ContextCompat.getColor(getContext(), R.color._4D000000), android.graphics.PorterDuff.Mode.MULTIPLY);
        STATUS_COMPLETE.setVisibility(GONE);
        ORDER_TIME_TXT.setText(R.string.orderTime);
        ORDER_TIME_TXT.setTextColor(Color.parseColor("#FF8500"));
        hourTime.setTextColor(Color.parseColor("#FF8500"));
        minuteTime.setTextColor(Color.parseColor("#FF8500"));
        secondTime.setTextColor(Color.parseColor("#FF8500"));
        colonTXTFirst.setTextColor(Color.parseColor("#FF8500"));
        colonTXTSecond.setTextColor(Color.parseColor("#FF8500"));
    }

}
