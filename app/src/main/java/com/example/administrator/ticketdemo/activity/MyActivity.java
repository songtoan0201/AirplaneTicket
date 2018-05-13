package com.example.administrator.ticketdemo.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.ticketdemo.R;
import com.example.administrator.ticketdemo.adapter.TicketAdapter;
import com.example.administrator.ticketdemo.bean.Ticket;
import com.example.administrator.ticketdemo.db.DBUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */

public class MyActivity extends AppCompatActivity {

    private ListView myList;
    private List<Ticket> lists;
    private TicketAdapter adapter;
    private  DBUtils db;
    private String TAG = "MyActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        lists = new ArrayList<Ticket>();
        myList = (ListView) findViewById(R.id.id_mylist);

        db = new DBUtils(MyActivity.this);
        Ticket[] tickets =db.findData("my",null,null);

        for(int i=0;i<tickets.length;i++){
            lists.add(tickets[i]);
        }

        adapter = new TicketAdapter(MyActivity.this,lists);
        myList.setAdapter(adapter);


        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                ShowDialogBox(position);

            }
        });
    }


    /**
     *
     */
    public void ShowDialogBox(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        builder.setTitle("Cancel flight ticket");
        builder.setMessage("Are you sure cancel this reservation?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                long i = db.Delete("my","site=? and time=? and money=?",new String[]{lists.get(position).getSite()
                        ,String.valueOf(lists.get(position).getTime()),String.valueOf(lists.get(position).getMoney())});
                lists.remove(position);
                adapter.notifyDataSetChanged();

                Toast.makeText(MyActivity.this, "Help you cancel your reservation", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }

}
