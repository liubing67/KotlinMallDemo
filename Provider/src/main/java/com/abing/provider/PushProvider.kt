package com.abing.provider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-12 9:50
 * 修改人：Administrator
 * 修改时间：2018-7-12 9:50
 * 修改备注：
 * @version
 *
 */
/*
    跨模块接口调用 接口定义
 */
interface PushProvider: IProvider {
    fun getPushId():String
}
