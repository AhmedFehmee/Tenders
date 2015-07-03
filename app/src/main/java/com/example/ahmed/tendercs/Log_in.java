package com.example.ahmed.tendercs;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Log_in extends Activity {

    Button btnLogin;
    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final SQLiteDatabase db= openOrCreateDatabase("tenderDB", MODE_PRIVATE, null);
        try {
         //   db = openOrCreateDatabase("tenderDB", MODE_PRIVATE, null);

            db.execSQL("CREATE TABLE IF NOT EXISTS users"
                    + " (id integer primary key autoincrement, "
                    + " username varchar unique not null,"
                    + " passwd varchar not null,"
                    + " mail varchar not null,"
                    + " phone integer not null);");
        }catch(Exception e) {
                Log.e("Error", "Error", e);
        }finally {
            if (db != null)
                db.close();
        }

     //   checkUsersNumber();
        initViews();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteDatabase db = openOrCreateDatabase("telebookDB",MODE_PRIVATE, null);

                    String qLogin = "SELECT * FROM users WHERE username = '"
                            + etUsername.getText().toString() + "' AND passwd = '"
                            + etPassword.getText().toString() + "';";

                    Cursor c = db.rawQuery(qLogin, null);

                    if (c.moveToFirst()) {
                        Toast.makeText(getApplicationContext() , "Welcome, " + c.getString(c.getColumnIndex("username")), Toast.LENGTH_LONG).show();

                        Intent goToHome = new Intent(Log_in.this , Home.class);
                        goToHome.putExtra("User Name", etUsername.getText().toString());
                        startActivity(goToHome);
                    //    startActivity(new Intent(Log_in.this , Home.class));
                    } else {
                        etPassword.setText("");
                        Toast.makeText(getApplicationContext() ,"Invalid User Name & Password.!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e) {
                    Log.e("Error", "Error", e);
                }finally {
                    if (db != null)
                        db.close();
                }
            }
        });
    }

    private void initViews() {
        btnLogin = (Button) findViewById(R.id.bt_LogIn2);
        etUsername = (EditText) findViewById(R.id.et_log_name);
        etPassword = (EditText) findViewById(R.id.et_log_pass);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
   /* private void checkUsersNumber() {
        SQLiteDatabase db = openOrCreateDatabase("telebookDB", MODE_PRIVATE , null);

        Cursor c = db.rawQuery("SELECT * FROM users", null);
        int no = c.getCount();

        db.close();

        Toast.makeText(getApplicationContext(), "No: " + no, Toast.LENGTH_LONG).show();
    }*/

/*    private void initEventDriven() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                SQLiteDatabase db = openOrCreateDatabase("telebookDB",MODE_PRIVATE, null);

                String qLogin = "SELECT * FROM users WHERE username = '"
                        + etUsername.getText().toString() + "' AND passwd = '"
                        + etPassword.getText().toString() + "';";

                Cursor c = db.rawQuery(qLogin, null);

                if (c.moveToFirst()) {
                    Toast.makeText(getApplicationContext() , "Welcome, "
                           + c.getString(c.getColumnIndex("full_name")), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Log_in.this , Home.class));
                } else {
                    Toast.makeText(getApplicationContext() ,"Invalid User Name & Password.!", Toast.LENGTH_LONG).show();
                }
                }catch(Exception e) {
                    Log.e("Error", "Error", e);
                }finally {
                    if (db != null)
                        db.close();
                }
                db.close();
            }
        });
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }
}

 /* logIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] userNames = {"ahmed", "alamear", "asmaa", "ahmed eebs", "anas", "mostafa"};
                String[] passwordUsers = {"ahmed123", "alamear123", "asmaa123", "el eebs123", "anas123", "mostafa123"};

                if (userName.getText().toString().isEmpty()) {
                    userName.setError("User name is required !");
                    return;
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("password is required !");
                    return;
                }

                for (int i = 0; i < userNames.length; i++) {
                    if (userName.getText().toString().matches(String.valueOf(userNames[i]))) {
                        if (password.getText().toString().matches(String.valueOf(passwordUsers[i]))) {
                            Toast.makeText(getApplicationContext(), "Welcome  " + userNames[i] + " " , Toast.LENGTH_LONG).show();
                            Intent log_Intent = new Intent(Log_in.this, Home.class);
                            startActivity(log_Intent);
                            break;
                        }else {
                            Toast.makeText(getApplicationContext(), "Invalid password !", Toast.LENGTH_LONG).show();
                            break;
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "Invalid User Name !", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });*/
