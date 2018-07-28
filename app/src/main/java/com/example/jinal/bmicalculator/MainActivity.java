package com.example.jinal.bmicalculator;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button register;
    EditText username;
    EditText passwordt;
    String usernamevalue;
    String passwordvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        username= (EditText) findViewById(R.id.username);
        passwordt= (EditText) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                InClassDatabaseHelper helper = new InClassDatabaseHelper(getApplicationContext());
                SQLiteDatabase db = helper.getWritableDatabase();

                String email = "";
                String password = "";
                String id = "";
                boolean incorrectEmail = false;
                boolean incorrectPass = false;
                usernamevalue =  username.getText().toString();
                passwordvalue=  passwordt.getText().toString();

                Log.d("login activity","first: 111");


                Cursor resultSet = db.rawQuery("Select NAME , PASSWORD, ID from "+InClassDatabaseHelper.TABLE_NAME
                        +" where NAME = '" + usernamevalue +"'"
                        ,null);
                resultSet.moveToFirst();
                if (!(usernamevalue.equals("") || passwordvalue.equals(""))){

                if(resultSet.getCount()>0) {
                    email = resultSet.getString(0);
                    password = resultSet.getString(1);
                    id = resultSet.getString(2);
//                    Toast.makeText(getApplicationContext(), "Please Enter Valid Username Password."+email+password,
//                            Toast.LENGTH_LONG).show();
                    Log.d("login activity","userid 11:"+ id);

                }
                if (!email.equalsIgnoreCase("") && email.equals(usernamevalue)) {
                    // Account exists, return true if the password matches.
                    if (!password.equalsIgnoreCase("") && password.equals(passwordvalue)){
                        Intent i = new Intent(getApplicationContext(),ResultActivity.class);
                        i.putExtra("_id", id);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username and Password does not match.",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    incorrectEmail = true;
                }

                }else {
                    Toast.makeText(getApplicationContext(), "Username Password can not be null.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });

    }

    }

