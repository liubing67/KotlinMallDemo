package com.abing.usercenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView
import com.abing.usercenter.data.protocol.UserInfo

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
    编辑用户资料 视图回调
 */
interface UserInfoView : BaseView {

    /*
        获取上传凭证回调
     */
    fun onGetUploadTokenResult(result:String)

    /*
        编辑用户资料回调
     */
    fun onEditUserResult(result: UserInfo)
}
