package comd.example.lenovo.day03zuoye3.view;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface DataView {
    void getData(ArrayList<Bean.BodyBean.ResultBean> li);
    void showToast(String s);
    void getMess(ArrayList<Data.BodyBean.ResultBean> da);
}
