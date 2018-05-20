package com.example.slavick.telephone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    Contact contact;
    public static final String KEY_NAME = "Vasyan";

    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new Adapter(this, generateUsers());
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new Adapter(this, generateUsers()));
    }

    @OnItemClick(R.id.list)
    public void onItemClick(int position) {
        contact = new Contact(adapter.getItem(position).getName(), adapter.getItem(position).getPhone(), adapter.getItem(position).getIcon(), adapter.getItem(position).getEmail(),adapter.getItem(position).getAddress());
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(KEY_NAME, contact);
    }
    public List<Contact> generateUsers() {
        List<Contact> list = new ArrayList<>();
        for (int i = 0; i< 20; i++){
            list.add(new Contact("Vadim" + i, "+ 38(050) 26354589", R.mipmap.ic_launcher, "andrysha" + i*2 + "@gmail.com", "natalii uzhviy" + i*2));
        }
        return list;
    }

}