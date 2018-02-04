package com.example.oliver.androidengineerexercise.Model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by olive on 03/02/2018.
 */

public class UserModel extends RealmObject  implements Parcelable{
    public String mName;
    public String mUsername;
    public String mPassword;
    public String mDOB;
    public String mGender;
    public String mAddress;

    public UserModel(){

    }

    public UserModel(String mName, String mUsername, String mPassword, String mDOB, String mGender, String mAddress) {
        this.mName = mName;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mDOB = mDOB;
        this.mGender = mGender;
        this.mAddress = mAddress;
    }

    public String getmName() {
        return mName;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public String getmDOB() {
        return mDOB;
    }

    public String getmGender() {
        return mGender;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public void setmDOB(String mDOB) {
        this.mDOB = mDOB;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    protected UserModel(Parcel in){
        mName = in.readString();
        mUsername = in.readString();
        mPassword = in.readString();
        mDOB = in.readString();
        mGender = in.readString();
        mAddress = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mUsername);
        parcel.writeString(mPassword);
        parcel.writeString(mDOB);
        parcel.writeString(mGender);
        parcel.writeString(mAddress);
    }

}
