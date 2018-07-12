package com.abing.messagecenter.injection.component


import com.abing.baselibrary.injection.PerComponentScope
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.messagecenter.injection.module.MessageModule
import com.abing.messagecenter.ui.fragment.MessageFragment
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(MessageModule::class))
interface MessageComponent{
    fun inject(fragment: MessageFragment)
}
