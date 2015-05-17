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
import com.tkteam.reading.ui.fragment.MenuFragment;


public class BaseActivity extends FragmentActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuFragment menuFragment = new MenuFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.container, menuFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
