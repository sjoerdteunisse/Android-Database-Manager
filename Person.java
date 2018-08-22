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
import android.util.Pair;

public class Person extends Entity {

    //Entity Types
    public int Id;
    public String firstName;
    public String lastName;

    //Database types
    public static final String PERSON_COL_FIRSTNAME = "firstName";
    public static final String PERSON_COL_LASTNAME = "lastName";

    public Person() {
        TBL_NAME = Person.class.getSimpleName();
    }

    public static String createTable() {
        return "CREATE TABLE " + TBL_NAME + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PERSON_COL_FIRSTNAME + " TEXT , " + PERSON_COL_LASTNAME + " TEXT  )";
    }

    public static String dropTable() {
        return "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    @Override
    public Pair<String, ContentValues> addEntity(Entity entity) {

        ContentValues cv = new ContentValues();

        cv.put(this.PERSON_COL_FIRSTNAME, this.firstName);
        cv.put(this.PERSON_COL_LASTNAME,this.lastName);

        return new Pair<String, ContentValues>(TBL_NAME, cv);
    }

    @Override
    public Pair<String, ContentValues> updateEntity(int Id, Entity  entity) {

        ContentValues cv = new ContentValues();

        cv.put(this.PERSON_COL_FIRSTNAME, this.firstName);
        cv.put(this.PERSON_COL_LASTNAME, this.lastName);

        return new Pair<String, ContentValues>(TBL_NAME, cv);
    }

    @Override
    public Pair<String, String> deleteEntity(int Id) {
        return  new Pair<String, String>(TBL_NAME, COL_ID + " = " + Id);
    }

    @Override
    public String getEntityById(String col, String Id) {
        return col + " LIKE '%"+Id+"%'";
    }
}