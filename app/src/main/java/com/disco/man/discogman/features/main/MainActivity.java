package com.disco.man.discogman.features.main;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.disco.man.discogman.R;
import com.disco.man.discogman.features.main.fragments.wantlist.WantlistFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import static com.aurelhubert.ahbottomnavigation.AHBottomNavigation.TitleState.ALWAYS_HIDE;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @BindView(R.id.bb_main_bottom_navigation) AHBottomNavigation bottomBar;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupBottomBar();

        bottomBar.setCurrentItem(1);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, WantlistFragment.newInstance())
                .commit();
    }

    private void setupBottomBar() {
        AHBottomNavigationAdapter navigationAdapter =
                new AHBottomNavigationAdapter(this, R.menu.menu_bottom_bar);
        navigationAdapter.setupWithBottomNavigation(bottomBar);

        bottomBar.setDefaultBackgroundColor(getResources().getColor(R.color.bottom_bar_bg));
        bottomBar.setAccentColor(getResources().getColor(R.color.bottom_bar_accent_color));
        bottomBar.setTitleState(ALWAYS_HIDE);
        bottomBar.setForceTint(false);
        bottomBar.setNotificationBackgroundColor(getResources().getColor(R.color.bottom_bar_labels_color));

        bottomBar.setOnTabSelectedListener((position, wasSelected) -> true);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
