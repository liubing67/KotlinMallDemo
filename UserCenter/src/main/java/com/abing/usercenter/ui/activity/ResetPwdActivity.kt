package com.abing.usercenter.ui.activity

import android.os.Bundle
import com.abing.baselibrary.ext.enable
import com.abing.baselibrary.ext.onClick
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.baselibrary.utils.MD5Util
import com.abing.usercenter.R
import com.abing.usercenter.injection.component.DaggerUserComponent
import com.abing.usercenter.injection.module.UserModule
import com.abing.usercenter.presenter.ResetPwdPresenter
import com.abing.usercenter.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-10 17:25
 * 修改人：Administrator
 * 修改时间：2018-7-10 17:25
 * 修改备注：
 * @version
 *
 */
class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)

        initView()

    }
    /*
        初始化视图
     */
    private fun initView() {

        mConfirmBtn.enable(mPwdEt,{isBtnEnable()})
        mConfirmBtn.enable(mPwdConfirmEt,{isBtnEnable()})

        mConfirmBtn.onClick {
//            if (mPwdEt.text.toString() != mPwdConfirmEt.text.toString()){
//                toast("密码不一致")
//                return@onClick
//            }
            mPresenter.resetPwd(intent.getStringExtra("mobile"),"888888","888888","udid","android",intent.getStringExtra("authcode"),MD5Util.getMD5("17321436171"+"888888"+"888888"+"udid"+"android"+intent.getStringExtra("authcode")))
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
       判断按钮是否可用
    */
    private fun isBtnEnable():Boolean{
        return mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

    /*
        重置密码回调
     */
    override fun onResetPwdResult(result: String) {
        toast(result)
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }
}