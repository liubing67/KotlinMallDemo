package com.abing.usercenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-10 11:54
 * 修改人：Administrator
 * 修改时间：2018-7-10 11:54
 * 修改备注：
 * @version
 *
 */
/*
    忘记密码 视图回调
 */
interface ForgetPwdView : BaseView {

    /*
        忘记密码回调
     */
    fun onForgetPwdResult(result:String)
}
