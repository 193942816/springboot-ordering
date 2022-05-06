package com.example.meal_ordering_system.entity;

public class Orders {
    private Integer id;

    private Integer userid;

    private Integer menuid;

    private Integer menusum;

    private String times;

    private Integer delivery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getMenusum() {
        return menusum;
    }

    public void setMenusum(Integer menusum) {
        this.menusum = menusum;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }
}