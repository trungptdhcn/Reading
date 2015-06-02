package com.tkteam.reading.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tkteam.reading.dao.entites.User;

import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by trungpt on 3/31/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
    public static String DATABASE_NAME = "ATA.db";
    private static final int DATABASE_VERSION = 1;

    private Context context;
    private Dao<User, UUID> userDao;
    private static DatabaseHelper instance;


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static DatabaseHelper getInstance(Context ctx)
    {
        if (instance == null)
        {
            instance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return instance;
    }

    public Dao<User, UUID> getUserDao() throws SQLException
    {
        if (userDao == null)
        {
            userDao = getDao(User.class);
            ((BaseDaoImpl) userDao).initialize();
        }
        return userDao;
    }

// -------------------------- OTHER METHODS --------------------------

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource)
    {
        try
        {
            TableUtils.createTable(connectionSource, User.class);
        }
        catch (SQLException e)
        {
            Log.e(this.getClass().getName(), e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion,
                          int newVersion)
    {
        try
        {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.createTable(connectionSource, User.class);

        }
        catch (SQLException e)
        {
        }
    }

    public void dropAllDatabase() throws SQLException
    {
        TableUtils.dropTable(connectionSource, User.class, true);

    }

    public void createTables() throws SQLException
    {
        TableUtils.createTable(connectionSource, User.class);
    }
}
