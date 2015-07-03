package com.example.ahmed.tendercs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Categories extends ActionBarActivity {

    private DBTera3 tera3Database = null;
    private Cursor tera3 = null;
    private ListView lvAllCategories = null;

    private DBComputer computerDatabase = null;
    private Cursor computer = null;

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Intent i = getIntent();
        final String catName = i.getExtras().getString("Category Name");
        if (i.getExtras().getString("Category Name").contains("ترع و مصارف")) {
            sqliteTera3();
            lvAllCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    view.setBackgroundColor(0xFFAEC4FF);

                    switch (position) {
                        case 0:
                            Intent cat0 = new Intent(Categories.this, FirstCategory.class);
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
                            Intent cat1 = new Intent(Categories.this, FirstCategory.class);
                            cat1.putExtra("title", "عملية احلال وتجديد شبكات الصرف الصحي بمدينة");
                            cat1.putExtra("name", "ترميم الصرف الصحى ");
                            cat1.putExtra("number", "14927");
                            cat1.putExtra("data", "25/7/2015  14:00");
                            cat1.putExtra("geha", "الاهرام");
                            cat1.putExtra("e3lan", "الادراه العامه للشئون الماليه");
                            cat1.putExtra("adress", "محافظة القليوبية ");
                            cat1.putExtra("phone", "01089675567");
                            cat1.putExtra("describtion", "ترميم الصرف الصحى ");
                            startActivity(cat1);
                            break;
                        case 2:
                            Intent cat2 = new Intent(Categories.this, FirstCategory.class);
                            cat2.putExtra("title", "عملية احلال وتجديد لشبكات الصرف الصحي");
                            cat2.putExtra("name", "إحلال و تجديد الصرف الصحى");
                            cat2.putExtra("number", "14923");
                            cat2.putExtra("data", "2015-09-07  10:00");
                            cat2.putExtra("geha", "الجمهوريه");
                            cat2.putExtra("e3lan", "الشركه القابضه لمياه الشرب ");
                            cat2.putExtra("adress", "مدمياط بجوار كبري المعلمين ");
                            cat2.putExtra("phone", "01089675567");
                            cat2.putExtra("describtion", "تجديد الصرف الصحى");
                            startActivity(cat2);
                            break;
                        case 3:
                            Intent cat3 = new Intent(Categories.this, FirstCategory.class);
                            cat3.putExtra("title", "عملية توريد عدد وادوات لمحطة الصرف الصحي");
                            cat3.putExtra("name", "توريد معدات");
                            cat3.putExtra("number", "14923");
                            cat3.putExtra("data", "2015-09-07  10:00");
                            cat3.putExtra("geha", "الاهرام");
                            cat3.putExtra("e3lan", "الوحده المحليه ");
                            cat3.putExtra("adress", "مدينة القناطر الخيري");
                            cat3.putExtra("phone", "01089675567");
                            cat3.putExtra("describtion", "توريد معدات");
                            startActivity(cat3);
                            break;
                        case 4:
                            Intent cat4 = new Intent(Categories.this, FirstCategory.class);
                            cat4.putExtra("title", "مناقصة عامة عن عملية التطهيرات ونزع الحشائش بمركزى ابو حماد وفاقوس");
                            cat4.putExtra("name", "مناقصة عامة ");
                            cat4.putExtra("number", "14923");
                            cat4.putExtra("data", "2015-09-07  10:00");
                            cat4.putExtra("geha", "الاهرام");
                            cat4.putExtra("e3lan", "وزاره الموارد المائيه");
                            cat4.putExtra("adress", "مجمع الرى والصرف بالزقازيق");
                            cat4.putExtra("phone", "01089675567");
                            cat4.putExtra("describtion", "ناقصة عامة ");
                            startActivity(cat4);
                            break;
                    }

                }
            });

        } else if (catName.contains("نظم و شبكات")) {
            sqliteComputer();
            lvAllCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    view.setBackgroundColor(0xFFAEC4FF);
                    switch (position) {
                        case 0:
                            Intent cat0 = new Intent(Categories.this, FirstCategory.class);
                            cat0.putExtra("title", "عملية توريد سكانر لنظام الارشيف الالكتروني");
                            cat0.putExtra("name", "توريد سكانر لنظام الارشيف");
                            cat0.putExtra("number", "5585");
                            cat0.putExtra("data", "12/5/2015  13:00");
                            cat0.putExtra("geha", "الاهرام ");
                            cat0.putExtra("e3lan", "وزارة الكهرباء");
                            cat0.putExtra("adress", "بجوار قسم اول مدينة نصر القاهرة ");
                            cat0.putExtra("phone", "01215202485");
                            cat0.putExtra("describtion", "عملية توريد سكانر لنظام الارشيف الالكتروني ");
                            startActivity(cat0);
                            break;
                        case 1:
                            Intent cat1 = new Intent(Categories.this, FirstCategory.class);
                            cat1.putExtra("title", "عمليه توريد اجهزه محمول ولاسيلكى");
                            cat1.putExtra("name", "توريد اجهزه لاسيلكى");
                            cat1.putExtra("number", "14927");
                            cat1.putExtra("data", "25/7/2015  14:00");
                            cat1.putExtra("geha", "الاهرام");
                            cat1.putExtra("e3lan", "الشركة القابضة للصناعات الغذائية");
                            cat1.putExtra("adress", "ش جواد حسني -القاهرة");
                            cat1.putExtra("phone", "01089675567");
                            cat1.putExtra("describtion", " عملية توريد ق,غ اجهزة لاسلكي محمول وثابت");
                            startActivity(cat1);
                            break;
                        case 2:
                            Intent cat2 = new Intent(Categories.this, FirstCategory.class);
                            cat2.putExtra("title", " عملية شراء اجهزة ومعدات صوت");
                            cat2.putExtra("name", "عملية شراء اجهزة ومعدات صوت");
                            cat2.putExtra("number", "14923");
                            cat2.putExtra("data", "2015-09-07  10:00");
                            cat2.putExtra("geha", "الجمهوريه");
                            cat2.putExtra("e3lan", "الهيئة العامة للمركز الثقافي");
                            cat2.putExtra("adress", "الادارة العامة للمشتريات");
                            cat2.putExtra("phone", "01089675567");
                            cat2.putExtra("describtion", "عملية شراء اجهزة ومعدات صوت");
                            startActivity(cat2);
                            break;
                        case 3:
                            Intent cat3 = new Intent(Categories.this, FirstCategory.class);
                            cat3.putExtra("title", "عملية شراء عدد(50) جهاز مثبت ups");
                            cat3.putExtra("name", "توريد معدات");
                            cat3.putExtra("number", "14923");
                            cat3.putExtra("data", "2015-09-07  10:00");
                            cat3.putExtra("geha", "الاهرام");
                            cat3.putExtra("e3lan", "الادارة العامة للمرور");
                            cat3.putExtra("adress", "امتداد رمسيس - بجوار مكتب بريد");
                            cat3.putExtra("phone", "01089675567");
                            cat3.putExtra("describtion", "عملية شراء عدد(50) جهاز مثبت ups");
                            startActivity(cat3);
                            break;
                        case 4:
                            Intent cat4 = new Intent(Categories.this, FirstCategory.class);
                            cat4.putExtra("title", "عملية توريد وتشغيل وصيانة plotter لادارة النشر");
                            cat4.putExtra("name", "مناقصة عامة ");
                            cat4.putExtra("number", "14923");
                            cat4.putExtra("data", "2015-09-07  10:00");
                            cat4.putExtra("geha", "الاهرام");
                            cat4.putExtra("e3lan", "مكتبة الاسكندرية ");
                            cat4.putExtra("adress", "الشاطبي الاسكندرية ");
                            cat4.putExtra("phone", "01089675567");
                            cat4.putExtra("describtion", "عملية توريد وتشغيل وصيانة plotter لادارة النشر");
                            startActivity(cat4);
                            break;
                    }
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Not Available categories for '" + catName + "'", Toast.LENGTH_LONG).show();
        }
        back = (Button) findViewById(R.id.bt_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category = new Intent(Categories.this, Chossen_category.class);
                startActivity(category);
            }
        });
    }

    private void sqliteComputer() {
        //SQlite Computer
        SQLiteDatabase.CursorFactory factory = null;
        computerDatabase = new DBComputer(this, "computerDB", factory);
        String[] columnNames = {"Name", "Pop", BaseColumns._ID};
        lvAllCategories = (ListView) findViewById(R.id.lvAllCategories);
        int[] targetLayoutIDs = {R.id.textName, R.id.textPop};
        SQLiteDatabase db = computerDatabase.getReadableDatabase();
        tera3 = db.query("computer", columnNames, null, null, null, null, null);
        final CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.home_list_definition, tera3, columnNames, targetLayoutIDs, 0);
        lvAllCategories.setAdapter(adapter);}

    private void sqliteTera3() {
        //SQLite Tera3
        SQLiteDatabase.CursorFactory factory = null;
        tera3Database = new DBTera3(this, "tera3DB", factory);
        String[] columnNames = {"Name", "Pop", BaseColumns._ID};
        lvAllCategories = (ListView) findViewById(R.id.lvAllCategories);
        int[] targetLayoutIDs = {R.id.textName, R.id.textPop};
        SQLiteDatabase db = tera3Database.getReadableDatabase();
        tera3 = db.query("tera3", columnNames, null, null, null, null, null);
        final CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.home_list_definition, tera3, columnNames, targetLayoutIDs, 0);
        lvAllCategories.setAdapter(adapter);
    }


   /* public void onPause() {
        super.onPause();
        tera3Database.close();
        computerDatabase.close();
    }*/
}


