package com.abing.usercenter.service.impl

import com.abing.baselibrary.ext.convert
import com.abing.usercenter.data.respository.UploadRepository
import com.abing.usercenter.service.UploadService
import rx.Observable
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:27
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:27
 * 修改备注：
 * @version
 *
 */
/*
    上传业务实现类
 */
class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var repository:UploadRepository
    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }

}