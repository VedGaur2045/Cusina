package com.lutongbahay.user_auth.fragments.document_upload.mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lutongbahay.rest.request.RequestDocumentUpload;
import com.lutongbahay.rest.response.ResponseDocument;
import com.lutongbahay.rest.service.MainService;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Part;

public class DocumentUploadViewModel extends ViewModel {
    public DocumentUploadViewModel() {
    }
//    public LiveData<ResponseDocument> documentUpload(Context context, RequestDocumentUpload documentUpload, MultipartBody.Part file1, MultipartBody.Part file2, MultipartBody.Part file3){
//        return MainService.documentUpload(context,documentUpload,file1,file2,file3);
//    }

    public LiveData<ResponseDocument> documentUpload(Context context, RequestDocumentUpload documentUpload, List<MultipartBody.Part> files){
        return MainService.documentUpload(context, documentUpload, files);
    }
}
