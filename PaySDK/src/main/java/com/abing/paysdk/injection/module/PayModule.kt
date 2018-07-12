package com.abing.paysdk.injection.module

import com.abing.paysdk.service.PayService
import com.abing.paysdk.service.impl.PayServiceImpl
import dagger.Module
import dagger.Provides

/*
    支付 Module
 */
@Module
class PayModule {

    @Provides
    fun providePayService(payService: PayServiceImpl): PayService {
        return payService
    }

}
