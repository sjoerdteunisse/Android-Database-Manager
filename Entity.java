//Copyright (c) 2018 [AXR (Sjoerd Teunisse)]
//
//        Permission is hereby granted, free of charge, to any person obtaining a copy
//        of this software and associated documentation files (the "Software"), to deal
//        in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//        copies of the Software, and to permit persons to whom the Software is
//        furnished to do so, subject to the following conditions:
//
//        The above copyright notice and this permission notice shall be included in
//        all copies or substantial portions of the Software.


package axr.sjoerd.peopleapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.lang.reflect.Type;

public class Entity {

    public static final String COL_ID = "Id";
    public static String TBL_NAME = "";

    public Entity()
    {
    }

    private String createTableScript(){return "";}
    private String dropTableScript(){return ""; }

    public Pair<String, ContentValues> addEntity(Entity entity) { return null; };
    public Pair<String, ContentValues> updateEntity(int Id, Entity entity) { return null; };
    public Pair<String, String> deleteEntity(int Id) { return null; };
    public String getEntityById(String col, String searchFor) { return ""; };
}
