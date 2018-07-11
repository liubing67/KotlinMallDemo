package com.abing.goodscenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abing.baselibrary.ui.fragment.BaseMvpFragment
import com.abing.goodscenter.R
import com.abing.goodscenter.data.protocol.Category
import com.abing.goodscenter.presenter.CategoryPresenter
import com.abing.goodscenter.presenter.view.CategoryView

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述： 商品分类 Fragment
 * 创建人：liubing
 * 创建时间：2018-7-11 14:29
 * 修改人：Administrator
 * 修改时间：2018-7-11 14:29
 * 修改备注：
 * @version
 *
 */
class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryView {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onGetCategoryResult(result: MutableList<Category>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}