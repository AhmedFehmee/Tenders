package com.example.ahmed.tendercs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db=null;
        try{
        db = openOrCreateDatabase("telebookDB",MODE_PRIVATE, null);

        String dropSQL = "DROP TABLE IF EXISTS users" +  ";";
        db.execSQL(dropSQL);

        db.execSQL("CREATE TABLE IF NOT EXISTS users"
                + " (id integer primary key autoincrement, "
                + " username varchar unique not null,"
                + " passwd varchar not null,"
                + " mail varchar not null,"
                + " phone integer not null);");

            String insertSQL = "INSERT INTO users" + " (id ,username, passwd,mail,phone) " +
                    " SELECT '1' AS id, 'ahmed' AS username ,'aaa' AS passwd ,'ahmed@a.com' AS mail , '01125962401' AS phone" +
                    " UNION SELECT '2','anas' ,'aaa' , 'anas@a.com' , '0123456789'" +
                    " UNION SELECT '3','alamear' ,'aaa' , 'anas@a.com' , '0123456789'" +
                    " UNION SELECT '4','asmaa' ,'aaa' , 'anas@a.com' , '0123456789' ;" ;
            db.execSQL(insertSQL);
    }catch(Exception e) {
        Log.e("Error", "Error", e);
    }finally {
        if (db != null)
            db.close();
    }
        Button log_in = (Button)findViewById(R.id.bt_logIn);
        Button join_us = (Button)findViewById(R.id.bt_Join);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log_Intent = new Intent(Main.this , Log_in.class);
                startActivity(log_Intent);
            }
        });

        join_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent join_Intent = new Intent(Main.this , Join_Us.class);
                startActivity(join_Intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
