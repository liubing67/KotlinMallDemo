package com.abing.usercenter.presenter

import com.abing.baselibrary.ext.excute
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.presenter.view.ForgetPwdView
import com.abing.usercenter.presenter.view.LoginView
import com.abing.usercenter.service.UserService
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-10 11:53
 * 修改人：Administrator
 * 修改时间：2018-7-10 11:53
 * 修改备注：
 * @version
 *
 */
class ForgetPwdPresenter @Inject constructor(): BasePresenter<ForgetPwdView>()  {

    @Inject
    lateinit var userService:UserService

    /*
    忘记密码
     */
    fun forgetPwd(mobile: String, udid: String,type:String,sign:String){
        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.forgetPwd(mobile,udid,type,sign).excute(object : BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
//                if (t)
//                    mView.onForgetPwdResult("验证成功")
                    mView.onForgetPwdResult("验证成功"+t)
            }
        },lifecycleProvider)
    }
}