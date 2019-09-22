package comd.example.lenovo.day03zuoye3.persenter;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.CallBack;
import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;
import comd.example.lenovo.day03zuoye3.model.DataModel;
import comd.example.lenovo.day03zuoye3.view.DataView;

/**
 * Created by lenovo on 2019/9/22.
 */

public class DataPer implements CallBack{
    private DataView dataView;
    private DataModel dataModel;

    public DataPer(DataView dataView) {
        this.dataView = dataView;
        this.dataModel=new DataModel();
    }

    public void getData() {
        dataModel.getData(this);
    }

    @Override
    public void Sussecc1(ArrayList<Bean.BodyBean.ResultBean> lis) {
        dataView.getData(lis);
    }

    @Override
    public void Fuil(String st) {
        dataView.showToast(st);
    }

    @Override
    public void getMess(ArrayList<Data.BodyBean.ResultBean> da) {
            dataView.getMess(da);
    }

    public void getMess(int id) {
        dataModel.getMess(this,id);
    }
}
