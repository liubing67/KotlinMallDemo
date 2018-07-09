package com.abing.baselibrary.injection.module

import android.app.Activity
import com.abing.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

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
