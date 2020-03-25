package com.lutongbahay.user_auth.fragments.document_upload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.document_upload.mvvm.DocumentUploadView;
import com.lutongbahay.user_auth.fragments.document_upload.mvvm.DocumentUploadViewModel;

public class DocumentUploadFragment extends Fragment {

    private DocumentUploadView view;
    private DocumentUploadViewModel viewModel;
    private Context context;

    public Uri fileUri1,fileUri2,fileUri3;
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
        view = new DocumentUploadView(context,viewModel);
        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 101:
                if (resultCode == -1) {
                    fileUri1 = data.getData();
                    filePath = fileUri1.getPath();
                    view.fileNameFirstUploaded.setText(filePath);
                }
                break;
            case 102:
                if (resultCode == -1) {
                    fileUri2 = data.getData();
                    filePath = fileUri2.getPath();
                    view.fileNameSecondUploaded.setText(filePath);
                }
                break;
            case 103:
                if (resultCode == -1) {
                    fileUri3 = data.getData();
                    filePath = fileUri3.getPath();
                    view.fileNameThirdUploaded.setText(filePath);
                }
                break;
        }
    }

}
