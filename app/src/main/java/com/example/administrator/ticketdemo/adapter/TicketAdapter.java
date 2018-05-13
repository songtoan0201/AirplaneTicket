package com.example.administrator.ticketdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.ticketdemo.R;
import com.example.administrator.ticketdemo.bean.Ticket;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */

public class TicketAdapter extends BaseAdapter {
    private String TAG = "TicketAdapter";
    private Context ctx;
    private LayoutInflater inflater;
    private List<Ticket> tickets;
    public TicketAdapter(Context ctx, List<Ticket> tickets){
        this.ctx = ctx;
        this.tickets = tickets;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        if(tickets==null){

            Log.e(TAG,"数据改变了");
            return 0;
        }
        return tickets.size();
    }

    @Override
    public Object getItem(int position) {
        return tickets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHoder mHoder = null;
        if(convertView==null){
            mHoder = new ViewHoder();
            convertView = inflater.inflate(R.layout.ticket_item,null);
            mHoder.site = (TextView) convertView.findViewById(R.id.id_site);
            mHoder.type = (TextView) convertView.findViewById(R.id.id_type);
            mHoder.time = (TextView) convertView.findViewById(R.id.id_time);
            mHoder.money = (TextView) convertView.findViewById(R.id.id_money);

            mHoder.site.setText(tickets.get(position).getSite());
            mHoder.type.setText(tickets.get(position).getType());
            if(tickets.get(position).getTime()<10){
                mHoder.time.setText("0"+tickets.get(position).getTime()+":"+"00");
            }else{
                mHoder.time.setText(tickets.get(position).getTime()+":"+"00");
            }
            mHoder.money.setText(tickets.get(position).getMoney()+"");

            convertView.setTag(mHoder);
        }else{
            mHoder = (ViewHoder) convertView.getTag();

            mHoder.site.setText(tickets.get(position).getSite());
            mHoder.type.setText(tickets.get(position).getType());
            if(tickets.get(position).getTime()<10){
                mHoder.time.setText("0"+tickets.get(position).getTime()+":"+"00");
            }else{
                mHoder.time.setText(tickets.get(position).getTime()+":"+"00");
            }
            mHoder.money.setText(tickets.get(position).getMoney()+"");
        }


        return convertView;
    }

    class ViewHoder{

        public TextView site,type,time,money;
    }
}
