package com.klein.wetalks;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MessageDAO {
    
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Context context;

    public MessageDAO(Context context) {
        this.context = context;
        openHelper = new MessageOpenHelper(context, "message.db", null, 1);
        db = openHelper.getWritableDatabase();
        openHelper.onCreate(db);
        // 插入测试数据
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("sender", "小明");
        contentValues1.put("content", "你好");
        contentValues1.put("timestamp", "2023-12-11 23:59:59");
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("sender", "小刚");
        contentValues2.put("content", "Hello");
        contentValues2.put("timestamp", "2023-12-21 13:51:29");
        db.insert("message", null, contentValues1);
        db.insert("message", null, contentValues2);
    }

    public ArrayList<Message> getAllMessages() {
        @SuppressLint("Recycle") Cursor cursor = db.query("message", null, null, null, null, null, null);
        ArrayList<Message> messages = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String sender = cursor.getString(cursor.getColumnIndex("sender"));
                @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
                @SuppressLint("Range") String timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));
                Message message = new Message(sender, content, timestamp);
                messages.add(message);
            }
            Log.d("k13in", "数据查询成功");
            return messages;
        } else {
            Log.d("k13in", "数据查询失败");
            return null;
        }
    }
}
