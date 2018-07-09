package com.abing.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.abing.baselibrary.injection.ActivityScope
import com.abing.baselibrary.injection.module.ActivityModule
import com.abing.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/*
    Activity级别Component
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {

    fun activity():Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}
