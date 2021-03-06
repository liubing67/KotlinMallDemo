package com.abing.baselibrary.rx

import android.util.Log
import com.abing.baselibrary.presenter.view.BaseView
import rx.Subscriber

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：Rx订阅者默认实现
 * 创建人：liubing
 * 创建时间：2018-7-6 17:53
 * 修改人：Administrator
 * 修改时间：2018-7-6 17:53
 * 修改备注：
 * @version
 *
 */
open class BaseSubscriber<T> (val baseView: BaseView):Subscriber<T>() {

    override fun onStart() {
        baseView.showLoading()
    }
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if(e is BaseException){
            baseView.onError(e.rtMsrg)
        }else{
            baseView.onError(e.toString())
            Log.e("----------------",e.toString());
        }
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }
}