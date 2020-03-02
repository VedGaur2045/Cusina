package com.lutongbahay.interfaces;

import okhttp3.MultipartBody;

/**
 * Created by Abhishek Thanvi on 2020-02-25.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public interface OnImageCompressedListener {
    void OnImageCompressed(MultipartBody.Part part);
}
