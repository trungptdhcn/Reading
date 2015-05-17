package com.tkteam.reading.base;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by Trung on 5/14/2015.
 */
public abstract class BaseFragment extends Fragment
{
    protected View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.inject(this, rootView);
        setupView();
        return rootView;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }
    public abstract int getLayout();
    public abstract void setupView();
}