//Create the database helper:
       /* SQLiteDatabase.CursorFactory factory = null;

        allCategoryDatabase = new DBAllCategorirs(this, "categoriesAllDB", factory);

        String[] columnNames = {"Name", "Pop", BaseColumns._ID};
        lvAllCategories = (ListView) findViewById(R.id.lvAllCategories);

        int[] targetLayoutIDs = {R.id.textName, R.id.textPop};

        SQLiteDatabase db = allCategoryDatabase.getReadableDatabase();
        allCategories = db.query("allCategories", columnNames, null, null, null, null, null);
        CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.home_list_definition,
                allCategories, columnNames, targetLayoutIDs, 0);
        lvAllCategories.setAdapter(adapter);*/


// lvAllCategories.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
// lvAllCategories.setTextFilterEnabled(true);

      /*  lvAllCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(0xFFAEC4FF);

                switch (position) {
                    case 0:
                        Intent cat0 = new Intent(Categories.this, FirstCategory.class);
                        cat0.putExtra("title" ,"تخطيط جزء من ترعة الرشيديه");
                        cat0.putExtra("name",  "إنشاء مبنى في هيئه المياه");
                        cat0.putExtra("number","5585");
                        cat0.putExtra("data",  "12/5/2015  13:00");
                        cat0.putExtra("geha",  "الاخبار");
                        cat0.putExtra("e3lan", "هيئه المياه");
                        cat0.putExtra("adress", "15 ش محمد فؤاد ");
                        cat0.putExtra("phone", "01215202485");
                        cat0.putExtra("describtion", "إنشاء خطوط مياه");
                        startActivity(cat0);
                        break;
                    case 1:
                        Intent cat1 = new Intent(Categories.this, FirstCategory.class);
                        cat1.putExtra("title" ,"تطوير مبني نادى الطيران");
                        cat1.putExtra("name",  "ترميم مبنى الطيران ");
                        cat1.putExtra("number","14927");
                        cat1.putExtra("data",  "2015-08-06  14:00");
                        cat1.putExtra("geha",  "الوفد");
                        cat1.putExtra("e3lan", "مجلس مدينة بنها");
                        cat1.putExtra("adress", "بنها بجوار نادى بنها");
                        cat1.putExtra("phone", "01089675567");
                        cat1.putExtra("describtion", "ترميم مبنى نادي الطيران");
                        startActivity(cat1);
                        break;
                    case 2:
                        Intent cat2 = new Intent(Categories.this, FirstCategory.class);
                        cat2.putExtra("title" ,"ممارسه عامه لعمليات توريد حبوب");
                        cat2.putExtra("name",  "توريد حبوب ");
                        cat2.putExtra("number","14923");
                        cat2.putExtra("data",  "2015-09-07  10:00");
                        cat2.putExtra("geha",  "الجمهوريه");
                        cat2.putExtra("e3lan", "الجمعيه التعاونيه للاصلاح الزراعي");
                        cat2.putExtra("adress", "بجوار المتحف الزراعي بالدقي");
                        cat2.putExtra("phone", "01089675567");
                        cat2.putExtra("describtion", "توريد حبوب ");
                        startActivity(cat2);
                        break;
                }
            }
        });*/
