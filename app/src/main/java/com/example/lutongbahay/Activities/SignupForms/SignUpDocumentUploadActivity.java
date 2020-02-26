package com.example.lutongbahay.Activities.SignupForms;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lutongbahay.Activities.Login;
import com.example.lutongbahay.Activities.Success_confirmation;
import com.example.lutongbahay.R;
import com.example.lutongbahay.UtilClasses.UtilClass;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SignUpDocumentUploadActivity extends AppCompatActivity {

    Button uploadFileFirst,uploadFileSecond,uploadFileThird,nextBtn;
    TextView fileFisrtUpload,fileSecondUpload,fileThirdUpload;

    private Uri fileUri;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_document_upload);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            UtilClass.redStatusBar(this);
        }

        requestPermission();

        setObjectId();

    }

    private void setObjectId(){
        uploadFileFirst = findViewById(R.id.uploadFileIdFirst);
        uploadFileSecond = findViewById(R.id.uploadFileIdSecond);
        uploadFileThird = findViewById(R.id.uploadFileIdThird);
        nextBtn = findViewById(R.id.nextBtnUpload);
        fileFisrtUpload = findViewById(R.id.fileNameFirstUploaded);
        fileSecondUpload = findViewById(R.id.fileNameSecondUploaded);
        fileThirdUpload = findViewById(R.id.fileNameThirdUploaded);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void uploadFileOnClick(View view) {
        switch (view.getId()){
            case R.id.uploadFileIdFirst :
                getFileFromGallery(101);
                break;
            case R.id.uploadFileIdSecond :
                getFileFromGallery(102);
                break;
            case R.id.uploadFileIdThird :
                getFileFromGallery(103);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getFileFromGallery(int requestCode) {
//        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("file/*");
        startActivityForResult(intent, requestCode);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void nextBtnOnClick(View view) {
        Bundle bndlAnimation = ActivityOptions.makeCustomAnimation(SignUpDocumentUploadActivity.this, R.animator.enter_from_right, R.animator.exit_to_left).toBundle();
        startActivity(new Intent(SignUpDocumentUploadActivity.this, Success_confirmation.class),bndlAnimation);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 101:
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    fileFisrtUpload.setText(filePath);
                break;
            case 102:
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    fileSecondUpload.setText(filePath);
                break;
            case 103:
                    fileUri = data.getData();
                    filePath = fileUri.getPath();
                    fileThirdUpload.setText(filePath);
                break;
        }
    }


    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE}, 100);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode)
            {
                case 100:{ break; }
            }
        } else { }

        return;
    }

}
