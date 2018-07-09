package com.abing.usercenter.presenter

import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.usercenter.presenter.view.RegisterView
import com.abing.usercenter.service.UserService
import com.abing.baselibrary.ext.excute
import com.abing.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:26
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:26
 * 修改备注：
 * @version
 *
 */
/*
    用户注册Presenter
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService


    fun register(mobile: String,  verifyCode: String,pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.register(mobile,verifyCode, pwd).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onRegisterResult("注册成功")
            }
        }, lifecycleProvider)//

    }

}