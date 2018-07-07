package com.abing.baselibrary.injection.module

import com.abing.baselibrary.common.BaseApplication
import dagger.Module
import java.security.AccessControlContext

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 10:59
 * 修改人：Administrator
 * 修改时间：2018-7-7 10:59
 * 修改备注：
 * @version
 *
 */
/*
    Application级别Module
 */
@Module
class AppModule (private val context: BaseApplication){
}