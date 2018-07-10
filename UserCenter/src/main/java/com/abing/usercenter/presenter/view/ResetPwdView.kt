package com.abing.usercenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-10 17:26
 * 修改人：Administrator
 * 修改时间：2018-7-10 17:26
 * 修改备注：
 * @version
 *
 */
/*
    重置密码 视图回调
 */
interface ResetPwdView : BaseView {

    fun onResetPwdResult(result:String)
}