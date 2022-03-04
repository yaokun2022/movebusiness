package com.yaokun.movebusiness.utils;


import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetPhotoUtils extends AppCompatActivity {
    public static final int TAKE_PHOTO = 1;

    //打开相机
    public static void openCameraClick(Button takePhoto, Activity activity) {
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activity.startActivityForResult(intent, TAKE_PHOTO);
            }
        });

    }
    //

}