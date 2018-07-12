package com.abing.goodscenter.ui.activity

import android.os.Bundle
import com.abing.baselibrary.ui.activity.BaseActivity
import com.abing.goodscenter.R
import com.abing.goodscenter.ui.fragment.CartFragment

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-12 9:43
 * 修改人：Administrator
 * 修改时间：2018-7-12 9:43
 * 修改备注：
 * @version
 *
 */
/*
    购物车Activity
    只是Fragment一个壳
 */
class CartActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_cart)
        (fragment as CartFragment).setBackVisible(true)

    }
}
