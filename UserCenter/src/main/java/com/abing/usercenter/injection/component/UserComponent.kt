package com.abing.usercenter.injection.component

import com.abing.baselibrary.injection.PerComponentScope
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.usercenter.ui.activity.RegisterActivity
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.ui.activity.ForgetPwdActivity
import com.abing.usercenter.ui.activity.LoginActivity
import com.abing.usercenter.ui.activity.ResetPwdActivity
import dagger.Component

/*
    用户模块Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))//
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
//    fun inject(activity:UserInfoActivity)
}
