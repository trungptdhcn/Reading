package com.tkteam.reading.service;

import android.content.Context;
import com.tkteam.reading.dao.UserDAO;
import com.tkteam.reading.dao.entites.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Trung on 6/2/2015.
 */
public class UserService
{
    public static UserService instance;
    private Context context;

    public UserService(Context context)
    {
        this.context = context;

    }

    public static UserService getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new UserService(context);
        }
        return instance;
    }
    public User create(User user) throws SQLException
    {
        return UserDAO.getInstance(context).create(user);
    }

    public User findById(UUID id) throws SQLException, IOException
    {
        return UserDAO.getInstance(context).findById(id);
    }

    public List<User> findAll() throws SQLException
    {
        return UserDAO.getInstance(context).findAll();
    }

    public void update(User profileEntity) throws SQLException
    {
        UserDAO.getInstance(context).update(profileEntity);
    }

    public void delete(User user) throws SQLException, IOException
    {
        UserDAO.getInstance(context).delete(user);
    }

    public void createOrUpdate(User user) throws SQLException
    {
        UserDAO.getInstance(context).createOrUpdate(user);
    }
}
