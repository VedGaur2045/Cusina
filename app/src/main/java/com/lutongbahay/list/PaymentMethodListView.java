package com.lutongbahay.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lutongbahay.R;

import java.util.ArrayList;

public class PaymentMethodListView extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> paymentImgArr;
    private ArrayList<String> paymentMethodTxtArr;
    private RadioButton selected = null;

    public PaymentMethodListView(Context context, ArrayList<Integer> paymentImgArr, ArrayList<String> paymentMethodTxtArr) {
        this.context = context;
        this.paymentImgArr = paymentImgArr;
        this.paymentMethodTxtArr = paymentMethodTxtArr;
    }

    @Override
    public int getCount() {
        return paymentMethodTxtArr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View paymentView;

        if(view == null){
            paymentView = LayoutInflater.from(context).inflate(R.layout.adapter_payment_metod,viewGroup,false);

            final RadioButton rdBtn = paymentView.findViewById(R.id.payment_Checked);
            TextView paymentTxt = paymentView.findViewById(R.id.payment_txt);
            ImageView paymentImg = paymentView.findViewById(R.id.payment_Img);

            paymentTxt.setText(paymentMethodTxtArr.get(i));
            paymentImg.setImageResource(paymentImgArr.get(i));

            rdBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selected != null)
                    {
                        selected.setChecked(false);
                    }

                    rdBtn.setChecked(true);
                    selected = rdBtn;
                }
            });

        } else {
            paymentView = view;
        }

        return paymentView;
    }
}
