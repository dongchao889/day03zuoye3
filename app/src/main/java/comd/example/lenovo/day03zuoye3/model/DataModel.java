package comd.example.lenovo.day03zuoye3.model;

import java.util.ArrayList;
import java.util.List;

import comd.example.lenovo.day03zuoye3.ApiService;
import comd.example.lenovo.day03zuoye3.CallBack;
import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;
import comd.example.lenovo.day03zuoye3.persenter.DataPer;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2019/9/22.
 */

public class DataModel {
    public void getData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.uri)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<Bean> observable = retrofit.create(ApiService.class).getJson();
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        ArrayList<Bean.BodyBean.ResultBean> beanList = (ArrayList<Bean.BodyBean.ResultBean>) bean.getBody().getResult();
                        callBack.Sussecc1(beanList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.Fuil(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getMess(final CallBack callBack, int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.taburi)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<Data> data = retrofit.create(ApiService.class).getData(id);
        data.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Data data) {
                        ArrayList<Data.BodyBean.ResultBean> result = (ArrayList<Data.BodyBean.ResultBean>) data.getBody().getResult();

                        callBack.getMess(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.Fuil(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
