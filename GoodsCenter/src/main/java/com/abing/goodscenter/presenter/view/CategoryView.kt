package com.abing.goodscenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView
import com.abing.goodscenter.data.protocol.Category

/*
    商品分类 视图回调
 */
interface CategoryView : BaseView {

    //获取商品分类列表
    fun onGetCategoryResult(result: MutableList<Category>?)
}
