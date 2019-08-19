package com.aj.module_project.mvp.presenter;

import android.util.Log;

import com.aj.module_project.api.Api;
import com.aj.module_project.mvp.contract.ImageListContract;
import com.aj.module_project.mvp.model.entity.GankBaseResponse;
import com.aj.module_project.mvp.model.entity.GankItemBean;
import com.aj.module_project.mvp.ui.IView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zhy
 * @time 2019/8/18.
 */
public class ImageLoadPresenter extends BasePresenter<ImageListContract.Model,ImageListContract.View> {


    @Override
    public void destroy() {

    }


    public void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                //设置数据解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .baseUrl("http://gank.io")
                .build();
// 创建网络请求接口的实例
        Api mApi = retrofit.create(Api.class);
        mApi.getGirlList(2,1)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankBaseResponse<List<GankItemBean>>>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("test", "onSubscribe");
                    }

                    @Override
                    public void onNext(GankBaseResponse<List<GankItemBean>> listGankBaseResponse) {
                        Log.d("test",listGankBaseResponse.getResults().get(0).get_id() + "");
                        view.loadDataSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test", "onError" + e.getMessage());
                        view.loadDataError();
                    }

                    @Override
                    public void onComplete() {
                        Log.d("test", "onComplete");
                    }
                })
              ;

    }
}
