package com.abing.baselibrary.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.abing.baselibrary.common.BaseApplication
import com.abing.baselibrary.injection.component.ActivityComponent
import com.abing.baselibrary.injection.component.DaggerActivityComponent
import com.abing.baselibrary.injection.module.ActivityModule
import com.abing.baselibrary.injection.module.LifecycleProviderModule
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.presenter.view.BaseView
import com.abing.baselibrary.utils.DateUtils
import com.abing.baselibrary.widgets.ProgressLoading
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import org.jetbrains.anko.toast
import java.io.File
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:20
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:20
 * 修改备注：
 * @version
 *
 */
/*
    存在选择图片的Activity基础封装
 */
abstract open class BaseTakePhotoActivity<T : BasePresenter<*>> : BaseActivity(), BaseView, TakePhoto.TakeResultListener {

    private lateinit var mTakePhoto: TakePhoto

    private lateinit var mTempFile: File

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        mTakePhoto = TakePhotoImpl(this,this)
        mTakePhoto.onCreate(savedInstanceState)

        mLoadingDialog = ProgressLoading.create(this)
//        ARouter.getInstance().inject(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始化Activity Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
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
    override fun onError(text:String) {
        toast(text)
    }

    /*
        弹出选择框，默认实现
        可根据实际情况，自行修改
     */
    protected fun showAlertView() {
        AlertView("选择图片", "", "取消", null, arrayOf("拍照", "相册"), this,
                AlertView.Style.ActionSheet, OnItemClickListener { o, position ->
            mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(),false)
            when (position) {
                0 -> {
                    createTempFile()
                    mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                }
                1 -> mTakePhoto.onPickFromGallery()
            }
        }

        ).show()

    }

    /*
        获取图片，成功回调
     */
    override fun takeSuccess(result: TResult?) {
        Log.d("TakePhoto",result?.image?.originalPath)
        Log.d("TakePhoto",result?.image?.compressPath)
    }

    /*
        获取图片，取消回调
     */
    override fun takeCancel() {
    }

    /*
        获取图片，失败回调
     */
    override fun takeFail(result: TResult?, msg: String?) {
        Log.e("takePhoto",msg)
    }

    /*
        TakePhoto默认实现
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode,resultCode,data)
    }

    /*
        新建临时文件
     */
    fun createTempFile(){
        val tempFileName = "${DateUtils.curTime}.png"
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            this.mTempFile = File(Environment.getExternalStorageDirectory(),tempFileName)
            return
        }

        this.mTempFile = File(filesDir,tempFileName)
    }
}
