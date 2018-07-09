package com.abing.provider.common

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-9 17:13
 * 修改人：Administrator
 * 修改时间：2018-7-9 17:13
 * 修改备注：
 * @version
 *
 */
/*
    业务常量
 */
class ProviderConstant {
    companion object {
        //用户名称
        const val KEY_SP_USER_NAME = "sp_user_name"
        //用户电话
        const val KEY_SP_USER_MOBILE = "sp_user_mobile"
        //用户头像
        const val KEY_SP_USER_ICON = "sp_user_icon"
        //用户性别
        const val KEY_SP_USER_GENDER = "sp_user_gender"
        //用户签名
        const val KEY_SP_USER_SIGN = "sp_user_sign"

        //订单ID
        const val KEY_ORDER_ID = "order_id"
        //订单价格
        const val KEY_ORDER_PRICE = "order_price"
    }
}
