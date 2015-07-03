package com.example.ahmed.tendercs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahmed on 19/04/2015.
 */
public class DBComputer  extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String CATEGORIES_TABLE_NAME = "computer";

    DBComputer(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbComputer) {
        createTable(dbComputer);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbComputer, int oldVersion, int newVersion) {
        String dropSQL = "DROP TABLE IF EXISTS " + CATEGORIES_TABLE_NAME + ";";
        dbComputer.execSQL(dropSQL);
        createTable(dbComputer);
    }
    private void createTable(SQLiteDatabase dbComputer) {
        String dropSQL = "DROP TABLE IF EXISTS " + CATEGORIES_TABLE_NAME + ";";
        dbComputer.execSQL(dropSQL);

        String createSQL = "CREATE TABLE " + CATEGORIES_TABLE_NAME + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Pop TEXT);";
        dbComputer.execSQL(createSQL);

        String insertSQL = "INSERT INTO " + CATEGORIES_TABLE_NAME +
                " (Name, Pop) " +
                " SELECT 'عملية توريد سكانر لنظام الارشيف الالكتروني' AS Name,'وزارة الكهرباء'AS Pop"+
                " UNION SELECT 'عمليه توريد اجهزه لاسيلكى ومحمول' , ' الشركة القابضة للصناعات الغذائية'"+
                " UNION SELECT ' عملية شراء اجهزة ومعدات صوت','الهيئة العامة للمركز الثقافي دار الاوبرا'"+
                " UNION SELECT ' عملية شراء عدد(50) جهاز مثبت ups','الادارة العامة للمرور'"+
                " UNION SELECT 'عملية توريد وتشغيل وصيانة plotter لادارة النشر','مكتبة الاسكندرية ';";
        dbComputer.execSQL(insertSQL);
    }
}
