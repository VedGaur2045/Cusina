package com.lutongbahay.main.fragments.order_history.mvvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import com.applandeo.materialcalendarview.CalendarView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.lutongbahay.R;
import com.lutongbahay.adapter.OrderHistoryRecyclerAdapter;
import com.lutongbahay.main.fragments.order_history.OrderHistoryFragmentDirections;
import com.lutongbahay.utils.Constants;

import org.w3c.dom.Text;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderHistoryView extends FrameLayout {
    private final OrderHistoryViewModel viewModel;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.fromDate)
    TextView fromDate;
    @BindView(R.id.fromDownImg)
    ImageButton fromDownImg;
    @BindView(R.id.toDate)
    TextView toDate;
    @BindView(R.id.toDownImg)
    ImageButton toDownImg;
    @BindView(R.id.completedOrdersTxt)
    TextView completedOrdersTxt;
    @BindView(R.id.CancelledBySellerTxt)
    TextView CancelledBySellerTxt;
    @BindView(R.id.CancelledByCustomerTxt)
    TextView CancelledByCustomerTxt;
    @BindView(R.id.completedOrdersList)
    RecyclerView completedOrdersList;
    @BindView(R.id.CancelledBySellerList)
    RecyclerView CancelledBySellerList;
    @BindView(R.id.CancelledByCustomerList)
    RecyclerView CancelledByCustomerList;
    @BindView(R.id.calenderLayout)
    RelativeLayout calenderLayout;
    @BindView(R.id.fromLayout)
    RelativeLayout fromLayout;
    @BindView(R.id.toLayout)
    RelativeLayout toLayout;
    @BindView(R.id.setDateButton)
    Button setDateButton;
    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    static boolean checkFromCal = true;
    static boolean checkToCal = true;

    public OrderHistoryView(@NonNull Context context, OrderHistoryViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_order_history,this);
        ButterKnife.bind(this,this);

        OrderHistoryRecyclerAdapter orderHistoryRecyclerAdapter = new OrderHistoryRecyclerAdapter();
        completedOrdersList.setAdapter(orderHistoryRecyclerAdapter);

    }

    @OnClick({R.id.closeImgBtn,R.id.fromDate,R.id.toDate,R.id.setDateButton})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.closeImgBtn){
//            Navigation.findNavController(view).navigate(OrderHistoryFragmentDirections.toProfileFragment());
            Navigation.findNavController(view).navigateUp();
        } else if(id == R.id.fromDate){
            String fromDateStr = fromDate.getText().toString();
            String[] separated = fromDateStr.split(" ");
            String[] separatedComma = separated[1].split(",");

            calUseMethod(1,fromLayout,toLayout,checkFromCal,Integer.parseInt(separatedComma[0]), Constants.getMonthValInt(separated[0]),Integer.parseInt(separated[2]));
        } else if(id == R.id.toDate){
            String toDateStr = toDate.getText().toString();
            String[] separated = toDateStr.split(" ");
            String[] separatedComma = separated[1].split(",");

            calUseMethod(2,toLayout,fromLayout,checkToCal,Integer.parseInt(separatedComma[0]), Constants.getMonthValInt(separated[0]),Integer.parseInt(separated[2]));
        } else if (id == R.id.setDateButton){
            String selectedDate = String.valueOf(calendarView.getSelectedDate().getTime());
            String[] separatedDate = selectedDate.split(" ");

            for(String s : separatedDate)
                System.out.println(s);

            if(Constants.constVal == 1){
                setDate(fromDate,Integer.parseInt(separatedDate[5]),Constants.getMonthValStr(separatedDate[1]),Integer.parseInt(separatedDate[2]));
            } else if(Constants.constVal == 2) {
                setDate(toDate, Integer.parseInt(separatedDate[5]), Constants.getMonthValStr(separatedDate[1]), Integer.parseInt(separatedDate[2]));
            }

            calenderLayout.setVisibility(GONE);
        }
    }

    private void calUseMethod(int constVal,RelativeLayout firstLayout,RelativeLayout secondlayout,boolean check, int date, int month, int year){
        firstLayout.setBackgroundColor(Color.parseColor("#FF8500"));
        secondlayout.setBackgroundColor(Color.parseColor("#B3FF8500"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);

        Constants.constVal = constVal;

        try {
            calendarView.setDate(calendar);
        } catch (OutOfDateRangeException e) {
            e.printStackTrace();
        }
        if(check){
            calenderLayout.setVisibility(View.VISIBLE);
            check = false;
        } else {
            calenderLayout.setVisibility(View.GONE);
            check = true;
        }
    }

    @SuppressLint("SetTextI18n")
    private void setDate(TextView textView, int year, String month, int date){
        textView.setText(month+" "+date+", "+year);
    }

}
