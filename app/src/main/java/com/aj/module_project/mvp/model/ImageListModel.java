package com.aj.module_project.mvp.model;

import com.aj.module_project.api.Api;
import com.aj.module_project.mvp.contract.ImageListContract;
import com.aj.module_project.mvp.model.entity.GankBaseResponse;
import com.aj.module_project.mvp.model.entity.GankItemBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zhy
 * @time 2019/8/20.
 */
public class ImageListModel implements ImageListContract.Model {
    @Override
    public Observable<GankBaseResponse<List<GankItemBean>>> getGirlList(int num, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                //设置数据解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .baseUrl("http://gank.io")
                .build();
// 创建网络请求接口的实例
        Api mApi = retrofit.create(Api.class);

        return  mApi.getGirlList(num,page);
    }
}
