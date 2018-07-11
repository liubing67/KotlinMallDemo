package com.abing.usercenter.service.impl

import com.abing.baselibrary.ext.convert
import com.abing.usercenter.data.respository.UserRepository
import com.abing.usercenter.service.UserService
import com.abing.baselibrary.ext.convertBoolean
import com.abing.usercenter.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject
/**
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 17:30
 * 修改人：Administrator
 * 修改时间：2018-7-6 17:30
 * 修改备注：
 */
/*
    用户模块业务实现类
 */
class UserServiceImpl @Inject constructor():UserService{



    @Inject
    lateinit var repository:UserRepository
    /*
       注册
    */
    override fun register(mobile: String,verifyCode: String,pwd: String):Observable<Boolean>{
        return repository.register(mobile,verifyCode,pwd).convertBoolean()
    }
    /*
    //用户登录
     */
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile,pwd,pushId).convert()
    }
    /*
    忘记密码
     */
    override fun forgetPwd(mobile: String, udid: String,type:String,sign:String): Observable<Boolean> {
        return repository.forgetPwd(mobile,udid,type,sign).convertBoolean()
    }
    /*
    重置密码
     */
    override fun resetPwd(mobile: String, newpwd: String, confirmpwd: String, udid: String, type: String, authcode: String, sign: String): Observable<Boolean> {
        return repository.resetPwd(mobile, newpwd, confirmpwd, udid, type, authcode, sign).convertBoolean()
    }
    /*
    编辑用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }
}
