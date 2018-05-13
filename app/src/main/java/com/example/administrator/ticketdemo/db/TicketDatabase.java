package com.example.administrator.ticketdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/11/13.
 */

public class TicketDatabase extends SQLiteOpenHelper {

    private static final String NAME ="Debauchery.db";
    private static final int VERSION =1;
    public TicketDatabase(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         *创建机票表
         */
        String sql = "CREATE TABLE ticket(_id integer primary key autoincrement," +
                "site varchar(10),type varchar(20),money varchar(10),time varchar(10));";

        String sql2 = "CREATE TABLE my(_id integer primary key autoincrement," +
                "site varchar(10),type varchar(20),money varchar(10),time varchar(10));";
        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
