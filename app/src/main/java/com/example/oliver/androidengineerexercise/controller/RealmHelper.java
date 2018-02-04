package com.example.oliver.androidengineerexercise.controller;

import com.example.oliver.androidengineerexercise.Model.UserModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by olive on 03/02/2018.
 */

public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void saveUser(final UserModel userModel){

        //Async

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(userModel);
            }
        });
    }

    public ArrayList<UserModel> getUsers(){

        ArrayList<UserModel> userModelArrayList = new ArrayList<>();

        RealmResults<UserModel> realmResults= realm.where(UserModel.class).findAll();

        for(UserModel userModel: realmResults){
            userModelArrayList.add(userModel);
        }
        return userModelArrayList;
    }
}
