package com.example.ahmed.tendercs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahmed on 27/03/2015.
 */
public class DBAllCategorirs extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String CATEGORIES_TABLE_NAME = "allCategories";

    DBAllCategorirs(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbAllCategories){
        createTable(dbAllCategories);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbAllCategories, int oldVersion, int newVersion) {
        String dropSQL = "DROP TABLE IF EXISTS " + CATEGORIES_TABLE_NAME + ";";
        dbAllCategories.execSQL(dropSQL);
        onCreate(dbAllCategories);
    }
    private void createTable(SQLiteDatabase dbAllCategories) {
        String createSQL = "CREATE TABLE " + CATEGORIES_TABLE_NAME + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Pop TEXT);";
        dbAllCategories.execSQL(createSQL);

        String insertSQL = "INSERT INTO " + CATEGORIES_TABLE_NAME +
                " (Name, Pop) " +
                " SELECT 'تخطيط جزء من ترعة الرشيديه' AS Name, 'وزراة الموارد المائيه - غرب كفر الشيخ' AS Pop" +
                " UNION SELECT 'تطوير و ترميم مبنى نادي الطيران ببنها','مجلس مدينة بنها للعقود و المشتريات' " +
                " UNION SELECT 'ممارسه عامه لعمليات توريد حبوب','الجمعيه التعاونيه للاصلاح الزراعي';";
        dbAllCategories.execSQL(insertSQL);
    }
}
