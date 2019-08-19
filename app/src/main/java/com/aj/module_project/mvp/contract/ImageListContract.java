package com.aj.module_project.mvp.contract;

import com.aj.module_project.mvp.model.IModel;
import com.aj.module_project.mvp.model.entity.GankBaseResponse;
import com.aj.module_project.mvp.model.entity.GankItemBean;
import com.aj.module_project.mvp.presenter.IPresenter;
import com.aj.module_project.mvp.ui.IView;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author zhy
 * @time 2019/8/18.
 */
public interface ImageListContract  {

     interface View extends IView {
         void loadDataSuccess();
         void loadDataError();
    }

    interface Presenter extends IPresenter {
        void loadData();

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface Model extends IModel {
        Observable<GankBaseResponse<List<GankItemBean>>> getGirlList(int num, int page);
    }
}
