package com.abing.baselibrary.injection.module

import android.app.Activity
import com.abing.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 11:05
 * 修改人：Administrator
 * 修改时间：2018-7-7 11:05
 * 修改备注：
 * @version
 *
 */
/*
    Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}
