package com.abing.ordercenter.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.abing.baselibrary.ui.activity.BaseActivity
import com.abing.ordercenter.R
import com.abing.ordercenter.common.OrderConstant
import com.abing.ordercenter.common.OrderStatus
import com.abing.ordercenter.ui.adapter.OrderVpAdapter
import kotlinx.android.synthetic.main.activity_order.*

/*
    订单Activity
    主要包括不同订单状态的Fragment
 */
class OrderActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mOrderTab.tabMode = TabLayout.MODE_FIXED
        mOrderVp.adapter = OrderVpAdapter(supportFragmentManager,this)
        mOrderTab.setupWithViewPager(mOrderVp)

        //根据订单状态设置当前页面
        mOrderVp.currentItem = intent.getIntExtra(OrderConstant.KEY_ORDER_STATUS, OrderStatus.ORDER_ALL)
    }
}
