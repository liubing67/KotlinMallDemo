package com.abing.demo.common

import cn.jpush.android.api.JPushInterface
import com.abing.baselibrary.common.BaseApplication

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 11:02
 * 修改人：Administrator
 * 修改时间：2018-7-11 11:02
 * 修改备注：
 * @version
 *
 */
/*
    主工程 Application
 */
class MainApplication: BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }
}