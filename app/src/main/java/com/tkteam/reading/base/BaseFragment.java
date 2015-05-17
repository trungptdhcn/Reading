package com.tkteam.reading.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

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
        setRetainInstance(true);
//        if(!EventBus.getDefault().isRegistered(this))
//        {
//            EventBus.getDefault().register(this);
//        }
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null)
        {
            restoreState(savedInstanceState);
        }
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        saveSate(outState);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
//        if (EventBus.getDefault().isRegistered(this))
//        {
//            EventBus.getDefault().unregister(this);
//        }
    }

    public abstract int getLayout();

    public abstract void setupView();

    public void restoreState(Bundle savedInstanceState)
    {

    }

    public void saveSate(Bundle outState)
    {

    }
}
