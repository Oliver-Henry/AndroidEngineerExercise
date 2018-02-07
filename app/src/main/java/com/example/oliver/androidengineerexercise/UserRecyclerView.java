package com.example.oliver.androidengineerexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.oliver.androidengineerexercise.Model.UserModel;
import com.example.oliver.androidengineerexercise.controller.RealmHelper;

import java.util.ArrayList;

import io.realm.Realm;

public class UserRecyclerView extends AppCompatActivity {
    private Realm realm;
    private RealmHelper realmHelper;
    private ArrayList<UserModel> arrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recycler_view);
        initRealm();
        initRecyclerView();
    }

    public void initRealm() {
        realm = Realm.getDefaultInstance();
        realmHelper = new RealmHelper(realm);

        arrayList = new ArrayList<>();
        arrayList = realmHelper.getUsers();
    }

    public void initRecyclerView(){
        recyclerView = findViewById(R.id.rVUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), R.layout.row_user, arrayList));
    }
}
