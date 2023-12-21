package com.klein.wetalks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactOpenHelper extends SQLiteOpenHelper {

    public ContactOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @SuppressLint("Recycle")
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        if (sqLiteDatabase.query("contact", null, null, null, null, null, null) != null) {
            return;
        }
        sqLiteDatabase.execSQL("create table contact (id integer primary key autoincrement, name varchar(20), number varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
