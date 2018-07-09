package com.abing.usercenter.injection.module

import com.abing.usercenter.service.UserService
import com.abing.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

/*
    用户模块Module
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }

}

