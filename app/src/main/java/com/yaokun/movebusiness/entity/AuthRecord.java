package com.yaokun.movebusiness.entity;

import android.graphics.drawable.Drawable;

/**
 * 授权用户实体，授权信息
 */

public class AuthRecord {

    private String province;//省
    private String carNum;//车牌
    private int isPresenceIc;//是否在场图标
    private String isPresence;//是否在场
    private String isEffective;//是否有效

    private String parkingTv;//车场
    private String parkingInfo;//车场信息
    private String startTimeTv;//授权开始时间
    private String startTimeInfo;//开始时间
    private String endTimeTv;//授权结束时间
    private String endTimeInfo;//结束时间
    private String bindingStatusTv;//绑定状态
    private String bindingStatusInfo;//绑定状态信息
    private String remarks;//备注
    private String remarksInfo;//备注信息

    public AuthRecord(String province, String carNum, int isPresenceIc, String isPresence, String isEffective) {
        this.province = province;
        this.carNum = carNum;
        this.isPresenceIc = isPresenceIc;
        this.isPresence = isPresence;
        this.isEffective = isEffective;
    }

    public AuthRecord(String province, String carNum, int isPresenceIc, String isPresence, String isEffective, String parkingInfo, String startTimeInfo, String endTimeInfo, String bindingStatusInfo, String remarksInfo) {
        this.province = province;
        this.carNum = carNum;
        this.isPresenceIc = isPresenceIc;
        this.isPresence = isPresence;
        this.isEffective = isEffective;
        this.parkingInfo = parkingInfo;
        this.startTimeInfo = startTimeInfo;
        this.endTimeInfo = endTimeInfo;
        this.bindingStatusInfo = bindingStatusInfo;
        this.remarksInfo = remarksInfo;
    }

    public AuthRecord(String province, String carNum, int isPresenceIc, String isPresence, String isEffective, String parkingTv, String parkingInfo, String startTimeTv, String startTimeInfo, String endTimeTv, String endTimeInfo, String bindingStatusTv, String bindingStatusInfo, String remarks, String remarksInfo) {
        this.province = province;
        this.carNum = carNum;
        this.isPresenceIc = isPresenceIc;
        this.isPresence = isPresence;
        this.isEffective = isEffective;
        this.parkingTv = parkingTv;
        this.parkingInfo = parkingInfo;
        this.startTimeTv = startTimeTv;
        this.startTimeInfo = startTimeInfo;
        this.endTimeTv = endTimeTv;
        this.endTimeInfo = endTimeInfo;
        this.bindingStatusTv = bindingStatusTv;
        this.bindingStatusInfo = bindingStatusInfo;
        this.remarks = remarks;
        this.remarksInfo = remarksInfo;
    }


    public String getParkingTv() {
        return parkingTv;
    }

    public void setParkingTv(String parkingTv) {
        this.parkingTv = parkingTv;
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public String getStartTimeTv() {
        return startTimeTv;
    }

    public void setStartTimeTv(String startTimeTv) {
        this.startTimeTv = startTimeTv;
    }

    public String getStartTimeInfo() {
        return startTimeInfo;
    }

    public void setStartTimeInfo(String startTimeInfo) {
        this.startTimeInfo = startTimeInfo;
    }

    public String getEndTimeTv() {
        return endTimeTv;
    }

    public void setEndTimeTv(String endTimeTv) {
        this.endTimeTv = endTimeTv;
    }

    public String getEndTimeInfo() {
        return endTimeInfo;
    }

    public void setEndTimeInfo(String endTimeInfo) {
        this.endTimeInfo = endTimeInfo;
    }

    public String getBindingStatusTv() {
        return bindingStatusTv;
    }

    public void setBindingStatusTv(String bindingStatusTv) {
        this.bindingStatusTv = bindingStatusTv;
    }

    public String getBindingStatusInfo() {
        return bindingStatusInfo;
    }

    public void setBindingStatusInfo(String bindingStatusInfo) {
        this.bindingStatusInfo = bindingStatusInfo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarksInfo() {
        return remarksInfo;
    }

    public void setRemarksInfo(String remarksInfo) {
        this.remarksInfo = remarksInfo;
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
                ", parkingTv='" + parkingTv + '\'' +
                ", parkingInfo='" + parkingInfo + '\'' +
                ", startTimeTv='" + startTimeTv + '\'' +
                ", startTimeInfo='" + startTimeInfo + '\'' +
                ", endTimeTv='" + endTimeTv + '\'' +
                ", endTimeInfo='" + endTimeInfo + '\'' +
                ", bindingStatusTv='" + bindingStatusTv + '\'' +
                ", bindingStatusInfo='" + bindingStatusInfo + '\'' +
                ", remarks='" + remarks + '\'' +
                ", remarksInfo='" + remarksInfo + '\'' +
                '}';
    }
}
