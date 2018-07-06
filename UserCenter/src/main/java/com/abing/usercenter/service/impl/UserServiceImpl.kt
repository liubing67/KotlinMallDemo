package com.abing.usercenter.service.impl

import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.service.UserService
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


    /*
       注册
    */
    override fun register(mobile: String,verifyCode: String,pwd: String): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
