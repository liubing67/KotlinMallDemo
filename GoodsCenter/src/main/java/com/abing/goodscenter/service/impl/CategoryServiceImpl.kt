package com.abing.goodscenter.service.impl

import com.abing.baselibrary.ext.convert
import com.abing.goodscenter.data.protocol.Category
import com.abing.goodscenter.data.repository.CategoryRepository
import com.abing.goodscenter.service.CategoryService
import rx.Observable
import javax.inject.Inject

/*
    商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor(): CategoryService {
    @Inject
    lateinit var repository: CategoryRepository

    /*
        获取商品分类列表
     */
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}
