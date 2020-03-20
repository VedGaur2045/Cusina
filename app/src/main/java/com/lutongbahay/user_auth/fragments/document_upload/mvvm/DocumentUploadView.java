package com.lutongbahay.user_auth.fragments.document_upload.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragment;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class DocumentUploadView extends FrameLayout {
    private static final int PERMISSION_REQUEST_CODE = 902;
    private final DocumentUploadViewModel viewModel;
    @BindView(R.id.close)
    ImageButton close;
    @BindView(R.id.uploadFileIdFirst)
    Button uploadFileIdFirst;
    @BindView(R.id.fileNameFirstUploaded)
    public TextView fileNameFirstUploaded;
    @BindView(R.id.uploadFileIdSecond)
    Button uploadFileIdSecond;
    @BindView(R.id.fileNameSecondUploaded)
    public TextView fileNameSecondUploaded;
    @BindView(R.id.uploadFileIdThird)
    Button uploadFileIdThird;
    @BindView(R.id.fileNameThirdUploaded)
    public TextView fileNameThirdUploaded;
    @BindView(R.id.nextBtnUpload)
    Button nextBtnUpload;

    AppCompatActivity compatActivity;

    DocumentUploadFragment fragment = new DocumentUploadFragment();

    public DocumentUploadView(@NonNull Context context, DocumentUploadViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        compatActivity = (AppCompatActivity) context;
        inflate(context,R.layout.fragment_document_upload,this);
        ButterKnife.bind(this,this);

        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE)) {
            return;
        }

    }

    @OnClick({R.id.close,R.id.nextBtnUpload,R.id.uploadFileIdFirst,R.id.uploadFileIdSecond,R.id.uploadFileIdThird})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.close :
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpFragment());
                break;
            case R.id.nextBtnUpload :
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpCompleteFragment());
                break;
            case R.id.uploadFileIdFirst:
                getFileFromGallery(101);
                break;
            case R.id.uploadFileIdSecond:
                getFileFromGallery(102);
                break;
            case R.id.uploadFileIdThird:
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
        compatActivity.startActivityForResult(intent, requestCode);
    }



}
