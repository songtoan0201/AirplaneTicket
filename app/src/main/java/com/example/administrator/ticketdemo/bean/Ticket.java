package com.example.administrator.ticketdemo.bean;

/**
 * Created by Administrator on 2017/11/13.
 */
public class Ticket {

    private String site;
    private String type;
    private int src;
    private int money;
    private int time;

    public Ticket(){}
    public Ticket(String site, String type, int money, int time) {
        this.site = site;
        this.type = type;
        this.money = money;
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
