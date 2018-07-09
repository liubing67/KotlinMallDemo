package com.abing.provider.common

import com.abing.baselibrary.common.BaseConstant
import com.abing.baselibrary.utils.AppPrefsUtils

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-9 17:05
 * 修改人：Administrator
 * 修改时间：2018-7-9 17:05
 * 修改备注：
 * @version
 *
 */
/*
    顶级函数，判断是否登录
 */
fun isLogined():Boolean{
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}

/*
    如果已经登录，进行传入的方法处理
    如果没有登录，进入登录界面
 */
fun afterLogin(method:()->Unit){
    if (isLogined()){
        method()
    }else{
//        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
    }
}
