package com.yaokun.movebusiness.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaokun.movebusiness.Adapter.RecordAdapter;
import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.entity.AuthRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆记录界面
 */
public class RecordActivity extends BaseActivity {
    private List<AuthRecord> authRecordList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization_details);
        initAuthRecord();//初始化
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecordAdapter adapter = new RecordAdapter(authRecordList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    private void initAuthRecord(){
        AuthRecord record = new AuthRecord("贵", "A12345", R.drawable.green_point, "在场", "无效");
        authRecordList.add(record);
        AuthRecord record1 = new AuthRecord("粤", "A12345", R.drawable.green_point, "在场", "有效");
        authRecordList.add(record1);

    }

}
