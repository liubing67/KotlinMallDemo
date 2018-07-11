package com.abing.demo.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abing.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import com.abing.baselibrary.utils.GlideUtils
import com.abing.demo.R
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 10:56
 * 修改人：Administrator
 * 修改时间：2018-7-11 10:56
 * 修改备注：
 * @version
 *
 */
/*
首页折扣区域Adapter
*/
class HomeDiscountAdapter(context: Context): BaseRecyclerViewAdapter<String, HomeDiscountAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_home_discount_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        //加载图片
        GlideUtils.loadUrlImage(mContext,dataList[position],holder.itemView.mGoodsIconIv)
        //静态假数据
        holder.itemView.mDiscountAfterTv.text = "￥123.00"
        holder.itemView.mDiscountBeforeTv.text = "$1000.00"
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            //设置TextView样式
            view.mDiscountBeforeTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            view.mDiscountBeforeTv.paint.isAntiAlias = true
        }
    }

}
