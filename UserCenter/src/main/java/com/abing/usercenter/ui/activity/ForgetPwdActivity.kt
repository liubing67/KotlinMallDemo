package com.abing.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.abing.baselibrary.ext.enable
import com.abing.baselibrary.ext.onClick
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.baselibrary.utils.MD5Util
import com.abing.usercenter.R
import com.abing.usercenter.injection.component.DaggerUserComponent
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.presenter.ForgetPwdPresenter
import com.abing.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-10 11:52
 * 修改人：Administrator
 * 修改时间：2018-7-10 11:52
 * 修改备注：
 * @version
 *
 */
class ForgetPwdActivity: BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()

    }
    fun initView(){

        mNextBtn.enable(mMobileEt,{isBtnEnable()})
        mNextBtn.enable(mVerifyCodeEt,{isBtnEnable()})

        mVerifyCodeBtn.onClick(this)
        mNextBtn.onClick(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()

                mPresenter.forgetPwd("17321436171","udid","android", MD5Util.getMD5("17321436171" + "udid" + "android"))
            }

            R.id.mNextBtn -> {
                startActivity<ResetPwdActivity>("mobile" to "17321436171","authcode" to mVerifyCodeEt.text.toString())
            }
        }
    }
    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
    /*
        忘记密码回调
     */
    override fun onForgetPwdResult(result: String) {
        toast(result)
    }
    /*
       判断按钮是否可用
    */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }
}