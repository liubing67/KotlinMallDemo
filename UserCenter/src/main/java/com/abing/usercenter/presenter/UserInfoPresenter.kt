package com.abing.usercenter.presenter

import com.abing.baselibrary.ext.excute
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.presenter.view.UserInfoView
import com.abing.usercenter.service.UploadService
import com.abing.usercenter.service.UserService
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:24
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:24
 * 修改备注：
 * @version
 *
 */
/*
    编辑用户资料Presenter
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var userService:UserService

    @Inject
    lateinit var uploadService: UploadService

    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(){
        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        uploadService.getUploadToken().excute(object :BaseSubscriber<String>(mView){
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        },lifecycleProvider)
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        if (!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        },lifecycleProvider)
    }

}