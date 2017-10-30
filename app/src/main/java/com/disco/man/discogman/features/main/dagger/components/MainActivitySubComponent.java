package com.disco.man.discogman.features.main.dagger.components;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.features.main.MainActivity;
import com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules.WantlistFragmentModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Dagger SubComponent for {@link MainActivity}
 */

@ActivityScope
@Subcomponent(modules = {WantlistFragmentModule.class})
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder()
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

}