package com.abing.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.abing.baselibrary.common.AppManager
import com.abing.baselibrary.ext.enable
import com.abing.baselibrary.ext.onClick
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.usercenter.R
import com.abing.usercenter.injection.component.DaggerUserComponent
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.presenter.RegisterPresenter
import com.abing.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * 项目名称：KotlinMallDemo
 * 类描述：注册页面
 * 创建人：liubing
 * 创建时间：2018-7-6 16:25
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:25
 * 修改备注：
 */
class RegisterActivity:BaseMvpActivity<RegisterPresenter>(),RegisterView, View.OnClickListener {

    private var pressTime:Long = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()

    }

    /*
        Dagger注册
     */
    override fun injectComponent() {

        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView=this
    }
    /*
    初始化视图
     */
    private fun initView(){
        mRegisterBtn.enable(mMobileEt,{isBtnEnable()})
        mRegisterBtn.enable(mVerifyCodeEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdConfirmEt,{isBtnEnable()})


        mRegisterBtn.onClick(this)
        mVerifyCodeBtn.onClick(this)

    }

    /*
        注册回调
     */
    override fun onRegisterResult(result: String) {
        toast(result)
    }
    /*
       点击事件
    */
    override fun onClick(v: View) {
       when(v.id){
           R.id.mRegisterBtn->{
               mPresenter.register(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
           }
           R.id.mVerifyCodeBtn->{
               mVerifyCodeBtn.requestSendVerifyNumber()
               toast("发送验证成功")
           }
       }
    }

    override fun onBackPressed() {
        val time=System.currentTimeMillis()
        if(time-pressTime>2000){
            toast("再按一次退出程序")
            pressTime=time
        }else{
            AppManager.instance.exitApp(this);
        }
    }

    /*
    判断按钮是否可用
     */

    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not()&&
                mVerifyCodeEt.text.isNullOrEmpty().not()&&
                mPwdEt.text.isNullOrEmpty().not()&&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
