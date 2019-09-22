package comd.example.lenovo.day03zuoye3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.R;
import comd.example.lenovo.day03zuoye3.bean.Bean;

/**
 * Created by lenovo on 2019/9/22.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Bean.BodyBean.ResultBean> list;
    private Context context;

    public MyAdapter(ArrayList<Bean.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item2, parent, false);
        return new MyHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MyHoldel holdel= (MyHoldel) holder;
            holdel.tv.setText(list.get(position).getTeacherName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHoldel extends RecyclerView.ViewHolder {
        private TextView tv;
        public MyHoldel(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv1);
        }
    }
}
