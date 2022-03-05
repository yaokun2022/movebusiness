package com.yaokun.movebusiness.ui;

import static com.yaokun.movebusiness.R.drawable.*;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.AppCompatButton;

import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.github.gzuliyujiang.wheelpicker.TimePicker;
import com.github.gzuliyujiang.wheelpicker.annotation.TimeMode;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimePickedListener;
import com.github.gzuliyujiang.wheelpicker.entity.TimeEntity;
import com.github.gzuliyujiang.wheelpicker.impl.UnitTimeFormatter;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;
import com.github.gzuliyujiang.wheelview.annotation.CurtainCorner;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;
import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.entity.Parking;
import com.yaokun.movebusiness.utils.DataTimeUtils;
import com.yaokun.movebusiness.utils.LicensePlateUtils;

import java.util.ArrayList;
import java.util.List;


public class AuthorizationActivity extends BaseActivity {
    private ImageView licensePlate;
    private ImageView noLicensePlate;
    private EditText licPlate;
    private TextView licTv;
    private ImageView pointRed;
    private TextView helpTv;
    private ImageView picture;
    private AppCompatButton deletePic;
    private EditText remarksText;
    private TextView remarksCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization1);
        TextView textView = findViewById(R.id.dataTV);

        //结束授权
        TextView determineBtn = findViewById(R.id.determineBtn);
        TextView title = findViewById(R.id.titleDialog);
        determineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AuthorizationActivity.this);
                View dialogView = View.inflate(getApplicationContext(), R.layout.activity_quit_dialog, null);
                builder.setView(dialogView);
                Button cancelBtn = dialogView.findViewById(R.id.cancelBtn);
                final AlertDialog dialog = builder.show();
                dialogView.findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = DataTimeUtils.onTime24(AuthorizationActivity.this);
                String data = DataTimeUtils.selectData(AuthorizationActivity.this);
                textView.setText(data + time);
            }
        });


        //备注统计
        //打开输入法 文本框上移
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        int bigNum = 30;
        remarksText = findViewById(R.id.remarksText);
        remarksCount = findViewById(R.id.remarksCount);
        remarksCount.setText(remarksText.length() + "/" + bigNum);
        remarksText.addTextChangedListener(new TextWatcher() {

            private CharSequence temp;
            private int selectionStart;
            private int selectionEnd;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;

            }

            @Override
            public void afterTextChanged(Editable s) {
                remarksCount.setText(s.length() + "/30");
                if (s.length() == 30) {
                    Toast.makeText(getApplicationContext(), "备注超出", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //删除凭证
        deletePic = findViewById(R.id.deletePic);
        deletePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picture.setVisibility(picture.GONE);
                deletePic.setVisibility(deletePic.GONE);
            }
        });

        //设置有车牌无车牌选择
        licensePlate = findViewById(R.id.selectLicensePlate);
        noLicensePlate = findViewById(R.id.selectNoLicensePlate);
        licPlate = findViewById(R.id.licPlaEt);
        licTv = findViewById(R.id.licTV);
        pointRed = findViewById(R.id.pointIv);
        helpTv = findViewById(R.id.helpTv);
        licPlate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (LicensePlateUtils.checkLicensePlate(licPlate.getText().toString())) {
                    licPlate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getDrawable(R.mipmap.login_username_ic), null);
                }
            }
        });

        licensePlate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!licensePlate.isSelected()) {
                    if (licensePlate.isClickable()) {
                        licensePlate.setSelected(true);
                        noLicensePlate.setSelected(false);
                        licensePlate.setClickable(false);
                        noLicensePlate.setClickable(true);
                        //设置车牌号样式
                        licPlate.setEnabled(true);
                        licPlate.setBackground(getDrawable(au_boarder));
                        licTv.setTextColor(getColor(R.color.licTvColor2));
                        pointRed.setImageDrawable(getResources().getDrawable(red_point));
                        licPlate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
                        helpTv.setVisibility(helpTv.VISIBLE);
                    }
                }

            }
        });
        noLicensePlate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!noLicensePlate.isSelected()) {
                    if (noLicensePlate.isClickable())
                        noLicensePlate.setSelected(true);
                    licensePlate.setSelected(false);
                    noLicensePlate.setClickable(false);
                    licensePlate.setClickable(true);
                    //设置车牌号样式
                    licPlate.setEnabled(false);
                    licPlate.setBackground(getDrawable(lic_plate_select_bg));
                    licTv.setTextColor(getColor(R.color.licTvColor));
                    pointRed.setImageDrawable(getResources().getDrawable(red_point2));
                    licPlate.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getDrawable(lic_tv_block), null);
                    helpTv.setVisibility(helpTv.GONE);

                }
            }
        });

        //车牌号是否正确
        licPlate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    /**
     * 选择停车场
     */
    public void SelectParking() {
        List<Parking> data = new ArrayList<>();
        data.add(new Parking(1, "中天车场2"));
        data.add(new Parking(2, "停车场2"));
        data.add(new Parking(3, "中天停车场"));
        data.add(new Parking(4, "德福中心停车场"));
        data.add(new Parking(5, "龙洞停车场"));
        OptionPicker picker = new OptionPicker(this);
        picker.setTitle("车场选择");
        picker.setBodyWidth(140);
        picker.setData(data);
        picker.setDefaultPosition(2);
        picker.setOnOptionPickedListener(new OnOptionPickedListener() {
            @Override
            public void onOptionPicked(int position, Object item) {
                TextView parktv = findViewById(R.id.parktv);
                parktv.setText(item.toString());
            }
        });

        OptionWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setIndicatorEnabled(false);
        wheelLayout.setTextColor(Color.rgb(153, 153, 153));
        wheelLayout.setSelectedTextColor(Color.rgb(0, 0, 0));
        wheelLayout.setTextSize(20);
        wheelLayout.setSelectedTextBold(true);
        wheelLayout.setCurtainEnabled(true);
        //   wheelLayout.setCurtainColor(0xEEFF0000);
        wheelLayout.setCurtainCorner(CurtainCorner.ALL);
        wheelLayout.setCurtainRadius(25);
        wheelLayout.setOnOptionSelectedListener(new OnOptionSelectedListener() {
            @Override
            public void onOptionSelected(int position, Object item) {
                picker.getTitleView().setText(picker.getWheelView().formatItem(position));
            }
        });
        picker.show();
    }


    /**
     * 选择时间（时分秒）
     *
     * @param view
     */
    public void onTime24(View view) {
        TimePicker picker = new TimePicker(this);
        TimeWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setTimeMode(TimeMode.HOUR_24_HAS_SECOND);
        wheelLayout.setTimeFormatter(new UnitTimeFormatter());
        wheelLayout.setDefaultValue(TimeEntity.now());
        wheelLayout.setResetWhenLinkage(false);
        picker.setOnTimePickedListener(new OnTimePickedListener() {
            @Override
            public void onTimePicked(int hour, int minute, int second) {

            }
        });
        picker.show();
    }


    public void selectClick(View view) {
        SelectParking();
    }

    public void endDataClick(View view) {
        TextView textView = findViewById(R.id.dataTV2);
        String time = DataTimeUtils.onTime24(AuthorizationActivity.this);
        String data = DataTimeUtils.selectData(AuthorizationActivity.this);
        textView.setText(data + time);
    }

    //从相机或相册获取图片
    public void takePhoto(View view) {
        PictureSelector
                .create(AuthorizationActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                picture = findViewById(R.id.picture);
                if (pictureBean.isCut()) {
                    picture.setImageBitmap(BitmapFactory.decodeFile(pictureBean.getPath()));
                } else {
                    picture.setImageURI(pictureBean.getUri());
                    picture.setVisibility(picture.VISIBLE);
                    deletePic.setVisibility(deletePic.VISIBLE);
                }

                //使用 Glide 加载图片
                /*Glide.with(this)
                        .load(pictureBean.isCut() ? pictureBean.getPath() : pictureBean.getUri())
                        .apply(RequestOptions.centerCropTransform()).into(mIvImage);*/
            }
        }
    }
}





