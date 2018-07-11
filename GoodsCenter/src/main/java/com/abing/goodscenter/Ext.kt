package com.abing.goodscenter

import android.widget.EditText
import org.jetbrains.anko.find
import ren.qinc.numberbutton.NumberButton
import ren.qinc.numberbutton.R

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 16:04
 * 修改人：Administrator
 * 修改时间：2018-7-11 16:04
 * 修改备注：
 * @version
 *
 */
/*
    三方控件扩展
 */
fun NumberButton.getEditText(): EditText {
    return find(R.id.text_count)
}
