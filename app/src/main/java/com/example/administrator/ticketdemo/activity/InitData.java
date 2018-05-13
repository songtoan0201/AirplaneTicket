package com.example.administrator.ticketdemo.activity;

import android.content.Context;
import android.widget.Toast;
import com.example.administrator.ticketdemo.db.DBUtils;

/**
 * Created by Administrator on 2017/11/13.
 */

public class InitData {

    public static void InitializeData(Context ctx,DBUtils db){

        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->Japan","AirTicket","440","14"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->Japan","AirTicket","660","14"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->Japan","AirTicket","440","15"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->Japan","AirTicket","660","15"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","5440","16"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4440","17"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4540","14"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4470","20"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4470","19"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4000","15"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4500","13"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","4990","17"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->SanFrancisco","AirTicket","5000","12"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7400","6"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7500","3"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7550","17"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7500","16"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7650","15"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7750","20"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","7770","16"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","8000","8"});
        db.AddData("ticket",new String[]{"site","type","money","time"},new String[]{"Canton-->London","AirTicket","9000","6"});

    }
}
