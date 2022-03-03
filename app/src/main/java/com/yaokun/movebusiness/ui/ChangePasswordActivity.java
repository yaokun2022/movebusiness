package com.yaokun.movebusiness.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.utils.PasswordSelectUtils;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    PasswordSelectUtils pwdUtils;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        EditText pwdEt1 = findViewById(R.id.pwdET1);
        EditText pwdEt2 = findViewById(R.id.pwdET2);
        EditText pwdEt3 = findViewById(R.id.pwdET3);
        pwdUtils = new PasswordSelectUtils();


        ImageView pwd1 = findViewById(R.id.pwdIv1);
        pwd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwdUtils.usePwdSelect(pwd1, pwdEt1);
            }
        });

        ImageView pwd2 = findViewById(R.id.pwdIv2);
        pwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwdUtils.usePwdSelect(pwd2, pwdEt2);
            }
        });

        ImageView pwd3 = findViewById(R.id.pwdIv3);
        pwd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwdUtils.usePwdSelect(pwd3, pwdEt3);
            }
        });

    }

    public void fpClick(View view) {
        Intent intent = new Intent(ChangePasswordActivity.this, ModPwdSucceedActivity.class);
        startActivity(intent);
    }
}
