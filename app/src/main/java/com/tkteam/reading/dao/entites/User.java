package com.tkteam.reading.dao.entites;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Trung on 6/2/2015.
 */
@DatabaseTable(tableName = User.TABLE_NAME)
public class User extends Base
{
    public static final String TABLE_NAME = "user";
    public static final String AVATAR_URL = "avatarUrl";

    @DatabaseField
    private String name;
    @DatabaseField
    private boolean isCurrentUser = false;
    @DatabaseField
    private String avatarUrl;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public boolean isCurrentUser()
    {
        return isCurrentUser;
    }

    public void setCurrentUser(boolean isCurrentUser)
    {
        this.isCurrentUser = isCurrentUser;
    }
}
