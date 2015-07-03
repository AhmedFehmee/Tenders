package com.example.ahmed.tendercs;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Home extends ActionBarActivity {

    TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvUserName = (TextView)findViewById(R.id.tvUserName);
        Intent i = getIntent();
        tvUserName.setText(i.getExtras().getString("User Name"));

        //Create the database helper:
        SQLiteDatabase.CursorFactory factory = null;
        DBCategories categoryDatabase = new DBCategories(this, "categoriesDB", factory);

        String[] columnNames = {"Name", "Pop", BaseColumns._ID};
        ListView lvCategories = (ListView) findViewById(R.id.lvCategories);

        int[] targetLayoutIDs = {R.id.textName, R.id.textPop};

        SQLiteDatabase db = categoryDatabase.getReadableDatabase();
        Cursor categories1 = db.query("Categories", columnNames, null, null, null, null, null);
        CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.home_list_definition,
                categories1, columnNames, targetLayoutIDs, 0);
        lvCategories.setAdapter(adapter);

        //ListView
        //lvCategories.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //lvCategories.setTextFilterEnabled(true);


        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(0xFFAEC4FF);

                switch (position) {
                    case 0:
                        // view.setBackgroundColor(android.R.color.darker_gray);
                        //  String str0 = lvCategories.getItemAtPosition(position).toString().trim();
                        // Toast.makeText(getApplicationContext(), str0, Toast.LENGTH_SHORT).show();
                        Intent cat0 = new Intent(Home.this, FirstCategory.class);

                        cat0.putExtra("title", "تخطيط جزء من ترعة الرشيديه");
                        cat0.putExtra("name", "إنشاء مبنى في هيئه المياه");
                        cat0.putExtra("number", "5585");
                        cat0.putExtra("data", "12/5/2015  13:00");
                        cat0.putExtra("geha", "الاخبار");
                        cat0.putExtra("e3lan", "هيئه المياه");
                        cat0.putExtra("adress", "15 ش محمد فؤاد ");
                        cat0.putExtra("phone", "01215202485");
                        cat0.putExtra("describtion", "إنشاء خطوط مياه");
                        startActivity(cat0);
                        break;
                    case 1:
                        //  String str1= lvCategories.getItemAtPosition(position).toString().trim();
                        // Toast.makeText(getApplicationContext(), str1, Toast.LENGTH_SHORT).show();
                        Intent cat1 = new Intent(Home.this, FirstCategory.class);

                        cat1.putExtra("title", "تطوير مبني نادى الطيران");
                        cat1.putExtra("name", "ترميم مبنى الطيران ");
                        cat1.putExtra("number", "14927");
                        cat1.putExtra("data", "2015-08-06  14:00");
                        cat1.putExtra("geha", "الوفد");
                        cat1.putExtra("e3lan", "مجلس مدينة بنها");
                        cat1.putExtra("adress", "بنها بجوار نادى بنها");
                        cat1.putExtra("phone", "01089675567");
                        cat1.putExtra("describtion", "ترميم مبنى نادي الطيران");

                        startActivity(cat1);
                        break;
                    case 2:
                        //String str2 = lvCategories.getItemAtPosition(position).toString().trim();
                        // Toast.makeText(getApplicationContext(), str2 , Toast.LENGTH_SHORT).show();

                        Intent cat2 = new Intent(Home.this, FirstCategory.class);

                        cat2.putExtra("title", "ممارسه عامه لعمليات توريد حبوب");
                        cat2.putExtra("name", "توريد حبوب ");
                        cat2.putExtra("number", "14923");
                        cat2.putExtra("data", "2015-09-07  10:00");
                        cat2.putExtra("geha", "الجمهوريه");
                        cat2.putExtra("e3lan", "الجمعيه التعاونيه للاصلاح الزراعي");
                        cat2.putExtra("adress", "بجوار المتحف الزراعي بالدقي");
                        cat2.putExtra("phone", "01089675567");
                        cat2.putExtra("describtion", "توريد حبوب ");
                        startActivity(cat2);
                        break;
                }
            }
        });
        Button categories = (Button)findViewById(R.id.bt_categories);
        Button news = (Button)findViewById(R.id.bt_News);
        Button contact = (Button)findViewById(R.id.bt_Contact_Us);

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category = new Intent(Home.this, Chossen_category.class);
                startActivity(category);
            }
        });

        news.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent category = new Intent(Home.this, NewsList.class);
                startActivity(category);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category = new Intent(Home.this, Contact_Us.class);
                startActivity(category);
            }
        });

    }
    }

