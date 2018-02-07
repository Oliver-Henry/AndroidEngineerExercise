package com.example.oliver.androidengineerexercise;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;
import com.example.oliver.androidengineerexercise.Model.UserModel;
import com.example.oliver.androidengineerexercise.Util.Constants;
import com.example.oliver.androidengineerexercise.controller.RealmBackupRestore;
import com.example.oliver.androidengineerexercise.controller.RealmHelper;


import io.realm.Realm;

public class UserDetails extends AppCompatActivity implements DatePickerDialogFragment.DatePickerDialogHandler {
    EditText nameText;
    EditText emailText;
    EditText passwordText;
    EditText ageText;
    EditText genderText;
    Spinner addressText;
    Button saveButton;
    Button DOBButton;
    String username;
    String password;

    Realm realm;
    RealmHelper realmHelper;
    RealmBackupRestore realmBackupRestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        init();
        initRealm();
        UserModel userModel= getIntent().getParcelableExtra(Constants.KEY_USER);
        username = userModel.mUsername;
        password = userModel.mPassword;
        emailText.setText(username);
        passwordText.setText(password);

        realmBackupRestore = new RealmBackupRestore( this);

        DOBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                dpb.show();
            }
        });

    }

    @Override
    public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
        ageText.setText( dayOfMonth + "-" + monthOfYear  + "-" + year);
    }


    public void init(){
        nameText= findViewById(R.id.eTName);
        emailText= findViewById(R.id.eTUsername);
        passwordText= findViewById(R.id.eTPassword);
        ageText= findViewById(R.id.eTAge);
        genderText= findViewById(R.id.eTGender);
        addressText= findViewById(R.id.spnAddress);
        saveButton= findViewById(R.id.btnSave);
        DOBButton= findViewById(R.id.btnDOB);
    }

    public void initRealm(){
        realm= Realm.getDefaultInstance();
        realmHelper= new RealmHelper(realm);

    }

    public void changePhoto(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            //startActivityForResult(intent);
            startActivity(intent);
        }
    }



    public void saveData(View view){
        UserModel userModel = new UserModel(nameText.getText().toString(), emailText.getText().toString(), passwordText.getText().toString(), ageText.getText().toString(), genderText.getText().toString(), addressText.getSelectedItem().toString());
        realmHelper.saveUser(userModel);

        realmBackupRestore.backup();

        //Intent intent = new Intent(UserDetails.this, DisplayUsers.class);
        Intent intent = new Intent(UserDetails.this, UserRecyclerView.class);
        startActivity(intent);
    }

        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.rBFemale:
                    if (checked)
                        genderText.setText("Female");
                        break;
                case R.id.rBMale:
                    if (checked)
                        genderText.setText("Male");
                        break;
                case R.id.rBNotSpeci:
                    if (checked)
                        genderText.setText("Not Specified");
                        break;
            }
        }

}
