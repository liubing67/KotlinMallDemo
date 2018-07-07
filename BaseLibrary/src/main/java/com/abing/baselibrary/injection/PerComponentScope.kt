package com.abing.baselibrary.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-7 11:06
 * 修改人：Administrator
 * 修改时间：2018-7-7 11:06
 * 修改备注：
 * @version
 *
 */
/*
    组件级别 作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerComponentScope
