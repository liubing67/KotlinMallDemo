package com.abing.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.abing.baselibrary.ext.enable
import com.abing.baselibrary.ext.onClick
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.usercenter.R
import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.injection.component.DaggerUserComponent
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.presenter.LoginPresenter
import com.abing.usercenter.presenter.view.LoginView
import com.abing.usercenter.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-9 17:19
 * 修改人：Administrator
 * 修改时间：2018-7-9 17:19
 * 修改备注：
 * @version
 *
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginView, View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()

    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
    override fun onLoginResult(result: UserInfo) {
        toast(result.toString())
        UserPrefsUtils.putUserInfo(result)
        finish()
    }

    fun initView(){
        mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        mLoginBtn.enable(mPwdEt,{isBtnEnable()})

        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
        mForgetPwdTv.onClick(this)
    }
    /*
    实现点击事件
     */
    override fun onClick(v: View) {
       when(v.id){
           R.id.mLoginBtn->{
               mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
           }

           R.id.mRightTv->{
               startActivity<RegisterActivity>()
           }

           R.id.mForgetPwdTv->{
               startActivity<ForgetPwdActivity>()
           }
       }
    }
    /*
        判断按钮是否可用
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}