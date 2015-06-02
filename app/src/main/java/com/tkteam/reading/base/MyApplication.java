package com.tkteam.reading.base;

import android.app.Application;

/**
 * Created by Trung on 6/2/2015.
 */
public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "SERIF", "ClementePDag-Book.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "ClementePDal-SemiBoldItalic.ttf");
    }
}
