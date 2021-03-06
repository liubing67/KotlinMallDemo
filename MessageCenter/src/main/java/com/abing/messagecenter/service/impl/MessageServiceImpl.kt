package com.abing.messagecenter.service.impl


import com.abing.baselibrary.ext.convert
import com.abing.messagecenter.data.protocol.Message
import com.abing.messagecenter.data.repository.MessageRepository
import com.abing.messagecenter.service.MessageService
import rx.Observable
import javax.inject.Inject

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}
