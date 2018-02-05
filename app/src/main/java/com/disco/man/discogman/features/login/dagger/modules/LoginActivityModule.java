package com.disco.man.discogman.features.login.dagger.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.disco.man.discogman.domain.login.GetAccessTokenUseCase;
import com.disco.man.discogman.domain.login.GetRequestTokenUseCase;
import com.disco.man.discogman.features.login.LoginActivity;
import com.disco.man.discogman.features.login.LoginViewModel;
import com.disco.man.discogman.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module providing dependencies for {@link LoginActivity}'s ViewModel.
 */

@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel providesLoginViewModel(GetRequestTokenUseCase requestTokenUseCase,
                                          GetAccessTokenUseCase accessTokenUseCase) {
        return new LoginViewModel(requestTokenUseCase, accessTokenUseCase);
    }

    @Provides
    ViewModelProvider.Factory providesLoginViewModelProvider(LoginViewModel loginViewModel) {
        return new ViewModelProviderFactory<>(loginViewModel);
    }

}