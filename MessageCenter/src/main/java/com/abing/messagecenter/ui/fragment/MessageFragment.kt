package com.abing.messagecenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abing.baselibrary.ui.fragment.BaseMvpFragment
import com.abing.messagecenter.R
import com.abing.messagecenter.data.protocol.Message
import com.kotlin.message.presenter.MessagePresenter
import com.kotlin.message.presenter.view.MessageView

/**
 *
 * 项目名称：KotlinMallDemo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2018-7-11 14:53
 * 修改人：Administrator
 * 修改时间：2018-7-11 14:53
 * 修改备注：
 * @version
 *
 */
/*
    消息列表Fragment
 */
class MessageFragment : BaseMvpFragment<MessagePresenter>(), MessageView {
    override fun onGetMessageResult(result: MutableList<Message>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_message,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}