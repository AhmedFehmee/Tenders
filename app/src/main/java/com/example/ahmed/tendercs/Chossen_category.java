package com.example.ahmed.tendercs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Chossen_category extends ActionBarActivity {

    EditText cat;
    Button show , show2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chossen_category);

        show2 = (Button) findViewById(R.id.bt_show2);
        show = (Button) findViewById(R.id.bt_show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent goToCategories = new Intent(Chossen_category.this , Categories.class);
                    goToCategories.putExtra("Category Name","ترع و مصارف");
                    startActivity(goToCategories);

            }
        });
        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCategories = new Intent(Chossen_category.this , Categories.class);
                goToCategories.putExtra("Category Name","نظم و شبكات");
                startActivity(goToCategories);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chossen_category, menu);
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
