package com.disco.man.discogman.features.main.fragments.wantlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.disco.man.discogman.R;

/**
 * Wantlist screen.
 */

public class WantlistFragment extends android.support.v4.app.Fragment {

    public static WantlistFragment newInstance() {

        Bundle args = new Bundle();

        WantlistFragment fragment = new WantlistFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wantlist, container, false);

        return view;
    }
}
