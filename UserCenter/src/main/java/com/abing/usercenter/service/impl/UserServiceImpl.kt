package com.abing.usercenter.service.impl

import com.abing.usercenter.data.protocol.UserInfo
import com.abing.usercenter.data.respository.UserRepository
import com.abing.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject
//import com.abing.baselibrary.ext.convertBoolean
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
    override fun register(mobile: String,verifyCode: String,pwd: String){
//        return repository.register(mobile,verifyCode,pwd).convertBoolean()
//        return true
    }


}
