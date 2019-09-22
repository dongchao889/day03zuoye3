package comd.example.lenovo.day03zuoye3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.adapter.MyRecAdapter;
import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;
import comd.example.lenovo.day03zuoye3.persenter.DataPer;
import comd.example.lenovo.day03zuoye3.view.DataView;

public class MainActivity extends AppCompatActivity implements DataView{

    /**
     * 名师推荐
     */
    private TextView mTv;
    private Toolbar mTb;
    private RecyclerView mRe;
    private NavigationView mNav;
    private DrawerLayout mDl;
    private DataPer dataPer;
    private ArrayList<Bean.BodyBean.ResultBean> list;
    private MyRecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataPer = new DataPer(this);
        initView();

    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mTb = (Toolbar) findViewById(R.id.tb);
        mRe = (RecyclerView) findViewById(R.id.re);
        mNav = (NavigationView) findViewById(R.id.nav);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mTb.setTitle("");
        setSupportActionBar(mTb);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        mRe.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mTb, R.string.app_name, R.string.app_name);
        mDl.addDrawerListener(toggle);
        toggle.syncState();
        list = new ArrayList<>();
        adapter = new MyRecAdapter(list, this);
        mRe.setAdapter(adapter);
        dataPer.getData();
        adapter.setOnclick(new MyRecAdapter.Onclick() {
            @Override
            public void onclick(int position) {
                int id = list.get(position).getID();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("id",id);
                EventBus.getDefault().postSticky(list.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void getData(ArrayList<Bean.BodyBean.ResultBean> li) {
            list.addAll(li);
            adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMess(ArrayList<Data.BodyBean.ResultBean> da) {

    }
}
