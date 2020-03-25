package com.lutongbahay.user_auth.fragments.document_upload.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.rest.response.ResponseDocument;
import com.lutongbahay.rest.service.MainService;

import okhttp3.MultipartBody;

public class DocumentUploadViewModel extends ViewModel {
    public DocumentUploadViewModel() {
    }
    public LiveData<ResponseDocument> documentUpload(Context context, RequestDocumentUpload documentUpload, MultipartBody.Part file1, MultipartBody.Part file2, MultipartBody.Part file3){
        return MainService.documentUpload(context,documentUpload,file1,file2,file3);
    }
}
