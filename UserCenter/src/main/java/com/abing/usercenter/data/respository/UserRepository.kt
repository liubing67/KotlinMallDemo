package com.abing.usercenter.data.respository

import com.abing.baselibrary.data.net.RetrofitFactory
import com.abing.baselibrary.data.protocol.BaseResp
import com.abing.usercenter.data.api.UserApi
import com.abing.usercenter.data.protocol.LoginReq
import com.abing.usercenter.data.protocol.RegisterReq
import com.abing.usercenter.data.protocol.UserInfo
import retrofit2.http.Field
import rx.Observable
import java.sql.RowId
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:37
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:37
 * 修改备注：
 * @version
 *
 */

/*
    用户相关数据层
 */
class UserRepository @Inject constructor(){
    /*
        用户注册
     */
    fun register(mobile:String,verifyCode:String,pwd:String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(mobile,verifyCode,pwd)

    }

    /*
    用户登录
     */
    fun login(mobile: String,pwd: String,pushId: String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(mobile,pwd)
    }
    /*
    忘记密码,获取验证码
     */
    fun forgetPwd(mobile: String, udid: String,type:String,sign:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).forgetPwd(mobile,udid,type,sign)
    }
    /*
    重置密码
     */
    fun resetPwd(mobile: String, newpwd: String, confirmpwd: String, udid: String, type: String, authcode: String, sign: String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).resetPwd(mobile, newpwd, confirmpwd, udid, type, authcode, sign)
    }
}