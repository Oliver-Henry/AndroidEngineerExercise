package com.example.oliver.androidengineerexercise;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oliver.androidengineerexercise.Model.UserModel;

import java.util.ArrayList;

/**
 * Created by olive on 05/02/2018.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context applicationContext;
    private int row_user;
    private ArrayList<UserModel> arrayList;

    public UserAdapter(Context applicationContext, int row_user, ArrayList<UserModel> arrayList) {
        this.applicationContext = applicationContext;
        this.row_user = row_user;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_user, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mName.setText(arrayList.get(position).getmName());
        holder.mUsername.setText(arrayList.get(position).getmUsername());
        holder.mPassword.setText(arrayList.get(position).getmPassword());
        holder.mAge.setText(arrayList.get(position).getmDOB());
        holder.mGender.setText(arrayList.get(position).getmGender());
        holder.mAddress.setText(arrayList.get(position).getmAddress());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mName, mUsername, mPassword, mAge, mGender, mAddress;
       // private ItemClickListener itemClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName= itemView.findViewById(R.id.tVName);
            mUsername= itemView.findViewById(R.id.tVUsername);
            mPassword= itemView.findViewById(R.id.tVPassword);
            mAge= itemView.findViewById(R.id.tVAge);
            mGender= itemView.findViewById(R.id.tVGender);
            mAddress= itemView.findViewById(R.id.tVAddress);
        }


    }
}
