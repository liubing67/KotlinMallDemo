package com.abing.baselibrary.ui.activity

import android.os.Bundle
import com.abing.baselibrary.common.BaseApplication
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.baselibrary.injection.component.DaggerActivityComponent
import com.abing.baselibrary.injection.module.ActivityModule
import com.abing.baselibrary.injection.module.LifecycleProviderModule
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.presenter.view.BaseView
import com.abing.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject
/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 16:12
 * 修改人：Administrator
 * 修改时间：2018-7-6 16:12
 * 修改备注：
 * @version
 *
 */
/*
    Activity基类，业务相关
*/
abstract open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)
        //ARouter注册
//        ARouter.getInstance().inject(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始Activity Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    /*
        显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(text: String) {
        toast(text)
    }
}