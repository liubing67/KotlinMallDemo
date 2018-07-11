package com.abing.goodscenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView
import com.abing.goodscenter.data.protocol.Category

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 14:31
 * 修改人：Administrator
 * 修改时间：2018-7-11 14:31
 * 修改备注：
 * @version
 *
 */
/*
    商品分类 视图回调
 */
interface CategoryView : BaseView {

    //获取商品分类列表
    fun onGetCategoryResult(result: MutableList<Category>?)
}
