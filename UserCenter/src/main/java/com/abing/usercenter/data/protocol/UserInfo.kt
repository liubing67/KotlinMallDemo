package com.abing.usercenter.data.protocol

/**
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 17:33
 * 修改人：Administrator
 * 修改时间：2018-7-6 17:33
 * 修改备注：
 */
/*
    用户实体类
 */
data class UserInfo(val agentId:String,
                    val agentGrade:String,
                    val bankAuth:String,
                    val userGender:String,
                    val agentName:String,
                    val userName:String)