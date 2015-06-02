package com.tkteam.reading.dao.entites;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

import java.util.UUID;

/**
 * Created by Trung on 6/2/2015.
 */
public class Base extends BaseDaoEnabled
{
    public static final String ID = "id";
    public static final String CREATEDATE = "createDate";

    @DatabaseField(id = true)
    private UUID id = UUID.randomUUID();
    @DatabaseField
    private Long createDate;

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public Long getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Long createDate)
    {
        this.createDate = createDate;
    }
}
