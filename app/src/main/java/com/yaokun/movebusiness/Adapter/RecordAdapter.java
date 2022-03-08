package com.yaokun.movebusiness.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.yaokun.movebusiness.R;
import com.yaokun.movebusiness.entity.AuthRecord;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    //创建授权记录实体集合
    private List<AuthRecord> mAuthRecordList;
    private OnItemClickListener mOnItemClickListener;//声明自定义的接口


    //创建内部类ViewHolder 通过RecyclerView子项的外层布局 通过FindViewById()获取布局中的实例
    static class ViewHolder extends RecyclerView.ViewHolder {
        View myView;
        TextView provinceTv;
        TextView carNumTv;
        ImageView isPresenceIcIv;
        TextView isPresenceTv;
        TextView isEffectiveTv;

        TextView parkingInfo;
        TextView startTimeInfo;
        TextView endTimeInfo;
        TextView bindingStatusInfo;
        TextView remarksInfo;


        public ViewHolder(View view) {
            super(view);
            myView = view.findViewById(R.id.takeView);
            provinceTv = view.findViewById(R.id.ProvinceTv);
            carNumTv = view.findViewById(R.id.carNumTv);
            isPresenceIcIv = view.findViewById(R.id.isPresenceIv);
            isPresenceTv = view.findViewById(R.id.isPresenceTv);
            isEffectiveTv = view.findViewById(R.id.isEffectiveTv);

            parkingInfo = view.findViewById(R.id.parkingInfo);
            startTimeInfo = view.findViewById(R.id.startTimeInfo);
            endTimeInfo= view.findViewById(R.id.endTimeInfo);
            bindingStatusInfo = view.findViewById(R.id.bindingStatusInfo);
            remarksInfo = view.findViewById(R.id.remarksInfo);

        }
    }

    public RecordAdapter(List<AuthRecord> authRecordList) {
        mAuthRecordList = authRecordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                mOnItemClickListener.onItemClick(v, position);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                mOnItemClickListener.onItemLongClick(v, position);
                return true;
            }
        });
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
        holder.parkingInfo.setText(record.getParkingInfo());
        holder.startTimeInfo.setText(record.getStartTimeInfo());
        holder.endTimeInfo.setText(record.getEndTimeInfo());
        holder.bindingStatusInfo.setText(record.getBindingStatusInfo());
        holder.remarksInfo.setText(record.getRemarksInfo());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(, RecordDetailsActivity.class);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mAuthRecordList.size();
    }


    //定义方法并传给外面的使用者
    public void setOnItemClickListener(OnItemClickListener  listener) {
        this.mOnItemClickListener = listener;
    }

    //自定义一个回调接口来实现Click和LongClick事件
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }


}
