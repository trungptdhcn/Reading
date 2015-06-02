package com.tkteam.reading.ui.group;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tkteam.reading.R;
import com.tkteam.reading.dao.entites.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 6/2/2015.
 */
public class UserGroup extends Group
{
    private String userName;
    private String avatarUrl;

    @Override
    public int getLayout()
    {
        return R.layout.user_grid_item;
    }

    @Override
    public void findById(ViewHolder viewHolder, View view)
    {
        ImageView imageView = (ImageView) view.findViewById(R.id.user_grid_item_ivAvatar);
        TextView tvName = (TextView) view.findViewById(R.id.user_grid_item_tvName);
        viewHolder.addView(imageView);
        viewHolder.addView(tvName);
    }

    @Override
    public void setDataToView(ViewHolder viewHolder, View view)
    {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.user_grid_item_ivAvatar);
        TextView tvName = (TextView) viewHolder.getView(R.id.user_grid_item_tvName);
        tvName.setText(userName);
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public static List<UserGroup> convertFromUser(List<User> userList)
    {
        List<UserGroup> userGroups = new ArrayList<>();
        for (User user : userList)
        {
            UserGroup userGroup = new UserGroup();
            userGroup.setUserName(user.getName());
            userGroups.add(userGroup);
        }
        return userGroups;
    }
}
