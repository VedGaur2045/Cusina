package com.lutongbahay.user_auth.fragments.sign_up.mvvm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import com.lutongbahay.glide.GlideApp;
import com.lutongbahay.interfaces.DocumentMediaInterface;
import com.lutongbahay.interfaces.SignUpInterface;
import com.lutongbahay.main.fragments.add_photo.AddPhotoFragment;
import com.lutongbahay.rest.request.RequestAddSeller;
import com.lutongbahay.user_auth.activity.AuthActivity;
import com.lutongbahay.user_auth.activity.splash.SplashActivity;
import com.lutongbahay.user_auth.fragments.sign_up.SignUpFragmentDirections;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragment;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragmentDirections;
import com.lutongbahay.utils.Constants;
import com.lutongbahay.utils.Logger;
import com.lutongbahay.utils.SnackbarUtils;
import com.lutongbahay.utils.StatusBarUtils;
import com.lutongbahay.utils.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class SignUpView extends FrameLayout implements SignUpInterface {
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
    @BindView(R.id.profile_image)
    CircleImageView profile_Image;
    @BindView(R.id.upload_img)
    Button upload_img;

    Context compatActivity;
    ArrayList<String> file = new ArrayList<>();

    final String[] countries = new String[]{"City","Abra","Agusan del Norte","Agusan del Sur",
            "Aklan", "Albay","Antique","Bataan","Batanes","Batangas","Benguet","Bohol","Bukidnon","Bulacan",
            "Cagayan","Camarines Norte","Camarines Sur","Camiguin","Capiz","Catanduanes","Cavite","Cebu","Basilan"," Eastern Samar",
            "Davao del Sur","Davao Oriental","Ifugao","Ilocos Norte"," Ilocos Sur","Iloilo","Isabela","Laguna","Lanao del Norte","Lanao del Sur",
            "La Union","Leyte"};

    @SuppressLint("ClickableViewAccessibility")
    public SignUpView(@NonNull Context context, SignUpViewModel viewModel, String file) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_sign_up,this);
        ButterKnife.bind(this,this);
        compatActivity = context;
        try{
            if(!file.equals("")){
                System.out.println("Fiel : "+file);
                GlideApp.with(context).load(file).into(profile_Image);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

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

    @OnClick({R.id.close,R.id.NextBtn,R.id.genderlist,R.id.upload_img})
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

                    //addSellerInfoData((AppCompatActivity) getContext(), view, Constants.TOKEN);

                } else {
                    SnackbarUtils.showSnackBar(view, "Please fill all field", Snackbar.LENGTH_LONG);
                    Navigation.findNavController(view).navigate(SignUpFragmentDirections.toDocumentUploadFragment());
                }
                break;
            case R.id.genderlist:
                selectGender(view);
                break;
            case R.id.upload_img:
                AddPhotoFragment.signUpInterface = this::mediaCallBack;
                Bundle bundle = new Bundle();
                bundle.putString("titleName","Upload Documents");
                bundle.putString("text_1","All Photos");
                bundle.putString("text_2","Choose up to 1 images");
                bundle.putString("text_3","Minimum of 1 image");
                bundle.putInt("openPhotos",15);
                Navigation.findNavController(view).navigate(R.id.AddPhotoFragment,bundle);
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

    public void addSellerInfoData(AppCompatActivity compatActivity,View view, String token){
        Logger.ErrorLog(citylist.getSelectedItem().toString(),kitchenName.getText().toString());
        RequestAddSeller requestAddSeller = new RequestAddSeller();
        requestAddSeller.setImage(Collections.singletonList(file.get(0)));
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

        viewModel.addSeller(compatActivity, token, requestAddSeller).observe(compatActivity, response -> {
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
                    } else if(response.getData().getImages().get(0).matches("The image field is required.")){
                        SnackbarUtils.showSnackBar(view,"The image field is required.",Snackbar.LENGTH_LONG);
                    } else  {
                        System.out.println("Data Successfully Added");
                        SnackbarUtils.showSnackBar(view,"Data Successfully Added.",Snackbar.LENGTH_LONG);
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
                    if(responseVerifyKitchen.getMessage().equals("Kitchen name already taken.")){
                        showErrorAlert(compatActivity,"Kitchen name already taken., try another");
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

    @Override
    public void mediaCallBack(List<File> fileList) {
        if (fileList != null && fileList.size() > 0) {
            for (int i =0; i < fileList.size(); i++){
                System.out.println("Vakjkl : "+fileList.get(i));
                Bitmap myBitmap = BitmapFactory.decodeFile(fileList.get(i).getAbsolutePath());
                //GlideApp.with(compatActivity).load(fileList.get(i)).into(profile_Image);
                //file = new File(String.valueOf(fileList.get(i)));
                Uri uri = Uri.fromFile(fileList.get(i).getAbsoluteFile());
                System.out.println("Uri : "+uri);
                profile_Image.setImageURI(uri);
                String[] sapearted = String.valueOf(fileList.get(i)).split("/");
                for(int j=0; j<sapearted.length; j++){
                    if(j == sapearted.length-1) {
                        System.out.println("hbjsdf : "+sapearted[j]);
                        file.add(sapearted[j]);
                    }
                }
            }
        }
    }
}
