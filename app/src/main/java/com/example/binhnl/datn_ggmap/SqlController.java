package com.example.binhnl.datn_ggmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binhnl on 11/03/2018.
 */

public class SqlController extends SQLiteOpenHelper {
    public static final String DATA_BASE_NAME = "contactsManager";
    public static final int VERSION = 1;
    public static final String SETTING = "setting";

    public static final String ID = "id";
    public static final String KEY = "key";
    public static final String VALUE = "value";

    public SqlController(Context context) {
        super(context, DATA_BASE_NAME, null, VERSION);
        //Log.d("BinhLN ", "success");
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String query = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT UNIQUE, %s TEXT)", DATA_BASE_NAME, ID, KEY, VALUE);
        String query = "CREATE TABLE IF NOT EXISTS " + SETTING + "("
                + ID + " INTEGER PRIMARY KEY,"
                + KEY + " TEXT,"
                + VALUE + " TEXT" + ")";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // sqLiteDatabase.execSQL("Drop table if EXISTS " + SETTING);
    }

    public boolean insert (String key, String value) {
        SQLiteDatabase db = getWritableDatabase();
//        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY, key);
        contentValues.put(VALUE, value);
        db.insert(SETTING, null, contentValues);
        return true;
    }

    public List<String> selectData(String key, String table, int order) {
        List<String> listString = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cu = db.rawQuery("SELECT * FROM " + table + " WHERE " + KEY + " =? ", new String[]{key});
                if (cu.moveToFirst()) {
            while ( !cu.isAfterLast() ) {
                //Toast.makeText(this, "Table Name=> "+cu.getString(2), Toast.LENGTH_LONG).show();
                listString.add(cu.getString(order));
                cu.moveToNext();
            }
        }
        return listString;
    }

    public boolean update
}
