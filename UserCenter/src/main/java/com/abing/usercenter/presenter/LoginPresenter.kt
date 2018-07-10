package com.abing.usercenter.presenter

import com.abing.baselibrary.ext.excute
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.presenter.view.LoginView
import com.abing.usercenter.service.UserService
import com.abing.usercenter.ui.activity.LoginActivity
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述： 用户登录Presenter
 * 创建人：liubing
 * 创建时间：2018-7-9 17:23
 * 修改人：Administrator
 * 修改时间：2018-7-9 17:23
 * 修改备注：
 * @version
 *
 */
class LoginPresenter @Inject constructor(): BasePresenter<LoginView>() {


    @Inject
    lateinit var userService:UserService

    /*
    登录
     */
    fun login(mobile:String,pwd:String,pushId:String){
        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.login(mobile,pwd,pushId).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t:UserInfo) {
                mView.onLoginResult(t)
            }
        },lifecycleProvider)
    }
}