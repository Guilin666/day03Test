package bwie.example.com.day03test.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Sqlutils {

    private SQLiteDatabase db;

    public Sqlutils(Context context) {
        SqlHelper helper = new SqlHelper(context);
        db = helper.getWritableDatabase();
    }



    public long insert(String data) {
        ContentValues values = new ContentValues();
        values.put("data", data);
        return db.insert("bwie", null, values);
    }



    public String select() {
        String dd = "";
        Cursor cursor = db.rawQuery("select data from bwie", null);
        while (cursor.moveToNext()) {
            String data = cursor.getString(cursor.getColumnIndex("data"));
            dd = data;
        }
        return dd;
    }


}
