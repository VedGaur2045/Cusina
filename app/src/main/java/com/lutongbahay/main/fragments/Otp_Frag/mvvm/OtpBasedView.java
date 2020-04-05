package com.lutongbahay.main.fragments.Otp_Frag.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;

import com.chaos.view.PinView;
import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.dialogs.ProgressDialogFragment;
import com.lutongbahay.main.fragments.Otp_Frag.OtpBasedFragmentDirections;
import com.lutongbahay.main.home.HomeActivity;
import com.lutongbahay.user_auth.activity.splash.SplashActivity;
import com.lutongbahay.utils.Constants;
import com.lutongbahay.utils.SnackbarUtils;
import com.lutongbahay.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtpBasedView extends FrameLayout {
    private final OtpBasedViewModel viewModel;
    @BindView(R.id.closeImgBtn)
    ImageButton closeImgBtn;
    @BindView(R.id.resendOTP)
    TextView resendOTP;
    @BindView(R.id.otp_view)
    PinView otp_view;
    @BindView(R.id.nextBtn)
    Button nextBtn;
    AppCompatActivity compatActivity;
    static String otp;
    static int userId;

    public OtpBasedView(@NonNull Context context, OtpBasedViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_otp_based,this);
        ButterKnife.bind(this,this);
        compatActivity = (AppCompatActivity) context;
        userId =  CusinaApplication.getPreferenceManger().getIntegerValue(CusinaApplication.getPreferenceManger().USER_ID);
        try {
            otp = compatActivity.getIntent().getExtras().getString("otp");
            System.out.println("Given otp from main activity : "+otp);

            showErrorAlert(context,"Your otp : "+otp,"OTP");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @OnClick({R.id.closeImgBtn,R.id.resendOTP,R.id.nextBtn})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.closeImgBtn:
                SplashActivity.openSplashActivity(getContext());
                break;
            case R.id.nextBtn:
                checkOtpView(view,otp,userId);
                break;
            case R.id.resendOTP:
                resendOtp(compatActivity,97,view);
                break;
        }
    }

    public void resendOtp(AppCompatActivity context, int userId,View view){
        viewModel.resendOtp(context,userId).observe(context, responseResendOtp -> {
            if(responseResendOtp == null){
                showErrorAlert(context,"User Id is not valid","Error");
            } else {
                if (!responseResendOtp.getSuccess()){
                    showErrorAlert(context,responseResendOtp.getMessage(),"Message");
                } else {
                    ToastUtils.shortToast(responseResendOtp.getData().getOtp());
                    otp = responseResendOtp.getData().getOtp();
                    showErrorAlert(context,"Your otp : "+responseResendOtp.getData().getOtp(),"OTP");
                    checkOtpView(view,responseResendOtp.getData().getOtp(),userId);
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }

    private void otpVerify(Context context, int id, String otp, View view){
        viewModel.otpVerify(context,id,otp).observe(compatActivity, responseOtpVerify -> {
            if(responseOtpVerify == null){
                showErrorAlert(context,"User Id is not valid","Error");
            } else {
                if (!responseOtpVerify.isSuccess()){
                    showErrorAlert(context,responseOtpVerify.getMessage(),"Message");
                } else {
                    CusinaApplication.getPreferenceManger().putUserToken(responseOtpVerify.getDataOtpVerify().getToken());
                    CusinaApplication.getPreferenceManger().putUserType(responseOtpVerify.getDataOtpVerify().getUserType());
                    Navigation.findNavController(view).navigate(OtpBasedFragmentDirections.toPrivacyFragment());
                }
            }
            ProgressDialogFragment.dismissProgressDialog(context);
        });
    }


    public void showErrorAlert(Context context, String errorMessage, String title) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, title, errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

    private void checkOtpView(View view,String otp,int userId){
        if (otp_view.getText().toString().isEmpty()){
            SnackbarUtils.showSnackBar(view,"Please enter the otp...", Snackbar.LENGTH_LONG);
        } else {
            if(otp_view.getText().toString().equals(otp)){
                otpVerify(compatActivity,userId,otp,view);
            } else {
                SnackbarUtils.showSnackBar(view,"Otp does not match...",Snackbar.LENGTH_LONG);
            }
           // Navigation.findNavController(view).navigate(OtpBasedFragmentDirections.toPrivacyFragment());
        }
    }

}
