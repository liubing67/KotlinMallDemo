package com.abing.baselibrary.rx

import java.sql.ClientInfoStatus

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 11:01
 * 修改人：Administrator
 * 修改时间：2018-7-7 11:01
 * 修改备注：
 * @version
 *
 */
/*
    定义通用异常
 */
class BaseException(val status: Int,val msg:String):Throwable() {
}