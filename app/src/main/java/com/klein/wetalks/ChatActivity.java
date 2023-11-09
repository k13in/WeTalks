package com.klein.wetalks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // 获取传递的额外信息
        String sender = getIntent().getStringExtra("sender");
        String content = getIntent().getStringExtra("content");
        String timestamp = getIntent().getStringExtra("timestamp");

        // 使用这些信息更新UI，例如设置标题或显示消息内容
        TextView senderTextView = findViewById(R.id.textViewForName);
        senderTextView.setText(sender);
    }
}