package com.lutongbahay.main.fragments.complete_details.mvvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.lutongbahay.R;
import com.lutongbahay.adapter.TimeOfPickupOrderRecyclerAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.AppAction;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.interfaces.DocumentMediaInterface;
import com.lutongbahay.main.fragments.complete_details.CompletedDetailsFragmentDirections;
import com.lutongbahay.rest.request.RequestAddDish;
import com.lutongbahay.utils.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CompletedDetailsView extends FrameLayout implements DocumentMediaInterface {
    private final CompletedDetailsViewModel viewModel;
    private AppCompatActivity compatActivity;
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
//    LinearLayout selecttimefrom)
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
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.dateFromImg)
    ImageView dateFromImg;
    @BindView(R.id.dateToImg)
    ImageView dateToImg;
    @BindView(R.id.timeListItem)
    RecyclerView timeListItem;
    @BindView(R.id.setDateButton)
    Button setDateButton;
    @BindView(R.id.calendarView)
    CalendarView calendarView;
    @BindView(R.id.calenderLayout)
    RelativeLayout calenderLayout;

    ArrayList<String> image = new ArrayList<>();

    static int deliveryMethod;
    public static Integer countSell=1;
    public static Integer countServe=1;
    static boolean checkFromCal = true;
    static boolean checkToCal = true;
    private static String startTxt,endTxt;

    public CompletedDetailsView(@NonNull Context context, CompletedDetailsViewModel viewModel, String categoryName) {
        super(context);
        compatActivity = (AppCompatActivity) context;
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_completed_details,this);
        ButterKnife.bind(this,this);

        titleName.setText(R.string.complete_dish_details);
        closeImgBtn.setVisibility(GONE);

        category.setText(categoryName);

        deliveryMethod = selectedRadioBtn();

        LinearLayoutManager horizontalLayoutManager= new LinearLayoutManager((Context) context, LinearLayoutManager.HORIZONTAL, false);
        timeListItem.setLayoutManager(horizontalLayoutManager);

        TimeOfPickupOrderRecyclerAdapter timeOfPickupOrderRecyclerAdapter = new TimeOfPickupOrderRecyclerAdapter();
        timeListItem.setAdapter(timeOfPickupOrderRecyclerAdapter);

    }

    private int selectedRadioBtn(){
        int selectId = 0;
        int selectedRdId = radioGroup.getCheckedRadioButtonId();
        switch (selectedRdId){
            case R.id.pickUpOnly_RD_Btn :
                deliveryMethod = 1;
                break;
            case R.id.delivery_RD_Btn :
                deliveryMethod = 0;
                break;
        }
        return selectId;
    }

    @OnClick({R.id.backBtnImg,R.id.listMyLutoSubmitBtn,R.id.add_No_of_Sell,R.id.add_MinServing,
            R.id.minus_No_of_Sell,R.id.minus_MinServing,R.id.dateToImg,R.id.dateFromImg,R.id.setDateButton})
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
            case R.id.dateFromImg:
                String fromDateStr = dateFrom.getText().toString();
                String[] separated = fromDateStr.split(" ");
                listMyLutoSubmitBtn.setVisibility(GONE);
                calUseMethod(1,checkFromCal,Integer.parseInt(separated[0]), Constants.getMonthValInt(separated[0]),Integer.parseInt(separated[2]));
                break;
            case R.id.dateToImg:
                String toDateStr = dateTo.getText().toString();
                String[] separated1 = toDateStr.split(" ");
                listMyLutoSubmitBtn.setVisibility(GONE);
                calUseMethod(2,checkToCal,Integer.parseInt(separated1[0]), Constants.getMonthValInt(separated1[0]),Integer.parseInt(separated1[2]));
                break;
            case R.id.setDateButton:
                listMyLutoSubmitBtn.setVisibility(GONE);
                String selectedDate = String.valueOf(calendarView.getSelectedDate().getTime());
                String[] separatedDate = selectedDate.split(" ");

                for(String s : separatedDate)
                    System.out.println(s);

                if(Constants.constVal == 1){
                    setDate(dateFrom,Integer.parseInt(separatedDate[5]),Constants.getMonthValStr(separatedDate[1]),Integer.parseInt(separatedDate[2]));
                } else if(Constants.constVal == 2) {
                    setDate(dateTo, Integer.parseInt(separatedDate[5]), Constants.getMonthValStr(separatedDate[1]), Integer.parseInt(separatedDate[2]));
                }

                calenderLayout.setVisibility(GONE);
                break;
        }
    }

    private void calUseMethod(int constVal,boolean check, int date, int month, int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);

        Constants.constVal = constVal;

        try {
            calendarView.setDate(calendar);
        } catch (OutOfDateRangeException e) {
            e.printStackTrace();
        }
        if(check){
            listMyLutoSubmitBtn.setVisibility(GONE);
            calenderLayout.setVisibility(View.VISIBLE);
            check = false;
        } else {
            listMyLutoSubmitBtn.setVisibility(VISIBLE);
            calenderLayout.setVisibility(View.GONE);
            check = true;
        }
    }

    @SuppressLint("SetTextI18n")
    private void setDate(TextView textView, int year, String month, int date){
        textView.setText(date+" "+month+" "+year);
    }

    private void addDishDetail(AppCompatActivity context, List<MultipartBody.Part> file, View view){
        RequestAddDish addDish = new RequestAddDish();
        addDish.setUserId(CusinaApplication.getPreferenceManger().getIntegerValue(CusinaApplication.getPreferenceManger().USER_ID));
        addDish.setName(dishName.getText().toString());
        addDish.setDescription(description.getText().toString());
        addDish.setMinQty(Integer.parseInt(quantity2.getText().toString()));
        //addDish.setFoodType();
        addDish.setPrice(price.getText().toString());
        addDish.setDeliveryType(deliveryMethod);
        addDish.setDeliveryPrice(feeOfDelivery.getText().toString());
        addDish.setDatesAvailableFrom(dateFrom.getText().toString());
        addDish.setDatesAvailableTo(dateTo.getText().toString());
        addDish.setTimeAvailableFrom(Constants.startTime);
        addDish.setTimeAvailableTo(Constants.endTime);
        addDish.setTotalQty(Integer.parseInt(quantity.getText().toString()));
        viewModel.responseAddDish(context,addDish,file).observe(context,responseAddDish -> {
            if(responseAddDish == null){
                showErrorAlert(context,"Oops!! Server error occurred. Please try again.","Error");
            } else {
                if(!responseAddDish.getSuccess()){
                    showErrorAlert(context,responseAddDish.getMessage(),"Error");
                } else {
                    showErrorAlert(context,"Data Successfully Added.","Alert");
                    Navigation.findNavController(view).navigate(CompletedDetailsFragmentDirections.toSuccessConfirmation());
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

    public void showErrorAlert(Context context, String errorMessage,String title) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, title, errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

    @Override
    public void mediaCallBack(List<File> fileList) {
        if (fileList != null && fileList.size() > 0){

            List<MultipartBody.Part> requestFiles = new ArrayList<>();
            for (int i =0; i < fileList.size(); i++){

                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), fileList.get(i));
                MultipartBody.Part fileData =
                        MultipartBody.Part.createFormData("file" + (i + 1), fileList.get(i).getName(), requestFile);

                requestFiles.add(fileData);
            }

            if (requestFiles.size() > 0)
                addDishDetail(compatActivity,requestFiles,getRootView());
        }
    }

    private ArrayList<String> setArray(ArrayList<String> imageList){
        String separeteString = imageList.get(0).replace("[","").replace(",","").replace("]","");

        String[] separeted = separeteString.split(" ");

        image.addAll(Arrays.asList(separeted));

        System.out.println(image.size());

        return image;

    }

}
