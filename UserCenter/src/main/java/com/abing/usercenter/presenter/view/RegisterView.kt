package com.abing.usercenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:28
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:28
 * 修改备注：
 * @version
 *
 */
/*
    用户注册 视图回调
 */
interface RegisterView:BaseView {

    fun onRegisterResult(result:String)
}