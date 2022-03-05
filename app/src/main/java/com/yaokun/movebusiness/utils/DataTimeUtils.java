package com.yaokun.movebusiness.utils;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.github.gzuliyujiang.wheelpicker.DatePicker;
import com.github.gzuliyujiang.wheelpicker.TimePicker;
import com.github.gzuliyujiang.wheelpicker.annotation.DateMode;
import com.github.gzuliyujiang.wheelpicker.annotation.TimeMode;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatePickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimePickedListener;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.entity.TimeEntity;
import com.github.gzuliyujiang.wheelpicker.impl.UnitDateFormatter;
import com.github.gzuliyujiang.wheelpicker.impl.UnitTimeFormatter;
import com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;
import com.yaokun.movebusiness.R;

public class DataTimeUtils{
    private static String data;
    private static String time;
    /**
     * 选择时间（年月日）
     */

    public static String selectData(Activity activity) {


        DatePicker picker = new DatePicker(activity);
        picker.setBodyWidth(240);
        DateWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setDateMode(DateMode.YEAR_MONTH_DAY);
//      wheelLayout.setDateLabel("年", "月", "日");
        wheelLayout.setDateFormatter(new UnitDateFormatter());
        wheelLayout.setRange(DateEntity.target(2021, 1, 1), DateEntity.target(2050, 12, 31), DateEntity.today());
        wheelLayout.setCurtainEnabled(true);
//      wheelLayout.setCurtainColor(Color.parseColor("#3D90FF"));
        wheelLayout.setIndicatorEnabled(true);
//      wheelLayout.setIndicatorColor(0xFFFF0000);
        wheelLayout.setIndicatorSize(0);
        wheelLayout.setTextColor(Color.parseColor("#666666"));
        wheelLayout.setSelectedTextColor(Color.parseColor("#3D90FF"));
//        wheelLayout.getYearLabelView().setTextColor(0xFF999999);
//        wheelLayout.getMonthLabelView().setTextColor(0xFF999999);
//        wheelLayout.getDayLabelView().setTextColor(0xFF999999);
//        picker.getWheelLayout().setResetWhenLinkage(false);
        picker.setOnDatePickedListener(new OnDatePickedListener() {
            @Override
            public void onDatePicked(int year, int month, int day) {
                data = year+"/"+month+"/"+day+" ";
                Log.e("tag", "onDatePicked: " +data.toString());
            }
        });
        picker.show();
        return data;
    }

    /**
     * 选择时间（时分秒）
     *
     * @param activity
     */
    public static String onTime24(Activity activity) {
        TimePicker picker = new TimePicker(activity);
        TimeWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setTimeMode(TimeMode.HOUR_24_HAS_SECOND);
        wheelLayout.setTimeFormatter(new UnitTimeFormatter());
        wheelLayout.setDefaultValue(TimeEntity.now());
        wheelLayout.setResetWhenLinkage(false);
        picker.setOnTimePickedListener(new OnTimePickedListener() {
            @Override
            public void onTimePicked(int hour, int minute, int second) {
                time = hour+":"+minute+":"+second;
            }

        });
        picker.show();
        return time;
    }

}
