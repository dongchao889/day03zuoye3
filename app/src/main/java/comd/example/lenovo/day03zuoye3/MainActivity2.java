package comd.example.lenovo.day03zuoye3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.adapter.MyPagerAdapter;
import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;
import comd.example.lenovo.day03zuoye3.persenter.DataPer;
import comd.example.lenovo.day03zuoye3.view.DataView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, DataView {

    private Toolbar mTb2;
    private ImageView mItem1Iv;
    private TextView mItem1Tv1;
    private TextView mItem1Tv2;
    private TextView mItem1Tv3;
    private LinearLayout mLl;
    private TabLayout mTab;
    /**
     * ＞
     */
    private Button mBt;
    private DataPer dataPer;
    private ArrayList<Data.BodyBean.ResultBean> list;
    private String name;
    private String title;
    private int id;
    private String pic;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            RequestOptions crop = new RequestOptions().circleCrop();
            Glide.with(MainActivity2.this).load(pic).apply(crop).into(mItem1Iv);
            super.handleMessage(msg);
        }
    };
    private ViewPager mVp;
    private ArrayList<Fragment> list1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);
        dataPer = new DataPer(this);
        initView();

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMess(Bean.BodyBean.ResultBean bean) {
        name = bean.getTeacherName();
        title = bean.getTitle();
        id = bean.getID();
        pic = bean.getTeacherPic();
    }

    private void initView() {
        mTb2 = (Toolbar) findViewById(R.id.tb2);
        mItem1Iv = (ImageView) findViewById(R.id.item2_iv);
        mItem1Tv1 = (TextView) findViewById(R.id.item2_tv1);
        mItem1Tv2 = (TextView) findViewById(R.id.item2_tv2);
        mItem1Tv3 = (TextView) findViewById(R.id.item2_tv3);
        mItem1Tv1.setText(name);
        mItem1Tv2.setText(title);
        mItem1Tv3.setText(id + "");
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTab = (TabLayout) findViewById(R.id.tab);
        mTb2.setTitle("");
        setSupportActionBar(mTb2);
        mBt = (Button) findViewById(R.id.bt);
        handler.sendEmptyMessage(1);
        mBt.setOnClickListener(this);
        list = new ArrayList<>();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 100);
        dataPer.getMess(id);
        mVp = (ViewPager) findViewById(R.id.vp);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                finish();
                break;
        }
    }

    @Override
    public void getData(ArrayList<Bean.BodyBean.ResultBean> li) {

    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void getMess(ArrayList<Data.BodyBean.ResultBean> da) {
        list.addAll(da);
        list1 = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        HomeFragment2 homeFragment2 = new HomeFragment2();
        HomeFragment3 homeFragment3 = new HomeFragment3();
        if (da.size()==2){
            list1.add(homeFragment);
            list1.add(homeFragment2);
        }
        if (da.size()==3){
            list1.add(homeFragment);
            list1.add(homeFragment2);
            list1.add(homeFragment3);
        }
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), list1, da);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
    }


}
