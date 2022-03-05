package com.yaokun.movebusiness.entity;

import android.graphics.drawable.Drawable;

/**
 *  授权用户实体，授权信息
 *
 */

public class AuthRecord {
    private String province;//省
    private String carNum;//车牌
    private int isPresenceIc;//是否在场图标
    private String isPresence;//是否在场
    private String isEffective;//是否有效

    public AuthRecord(String province, String carNum, int isPresenceIc, String isPresence, String isEffective) {
        this.province = province;
        this.carNum = carNum;
        this.isPresenceIc = isPresenceIc;
        this.isPresence = isPresence;
        this.isEffective = isEffective;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public int getIsPresenceIc() {
        return isPresenceIc;
    }

    public void setIsPresenceIc(int isPresenceIc) {
        this.isPresenceIc = isPresenceIc;
    }

    public String getIsPresence() {
        return isPresence;
    }

    public void setIsPresence(String isPresence) {
        this.isPresence = isPresence;
    }

    public String getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(String isEffective) {
        this.isEffective = isEffective;
    }

    @Override
    public String toString() {
        return "AuthRecord{" +
                "province='" + province + '\'' +
                ", carNum='" + carNum + '\'' +
                ", isPresenceIc=" + isPresenceIc +
                ", isPresence='" + isPresence + '\'' +
                ", isEffective='" + isEffective + '\'' +
                '}';
    }
}
