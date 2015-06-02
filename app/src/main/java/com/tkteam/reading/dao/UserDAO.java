package com.tkteam.reading.dao;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.tkteam.reading.dao.entites.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Trung on 6/2/2015.
 */
public class UserDAO
{
    private static UserDAO instance;
    Dao<User, UUID> userDao;

    public UserDAO(Context context) throws SQLException
    {
        this.userDao = DatabaseHelper.getInstance(context).getUserDao();
    }

    public static UserDAO getInstance(Context context) throws SQLException
    {
        if (instance == null)
        {
            instance = new UserDAO(context);
        }
        return instance;
    }

    public User create(User user) throws SQLException
    {
        return userDao.createIfNotExists(user);
    }

    public void update(User user) throws SQLException
    {
        userDao.update(user);
    }

    public User findById(UUID id) throws SQLException, IOException
    {
        return userDao.queryForId(id);
    }

    public List<User> findAll() throws SQLException
    {
        return userDao.queryForAll();
    }

    public void createOrUpdate(User user) throws SQLException
    {
        userDao.createOrUpdate(user);
    }
    
    public void delete(User user) throws SQLException
    {
        userDao.delete(user);
    }

}
