package com.example.slavick.telephone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Contact> contactList;

    public Adapter(Context context, @NonNull List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Contact getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;
        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
            holder = new ViewHolder(rowView);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        holder.icon.setImageResource(getItem(position).getIcon());
        holder.userName.setText(getItem(position).getName());
        holder.phone.setText(getItem(position).getPhone());
        holder.email.setText(getItem(position).getEmail());
        return rowView;
    }
    static class ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.phone)
        TextView phone;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.address)
        TextView address;
        public ViewHolder(View root) {
            ButterKnife.bind(this, root);
        }
    }


}
