package com.abing.usercenter.presenter

import com.abing.baselibrary.ext.excute
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.usercenter.presenter.view.ResetPwdView
import com.abing.usercenter.service.UserService
import javax.inject.Inject

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
    重置密码Presenter
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>(){


    @Inject
    lateinit var userService: UserService


    /*
        重置密码
     */
    fun resetPwd(mobile: String, newpwd: String, confirmpwd: String, udid: String, type: String, authcode: String, sign: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.resetPwd(mobile, newpwd, confirmpwd, udid, type, authcode, sign).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onResetPwdResult("重置密码成功")
            }
        }, lifecycleProvider)

    }
}