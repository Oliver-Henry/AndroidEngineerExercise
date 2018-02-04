package com.example.oliver.androidengineerexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oliver.androidengineerexercise.MainActivity;
import com.example.oliver.androidengineerexercise.Model.UserModel;
import com.example.oliver.androidengineerexercise.R;
import com.example.oliver.androidengineerexercise.UserDetails;
import com.example.oliver.androidengineerexercise.Util.Constants;


public class CreateAccount extends AppCompatActivity {
    EditText emailText;
    EditText passwordText;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        init();
    }
    public void init(){
        emailText= findViewById(R.id.eTEmail);
        passwordText= findViewById(R.id.eTCrePassword);
        nextButton= findViewById(R.id.btnNext);
    }
    public void previousPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void createAccount(View view){
     //   String test = emailText.getText().toString();
       // String testPassword = passwordText.getText().toString();
       // Toast.makeText(this, test + " " + testPassword, Toast.LENGTH_LONG).show();
        UserModel userModel = new UserModel(" ", emailText.getText().toString(),passwordText.getText().toString(), " "," ", " ");
        Intent intent = new Intent(this, UserDetails.class);
        intent.putExtra(Constants.KEY_USER, userModel);
        startActivity(intent);
    }
}
