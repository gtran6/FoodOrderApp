package com.example.foodorderapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class RestaurantModel implements Parcelable {

    private String name;
    private String address;
    private float delivery_charge;
    private String image;
    private Hours hours;
    private List<Menu> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(float delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    protected RestaurantModel(Parcel in) {
        name = in.readString();
        address = in.readString();
        delivery_charge = in.readFloat();
        image = in.readString();
        menus = in.createTypedArrayList(Menu.CREATOR);
    }

    public static final Creator<RestaurantModel> CREATOR = new Creator<RestaurantModel>() {
        @Override
        public RestaurantModel createFromParcel(Parcel in) {
            return new RestaurantModel(in);
        }

        @Override
        public RestaurantModel[] newArray(int size) {
            return new RestaurantModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeFloat(delivery_charge);
        parcel.writeString(image);
        parcel.writeTypedList(menus);
    }
}
