package com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules;

import com.disco.man.discogman.features.main.fragments.wantlist.WantlistFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Dagger module provides {@link WantlistFragment}
 */

@Module
public abstract class WantlistFragmentBuilder {

    @ContributesAndroidInjector(modules = WantlistFragmentModule.class)
    abstract WantlistFragment providesWantlistFragment();

}