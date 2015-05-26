package com.tkteam.reading.ui.customview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Trung on 5/26/2015.
 */
public class CustomDialog extends AlertDialog
{
    public Context context;
    public int layout;

    public CustomDialog(Context context)
    {
        super(context);
    }

    public CustomDialog(Context context,int layout, int styleAnimation)
    {
        super(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = layoutInflater.inflate(layout, null);
        setView(rootView);
        this.getWindow().getAttributes().windowAnimations = styleAnimation;
    }
}
