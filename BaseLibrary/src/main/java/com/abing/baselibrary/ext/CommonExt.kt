package com.abing.baselibrary.ext

import com.abing.baselibrary.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：//Kotlin通用扩展
 * 创建人：liubing
 * 创建时间：2018-7-6 17:56
 * 修改人：Administrator
 * 修改时间：2018-7-6 17:56
 * 修改备注：
 * @version
 *
 */
/*
    扩展Observable执行
 */
fun <T> rx.Observable<T>.excute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}