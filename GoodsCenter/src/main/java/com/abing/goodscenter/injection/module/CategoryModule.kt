package com.abing.goodscenter.injection.module

import com.abing.goodscenter.service.CategoryService
import com.abing.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品分类Module
 */
@Module
class CategoryModule {

    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}
