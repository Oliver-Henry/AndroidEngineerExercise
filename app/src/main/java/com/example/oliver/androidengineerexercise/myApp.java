package com.example.oliver.androidengineerexercise;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by olive on 03/02/2018.
 */

public class myApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        configRealm();

    }

    public void configRealm(){
        /**
         *
         */
        Realm.init(getApplicationContext());

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
