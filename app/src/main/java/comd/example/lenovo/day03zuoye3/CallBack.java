package comd.example.lenovo.day03zuoye3;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface CallBack {
    void Sussecc1(ArrayList<Bean.BodyBean.ResultBean> lis);
    void Fuil(String  st);
    void getMess(ArrayList<Data.BodyBean.ResultBean> da);
}
