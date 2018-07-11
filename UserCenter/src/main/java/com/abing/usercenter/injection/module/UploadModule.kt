package com.abing.usercenter.injection.module

import com.abing.usercenter.service.UploadService
import com.abing.usercenter.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/*
    上传Module
 */
@Module
class UploadModule {

    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }

}
