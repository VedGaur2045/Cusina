package com.lutongbahay.main.fragments.complete_details.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.dialogs.AppAction;
import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompletedDetailsView extends FrameLayout {
    private final CompletedDetailsViewModel viewModel;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.backBtnImg)
    ImageButton backBtnImg;
    @BindView(R.id.dishName)
    EditText dishName;
    @BindView(R.id.description)
    EditText description;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.pickUpOnly_RD_Btn)
    RadioButton pickUpOnly;
    @BindView(R.id.delivery_RD_Btn)
    RadioButton delivery_RD_Btn;
    @BindView(R.id.feeOfDelivery)
    EditText feeOfDelivery;
    @BindView(R.id.selectdatefrom)
    LinearLayout selectDateFrom;
    @BindView(R.id.dateFrom)
    TextView dateFrom;
    @BindView(R.id.selectdateto)
    LinearLayout selectdateto;
    @BindView(R.id.dateTo)
    TextView dateTo;
//    @BindView(R.id.selecttimefrom2)
//    LinearLayout selecttimefrom;
    @BindView(R.id.timefrom)
    TextView timefrom;
    @BindView(R.id.selecttimeto)
    LinearLayout selecttimeto;
    @BindView(R.id.timeto)
    TextView timeto;
    @BindView(R.id.minus_No_of_Sell)
    RelativeLayout minus_No_of_Sell;
    @BindView(R.id.quantity)
    TextView quantity;
    @BindView(R.id.add_No_of_Sell)
    RelativeLayout add_No_of_Sell;
    @BindView(R.id.minus_MinServing)
    RelativeLayout minus_MinServing;
    @BindView(R.id.quantity2)
    TextView quantity2;
    @BindView(R.id.add_MinServing)
    RelativeLayout add_MinServing;
    @BindView(R.id.listMyLutoSubmitBtn)
    Button listMyLutoSubmitBtn;

    public static Integer countSell=1;
    public static Integer countServe=1;

    public CompletedDetailsView(@NonNull Context context, CompletedDetailsViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_completed_details,this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.complete_dish_details);
        closeImgBtn.setVisibility(GONE);

    }

    @OnClick({R.id.backBtnImg,R.id.listMyLutoSubmitBtn,R.id.add_No_of_Sell,R.id.add_MinServing,
            R.id.minus_No_of_Sell,R.id.minus_MinServing})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.backBtnImg:
                //Navigation.findNavController(view).navigate(CompletedDetailsFragmentDirections.toChooseCategory());
                Navigation.findNavController(view).navigateUp();
                break;
            case R.id.listMyLutoSubmitBtn:
                Navigation.findNavController(view).navigate(CompletedDetailsFragmentDirections.toSuccessConfirmation());
                break;
            case R.id.add_No_of_Sell:
                AppAction.addCount(countSell,quantity);
                break;
            case R.id.add_MinServing:
                AppAction.addCount(countServe,quantity2);
                break;
            case R.id.minus_No_of_Sell:
                AppAction.minusCount(countSell,quantity);
                break;
            case R.id.minus_MinServing:
                AppAction.minusCount(countServe,quantity2);
                break;
        }
    }

}
