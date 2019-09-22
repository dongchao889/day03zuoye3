package comd.example.lenovo.day03zuoye3;

import comd.example.lenovo.day03zuoye3.bean.Bean;
import comd.example.lenovo.day03zuoye3.bean.Data;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by lenovo on 2019/9/22.
 */

public interface ApiService {
    String uri="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<Bean> getJson();

    String taburi="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/teacher/getTeacherPower/{ID}")
    Observable<Data> getData(@Path("ID") int id);

}
