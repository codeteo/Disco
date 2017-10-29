package com.disco.man.discogman.domain.features.wantlist;

import com.disco.man.discogman.data.api.WantlistService;
import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.utils.headers.AuthHeader;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.ResponseBody;

/**
 * Concrete implementation for {@link GetWantlistUseCase}.
 */

public class GetWantlistUseCaseImpl implements GetWantlistUseCase {

    private WantlistService wantlistService;
    private BaseSchedulerProvider schedulerProvider;
    private SharedPreferencesManager preferencesManager;

    @Inject
    public GetWantlistUseCaseImpl(WantlistService wantlistService,
                                  BaseSchedulerProvider schedulerProvider, SharedPreferencesManager preferencesManager) {
        this.wantlistService = wantlistService;
        this.schedulerProvider = schedulerProvider;
        this.preferencesManager = preferencesManager;
    }

    @Override
    public Single<ResponseBody> getWantlist(String username, String authHeader) {
        return wantlistService.getWantlist(username, new AuthHeader()
                .createHeaderForAuthToken(preferencesManager.getAccessToken(), preferencesManager.getAccessTokenSecret()))
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }
}
