package com.example.ahmed.tendercs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class News_describtion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_describtion);

        TextView tv_title = (TextView)findViewById(R.id.tv_title);
        TextView tv_Describtion = (TextView)findViewById(R.id.tv_describtion);

        Intent i = getIntent();

        getSupportActionBar().setTitle(i.getExtras().getString("main title"));

        tv_title.setText(i.getExtras().getString("title"));
        tv_Describtion.setText(i.getExtras().getString("describtion"));
    }
}
