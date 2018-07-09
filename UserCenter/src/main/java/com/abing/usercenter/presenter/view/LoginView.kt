package com.abing.usercenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView
import com.abing.usercenter.data.protocol.UserInfo

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述： 用户登录 视图回调
 * 创建人：liubing
 * 创建时间：2018-7-9 17:21
 * 修改人：Administrator
 * 修改时间：2018-7-9 17:21
 * 修改备注：
 * @version
 *
 */
interface LoginView:BaseView{
    fun onLoginResult(result:UserInfo)
}