package com.example.slavick.telephone;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private String address;
    private String name;
    private String phone;
    private int icon;
    private String email;

    public Contact(String name, String phone, int icon, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.icon = icon;
        this.email = email;
        this.address = address;
    }

    protected Contact(Parcel in) {
        address = in.readString();
        name = in.readString();
        phone = in.readString();
        icon = in.readInt();
        email = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeInt(icon);
        dest.writeString(email);
    }
}
