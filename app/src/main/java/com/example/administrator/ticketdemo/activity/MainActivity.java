package com.example.administrator.ticketdemo.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ticketdemo.R;
import com.example.administrator.ticketdemo.adapter.TicketAdapter;
import com.example.administrator.ticketdemo.bean.Ticket;
import com.example.administrator.ticketdemo.db.DBUtils;
import com.example.administrator.ticketdemo.db.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private String TAG = "MainActivity";
    private Spinner id_sort,id_site;
    private ListView ticketList;
    private TextView my;
    private List<String> sortlist;
    private List<String> sitelist;
    private DBUtils db;
    private String sort;
    private String site;
    private List<Ticket> lists;

    private Ticket[] tkt;
    private boolean isOwn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeData();

        InitUI();
        Click();

    }

    private void InitializeData(){
        db = new DBUtils(MainActivity.this);
        final int i = db.Count("ticket");
        if(i==0){
            InitData.InitializeData(MainActivity.this, db);
        }


        tkt = db.findData("ticket",null,null);
    }

    private void InitUI() {
        id_sort = (Spinner) findViewById(R.id.id_sort);
        id_site = (Spinner) findViewById(R.id.id_site);
        ticketList = (ListView) findViewById(R.id.id_ticketlist);
        my = (TextView) findViewById(R.id.id_my);
        /**
         *
         */
        sortlist = new ArrayList<String>();
        sortlist.add("Comprehensive");
        sortlist.add("depart earliest to latest");
        sortlist.add("depart latest to earliest");
        sortlist.add("price expensive to cheap");
        sortlist.add("price cheap to expensive");
        ArrayAdapter<String> pAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,sortlist);
        id_sort.setAdapter(pAdapter);

        /**
         *
         */
        sitelist = new ArrayList<String>();
        sitelist.add("ALL");

        for(int i=0;i<tkt.length;i++){
            String s = tkt[i].getSite();
            if(sitelist.size()!=0){
                for(int c=0;c<sitelist.size();c++){
                    if(s.equals(sitelist.get(c))){
                        isOwn = true;
                    }
                }
                if(isOwn==true){
                    isOwn = false;
                }else{
                    sitelist.add(s);
                }
            }else{
                sitelist.add(s);
            }
        }
        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,sitelist);
        id_site.setAdapter(sAdapter);

        lists = new ArrayList<Ticket>();
        TicketAdapter adapter = new TicketAdapter(MainActivity.this,lists);
        ticketList.setAdapter(adapter);

    }

    /**
     *
     */
    private void Click(){
        /**
         *
         */
        id_site.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                site = sitelist.get(position);
                Swtichs();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         *
         */
        id_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sort = sortlist.get(position);
                if(tkt!=null&&site!=null){
                    Swtichs();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         *
         */
        ticketList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDialogBox(lists.get(position));
            }
        });


        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);

            }
        });
    }


    /**
     *
     * @param tk
     */
    public void ShowDialogBox(final Ticket tk){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("book flight ticket");
        builder.setMessage("Are you sure booking"+tk.getSite()+"a Ticket."+"The time of departure"+tk.getTime()+":00"+".Ticket unit price"+tk.getMoney());
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                db.AddData("my",new String[]{"site","type","money","time"},new String[]{tk.getSite(),tk.getType(),
                        String.valueOf(tk.getMoney()),String.valueOf(tk.getTime())});

                Toast.makeText(MainActivity.this, "Booking succeed", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }


    public void Swtichs(){
        if(site.equals("ALL")){
            Refresh();

            tkt = db.findData("ticket",null,null);
        }else{
            Refresh();
            tkt = db.findData("ticket","site=?",new String[]{site});
            Log.e(TAG,tkt.length+"----");
        }
        switch (sort){
            case "Comprehensive":
                addList(tkt);
                Notification();
                break;
            case "depart earliest to latest":
                QuickSort.sort(tkt,0,tkt.length-1,sort);
                addList(tkt);
                Notification();
                break;
            case "depart latest to earliest":
                QuickSort.sort(tkt,0,tkt.length-1,sort);
                addList(tkt);
                Notification();
                break;
            case "price expensive to cheap":
                QuickSort.sort(tkt,0,tkt.length-1,sort);
                addList(tkt);
                Notification();
                break;
            case "price cheap to expensive":
                QuickSort.sort(tkt,0,tkt.length-1,sort);
                addList(tkt);
                Notification();
                break;
        }
    }
    /**
     *
     * @param tkt
     */
    public void addList(Ticket[] tkt){
        for(int i=0;i<tkt.length;i++){
            lists.add(tkt[i]);
        }
    }

    /**
     *
     */
    public void Refresh(){
        lists.clear();
        TicketAdapter adapter = (TicketAdapter) ticketList.getAdapter();
        adapter.notifyDataSetChanged();
    }

    /**
     *
     */
    public void Notification(){
        TicketAdapter adapter = (TicketAdapter) ticketList.getAdapter();
        adapter.notifyDataSetChanged();
    }
}
