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
    String otp;

    public OtpBasedView(@NonNull Context context, OtpBasedViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_otp_based,this);
        ButterKnife.bind(this,this);
        compatActivity = (AppCompatActivity) context;
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
                checkOtpView(view,otp);
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
                    showErrorAlert(context,"Your otp : "+responseResendOtp.getData().getOtp(),"OTP");
                    checkOtpView(view,responseResendOtp.getData().getOtp());
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

    private void checkOtpView(View view,String otp){
        if (otp_view.getText().toString().isEmpty()){
            SnackbarUtils.showSnackBar(view,"Please enter the otp...", Snackbar.LENGTH_LONG);
        } else {
//            if(otp_view.getText().toString().equals(otp)){
//                Navigation.findNavController(view).navigate(OtpBasedFragmentDirections.toPrivacyFragment());
//            } else {
//                SnackbarUtils.showSnackBar(view,"Otp does not match...",Snackbar.LENGTH_LONG);
//            }
            Navigation.findNavController(view).navigate(OtpBasedFragmentDirections.toPrivacyFragment());
        }
    }

}
