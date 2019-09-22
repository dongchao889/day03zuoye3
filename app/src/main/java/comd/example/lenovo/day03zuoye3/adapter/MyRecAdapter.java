package comd.example.lenovo.day03zuoye3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.R;
import comd.example.lenovo.day03zuoye3.bean.Bean;

/**
 * Created by lenovo on 2019/9/22.
 */

public class MyRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Bean.BodyBean.ResultBean> list;
    private Context context;

    public MyRecAdapter(ArrayList<Bean.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);
        return new MyHolerl(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyHolerl holerl= (MyHolerl) holder;
        RequestOptions crop = new RequestOptions().circleCrop();
        Glide.with(context).load(list.get(position).getTeacherPic()).apply(crop).into(holerl.iv);
        holerl.tv1.setText(list.get(position).getTeacherName());
        holerl.tv2.setText(list.get(position).getTitle());
        holerl.tv3.setText(list.get(position).getID()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick!=null){
                    onclick.onclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolerl extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public MyHolerl(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.item1_iv);
            tv1=itemView.findViewById(R.id.item1_tv1);
            tv2=itemView.findViewById(R.id.item1_tv2);
            tv3=itemView.findViewById(R.id.item1_tv3);
        }
    }
    public interface Onclick{
        void onclick(int position);
    }
    private Onclick onclick;

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }
}
