package com.abing.baselibrary.common

import android.app.Application
import android.content.Context
import com.abing.baselibrary.injection.module.AppModule

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:56
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:56
 * 修改备注：
 * @version
 *
 */
/*
    Application 基类
 */
open class BaseApplication : Application() {

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

//        initAppInjection()

        context = this

//        //ARouter初始化
//        ARouter.openLog()    // 打印日志
//        ARouter.openDebug()
//        ARouter.init(this)
    }

//    /*
//        Application Component初始化
//     */
//    private fun initAppInjection() {
//        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
//    }

    /*
        全局伴生对象
     */
    companion object {
        lateinit var context: Context
    }
}
