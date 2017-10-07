package com.disco.man.discogman.features.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.disco.man.discogman.R;

/**
 * Screen where user will sign in giving username and password.
 * Sign in is mandatory for the user to proceed further to the app.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
