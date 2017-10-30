package com.disco.man.discogman.features.main.fragments.wantlist.dagger.components;

import com.disco.man.discogman.features.main.fragments.wantlist.WantlistFragment;
import com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules.WantlistFragmentModule;
import com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules.WantlistModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Dagger Sub component for {@link WantlistFragment}
 */

@Subcomponent(modules = {WantlistModule.class, WantlistFragmentModule.class})
public interface WantlistSubComponent extends AndroidInjector<WantlistFragment> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<WantlistFragment> {}
}
