package com.example.ahmed.tendercs;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Join_Us extends ActionBarActivity {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "\\d{3}\\d{7}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join__us);

        Button create = (Button) findViewById(R.id.btn_Create_account);
        final EditText name = (EditText) findViewById(R.id.et_Name);
        final EditText mail = (EditText) findViewById(R.id.et_mail);
        final EditText pass = (EditText) findViewById(R.id.et_pass);
        final EditText conf_pass = (EditText) findViewById(R.id.et_Con_pass);
        final EditText phone = (EditText) findViewById(R.id.et_phone);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = null;
               /* if (name.getText().toString().length() != 0
                        && mail.getText().toString().length() != 0
                        && pass.getText().toString().length() != 0
                        && pass.getText().toString().equals(conf_pass.getText().toString())) {
                        */
                if (name.getText().toString().isEmpty()) {
                    name.setError("name is required !");

                } else if (mail.getText().toString().isEmpty()) {
                    mail.setError("mail is required !");

                } else if (!mail.getText().toString().matches(EMAIL_PATTERN)) {
                    mail.setError("invalid mail !");

                } else if (pass.getText().toString().isEmpty() || conf_pass.getText().toString().isEmpty()) {
                    pass.setError("pass is required !");
                    conf_pass.setError("conf pass is required !");

                } else if (!conf_pass.getText().toString().equals(pass.getText().toString())) {
                    pass.setText("");
                    conf_pass.setText("");
                    conf_pass.setError("password doesn't match !");

                } else if (phone.getText().toString().isEmpty()) {
                    phone.setError("phone is required !");

                } else if (phone.getText().toString().matches(PHONE_REGEX)) {
                    phone.setError("invalid phone !");

                   // Intent cat1 = new Intent(Join_Us.this, Home.class);
                   // startActivity(cat1);
                } else {
                    try {
                        db = openOrCreateDatabase("telebookDB", MODE_PRIVATE, null);

                        db.execSQL("INSERT INTO users(username, passwd , mail , phone ) VALUES('"
                                + name.getText().toString()
                                + "', '"
                                + pass.getText().toString()
                                + "', '"
                                + mail.getText().toString()
                                + "', '"
                                + phone.getText().toString() + "');");
                    } catch (Exception e) {
                        Log.e("Error", "Error", e);
                    } finally {
                        if (db != null)
                            db.close();
                        Toast.makeText(getApplicationContext()," Congratulations  "+name.getText().toString(),Toast.LENGTH_SHORT).show();
                        // redirection..!
                        Intent goToHome = new Intent(Join_Us.this , Home.class);
                        goToHome.putExtra("User Name", name.getText().toString());
                        startActivity(goToHome);
                    }

                }
            }
        });
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        finish();
    }
}

