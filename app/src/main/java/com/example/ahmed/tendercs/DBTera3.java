package com.example.ahmed.tendercs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahmed on 18/04/2015.
 */
public class DBTera3  extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String CATEGORIES_TABLE_NAME = "tera3";

    DBTera3(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbTera3) {
        createTable(dbTera3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbTera3, int oldVersion, int newVersion) {
        String dropSQL = "DROP TABLE IF EXISTS " + CATEGORIES_TABLE_NAME + ";";
        dbTera3.execSQL(dropSQL);
        createTable(dbTera3);
    }
    private void createTable(SQLiteDatabase dbTera3) {
        String dropSQL = "DROP TABLE IF EXISTS " + CATEGORIES_TABLE_NAME + ";";
        dbTera3.execSQL(dropSQL);

        String createSQL = "CREATE TABLE " + CATEGORIES_TABLE_NAME + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Pop TEXT);";
        dbTera3.execSQL(createSQL);

        String insertSQL = "INSERT INTO " + CATEGORIES_TABLE_NAME +
                " (Name, Pop) " +
                " SELECT 'تخطيط جزء من ترعة الرشيديه' AS Name, 'وزراة الموارد المائيه - غرب كفر الشيخ' AS Pop" +
                " UNION SELECT 'عملية احلال وتجديد شبكات الصرف الصحي بمدينة','محافظة القليوبية الادارة العامة للشئون المالية والادارية'"+
                " UNION SELECT 'عملية احلال وتجديد لشبكات الصرف الصحي' , ' الشركة القابضة لمياه الشرب والصرف الصحي'"+
                " UNION SELECT 'عملية توريد عدد وادوات لمحطة الصرف الصحي' , ' محافظة القليوبية الوحدة المحلية لمركز ومدينة القناطر الخيرية '"+
                " UNION SELECT 'مناقصة عامة عن عملية التطهيرات ونزع الحشائش بمركزى ابو حماد وفاقوس' , 'وزارة الموارد المائية والرى الهيئة المصرية';";
        dbTera3.execSQL(insertSQL);
    }
}

