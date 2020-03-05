package com.lutongbahay.user_auth.fragments.document_upload.mvvm;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.lutongbahay.R;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragment;
import com.lutongbahay.user_auth.fragments.document_upload.DocumentUploadFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DocumentUploadView extends FrameLayout {
    private final DocumentUploadViewModel viewModel;
    @BindView(R.id.close)
    ImageButton close;
    @BindView(R.id.uploadFileIdFirst)
    Button uploadFileIdFirst;
    @BindView(R.id.fileNameFirstUploaded)
    TextView fileNameFirstUploaded;
    @BindView(R.id.uploadFileIdSecond)
    Button uploadFileIdSecond;
    @BindView(R.id.fileNameSecondUploaded)
    TextView fileNameSecondUploaded;
    @BindView(R.id.uploadFileIdThird)
    Button uploadFileIdThird;
    @BindView(R.id.fileNameThirdUploaded)
    TextView fileNameThirdUploaded;
    @BindView(R.id.nextBtnUpload)
    Button nextBtnUpload;

    public DocumentUploadView(@NonNull Context context, DocumentUploadViewModel viewModel) {
        super(context);
        this.viewModel = viewModel;
        inflate(context,R.layout.fragment_document_upload,this);
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.close)
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.close :
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpFragment());
                break;
            case R.id.nextBtnUpload :
                Navigation.findNavController(view).navigate(DocumentUploadFragmentDirections.toSignUpCompleteFragment());
                break;
        }
    }

}
