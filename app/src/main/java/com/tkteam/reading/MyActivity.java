package com.tkteam.reading;

import android.os.Bundle;
import android.util.Log;
import com.tkteam.reading.base.BaseActivity;
import com.tkteam.reading.dao.entites.Base;
import com.tkteam.reading.dao.entites.User;
import com.tkteam.reading.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Trung on 6/2/2015.
 */
public class MyActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        try
        {
            List<User> userList = UserService.getInstance(this).findAll();
            if (userList == null || userList.size() == 0)
            {
                User user = new User();
                user.setCurrentUser(true);
                user.setName("Current User");
                UserService.getInstance(this).createOrUpdate(user);
            }
        }
        catch (SQLException e)
        {
            Log.e(this.getClass().toString(), "Error when create database");
        }
    }
}
