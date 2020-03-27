package com.lutongbahay.user_auth.fragments.document_upload;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.document_upload.mvvm.DocumentUploadView;
import com.lutongbahay.user_auth.fragments.document_upload.mvvm.DocumentUploadViewModel;
import com.lutongbahay.utils.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class DocumentUploadFragment extends Fragment {

    private DocumentUploadView view;
    private DocumentUploadViewModel viewModel;
    private Context context;

    public Uri fileUri1,fileUri2,fileUri3,fileUri4,fileUri5,fileUri6,fileUri7,fileUri8,fileUri9;
    private String filePath;
    private AppCompatActivity compatActivity;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        compatActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(DocumentUploadViewModel.class);
        ArrayList<String> imageArrList = new ArrayList<>();
        imageArrList.add(Arrays.toString(getArguments().getStringArray("photoList")));
        try {
            view = new DocumentUploadView(context,viewModel,imageArrList);
        } catch (Exception e){
            Logger.ErrorLog("Exception : ",e.getMessage());
        }

        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 101:
                if (resultCode == -1) {
                    fileUri1 = data.getData();
//                    view.imageFirst.setImageURI(fileUri1);
//                    view.closeFirst.setVisibility(View.VISIBLE);
//                    InputStream imageStream = getImageFromGallery(fileUri1);
//                    System.out.println("Path : "+imageStream);
//                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
//                    String[] filePathColumn = { MediaStore.Images.Media.DATA };
//
//                    Cursor cursor = compatActivity.getContentResolver().query(fileUri1,
//                            filePathColumn, null, null, null);
//                    cursor.moveToFirst();
//
//                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                    String picturePath = cursor.getString(columnIndex);
//                    cursor.close();
//
//                    System.out.println("Image : "+picturePath+"   "+BitmapFactory.decodeFile(picturePath));
//                    view.imageFirst.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
                break;
            case 102:
                if (resultCode == -1) {
                    fileUri2 = data.getData();
//                    view.imageSecond.setImageURI(fileUri2);
//                    view.closeSecond.setVisibility(View.VISIBLE);
                }
                break;
            case 103:
                if (resultCode == -1) {
                    fileUri3 = data.getData();
//                    view.imageThird.setImageURI(fileUri3);
//                    view.closeThird.setVisibility(View.VISIBLE);
                }
                break;
            case 104:
                if (resultCode == -1) {
                    fileUri4 = data.getData();
//                    view.imageForth.setImageURI(fileUri4);
//                    view.closeForth.setVisibility(View.VISIBLE);
                }
                break;
            case 105:
                if (resultCode == -1) {
                    fileUri5 = data.getData();
//                    view.imageFifth.setImageURI(fileUri5);
//                    view.closeFifth.setVisibility(View.VISIBLE);
                }
                break;
            case 106:
                if (resultCode == -1) {
                    fileUri6 = data.getData();
//                    view.imageSixth.setImageURI(fileUri6);
//                    view.closeSixth.setVisibility(View.VISIBLE);
                }
                break;
            case 107:
                if (resultCode == -1) {
                    fileUri7 = data.getData();
//                    view.imageSeventh.setImageURI(fileUri7);
//                    view.closeSeventh.setVisibility(View.VISIBLE);
                }
                break;
            case 108:
                if (resultCode == -1) {
                    fileUri8 = data.getData();
//                    view.imageEighth.setImageURI(fileUri8);
//                    view.closeEighth.setVisibility(View.VISIBLE);
                }
                break;
            case 109:
                if (resultCode == -1) {
                    fileUri9 = data.getData();
//                    view.imageNinth.setImageURI(fileUri9);
//                    view.closeNinth.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    private InputStream getImageFromGallery(Uri fileUri) {
        InputStream imageStream = null;
        try {
            imageStream = compatActivity.getContentResolver().openInputStream(fileUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageStream;
    }

}
