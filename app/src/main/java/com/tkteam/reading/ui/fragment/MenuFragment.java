package com.tkteam.reading.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.tkteam.reading.base.BaseFragment;
import com.tkteam.reading.R;
import com.tkteam.reading.base.event.ChangedFragmentEvent;
import com.tkteam.reading.service.UserService;
import com.tkteam.reading.ui.adapter.CommonAdapter;
import com.tkteam.reading.ui.customview.CustomDialog;
import com.tkteam.reading.ui.group.UserGroup;
import de.greenrobot.event.EventBus;

import java.sql.SQLException;
import java.util.List;

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
        GridView gridView = (GridView)dialog.getRootView().findViewById(R.id.dialog_manager_users_gridViewUser);
        ImageView ivAddUser = (ImageView)dialog.getRootView().findViewById(R.id.dialog_manager_users_btAddUser);
        try
        {
            List<UserGroup> userGroupList = UserGroup.convertFromUser(UserService.getInstance(getActivity()).findAll());
            CommonAdapter commonAdapter = new CommonAdapter(getActivity(), userGroupList);
            gridView.setAdapter(commonAdapter);
        }
        catch (SQLException e)
        {
            Log.e(this.getClass().toString(),"Error when get from database");
        }
        ivAddUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CustomDialog dialog = new CustomDialog(getActivity(),R.layout.dialog_add_new_user,R.style.dialog_anim_style);
                dialog.show();
            }
        });
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
