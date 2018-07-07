package com.abing.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.usercenter.R
import com.abing.usercenter.presenter.RegisterPresenter
import com.abing.usercenter.presenter.view.RegisterView
import com.abing.baselibrary.ext.onClick
import com.abing.usercenter.injection.component.DaggerUserComponent
import com.abing.usercenter.injection.module.UserModule
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
import javax.inject.Inject

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
        mRegisterBtn.onClick(this)
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
       }
    }
}
