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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

public class DatabaseManager extends SQLiteOpenHelper {

    protected SQLiteDatabase sqLiteDatabase;

    private static final String dbName = "MyDatabaseName";
    private static final int dbVersion = 2;

    public DatabaseManager(Context ctx) {
        super(ctx, dbName, null, dbVersion);
        sqLiteDatabase = getWritableDatabase();
    }

    public boolean addEntity(Entity entity) {
        Pair<String, ContentValues> pair = entity.addEntity(entity);
        return sqLiteDatabase.insert(pair.first, null, pair.second) > 0;
    }

    public boolean updateEntity(Entity entity, int id) {
        Pair<String, ContentValues> pair = entity.updateEntity(id, entity);
        return sqLiteDatabase.update(pair.first, pair.second, entity.COL_ID + "=" + id, null) > 0;
    }

    public boolean deleteEntity(Entity entity, int id) {
        Pair<String, String> pair = entity.deleteEntity(id);
        return  sqLiteDatabase.delete(pair.first, pair.second, null) > 0;
    }

    public int getEntityById(Entity entity, String col, String searchFor){
        String query = entity.getEntityById(col , searchFor);
        Cursor cursor;

        try {
             cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + entity.TBL_NAME + " "+ col + " WHERE " + query, null); //+ Person.PERSON_TBL_NAME , null);//
        } catch (Exception ex) {
            throw ex;
        }

        if(cursor.moveToNext()) {
            return  cursor.getInt(0);
        }

        //Nothing Found, for now we return 0. This should be changed to a message to top layer.
        return 0;
    }

    //Ability to retrieve all table(s) name(s) from the current application. by it's scheme
    public Cursor getExistingTables()
    {
        return sqLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
    }

    //Create table upon not existing
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {

            sqLiteDatabase.execSQL(Person.createTable());

        }catch (Exception ex) {
            throw ex;
        }

    }

    //Update table with new version number
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{

            sqLiteDatabase.execSQL(Person.dropTable());
            onCreate(sqLiteDatabase);

        }catch (Exception ex) {
            throw ex;
        }
    }

}