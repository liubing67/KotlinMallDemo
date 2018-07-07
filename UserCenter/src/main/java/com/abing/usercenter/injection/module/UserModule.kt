package com.abing.usercenter.injection.module

import com.abing.usercenter.service.UserService
import com.abing.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 19:05
 * 修改人：Administrator
 * 修改时间：2018-7-7 19:05
 * 修改备注：
 * @version
 *
 */
/*
    用户模块Module
 */
@Module
class UserModule{

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}