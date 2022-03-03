package com.yaokun.movebusiness.utils;

import android.app.Activity;
import android.graphics.Color;


import com.github.gzuliyujiang.wheelpicker.DatePicker;
import com.github.gzuliyujiang.wheelpicker.annotation.DateMode;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatePickedListener;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.impl.UnitDateFormatter;
import com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout;

public class DataTimeUtils{

    /**
     * 选择时间（年月日）
     */

    public static void selectData(Activity activity) {

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

            }
        });
        picker.show();
    }

}
