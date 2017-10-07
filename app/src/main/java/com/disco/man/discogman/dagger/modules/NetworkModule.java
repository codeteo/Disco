package com.disco.man.discogman.dagger.modules;


import com.disco.man.discogman.utils.BaseUrlInterceptor;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;
import com.disco.man.discogman.utils.schedulers.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Module with network dependencies.
 */

@Module()
public class NetworkModule {

    private static final int CONNECTION_TIMEOUT = 15;

    public NetworkModule() {
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(BaseUrlInterceptor baseUrlInterceptor) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.retryOnConnectionFailure(true);
        client.addInterceptor(interceptor);
        client.addInterceptor(baseUrlInterceptor);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        return client.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(HttpUrl baseUrl, OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    BaseSchedulerProvider baseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

}