package com.lutongbahay.user_auth.fragments.sign_up.mvvm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.user_auth.activity.AuthActivity;
import com.lutongbahay.user_auth.activity.splash.SplashActivity;
import com.lutongbahay.user_auth.fragments.sign_up.SignUpFragmentDirections;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragment;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragmentDirections;
import com.lutongbahay.utils.Constants;
import com.lutongbahay.utils.SnackbarUtils;
import com.lutongbahay.utils.StatusBarUtils;
import com.lutongbahay.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpView extends FrameLayout {
    private final SignUpViewModel viewModel;
    @BindView(R.id.close)
    ImageButton close;
    @BindView(R.id.kitchenName)
    EditText kitchenName;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.usermobile)
    EditText usermobile;
    @BindView(R.id.useremail)
    EditText useremail;
    @BindView(R.id.useradddressline1)
    EditText useradddressline1;
    @BindView(R.id.useradddressline2)
    EditText useradddressline2;
    @BindView(R.id.citylist)
    Spinner citylist;
    @BindView(R.id.zipcode)
    EditText zipcode;
    @BindView(R.id.usercountry)
    EditText usercountry;
    @BindView(R.id.genderlist)
    TextView genderlist;
    @BindView(R.id.NextBtn)
    Button NextBtn;

    final String[] gender = new String[]{"Gender", "Male", "Female", "Other"};
    final String[] countries = new String[]{"City","Abra","Agusan del Norte","Agusan del Sur",
            "Aklan", "Albay","Antique","Bataan","Batanes","Batangas","Benguet","Bohol","Bukidnon","Bulacan",
            "Cagayan","Camarines Norte","Camarines Sur","Camiguin","Capiz","Catanduanes","Cavite","Cebu","Basilan"," Eastern Samar",
            "Davao del Sur","Davao Oriental","Ifugao","Ilocos Norte"," Ilocos Sur","Iloilo","Isabela","Laguna","Lanao del Norte","Lanao del Sur",
            "La Union","Leyte"};

    @SuppressLint("ClickableViewAccessibility")
    public SignUpView(@NonNull Context context, SignUpViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_sign_up,this);
        ButterKnife.bind(this,this);

        citylist.setPrompt("Country");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner_row,R.id.item,countries);

        citylist.setAdapter(adapter2);

        kitchenName.addTextChangedListener(textWatcher);

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            verifyKitchenName((AppCompatActivity) getContext(),kitchenName.getText().toString(), Constants.TOKEN);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @OnClick({R.id.close,R.id.NextBtn,R.id.genderlist})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.close:
                Navigation.findNavController(view).navigate(SignUpFragmentDirections.toSellWithLutongBehay());
                break;
            case R.id.NextBtn:
                System.out.println(citylist.getSelectedItem().toString()+"     "+genderlist.getText().toString());
                if(kitchenName.getText().length()>0 && username.getText().length()>0 && usermobile.getText().length()>0 && useremail.getText().length()>0
                        && useradddressline1.getText().length()>0 && useradddressline2.getText().length()>0 && zipcode.getText().length()>0
                        && usercountry.getText().length()>0 && citylist.getSelectedItemPosition()>0 && genderlist.getText().length()>0){
                    addSellerInfoData((AppCompatActivity) getContext(), view);

                } else {
                    SnackbarUtils.showSnackBar(view, "Please fill all field", Snackbar.LENGTH_LONG);
                    Navigation.findNavController(view).navigate(SignUpFragmentDirections.toDocumentUploadFragment());
                }
                break;
            case R.id.genderlist:
                selectGender(view);
                break;
        }
    }

    private void selectGender(View mainView){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.setLightStatusBar((Activity) getContext(),"#99000000");
        }
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popUpView = inflater.inflate(R.layout.popup_gender_selection_layout,null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;

        TextView maleBtn = popUpView.findViewById(R.id.maleTxt);
        TextView femaleTxt = popUpView.findViewById(R.id.femaleTxt);
        TextView cancelTxt = popUpView.findViewById(R.id.cancelTxt);

        final PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

        popupWindow.showAtLocation(mainView, Gravity.BOTTOM,0,0);

        popupWindow.setOutsideTouchable(false);

        maleBtn.setOnClickListener(view -> {
            genderlist.setText(maleBtn.getText().toString());
            popupWindow.dismiss();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                StatusBarUtils.redStatusBar((Activity) getContext());
            }
        });
        femaleTxt.setOnClickListener(view -> {
            genderlist.setText(femaleTxt.getText().toString());
            popupWindow.dismiss();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                StatusBarUtils.redStatusBar((Activity) getContext());
            }
        });
        cancelTxt.setOnClickListener(view -> {
            popupWindow.dismiss();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                StatusBarUtils.redStatusBar((Activity) getContext());
            }
        });
    }

    public void addSellerInfoData(AppCompatActivity compatActivity,View view){
        RequestAddSeller requestAddSeller = new RequestAddSeller();
        requestAddSeller.setName(username.getText().toString());
        requestAddSeller.setMobile(usermobile.getText().toString());
        requestAddSeller.setEmail(useremail.getText().toString());
        requestAddSeller.setAddress1(useradddressline1.getText().toString());
        requestAddSeller.setAddress2(useradddressline2.getText().toString());
        requestAddSeller.setCity(citylist.getSelectedItem().toString());
        requestAddSeller.setZipcode(zipcode.getText().toString());
        requestAddSeller.setCountry(usercountry.getText().toString());
        requestAddSeller.setGender(genderlist.getText().toString());
        requestAddSeller.setKitchen(kitchenName.getText().toString());

        viewModel.addSeller(compatActivity, requestAddSeller).observe(compatActivity, response -> {
            if (response == null) {
                showErrorAlert(compatActivity, "Oops!! Server error occurred. Please try again.");
            } else {
                if (!response.getSuccess()) {
                    showErrorAlert(compatActivity, response.getMessage());
                } else {
                    //ToastUtils.shortToast(response.getMessage());
                    if(response.getMessage().matches("Kitchen already exists")){
                        SnackbarUtils.showSnackBar(view,"Kitchen already exists",Snackbar.LENGTH_LONG);
                    } else if(response.getMessage().matches("Mobile number already exists")){
                        SnackbarUtils.showSnackBar(view,"Mobile number already exists",Snackbar.LENGTH_LONG);
                    } else if(response.getMessage().matches("Email id already register.")){
                        SnackbarUtils.showSnackBar(view,"Email id already register.",Snackbar.LENGTH_LONG);
                    } else {
                        System.out.println("Data Successfully Added");
                        Navigation.findNavController(view).navigate(SignUpFragmentDirections.toDocumentUploadFragment());
                    }
                }
            }
            ProgressDialogFragment.dismissProgressDialog(compatActivity);
        });
    }

    public void verifyKitchenName(AppCompatActivity compatActivity, String kitchenName, String token){
        viewModel.verifyKitchen(compatActivity,kitchenName,token).observe(compatActivity, responseVerifyKitchen -> {
            if(responseVerifyKitchen == null){
                showErrorAlert(compatActivity, "Oops!! Server error occurred. Please try again.");
            } else {
                if(!responseVerifyKitchen.getSuccess()){
                    showErrorAlert(compatActivity,responseVerifyKitchen.getMessage());
                } else {
                    if(responseVerifyKitchen.getSuccess().equals("Kitchen already exists")){
                        showErrorAlert(compatActivity,"Kitchen already exists, try another");
                    } else {
                        ToastUtils.shortToast(responseVerifyKitchen.getMessage());
                        System.out.println("On Kitchen Name Success : "+responseVerifyKitchen.getMessage());
                        //addSellerInfoData(compatActivity,view);
                    }
                }
            }
            ProgressDialogFragment.dismissProgressDialog(compatActivity);
        });
    }


    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
