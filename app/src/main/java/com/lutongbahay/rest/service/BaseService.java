package com.lutongbahay.rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lutongbahay.BuildConfig;
import com.lutongbahay.app.CusinaApplication;
import com.lutongbahay.helper.PreferenceManger;
import com.lutongbahay.rest.HostSelectionInterceptor;
import com.lutongbahay.rest.RestUtils;
import com.waiter.diner.rest.SslUtils;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class BaseService {
    private static Retrofit retrofit;

    public static Retrofit getAPIClient() {
        if (retrofit == null) {
            Builder okHttpClient = null;
            TrustManagerFactory trustManagerFactory;
            try {
                trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                }
                X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
                SSLContext sslContext = null;
                sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new TrustManager[]{trustManager}, null);

                okHttpClient = new OkHttpClient()
                        .newBuilder()
                        .addInterceptor(chain -> {
                            Request request = chain.request().newBuilder().addHeader("x-access" +
                                    "-token", CusinaApplication.getPreferenceManger().getStringValue(PreferenceManger.AUTH_TOKEN))
                                    .build();
                            return chain.proceed(request);
                        })
                        .connectTimeout(5, TimeUnit.MINUTES)
                        .readTimeout(5, TimeUnit.MINUTES)
                        .writeTimeout(5, TimeUnit.MINUTES);

                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);
                okHttpClient.addInterceptor(HostSelectionInterceptor.getSelectionInterceptor());
                okHttpClient.addInterceptor(loggingInterceptor);

                if (SslUtils.INSTANCE.getTrustAllHostsSSLSocketFactory() != null) {
                    okHttpClient.sslSocketFactory(SslUtils.INSTANCE.getTrustAllHostsSSLSocketFactory(), trustManager);
                }

                okHttpClient.sslSocketFactory(SslUtils.INSTANCE.getSslContextForCertificateFile(CusinaApplication.getInstance().getApplicationContext()).getSocketFactory(), trustManager);

            } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
                e.printStackTrace();
            }

            if (okHttpClient == null) {
                retrofit = new Retrofit.Builder().baseUrl(RestUtils.getEndPoint())
                        .addConverterFactory(GsonConverterFactory.create(createGSON()))
                        .build();

            } else {
                retrofit = new Retrofit.Builder().baseUrl(RestUtils.getEndPoint())
                        .client(okHttpClient.build())
                        .addConverterFactory(GsonConverterFactory.create(createGSON()))
                        .build();

            }

        }
        return retrofit;
    }

    private static Gson createGSON() {
        return new GsonBuilder().setLenient().create();
    }

}
