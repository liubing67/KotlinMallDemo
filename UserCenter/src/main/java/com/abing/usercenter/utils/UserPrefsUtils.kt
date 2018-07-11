package com.abing.usercenter.utils

import com.abing.baselibrary.common.BaseConstant
import com.abing.baselibrary.utils.AppPrefsUtils
import com.abing.provider.common.ProviderConstant
import com.abing.usercenter.data.protocol.UserInfo

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-9 17:01
 * 修改人：Administrator
 * 修改时间：2018-7-9 17:01
 * 修改备注：
 * @version
 *
 */
/*
    本地存储用户相关信息
 */
object UserPrefsUtils {

    /*
        退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo?.agentId ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.userName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.agentName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.agentName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, userInfo?.bankAuth ?: "")
    }
}
