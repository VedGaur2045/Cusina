package com.lutongbahay.user_auth.fragments.document_upload.mvvm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.adapter.DocumentUploadRecyclerAdapter;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.helper.GridSpacingItemDecoration;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragment;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragmentDirections;
import com.lutongbahay.utils.FileUtils;
import com.lutongbahay.utils.SnackbarUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class DocumentUploadView extends FrameLayout {
    private static final int PERMISSION_REQUEST_CODE = 902;
    private final DocumentUploadViewModel viewModel;
    @BindView(R.id.close)
    ImageButton close;
    @BindView(R.id.uploadFileIdFirst)
    Button uploadFileIdFirst;
    @BindView(R.id.uploadFileIdSecond)
    Button uploadFileIdSecond;
    @BindView(R.id.uploadFileIdThird)
    Button uploadFileIdThird;
    @BindView(R.id.nextBtnUpload)
    Button nextBtnUpload;
    @BindView(R.id.fileNameFirstUploaded)
    TextView fileNameFirstUploaded;
    @BindView(R.id.fileNameSecondUploaded)
    TextView fileNameSecondUploaded;
    @BindView(R.id.fileNameThirdUploaded)
    TextView fileNameThirdUploaded;
    @BindView(R.id.governmentId_rv)
    RecyclerView governmentId_rv;
    @BindView(R.id.sanitaryPermit_rv)
    RecyclerView sanitaryPermit_rv;
    @BindView(R.id.addressProof_rv)
    RecyclerView addressProof_rv;

    AppCompatActivity compatActivity;

    DocumentUploadFragment fragment = new DocumentUploadFragment();
    ArrayList<String> image = new ArrayList<>();

    static int checkBtnClick = 0;

    public DocumentUploadView(@NonNull Context context, DocumentUploadViewModel viewModel, ArrayList<String> imageList) {
        super(context);
        this.viewModel = viewModel;
        compatActivity = (AppCompatActivity) context;
        inflate(context,R.layout.fragment_document_upload,this);
        ButterKnife.bind(this,this);

        //image.addAll(imageList);

        if (MarshMallowPermission.checkMashMallowPermissions((AppCompatActivity) context, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE)) {
            return;
        }

        LinearLayoutManager horizontalLayoutManager1= new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManager2= new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManager3= new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        governmentId_rv.setLayoutManager(horizontalLayoutManager1);
        sanitaryPermit_rv.setLayoutManager(horizontalLayoutManager2);
        addressProof_rv.setLayoutManager(horizontalLayoutManager3);

        if (checkBtnClick == 12){
            DocumentUploadRecyclerAdapter recyclerAdapter = new DocumentUploadRecyclerAdapter(setArray(imageList),getContext());
            setVisibilityOfText(fileNameSecondUploaded,fileNameFirstUploaded,fileNameThirdUploaded);
            setVisibilityOfRecyclerView(governmentId_rv,sanitaryPermit_rv,addressProof_rv);
            governmentId_rv.setAdapter(recyclerAdapter);
        } else if (checkBtnClick == 13) {
            DocumentUploadRecyclerAdapter recyclerAdapter = new DocumentUploadRecyclerAdapter(setArray(imageList),getContext());
            setVisibilityOfText(fileNameFirstUploaded,fileNameSecondUploaded,fileNameThirdUploaded);
            setVisibilityOfRecyclerView(sanitaryPermit_rv,governmentId_rv,addressProof_rv);
            sanitaryPermit_rv.setAdapter(recyclerAdapter);
        } else if (checkBtnClick == 14) {
            DocumentUploadRecyclerAdapter recyclerAdapter = new DocumentUploadRecyclerAdapter(setArray(imageList),getContext());
            setVisibilityOfText(fileNameThirdUploaded,fileNameSecondUploaded,fileNameFirstUploaded);
            setVisibilityOfRecyclerView(addressProof_rv,governmentId_rv,sanitaryPermit_rv);
            addressProof_rv.setAdapter(recyclerAdapter);
        } else {
            fileNameFirstUploaded.setVisibility(VISIBLE);
            fileNameSecondUploaded.setVisibility(VISIBLE);
            fileNameThirdUploaded.setVisibility(VISIBLE);
            governmentId_rv.setVisibility(GONE);
            sanitaryPermit_rv.setVisibility(GONE);
            addressProof_rv.setVisibility(GONE);
        }

    }

    @OnClick({R.id.close,R.id.nextBtnUpload,R.id.uploadFileIdFirst,R.id.uploadFileIdSecond,R.id.uploadFileIdThird})
    public void onClick(View view){
        int id = view.getId();
        Bundle bundle = new Bundle();
        bundle.putString("titleName","Upload Documents");
        bundle.putString("text_1","Recents");
        bundle.putString("text_2","Choose up to 3 images");
        bundle.putString("text_3","Minimum of 1 image");
        switch (id){
            case R.id.close :
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpFragment());
                break;
            case R.id.nextBtnUpload :
                //fileSet(fragment.fileUri1,fragment.fileUri2,fragment.fileUri3,fileNameFirstUploaded.getText().toString(),fileNameSecondUploaded.getText().toString(),fileNameThirdUploaded.getText().toString(),view);
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpCompleteFragment());
                break;
            case R.id.uploadFileIdFirst:
                checkBtnClick = 12;
                bundle.putInt("openPhotos",12);
                Navigation.findNavController(view).navigate(R.id.AddPhotoFragment,bundle);
                break;
            case R.id.uploadFileIdSecond:
                checkBtnClick = 13;
                bundle.putInt("openPhotos",13);
                Navigation.findNavController(view).navigate(R.id.AddPhotoFragment,bundle);
                break;
            case R.id.uploadFileIdThird:
                checkBtnClick = 14;
                bundle.putInt("openPhotos",14);
                Navigation.findNavController(view).navigate(R.id.AddPhotoFragment,bundle);
                break;
        }
    }

    private ArrayList<String> setArray(ArrayList<String> imageList){
        String separeteString = imageList.get(0).replace("[","").replace(",","").replace("]","");

        String[] separeted = separeteString.split(" ");

        image.addAll(Arrays.asList(separeted));

        System.out.println(image.size());

        return image;

    }

    private void setVisibilityOfText(TextView text1, TextView text2, TextView text3){
        text1.setVisibility(VISIBLE);
        text2.setVisibility(GONE);
        text3.setVisibility(GONE);
    }
    private void setVisibilityOfRecyclerView(RecyclerView rv1, RecyclerView rv2, RecyclerView rv3){
        rv1.setVisibility(VISIBLE);
        rv2.setVisibility(GONE);
        rv3.setVisibility(GONE);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getFileFromGallery(int requestCode) {
//        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
        Intent intent = new Intent(Intent.ACTION_PICK);
        //intent.setAction(Intent.ACTION_PICK);  //ACTION_GET_CONTENT
        intent.setType("image/*");
        compatActivity.startActivityForResult(intent, requestCode);
    }

    private String getFileName(String fullFilePath){
        String[] saperated = fullFilePath.split("/");
        String fileName = "";
        for(int i=0;i<saperated.length;i++){
            if(i == saperated.length-1){
                fileName = saperated[i];
            }
        }
        System.out.println("File Name : "+fileName);
        return fileName;
    }

    private void fileSet(Uri fileUri1, Uri fileUri2, Uri fileUri3,String fileName1, String fileName2, String fileName3, View view){
        MultipartBody.Part file1 = prepareFilePart("File1",fileUri1);
        MultipartBody.Part file2 = prepareFilePart("File2",fileUri2);
        MultipartBody.Part file3 = prepareFilePart("FIle3",fileUri3);
        documentUpload(compatActivity,file1,file2,file3,view,fileName1,fileName2,fileName3);
    }

    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(compatActivity, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(Objects.requireNonNull(compatActivity.getContentResolver().getType(fileUri))),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

    public void documentUpload(Context context, MultipartBody.Part file1, MultipartBody.Part file2, MultipartBody.Part file3,View view, String fileName1, String fileName2, String fileName3){
        RequestDocumentUpload documentUpload = new RequestDocumentUpload();
        documentUpload.setId1Type(fileName1);
        documentUpload.setId2Type(fileName2);
        documentUpload.setId3Type(fileName3);
        documentUpload.setUserId(CusinaApplication.getPreferenceManger().getIntegerValue(CusinaApplication.getPreferenceManger().USER_ID));
        viewModel.documentUpload(context,documentUpload,file1,file2,file3).observe(compatActivity, responseDocument -> {
            if(responseDocument == null){
                showErrorAlert(context,"Oops!! Server error occurred. Please try again.");
            } else {
                if(!responseDocument.isSuccess()){
                    showErrorAlert(context,responseDocument.getMessage());
                } else {
                    SnackbarUtils.showSnackBar(view,responseDocument.getMessage(),Snackbar.LENGTH_LONG);
                }
            }
        });
    }

    public void showErrorAlert(Context context, String errorMessage) {
        CusinaAlertDialog.showDCAlertDialog(context, 0, "Error", errorMessage, null, "Ok", null,
                (view, dialog) -> {

                }, null);
    }

}
