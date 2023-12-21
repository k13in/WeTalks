package com.klein.wetalks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class ContactDAO {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Context context;

    public ContactDAO(Context context) {
        this.context = context;
        openHelper = new ContactOpenHelper(context, "contact.db", null, 1);
        db = openHelper.getWritableDatabase();
        openHelper.onCreate(db);
    }

    public ArrayList<Contact> getAllContacts() {
        @SuppressLint("Recycle") Cursor cursor = db.query("contact", null, null, null, null, null, null);
        ArrayList<Contact> contacts = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String number = cursor.getString(cursor.getColumnIndex("number"));
                Contact contact = new Contact(name, number);
                contacts.add(contact);
            }
            Log.d("k13in", "数据查询成功");
            return contacts;
        } else {
            Log.d("k13in", "数据查询失败");
            return null;
        }
    }

    public void addContact(Contact contact) {
        String name = contact.getName();
        String number = contact.getNumber();
        db.execSQL("insert into contact (name, number) values (?, ?)", new String[]{name, number});
    }

}
