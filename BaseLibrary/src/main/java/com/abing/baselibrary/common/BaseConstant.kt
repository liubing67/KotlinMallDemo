package com.abing.baselibrary.common

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-6 18:32
 * 修改人：Administrator
 * 修改时间：2018-7-6 18:32
 * 修改备注：
 * @version
 *
 */
/*
    基础常量
 */
class BaseConstant{
    companion object {
        //七牛服务地址
        const val IMAGE_SERVER_ADDRESS = "http://osea2fxp7.bkt.clouddn.com/"
        //本地服务器地址
        const val SERVER_ADDRESS = "http://sdzy.china-madpay.com/crmapi_v16/"
        //SP表名
        const val TABLE_PREFS = "Kotlin_mall"
        //Token Key
        const val KEY_SP_TOKEN = "token"
    }
}
