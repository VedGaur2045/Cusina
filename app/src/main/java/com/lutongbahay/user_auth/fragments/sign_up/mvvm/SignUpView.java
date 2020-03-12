package com.lutongbahay.user_auth.fragments.sign_up.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.sign_up.SignUpFragmentDirections;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragment;
import com.lutongbahay.user_auth.fragments.sign_up_complete.SignUpCompleteFragmentDirections;
import com.lutongbahay.utils.SnackbarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpView extends FrameLayout {
    private final SignUpViewModel viewModel;
    @BindView(R.id.close)
    ImageButton close;
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
    Spinner genderlist;
    @BindView(R.id.NextBtn)
    Button NextBtn;

    final String[] gender = new String[]{"Gender", "Male", "Female", "Other"};
    final String[] countries = new String[]{"Country","Abra","Agusan del Norte","Agusan del Sur",
            "Aklan", "Albay","Antique","Bataan","Batanes","Batangas","Benguet","Bohol","Bukidnon","Bulacan",
            "Cagayan","Camarines Norte","Camarines Sur","Camiguin","Capiz","Catanduanes","Cavite","Cebu","Basilan"," Eastern Samar",
            "Davao del Sur","Davao Oriental","Ifugao","Ilocos Norte"," Ilocos Sur","Iloilo","Isabela","Laguna","Lanao del Norte","Lanao del Sur",
            "La Union","Leyte"};

    public SignUpView(@NonNull Context context, SignUpViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context, R.layout.fragment_sign_up,this);
        ButterKnife.bind(this,this);

        genderlist.setPrompt("Gender");
        citylist.setPrompt("Country");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner_row, R.id.item, gender);

        genderlist.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), R.layout.custom_spinner_row,R.id.item,countries);

        citylist.setAdapter(adapter2);

    }

    @OnClick({R.id.close,R.id.NextBtn})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.close:
                Navigation.findNavController(view).navigate(SignUpFragmentDirections.toSellWithLutongBehay());
                break;
            case R.id.NextBtn:
                if(username.getText().length()>0 && usermobile.getText().length()>0 && useremail.getText().length()>0
                        && useradddressline1.getText().length()>0 && useradddressline2.getText().length()>0 && zipcode.getText().length()>0
                        && usercountry.getText().length()>0 && citylist.getSelectedItemPosition()>0 && genderlist.getSelectedItemPosition()>0){
                    Navigation.findNavController(view).navigate(SignUpFragmentDirections.toDocumentUploadFragment());
                } else {
                    SnackbarUtils.showSnackBar(view, "Please fill all field", Snackbar.LENGTH_LONG);
                }
                break;
        }
    }
}
