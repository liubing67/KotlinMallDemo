package com.abing.ordercenter.injection.component

import com.abing.baselibrary.injection.PerComponentScope
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.ordercenter.injection.module.OrderModule
import com.abing.ordercenter.ui.activity.OrderConfirmActivity
import com.abing.ordercenter.ui.activity.OrderDetailActivity
import com.abing.ordercenter.ui.fragment.OrderFragment
import dagger.Component

/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(OrderModule::class))
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
    fun inject(fragment: OrderFragment)

    fun inject(activity: OrderDetailActivity)
}
