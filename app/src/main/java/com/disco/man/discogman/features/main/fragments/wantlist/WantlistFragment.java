package com.disco.man.discogman.features.main.fragments.wantlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.disco.man.discogman.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * Wantlist screen.
 */

public class WantlistFragment extends Fragment {

    @BindView(R.id.rv_wantlist_list) RecyclerView recyclerView;

/*
    @Inject
    ViewModelProvider.Factory viewModelFactory;
*/

    private WantlistViewModel wantlistViewModel;

    public static WantlistFragment newInstance() {

        Bundle args = new Bundle();

        WantlistFragment fragment = new WantlistFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wantlist, container, false);
        ButterKnife.bind(this, view);

//        wantlistViewModel = ViewModelProviders.of(this, viewModelFactory).get(WantlistViewModel.class);

        return view;
    }
}
