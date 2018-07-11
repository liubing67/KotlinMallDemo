package com.abing.usercenter.data.respository

import com.abing.baselibrary.data.net.RetrofitFactory
import com.abing.baselibrary.data.protocol.BaseResp
import com.abing.usercenter.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:28
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:28
 * 修改备注：
 * @version
 *
 */
class UploadRepository  @Inject constructor(){

    /*
          获取七牛云上传凭证
       */
    fun getUploadToken():Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }
}