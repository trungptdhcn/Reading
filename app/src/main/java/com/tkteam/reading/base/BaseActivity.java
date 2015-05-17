package com.tkteam.reading.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.tkteam.reading.R;
import com.tkteam.reading.base.event.ChangedFragmentEvent;
import com.tkteam.reading.ui.fragment.MenuFragment;
import de.greenrobot.event.EventBus;


public class BaseActivity<T> extends FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().register(this);
        }
        MenuFragment menuFragment = new MenuFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.container, menuFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onEventMainThread(ChangedFragmentEvent event)
    {
        BaseFragment baseFragment = event.getBaseFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter,0);
        fragmentTransaction.replace(R.id.container, baseFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().unregister(this);
        }

    }

}
