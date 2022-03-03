package com.yaokun.movebusiness.utils;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordSelectUtils extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText;

    public static void usePwdSelect(ImageView imageView, EditText editText) {
        if (imageView.isSelected()) {
            imageView.setSelected(false);
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            imageView.setSelected(true);
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }
}
