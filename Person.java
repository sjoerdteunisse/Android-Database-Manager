package axr.sjoerd.peopleapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class Person extends EntityHelper {

    //Entity Types
    public String firstName;
    public String lastName;

    //Database types
    private final String PERSON_TBL_NAME = this.getClass().getSimpleName();
    private final String PERSON_COL_ID = "Id";
    private final String PERSON_COL_FIRSTNAME = "firstName";
    private final String PERSON_COL_LASTNAME = "lastName";

    public Person(Context ctx) {
        super(ctx);

        //Move
        sqLiteDatabase.execSQL(createTable());

    }

    public String createTable() {
        return "CREATE TABLE IF NOT EXISTS " + PERSON_TBL_NAME + " ( " + PERSON_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PERSON_COL_FIRSTNAME + " TEXT , " + PERSON_COL_LASTNAME + " TEXT  )";
    }

    private String dropTable() {
        return "DROP TABLE IF EXISTS " + PERSON_TBL_NAME + ";";
    }

    public boolean addEntity(Person entity) {

        ContentValues cv = new ContentValues();
        cv.put(entity.PERSON_COL_FIRSTNAME, entity.firstName);
        cv.put(entity.PERSON_COL_LASTNAME,entity.lastName);

        return sqLiteDatabase.insert(PERSON_TBL_NAME, null, cv)  > 0;
    }

    public boolean updateEntity(String Id, Person entity) {

        ContentValues cv = new ContentValues();
        cv.put(entity.PERSON_COL_FIRSTNAME, entity.firstName);
        cv.put(entity.PERSON_COL_LASTNAME, entity.lastName);

        return sqLiteDatabase.update(PERSON_TBL_NAME, cv, PERSON_COL_ID + "=" + Id, null) > 0 ;
    }

    @Override
    public boolean deleteEntity(String Id) {
        return  sqLiteDatabase.delete(PERSON_TBL_NAME, PERSON_COL_ID + "=" + Id, null) > 0;
    }

    @Override
    public int getEntityById(String Id) {
        String whereClause = PERSON_COL_FIRSTNAME +" LIKE '%"+Id+"%'";

        Cursor c = sqLiteDatabase.query(true, PERSON_TBL_NAME, null,
                whereClause, null, null, null, null, null);

        if(c.getCount() >0)
            return c.getInt(0);
        else
            return 0;
    }
}
