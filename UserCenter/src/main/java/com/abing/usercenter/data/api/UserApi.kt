package com.abing.usercenter.data.api

import com.abing.baselibrary.data.protocol.BaseResp
import com.abing.usercenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:41
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:41
 * 修改备注：
 * @version
 *
 */
interface UserApi {

    /*
    用户注册
     */
    @POST("userCenter/regiser")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>
}