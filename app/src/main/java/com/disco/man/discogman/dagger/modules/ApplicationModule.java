package com.disco.man.discogman.dagger.modules;

import android.content.Context;

import com.disco.man.discogman.Constants;
import com.disco.man.discogman.MyApplication;
import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.data.preferences.SharedPreferencesManagerImpl;
import com.disco.man.discogman.utils.BaseUrlInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

/**
 * Dagger Module with application(singleton) scoped dependencies.
 */


@Module
public class ApplicationModule {

    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_DISCOGS_URL);

    @Provides
    @Singleton
    Context providesContext(MyApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferencesManager provideSharedPreferences(Context context) {
        return new SharedPreferencesManagerImpl(context);
    }

    @Provides
    @Singleton
    HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

    @Provides
    @Singleton
    static BaseUrlInterceptor providesBaseUrlInterceptor() {
        return new BaseUrlInterceptor(Constants.BASE_DISCOGS_URL);
    }

}