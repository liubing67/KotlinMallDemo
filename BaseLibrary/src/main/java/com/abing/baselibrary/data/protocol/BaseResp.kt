package com.abing.baselibrary.data.protocol

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:30
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:30
 * 修改备注：
 * @version
 *
 */
/*
    能用响应对象
    @status:响应状态码
    @message:响应文字消息
    @data:具体响应业务对象
 */
data class BaseResp <out T>(val rtState:Int,val rtMsrg:String,val rtData:T)