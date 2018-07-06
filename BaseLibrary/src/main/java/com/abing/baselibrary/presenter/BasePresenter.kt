package com.abing.baselibrary.presenter

import android.content.Context
import com.abing.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:08
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:08
 * 修改备注：
 */
open class BasePresenter<T: BaseView>{

    lateinit var mView:T

    //Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>


    @Inject
    lateinit var context: Context
}
