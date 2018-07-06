package com.abing.baselibrary.ui.activity

import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.presenter.view.BaseView

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:12
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:12
 * 修改备注：
 * @version
 *
 */
open class BaseMvpActivity<T : BasePresenter<*>> :BaseActivity(),BaseView{


    override fun showLoading() {
    }

    override fun hideLoading() {
    }
    override fun onError(text: String) {
    }

    lateinit var mPresenter:T
}