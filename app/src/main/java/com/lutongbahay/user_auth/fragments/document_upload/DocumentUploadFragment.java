package com.lutongbahay.user_auth.fragments.document_upload;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
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
}
