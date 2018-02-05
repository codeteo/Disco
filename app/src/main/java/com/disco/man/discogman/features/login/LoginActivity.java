package com.disco.man.discogman.features.login;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.disco.man.discogman.R;
import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.features.main.MainActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


/**
 * Screen where user will sign in giving username and password.
 * Sign in is mandatory for the user to proceed further to the app.
 */

public class LoginActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    public static final int REQUEST_CODE_AUTHORIZE = 0;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    @Inject
    SharedPreferencesManager preferencesManager;

    private LoginViewModel viewModel;

    private String authRequestToken, authRequestSecretToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (preferencesManager.checkIfUserGaveAccess()) {
            startMainActivity();
        } else {

            viewModel = ViewModelProviders.of(this, viewModelProvider)
                    .get(LoginViewModel.class);

            viewModel.getRequestToken()
                    .subscribe(pair -> {
                        authRequestToken = pair.first;
                        authRequestSecretToken = pair.second;
                        startWebActivity(authRequestToken);
                    });

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (requestCode == REQUEST_CODE_AUTHORIZE) {
                viewModel.postAccessToken(data.getData(), authRequestToken, authRequestSecretToken)
                        .subscribe((aBoolean, throwable) -> {

                            if (aBoolean.equals(Boolean.TRUE)) {
                                startMainActivity();
                            } else {
                                showErrorMessage();
                            }

                        });
            }
        }

    }

    private void showErrorMessage() {
        new MaterialDialog.Builder(this)
                .title(getString(R.string.login_error_dialog_title))
                .titleGravity(GravityEnum.CENTER)
                .content(R.string.login_error_dialog_content)
                .canceledOnTouchOutside(true)
                .show();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    private void startWebActivity(String requestToken) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("request_token", requestToken);
        startActivityForResult(intent, REQUEST_CODE_AUTHORIZE);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return null;
    }
}
