package com.abing.usercenter.injection.component

import com.abing.baselibrary.injection.PerComponentScope
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 19:06
 * 修改人：Administrator
 * 修改时间：2018-7-7 19:06
 * 修改备注：
 */
/*
    用户模块Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))//
interface UserComponent {
    fun inject(activity: RegisterActivity)
}
