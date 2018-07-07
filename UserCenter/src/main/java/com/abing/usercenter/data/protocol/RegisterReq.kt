package com.abing.usercenter.data.protocol

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:43
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:43
 * 修改备注：
 * @version
 *
 */

/*
    注册请求体
 */
data class RegisterReq(val mobile:String,val verifyCode:String,val pwd:String)