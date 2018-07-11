package com.abing.goodscenter.presenter

import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.goodscenter.data.protocol.Category
import com.abing.goodscenter.presenter.view.CategoryView
import javax.inject.Inject

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 14:35
 * 修改人：Administrator
 * 修改时间：2018-7-11 14:35
 * 修改备注：
 * @version
 *
 */
/*
    商品分类 Presenter
 */
class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

//    @Inject
//    lateinit var categoryService: CategoryService


    /*
        获取商品分类列表
     */
    fun getCategory(parentId:Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
//        categoryService.getCategory(parentId).excute(object : BaseSubscriber<MutableList<Category>?>(mView) {
//            override fun onNext(t: MutableList<Category>?) {
//                mView.onGetCategoryResult(t)
//            }
//        }, lifecycleProvider)

    }

}
