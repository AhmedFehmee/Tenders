package com.example.ahmed.tendercs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FirstCategory extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_category);


        TextView tvName = (TextView)findViewById(R.id.tvName);
        TextView tvNumber = (TextView)findViewById(R.id.tvNumber);
        TextView tvData = (TextView)findViewById(R.id.tvData);
        TextView tvGeha = (TextView)findViewById(R.id.tvGeha);
        TextView tvHy2a = (TextView)findViewById(R.id.tvHay2a);
        TextView tvAdress = (TextView)findViewById(R.id.tvAdress);
        TextView tvPhone = (TextView)findViewById(R.id.tvPhone);
        TextView tvDescribtion = (TextView)findViewById(R.id.tvDescribtion);

        Intent i = getIntent();
        getSupportActionBar().setTitle(i.getExtras().getString("title"));

        tvName.setText(i.getExtras().getString("name"));
        tvNumber.setText(i.getExtras().getString("number"));
        tvData.setText(i.getExtras().getString("data"));
        tvGeha.setText(i.getExtras().getString("geha"));
        tvHy2a.setText(i.getExtras().getString("e3lan"));
        tvAdress.setText(i.getExtras().getString("adress"));
        tvPhone.setText(i.getExtras().getString("phone"));
        tvDescribtion.setText(i.getExtras().getString("describtion"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_category, menu);
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
