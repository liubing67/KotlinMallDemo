package com.abing.ordercenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView
import com.abing.ordercenter.data.protocol.Order

/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}
