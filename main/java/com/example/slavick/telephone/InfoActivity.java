package com.example.slavick.telephone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        contact = getIntent().getParcelableExtra(MainActivity.KEY_NAME);
        address.setText(contact.getAddress());
        email.setText(contact.getEmail());
        name.setText(contact.getName());
        phone.setText(contact.getPhone());
        icon.setImageResource(contact.getIcon());
    }
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.email)
    TextView email;

}
