package com.example.administrator.ticketdemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.administrator.ticketdemo.bean.Ticket;

/**
 * Created by Administrator on 2017/11/13.
 */

public class DBUtils {

    private String TAG = "DBUtils";
    private Context ctx;
    private SQLiteDatabase db;
    public DBUtils(Context ctx){
        this.ctx = ctx;
        TicketDatabase database = new TicketDatabase(ctx);
        db = database.getReadableDatabase();
    }

    /**
     * 插入数据
     * @param key
     * @param object
     */
    public long AddData(String table,String[] key,String[] object){
        ContentValues values = new ContentValues();
        for(int i=0;i<key.length;i++){
            values.put(key[i],object[i]);
        }
        return db.insert(table,null,values);
    }

    /**
     * 查询数据
     * @param selection
     * @param selectionArgs
     * @return
     */
    public Ticket[] findData(String table,String selection,String[] selectionArgs){

        Cursor cursor = db.query(table,null,selection,selectionArgs,null,null,null,null);
        //定义一个数组  数组长度为cursor查询的数据长度
        Ticket[] tickets = new Ticket[cursor.getCount()];
        int i=-1;
        while(cursor.moveToNext()){
            //查出地点 票的类型 时间 金钱
            i++;

            Ticket ticket = new Ticket( cursor.getString(cursor.getColumnIndex("site"))
                    ,cursor.getString(cursor.getColumnIndex("type"))
                    ,Integer.parseInt(cursor.getString(cursor.getColumnIndex("money")))
                    ,Integer.parseInt(cursor.getString(cursor.getColumnIndex("time"))));

            tickets[i] = ticket;
        }
        return tickets;
    }

    /**
     * 删除数据
     * @param table
     * @return
     */

    public long Delete(String table,String selection,String[] selectionArgs){
        return  db.delete(table,selection,selectionArgs);
    }


    public int Count(String table){
        Cursor cursor = db.query(table,null,null,null,null,null,null);
        return cursor.getCount();
    }
}
