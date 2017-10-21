package com.disco.man.discogman.features.login;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.disco.man.discogman.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Screen where user will sign in giving username and password.
 * Sign in is mandatory for the user to proceed further to the app.
 */

public class LoginActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(LoginViewModel.class);

        viewModel.getRequestToken()
                .subscribe(stringStringPair -> {
                    startWebActivity(stringStringPair.first);
                });
    }

    private void startWebActivity(String requestToken) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("requestToken", requestToken);
        startActivity(intent);
    }

}
