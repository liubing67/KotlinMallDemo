package com.abing.goodscenter.presenter.view

import com.abing.baselibrary.presenter.view.BaseView
import com.abing.goodscenter.data.protocol.Goods

/*
    商品列表 视图回调
 */
interface GoodsListView : BaseView {

    //获取商品列表
    fun onGetGoodsListResult(result: MutableList<Goods>?)
}
