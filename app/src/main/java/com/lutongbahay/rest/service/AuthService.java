package com.lutongbahay.rest.service;


import com.lutongbahay.rest.APiInterface;

/**
 * Created by Abhishek Thanvi on 2020-02-26.
 * Copyright © 2020 Abhishek Thanvi. All rights reserved.
 */

public class AuthService {

    private static final APiInterface apiService =
            BaseService.getAPIClient().create(APiInterface.class);

    public AuthService() {
    }
}
