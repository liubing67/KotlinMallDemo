package com.abing.usercenter.ui.activity

import android.os.Bundle
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.presenter.view.BaseView
import com.abing.baselibrary.ui.activity.BaseMvpActivity
import com.abing.usercenter.R
import com.abing.usercenter.presenter.RegisterPresenter
import com.abing.usercenter.presenter.view.RegisterView

/**
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:25
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:25
 * 修改备注：
 */
class RegisterActivity:BaseMvpActivity<RegisterPresenter>(),RegisterView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

}
