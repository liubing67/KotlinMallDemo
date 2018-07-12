package com.abing.messagecenter.presenter

import com.abing.baselibrary.ext.excute
import com.abing.baselibrary.presenter.BasePresenter
import com.abing.baselibrary.rx.BaseSubscriber
import com.abing.messagecenter.data.protocol.Message
import com.abing.messagecenter.presenter.view.MessageView
import com.abing.messagecenter.service.MessageService
import javax.inject.Inject

/*
    消息列表 Presenter
 */
class MessagePresenter @Inject constructor() : BasePresenter<MessageView>() {

    @Inject
    lateinit var messageService: MessageService

    /*
        获取消息列表
     */
    fun getMessageList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        messageService.getMessageList().excute(object : BaseSubscriber<MutableList<Message>?>(mView) {
            override fun onNext(t: MutableList<Message>?) {
                mView.onGetMessageResult(t)
            }
        }, lifecycleProvider)

    }


}
