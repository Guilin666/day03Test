package bwie.example.com.day03test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.day03test.bean.ItemBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ItemBean> datas = new ArrayList<>();

    public MyAdapter(List<ItemBean> items, Context context) {
        this.context = context;
        this.datas = items;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.new_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_desc.setText(datas.get(i).getDesc());
        if (i % 2 == 0) {
            myViewHolder.tv_img.setImageURI(datas.get(i).getImage());
            myViewHolder.tv_img.setVisibility(View.VISIBLE);
            myViewHolder.tv_vv.setVisibility(View.GONE);

        } else {
            myViewHolder.tv_vv.setImageURI(datas.get(i).getImage());
            myViewHolder.tv_vv.setVisibility(View.VISIBLE);
            myViewHolder.tv_img.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_desc;
        SimpleDraweeView tv_img;
        SimpleDraweeView tv_vv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_img = itemView.findViewById(R.id.tv_img);
            tv_vv = itemView.findViewById(R.id.tv_vv);
        }
    }
}
