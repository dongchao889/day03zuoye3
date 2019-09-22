package comd.example.lenovo.day03zuoye3.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.bean.Data;

/**
 * Created by lenovo on 2019/9/22.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list1;
   private ArrayList<Data.BodyBean.ResultBean> da;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> list1, ArrayList<Data.BodyBean.ResultBean> da) {
        super(fm);
        this.list1 = list1;
        this.da = da;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list1.get(position);
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return da.get(position).getDescription();
    }
}
