package com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules;

import android.support.v4.app.Fragment;

import com.disco.man.discogman.features.main.fragments.wantlist.WantlistFragment;
import com.disco.man.discogman.features.main.fragments.wantlist.dagger.components.WantlistSubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = WantlistSubComponent.class)
public abstract class WantlistFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(WantlistFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindWantlistFragmentInjectorFactory(WantlistSubComponent.Builder builder);

}