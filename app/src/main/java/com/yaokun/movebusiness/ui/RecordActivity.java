package com.yaokun.movebusiness.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.yaokun.movebusiness.Adapter.RecordAdapter;
import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.data.RemoteRepository;
import com.yaokun.movebusiness.entity.AuthRecord;
import com.yaokun.movebusiness.utils.GsonUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 车辆记录界面
 */
public class RecordActivity extends BaseActivity {

    //创建集合
    private List<AuthRecord> authRecordList = new ArrayList<>();

    private RecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization_details);

        //搜索
        SearchView searchView = findViewById(R.id.search);
        searchView.setIconifiedByDefault(false);
//        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e(tag, "onQueryTextSubmit: " + query);
                getAuthRecordList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e(tag, "onQueryTextChange: " + newText);
                return false;
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new RecordAdapter(authRecordList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecordAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.e(tag, "onItemClick: " + position);
                Intent intent = new Intent(RecordActivity.this, AuthDetailsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View v, int position) {
                Log.e(tag, "onItemLongClick: " + position);
            }
        });

        //获取item
        getAuthRecordList("");

    }

    // 获取停车记录
    private void getAuthRecordList(String park) {

        RemoteRepository.getAuthList(park, new Callback() {
            @Override
            // 请求失败
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "登陆失败: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });


            }

            @Override
            // 请求成功
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    String json = response.body().string();

                    Log.d(tag, json);
                    Type type = new TypeToken<List<AuthRecord>>(){}.getType();
                    List<AuthRecord> record = GsonUtils.fromJson(json,  type);

                    if (record!=null && record.size()>0) {
                        authRecordList.clear();
                    }
                    authRecordList.addAll(record);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });



                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(tag, "请求失败：未知异常");
                }
            }
        });

    }
}