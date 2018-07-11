package com.abing.usercenter.data.api

import com.abing.baselibrary.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:30
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:30
 * 修改备注：
 * @version
 *
 */
/*
    上传相关 接口
 */
interface UploadApi {

    /*
        获取七牛云上传凭证
     */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}
