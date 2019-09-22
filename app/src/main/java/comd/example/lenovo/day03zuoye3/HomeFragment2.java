package comd.example.lenovo.day03zuoye3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import comd.example.lenovo.day03zuoye3.adapter.MyAdapter;
import comd.example.lenovo.day03zuoye3.bean.Bean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment2 extends Fragment {


    private View view;
    private RecyclerView mRe2;
    private ArrayList<Bean.BodyBean.ResultBean> list;
    private MyAdapter adapter;

    public HomeFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRe2 = (RecyclerView) view.findViewById(R.id.re2);
        mRe2.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();

        adapter = new MyAdapter(list, getContext());
        mRe2.setAdapter(adapter);
        initData();
    }

    private void initData() {
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
                        list.addAll(beanList);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
