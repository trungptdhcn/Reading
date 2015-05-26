package com.tkteam.reading.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.tkteam.reading.base.BaseFragment;
import com.tkteam.reading.R;
import com.tkteam.reading.base.event.ChangedFragmentEvent;
import com.tkteam.reading.ui.customview.CustomDialog;
import de.greenrobot.event.EventBus;

/**
 * Created by Trung on 5/14/2015.
 */
public class MenuFragment extends BaseFragment
{
    @InjectView(R.id.menu_fragment_ivManagerUsers)
    ImageView ivManagerUsers;

    @Override
    public int getLayout()
    {
        return R.layout.menu_fragment;
    }

    @Override
    public void setupView()
    {
    }

    @OnClick(R.id.menu_fragment_ivManagerUsers)
    public void clickManagerUsers()
    {
        CustomDialog dialog = new CustomDialog(getActivity(),R.layout.dialog_manager_users,R.style.dialog_anim_style);
        dialog.show();
    }


    @OnClick(R.id.menu_fragment_ivCreatedLesson)
    public void clickCreated()
    {
        EventBus.getDefault().post(new ChangedFragmentEvent(new CreatedFragment()));
    }

    @OnClick(R.id.menu_fragment_ivSetting)
    public void clickSetting()
    {
        CustomDialog dialog = new CustomDialog(getActivity(),R.layout.dialog_setting_app,R.style.dialog_anim_style);
        dialog.show();
    }

    @OnClick(R.id.menu_fragment_ivProsgress)
    public void clickProgress()
    {
        EventBus.getDefault().post(new ChangedFragmentEvent(new ProgressFragment()));
    }

    @OnClick(R.id.menu_fragment_ivStart)
    public void clickStart()
    {
        EventBus.getDefault().post(new ChangedFragmentEvent(new StartFragment()));
    }
}
