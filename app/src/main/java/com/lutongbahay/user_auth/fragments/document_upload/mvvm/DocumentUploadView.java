package com.lutongbahay.user_auth.fragments.document_upload.mvvm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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

import com.google.android.material.snackbar.Snackbar;
import com.lutongbahay.R;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.dialogs.CusinaAlertDialog;
import com.lutongbahay.helper.MarshMallowPermission;
import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragment;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragmentDirections;
import com.lutongbahay.utils.FileUtils;
import com.lutongbahay.utils.SnackbarUtils;

import java.io.File;
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
    @BindView(R.id.imageFirst)
    public ImageView imageFirst;
    @BindView(R.id.imageSecond)
    public ImageView imageSecond;
    @BindView(R.id.imageThird)
    public ImageView imageThird;
    @BindView(R.id.imageForth)
    public ImageView imageForth;
    @BindView(R.id.imageFifth)
    public ImageView imageFifth;
    @BindView(R.id.imageSixth)
    public ImageView imageSixth;
    @BindView(R.id.imageSeventh)
    public ImageView imageSeventh;
    @BindView(R.id.imageEighth)
    public ImageView imageEighth;
    @BindView(R.id.imageNinth)
    public ImageView imageNinth;
    @BindView(R.id.closeFirst)
    public ImageView closeFirst;
    @BindView(R.id.closeSecond)
    public ImageView closeSecond;
    @BindView(R.id.closeThird)
    public ImageView closeThird;
    @BindView(R.id.closeForth)
    public ImageView closeForth;
    @BindView(R.id.closeFifth)
    public ImageView closeFifth;
    @BindView(R.id.closeSixth)
    public ImageView closeSixth;
    @BindView(R.id.closeSeventh)
    public ImageView closeSeventh;
    @BindView(R.id.closeEighth)
    public ImageView closeEighth;
    @BindView(R.id.closeNinth)
    public ImageView closeNinth;

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

    @OnClick({R.id.close,R.id.nextBtnUpload,R.id.uploadFileIdFirst,R.id.uploadFileIdSecond,R.id.uploadFileIdThird,R.id.imageFirst,
            R.id.imageSecond,R.id.imageThird,R.id.imageForth,R.id.imageFifth,R.id.imageSixth,R.id.imageSeventh,R.id.imageEighth,R.id.imageNinth})
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.close :
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpFragment());
                break;
            case R.id.nextBtnUpload :
                //fileSet(fragment.fileUri1,fragment.fileUri2,fragment.fileUri3,fileNameFirstUploaded.getText().toString(),fileNameSecondUploaded.getText().toString(),fileNameThirdUploaded.getText().toString(),view);

                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpCompleteFragment());
                break;
            case R.id.uploadFileIdFirst:
//                getFileFromGallery(101);
                break;
            case R.id.uploadFileIdSecond:
//                getFileFromGallery(102);
                break;
            case R.id.uploadFileIdThird:
//                getFileFromGallery(103);
                break;
            case R.id.imageFirst: getFileFromGallery(101); break;
            case R.id.imageSecond: getFileFromGallery(102); break;
            case R.id.imageThird: getFileFromGallery(103); break;
            case R.id.imageForth: getFileFromGallery(104); break;
            case R.id.imageFifth: getFileFromGallery(105); break;
            case R.id.imageSixth: getFileFromGallery(106); break;
            case R.id.imageSeventh: getFileFromGallery(107); break;
            case R.id.imageEighth: getFileFromGallery(108); break;
            case R.id.imageNinth: getFileFromGallery(109); break;
            case R.id.closeFirst: imageFirst.setImageResource(R.drawable.add_button); closeFirst.setVisibility(GONE); break;
            case R.id.closeSecond: imageSecond.setImageResource(R.drawable.add_button); closeSecond.setVisibility(GONE); break;
            case R.id.closeThird: imageThird.setImageResource(R.drawable.add_button); closeThird.setVisibility(GONE); break;
            case R.id.closeForth: imageForth.setImageResource(R.drawable.add_button); closeForth.setVisibility(GONE); break;
            case R.id.closeFifth: imageFifth.setImageResource(R.drawable.add_button); closeFifth.setVisibility(GONE); break;
            case R.id.closeSixth: imageSixth.setImageResource(R.drawable.add_button); closeSixth.setVisibility(GONE); break;
            case R.id.closeSeventh: imageSeventh.setImageResource(R.drawable.add_button); closeSeventh.setVisibility(GONE); break;
            case R.id.closeEighth: imageEighth.setImageResource(R.drawable.add_button); closeEighth.setVisibility(GONE); break;
            case R.id.closeNinth: imageNinth.setImageResource(R.drawable.add_button); closeNinth.setVisibility(GONE); break;

        }
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
