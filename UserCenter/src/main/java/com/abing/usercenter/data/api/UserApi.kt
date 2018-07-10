package com.abing.usercenter.data.api

import com.abing.baselibrary.data.protocol.BaseResp
import com.abing.usercenter.data.protocol.LoginReq
import com.abing.usercenter.data.protocol.RegisterReq
import com.abing.usercenter.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
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
    @FormUrlEncoded
    @POST("userCenter/regiser")
    fun register(@Field("mobile")mobile:String,@Field("verifyCode") verifyCode:String,@Field("pwd")pwd:String):Observable<BaseResp<String>>

    /*
    用户登录
     */
    @FormUrlEncoded
    @POST("loginCheck")
    fun login(@Field("username")username:String,@Field("password") password:String):Observable<BaseResp<UserInfo>>
//    fun login(@Body req: LoginReq):Observable<BaseResp<UserInfo>>

    /*
   忘记密码，获取验证码
    */
    @FormUrlEncoded
    @POST("core/funcs/crma/mobileagent/getFindPwdVerifyCode")
    fun forgetPwd(@Field("mobile")mobile:String,@Field("udid") udid:String,@Field("type")type:String,@Field("sign")sign:String):Observable<BaseResp<String>>

    /*
           重置密码
        */
    @FormUrlEncoded
    @POST("core/funcs/crma/mobileagent/updateFindPwd")
    fun resetPwd(@Field("mobile")mobile:String,@Field("newpwd") newpwd:String,@Field("confirmpwd")confirmpwd:String,@Field("udid")udid:String,@Field("type")type:String,@Field("authcode")authcode:String,@Field("sign")sign:String):Observable<BaseResp<String>>
}