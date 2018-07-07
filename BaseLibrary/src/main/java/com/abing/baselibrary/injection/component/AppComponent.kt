package com.abing.baselibrary.injection.component

import android.content.Context
import com.abing.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 19:08
 * 修改人：Administrator
 * 修改时间：2018-7-7 19:08
 * 修改备注：
 * @version
 *
 */
/*
    Application级别Component
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context(): Context
}
