package com.abing.goodscenter.service

import com.abing.goodscenter.data.protocol.Category
import rx.Observable

/*
    商品分类 业务层 接口
 */
interface CategoryService {

    /*
        获取分类
     */
    fun getCategory(parentId:Int): Observable<MutableList<Category>?>
}
