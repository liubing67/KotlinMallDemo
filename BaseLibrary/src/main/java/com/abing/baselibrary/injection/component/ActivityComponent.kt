package com.abing.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.abing.baselibrary.injection.ActivityScope
import com.abing.baselibrary.injection.module.ActivityModule
import com.abing.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

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
    Activity级别Component
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {

    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}
