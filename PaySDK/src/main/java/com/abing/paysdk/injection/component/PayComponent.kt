package com.abing.paysdk.injection.component

import com.abing.baselibrary.injection.PerComponentScope
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.paysdk.injection.module.PayModule
import com.abing.paysdk.ui.activity.CashRegisterActivity
import dagger.Component

/*
    支付Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(PayModule::class))
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}
