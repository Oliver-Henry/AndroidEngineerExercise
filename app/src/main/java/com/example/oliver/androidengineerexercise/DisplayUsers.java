package com.example.oliver.androidengineerexercise;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.oliver.androidengineerexercise.Model.UserModel;
import com.example.oliver.androidengineerexercise.controller.RealmHelper;

import java.util.ArrayList;

import io.realm.Realm;

public class DisplayUsers extends ListActivity {
    private Realm realm;
    private RealmHelper realmHelper;
    private ArrayList<UserModel> arrayList;
    ArrayList<String> stringArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_users);

        realm= Realm.getDefaultInstance();
        realmHelper= new RealmHelper(realm);

        arrayList= new ArrayList<>();
        arrayList= realmHelper.getUsers();

        stringArrayList= new ArrayList<>();

        for(int i=0; i< arrayList.size(); i++ ){

            stringArrayList.add(arrayList.get(i).getmName());
            stringArrayList.add(arrayList.get(i).getmUsername());
            stringArrayList.add(arrayList.get(i).getmPassword());
            stringArrayList.add(arrayList.get(i).getmDOB());
            stringArrayList.add(arrayList.get(i).getmGender());
            stringArrayList.add(arrayList.get(i).getmAddress());
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(
                DisplayUsers.this,

                android.R.layout.simple_list_item_1,
                stringArrayList);


        getListView().setAdapter(arrayAdapter);

    }
}
