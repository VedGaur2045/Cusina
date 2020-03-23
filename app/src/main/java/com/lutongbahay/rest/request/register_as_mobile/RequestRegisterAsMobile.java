
package com.lutongbahay.rest.request.register_as_mobile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestRegisterAsMobile {

    @SerializedName("mobile")
    @Expose
    private String mobile;

    public RequestRegisterAsMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
