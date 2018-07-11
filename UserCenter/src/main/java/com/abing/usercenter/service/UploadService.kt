package com.abing.usercenter.service

import rx.Observable

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:26
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:26
 * 修改备注：
 * @version
 *
 */
/*
    上传业务接口
 */
interface UploadService {

    fun getUploadToken(): Observable<String>

}
