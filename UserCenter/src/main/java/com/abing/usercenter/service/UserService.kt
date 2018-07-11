package com.abing.usercenter.service

import com.abing.usercenter.data.protocol.UserInfo
import retrofit2.http.Field
import rx.Observable

/**
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 17:14
 * 修改人：Administrator
 * 修改时间：2018-7-6 17:14
 * 修改备注：
 */
/**
 * 用户模块  业务接口
 */
interface UserService {

    //用户注册
    fun register(mobile: String, verifyCode: String, pwd: String):Observable<Boolean>

    //用户登录
    fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo>

    //忘记密码
    fun forgetPwd(mobile: String, udid: String,type:String,sign:String): Observable<Boolean>

    //重置密码
    fun resetPwd(mobile: String, newpwd: String, confirmpwd: String, udid: String, type: String, authcode: String, sign: String): Observable<Boolean>

    //编辑用户资料
    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo>
}
