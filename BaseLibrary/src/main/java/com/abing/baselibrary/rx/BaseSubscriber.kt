package com.abing.baselibrary.rx

import rx.Subscriber

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 17:53
 * 修改人：Administrator
 * 修改时间：2018-7-6 17:53
 * 修改备注：
 * @version
 *
 */
open class BaseSubscriber<T> :Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
    }

    override fun onCompleted() {
    }
}