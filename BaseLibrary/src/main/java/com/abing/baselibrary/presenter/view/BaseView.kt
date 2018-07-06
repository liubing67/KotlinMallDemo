package com.abing.baselibrary.presenter.view

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:09
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:09
 * 修改备注：
 * @version
 *
 */
interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun onError(text:String)
}