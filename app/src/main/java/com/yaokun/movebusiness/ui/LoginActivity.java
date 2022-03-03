package com.yaokun.movebusiness.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.yaokun.movebusiness.BuildConfig;
import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.data.RemoteRepository;
import com.yaokun.movebusiness.entity.User;
import com.yaokun.movebusiness.utils.GsonUtils;
import com.yaokun.movebusiness.utils.PhoneUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 登陆页面
 * <p>
 * auth： yk
 * date：2022/2/18
 */
public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText usernameEt;
    private EditText passwordEt;
    private Button loginBtn;
    private ImageView showPwdIv;

    private LinearLayout networkLoadingLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEt = findViewById(R.id.username);
        passwordEt = findViewById(R.id.pwd);
        loginBtn = findViewById(R.id.login);
        showPwdIv = findViewById(R.id.showPwd);
        networkLoadingLL = findViewById(R.id.networkLoading);

        // Test
        if (BuildConfig.DEBUG) {
            usernameEt.setText("18096051254");
            passwordEt.setText("123456");
        }

        usernameEt.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkUsername(editable.toString());
            }
        });


        showPwdIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showPwdIv.isSelected()) {
                    showPwdIv.setSelected(false);
                    passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    showPwdIv.setSelected(true);
                    passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();

                // 1. 判断用户名密码是否正确
                if (!PhoneUtils.checkPhone(username)) {
                    Toast.makeText(getApplicationContext(), "用户名输入不正确", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(getApplicationContext(), "登陆中", Toast.LENGTH_SHORT).show();

                showNetworkLoading();

                RemoteRepository.login(username, password, new Callback() {
                    @Override
                    // 请求失败
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "登陆失败: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                hideNetworkLoading();
                            }

                        });


                    }

                    @Override
                    // 请求成功
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        try {
                            String json = response.body().string();
                            User user = GsonUtils.fromJson(json, User.class);
                            Log.d(TAG, user.toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    hideNetworkLoading();
                                    Toast.makeText(getApplicationContext(), "登陆成功: " + user.getName(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    String inputText = usernameEt.getText().toString();
                                    intent.putExtra("data",inputText);
                                    LoginActivity.this.startActivity(intent);
                                    finish();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d(TAG, "登陆失败：未知异常");
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUsername(usernameEt.getText().toString());
    }

    // 校验用户名设置icon
    private void checkUsername(String username) {
        if (PhoneUtils.checkPhone(username)) {
            // 3.符合显示正确图标不满足不显示
            usernameEt.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, getDrawable(R.mipmap.login_username_ic), null);
        } else {
            // 3.符合显示正确图标不满足不显示
            usernameEt.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        }
    }


    private void hideNetworkLoading() {
        networkLoadingLL.setVisibility(View.GONE);
    }

    private void showNetworkLoading() {
        networkLoadingLL.setVisibility(View.VISIBLE);
    }

    // 忘记密码
    public void forgetPwdClick(View view) {
        startActivity(new Intent(this, VerificationCodeActivity.class));
    }
}