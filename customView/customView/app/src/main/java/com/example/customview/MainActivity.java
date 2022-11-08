package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "딸기", "Box");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "수박", "시원함");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "포도 ", "달다");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "복숭아 ", "달다");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "사과", "달다");
       adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "파인에플 ", "달다");
       adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "천도복숭아 ", "달다");
       adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "석류 ", "달다");
       adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background),
                "망고 ", "달다");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ListView item = (ListViewItem) parent.getItemAtPosition(position);
                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawable = item.getIcon();

            }
        });
    }}

}