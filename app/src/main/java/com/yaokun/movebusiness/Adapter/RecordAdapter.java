package com.yaokun.movebusiness.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.entity.AuthRecord;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    //创建授权记录实体集合
    private List<AuthRecord> mAuthRecordList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AuthRecord record = mAuthRecordList.get(position);
        holder.provinceTv.setText(record.getProvince());
        holder.carNumTv.setText(record.getCarNum());
        holder.isPresenceIcIv.setImageResource(record.getIsPresenceIc());
        holder.isPresenceTv.setText(record.getIsPresence());
        holder.isEffectiveTv.setText(record.getIsEffective());
    }

    @Override
    public int getItemCount() {
        return mAuthRecordList.size();
    }

    //创建内部类ViewHolder 通过RecyclerView子项的外层布局 通过FindViewById()获取布局中的实例
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView provinceTv;
        TextView carNumTv;
        ImageView isPresenceIcIv;
        TextView isPresenceTv;
        TextView isEffectiveTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            provinceTv = itemView.findViewById(R.id.ProvinceTv);
            carNumTv = itemView.findViewById(R.id.carNumTv);
            isPresenceIcIv = itemView.findViewById(R.id.isPresenceIv);
            isPresenceTv = itemView.findViewById(R.id.isPresenceTv);
            isEffectiveTv = itemView.findViewById(R.id.isEffectiveTv);

        }
    }

    public RecordAdapter(List<AuthRecord> authRecordList) {
        mAuthRecordList = authRecordList;
    }

}
