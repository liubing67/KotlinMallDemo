package com.abing.usercenter.data.protocol

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 9:44
 * 修改人：Administrator
 * 修改时间：2018-7-11 9:44
 * 修改备注：
 * @version
 *
 */
/*
    修改用户资料请求体
 */
data class EditUserReq(val userIcon: String, val userName: String, val gender: String, val sign: String)