package axr.sjoerd.peopleapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Type;

public class EntityHelper extends SQLiteOpenHelper {

    protected SQLiteDatabase sqLiteDatabase;

    public EntityHelper(Context ctx)
    {
        super(ctx, "MyFirstThing", null, 2);
        sqLiteDatabase = getWritableDatabase();
    }

    private String createTableScript(){return "";}
    private String dropTableScript(){return ""; }

    public boolean addEntity(Object entity){ return false; };
    public boolean updateEntity(String Id, Object entity){ return false; };
    public boolean deleteEntity(String Id) { return false; };
    public int getEntityById(String Id){ return 0; };



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
