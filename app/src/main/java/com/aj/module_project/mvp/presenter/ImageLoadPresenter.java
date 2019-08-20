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


    public ImageLoadPresenter(ImageListContract.Model model, ImageListContract.View view) {
        super(model, view);
    }

    @Override
    public void destroy() {

    }


    public void loadData() {

        model.getGirlList(1,2).subscribeOn(Schedulers.io())
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
